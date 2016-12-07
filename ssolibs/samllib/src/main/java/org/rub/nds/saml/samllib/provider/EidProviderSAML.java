/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.saml.samllib.provider;

import java.io.UnsupportedEncodingException;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.saml.samllib.verifier.SAMLVerifierImpl;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.provider.EidProvider;
import org.rub.nds.sso.exceptions.WrongInputException;
import org.rub.nds.sso.utils.DecoderUtils;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public class EidProviderSAML implements EidProvider {

    private SamlType samlType;
    private VerificationProfileType verificationProfile;

    public EidProviderSAML(SamlType samlType) throws SAMLVerifyException {
        this.samlType = samlType;
        throw new SAMLVerifyException("Verification without Profile is useless");
    }

    public EidProviderSAML(SamlType samlType, VerificationProfileType verificationProfile) {
        this.samlType = samlType;
        this.verificationProfile = verificationProfile;
    }

    public void verify() throws WrongInputException, SAMLVerifyException, UnsupportedEncodingException {
        Response samlResponse;
        AuthnRequest authRequest;

        samlResponse = serializeSamlResponse();
        authRequest = serializeSamlAuthnRequest();

        if (samlResponse == null) {
            throw new SAMLVerifyException("Verification without Resonse is useless");
        }

        SAMLVerifierImpl verifier = new SAMLVerifierImpl();
        verifier.verify(samlResponse, verificationProfile);
    }

    private Response serializeSamlResponse() throws WrongInputException, UnsupportedEncodingException {
        Response samlResponse = null;
        try {
            if (samlType.getSamlResponse() == null || samlType.getSamlResponse().isEmpty()) {
                // TODO: Warning Log
            } else {
                samlResponse = (Response) SAMLUtils.buildObjectfromString(DecoderUtils.decodeBase64Mime(samlType
                        .getSamlResponse()));
            }
        } catch (WrongInputException ex) {
            throw new WrongInputException("Cannot parse SAML Response");
        } catch (NullPointerException ex) {
            // TODO: Warning Log

        }
        return samlResponse;
    }

    private AuthnRequest serializeSamlAuthnRequest() throws WrongInputException {
        AuthnRequest samlRequest = null;
        try {
            if (samlType.getSamlRequest() == null || samlType.getSamlRequest().isEmpty()) {
                // TODO: Warning Log
            } else {
                samlRequest = (AuthnRequest) SAMLUtils.buildObjectfromString(samlType.getSamlRequest());
            }
        } catch (WrongInputException ex) {
            throw new WrongInputException("Cannot parse SAML Authentication Request");
        }
        return samlRequest;
    }

    public SamlType getSamlType() {
        return samlType;
    }

    public void setSamlType(SamlType samlType) {
        this.samlType = samlType;
    }

}
