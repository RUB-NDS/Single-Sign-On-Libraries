package org.rub.nds.saml.samllib.provider;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.saml.samllib.verifier.SAMLVerifierImpl;
import org.rub.nds.sso.api.AuthenticatedUserType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.SsoType;
import org.rub.nds.sso.api.VerificationLogType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.api.VerificationResponseType;
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
    public VerificationResponseType verify(SsoType samlType) {
        VerificationResponseType result = new VerificationResponseType();

        VerificationProfileType verificationProfile = (VerificationProfileType) this.getVerificationProfile();

        try {
            AuthnRequest authRequest;
            Response samlResponse;
            samlResponse = serializeSamlResponse((SamlType) samlType);
            authRequest = serializeSamlAuthnRequest((SamlType) samlType);
            startVerification(samlResponse, verificationProfile);

            return createResult(samlType, samlResponse, authRequest);
        } catch (SAMLVerifyException | WrongInputException ex) {
            return result = responseException(samlType, ex);
        }

    }

    private void startVerification(Response samlResponse, VerificationProfileType verificationProfile)
            throws SAMLVerifyException {
        SAMLVerifierImpl verifier = new SAMLVerifierImpl();
        verifier.verify(samlResponse, verificationProfile);
    }

    private VerificationResponseType responseException(SsoType samlType, Exception ex) {
        VerificationResponseType result = new VerificationResponseType();
        // Log Exception
        VerificationLogType logs = new VerificationLogType();
        logs.setException(ex.getMessage());

        result.setVerificationLog(logs);
        // result.setSuccess(false);
        return result;
    }

    private VerificationResponseType createResult(SsoType samlType, Response samlResponse, AuthnRequest authnRequest) {
        try {
            VerificationResponseType result = new VerificationResponseType();
            AuthenticatedUserType user = new AuthenticatedUserType();
            user.setUserID(SAMLUtils.getAuthenticatedUser(samlResponse));
            return result;
        } catch (WrongInputException ex) {
            return responseException(samlType, ex);
        }
    }

    private Response serializeSamlResponse(SamlType samlType) throws WrongInputException {
        Response samlResponse = null;
        try {
            if (samlType.getSamlResponse() == null || samlType.getSamlResponse().isEmpty()) {
                // TODO: Warning Log
            } else {
                samlResponse = (Response) SAMLUtils.buildObjectfromString(DecoderUtils.decodeBase64Mime(samlType
                        .getSamlResponse()));
            }
        } catch (WrongInputException | UnsupportedEncodingException | NullPointerException ex) {
            throw new WrongInputException("Cannot parse SAML Response");
        }
        return samlResponse;
    }

    private AuthnRequest serializeSamlAuthnRequest(SamlType samlType) throws WrongInputException {
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
}
