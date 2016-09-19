/* 
 * Copyright (C) 2014 Vladislav Mladenov<vladislav.mladenov@rub.de>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.rub.nds.saml.samllib.verifier;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.SignableSAMLObject;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.metadata.IDPSSODescriptor;
import org.opensaml.saml2.metadata.provider.AbstractMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.security.MetadataCredentialResolver;
import org.opensaml.security.MetadataCriteria;
import org.opensaml.security.SAMLSignatureProfileValidator;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.security.CriteriaSet;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.credential.UsageType;
import org.opensaml.xml.security.criteria.EntityIDCriteria;
import org.opensaml.xml.security.criteria.UsageCriteria;
import org.opensaml.xml.security.keyinfo.KeyInfoCredentialResolver;
import org.opensaml.xml.signature.SignatureTrustEngine;
import org.opensaml.xml.signature.SignatureValidator;
import org.opensaml.xml.signature.impl.ExplicitKeySignatureTrustEngine;
import org.opensaml.xml.validation.ValidationException;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.exceptions.WrongInputException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SAMLSignatureVerification implements SAMLVerifierInterface {

    private static Logger _log = LoggerFactory.getLogger(SAMLSignatureVerification.class);
    private AbstractMetadataProvider metaData;

    public SAMLSignatureVerification() {
    }

    public SAMLSignatureVerification(AbstractMetadataProvider metaData) {
        this.metaData = metaData;
    }
    
    

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {

        if (profile.getSamlTokenVerificationChecks().isVerifyXSW()!=null && profile.getSamlTokenVerificationChecks().isVerifyXSW())
        {
            verifyStructure((SignableSAMLObject) samlObject);
        }
        
        if (profile.getSamlTokenVerificationChecks().isVerifiySAMLResponseSignature()!= null && profile.getSamlTokenVerificationChecks().isVerifiySAMLResponseSignature()) {
            verifyUntrustedKeys((Response) samlObject);
        }

        if (profile.getSamlTokenVerificationChecks().isVerifiySAMLResponseSignatureTrusted()!= null && profile.getSamlTokenVerificationChecks().isVerifiySAMLResponseSignatureTrusted()) {
            verifyTrustedKeys((Response) samlObject);
        }

        for (Assertion assertion : ((Response) samlObject).getAssertions()) {
            if (profile.getSamlTokenVerificationChecks().isVerifiySAMLAssertionSignature()!=null && profile.getSamlTokenVerificationChecks().isVerifiySAMLAssertionSignature()) {
                verifyUntrustedKeys(assertion);
            }
            
            if (profile.getSamlTokenVerificationChecks().isVerifiySAMLAssertionSignatureTrusted()!=null && profile.getSamlTokenVerificationChecks().isVerifiySAMLAssertionSignatureTrusted()) {
                verifyTrustedKeys(assertion);
            }
        }
    }

    private void verifyUntrustedKeys(final SignableSAMLObject obj) throws SAMLVerifyException {
        try {
            Credential verificationCredential = SAMLUtils.getCredential(obj.getSignature());
            SignatureValidator sigValidator = new SignatureValidator(verificationCredential);

            sigValidator.validate(obj.getSignature());
        } catch (ValidationException | WrongInputException ex) {
            _log.error("Verification of untrusted signature FAILED!");
            throw new SAMLVerifyException("Verification of untrusted signature FAILED!", ex);
        }
    }

    private void verifyTrustedKeys(final SignableSAMLObject obj) throws SAMLVerifyException {
        SignatureTrustEngine sigTrustEngine;
        MetadataProvider mdProvider = metaData;
        MetadataCredentialResolver mdCredResolver = new MetadataCredentialResolver(mdProvider);
        KeyInfoCredentialResolver keyInfoCredResolver = Configuration.getGlobalSecurityConfiguration().getDefaultKeyInfoCredentialResolver();

        try {
            sigTrustEngine = new ExplicitKeySignatureTrustEngine(mdCredResolver, keyInfoCredResolver);
            
            if (!sigTrustEngine.validate(obj.getSignature(), setCriteriaSet(obj)))
            {
                _log.error("Trusted verification FAILED! ");
                throw new SAMLVerifyException("Trusted verification FAILED! ");
            }
        } catch (org.opensaml.xml.security.SecurityException ex) {
            _log.error("Trusted verification FAILED! ");
            throw new SAMLVerifyException("Trusted verification FAILED! ", ex);
        }
    }

    private void verifyStructure(final SignableSAMLObject obj) throws SAMLVerifyException {
        try {
            SAMLSignatureProfileValidator profileValidator = new SAMLSignatureProfileValidator();
            if (obj instanceof Response && obj.isSigned())
            {
                profileValidator.validate(obj.getSignature());
                for (Assertion ass : ((Response)obj).getAssertions())
                {
                    if (ass.isSigned())
                    {
                        profileValidator.validate(ass.getSignature());
                    }
                }
            }
        } catch (ValidationException ex) {
            _log.error("Verification of the Signagure structure FAILED!");
            throw new SAMLVerifyException("Verification of the Signagure structure FAILED!", ex);
        }
    }

    private CriteriaSet setCriteriaSet(final SignableSAMLObject samlObject) throws SAMLVerifyException {
        CriteriaSet criteriaSet = new CriteriaSet();

        try {
            criteriaSet.add(new EntityIDCriteria((SAMLUtils.getIssuer(samlObject))));
            criteriaSet.add(new MetadataCriteria(IDPSSODescriptor.DEFAULT_ELEMENT_NAME, SAMLConstants.SAML20P_NS));
            criteriaSet.add(new UsageCriteria(UsageType.SIGNING));
        } catch (WrongInputException ex) {
            _log.error("Cannot set Criteria for the Signature verification!");
            throw new SAMLVerifyException("Cannot set Criteria for the Signature verification!", ex);
        }
        return criteriaSet;
    }
}
