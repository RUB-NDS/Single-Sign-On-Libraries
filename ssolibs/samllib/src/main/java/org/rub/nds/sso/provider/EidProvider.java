/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

import java.util.UUID;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.saml.samllib.verifier.SAMLVerifierImpl;
import org.rub.nds.sso.api.SamlAuthnRequestVerificationChecksType;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.SamlVerificationParametersType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.exceptions.WrongInputException;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public class EidProvider {

    private SamlType samlType;

    public EidProvider(SamlType samlType) {
        this.samlType = samlType;
    }

    public void verify() throws WrongInputException, SAMLVerifyException {
        Response samlResponse;
        AuthnRequest authRequest;
        SamlVerificationParametersType verificationParameters;
        String samlVerificationProfile;
        SamlTokenVerificationChecksType samlTokenVerificationChecks;
        SamlAuthnRequestVerificationChecksType samlAuthnRequestVerificationChecks;

        samlResponse = serializeSamlResponse();
        authRequest = serializeSamlAuthnRequest();
        verificationParameters = samlType.getSamlVerificationParameters();
        samlVerificationProfile = samlType.getSamlVerificationProfile();
        samlTokenVerificationChecks = samlType.getSamlTokenVerificationChecks();
        samlAuthnRequestVerificationChecks = samlType.getSamlAuthnReqVerificationChecks();

        VerificationProfileType verificationProfile = new VerificationProfileType();
        verificationProfile.setID(UUID.randomUUID().toString());
        verificationProfile.setSamlAuthnReqVerificationChecks(samlAuthnRequestVerificationChecks);
        verificationProfile.setSamlTokenVerificationChecks(samlTokenVerificationChecks);
        verificationProfile.setSamlTokenVerificationParameters(verificationParameters);

        SAMLVerifierImpl verifier = new SAMLVerifierImpl();
        verifier.verify(samlResponse, verificationProfile);
    }

    private Response serializeSamlResponse() throws WrongInputException {
        Response samlResponse = null;
        try {
            if (samlType.getSamlResponse() == null || samlType.getSamlResponse().isEmpty()) {
                // TODO: Warning Log
            } else {
                samlResponse = (Response) SAMLUtils.buildObjectfromString(samlType.getSamlResponse());
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
