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

import java.security.cert.X509Certificate;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.metadata.provider.AbstractMetadataProvider;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */

public class SAMLVerifierImpl implements SAMLVerifierInterface{
    private static Logger _log = LoggerFactory.getLogger(SAMLVerifierImpl.class);
    private AuthnRequest authnRequest;
    private X509Certificate certifficate;
    private AbstractMetadataProvider metadata;
    
    public SAMLVerifierImpl() {
    }

    public SAMLVerifierImpl(AuthnRequest authnRequest, X509Certificate certifficate) {
        this.authnRequest = authnRequest;
        this.certifficate = certifficate;
    }
    
    public SAMLVerifierImpl(AuthnRequest authnRequest) {
        this.authnRequest = authnRequest;
    }
    
    public SAMLVerifierImpl(X509Certificate certifficate) {
        this.certifficate = certifficate;
    }

    public SAMLVerifierImpl(AuthnRequest authnRequest, X509Certificate certifficate, AbstractMetadataProvider metadata) {
        this.authnRequest = authnRequest;
        this.certifficate = certifficate;
        this.metadata = metadata;
    }
    
    public SAMLVerifierImpl(AuthnRequest authnRequest, AbstractMetadataProvider metadata) {
        this.authnRequest = authnRequest;
        this.metadata = metadata;
    }
    
    public SAMLVerifierImpl(X509Certificate certifficate, AbstractMetadataProvider metadata) {
        this.certifficate = certifficate;
        this.metadata = metadata;
    }
    
    public SAMLVerifierImpl(AbstractMetadataProvider metadata) {
        this.metadata = metadata;
    }
    

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        new ResponseHeaderVerification(authnRequest).verify(samlObject, profile);
        new AssertionHeaderVerification().verify(samlObject, profile);
        new SAMLSignatureVerification(metadata).verify(samlObject, profile);
        new ConditionsVerification().verify(samlObject, profile);
        new SubjectVerification(authnRequest).verify(samlObject, profile);
        new HolderOfKeyVerification(certifficate).verify(samlObject, profile);
    }
    
}
