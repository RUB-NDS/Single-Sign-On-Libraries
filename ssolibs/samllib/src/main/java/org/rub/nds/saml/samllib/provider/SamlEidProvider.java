package org.rub.nds.saml.samllib.provider;

import java.io.UnsupportedEncodingException;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.saml.samllib.verifier.SAMLVerifierImpl;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.exceptions.WrongInputException;
import org.rub.nds.sso.provider.EidProvider;
import org.rub.nds.sso.utils.DecoderUtils;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public class SamlEidProvider extends EidProvider {

    private static final double VERSION = 1.0;

    private static final String INFO = "SAML eID provider v" + VERSION;

    private static final String NAME = "SAML eID";

    private static final String TYPE = "SAML";

    public SamlEidProvider() {
        super(NAME, INFO, VERSION, TYPE);
    }

    @Override
    public boolean verify() {
        try {
            SamlType samlType = (SamlType) this.getSecurityObject();
            VerificationProfileType verificationProfile = (VerificationProfileType) this.getVerificationProfile();
            if (samlType != null) {
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
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Response serializeSamlResponse() throws WrongInputException, UnsupportedEncodingException {
        Response samlResponse = null;
        SamlType samlType = (SamlType) this.getSecurityObject();

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
        SamlType samlType = (SamlType) this.getSecurityObject();

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
}
