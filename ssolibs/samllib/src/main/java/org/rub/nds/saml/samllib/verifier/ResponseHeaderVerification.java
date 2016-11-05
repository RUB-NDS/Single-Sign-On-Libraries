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

import java.util.concurrent.ExecutionException;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.api.VerificationProfileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class ResponseHeaderVerification implements SAMLVerifierInterface {

    private static Logger _log = LoggerFactory.getLogger(ResponseHeaderVerification.class);
    private AuthnRequest authnRequest;

    public ResponseHeaderVerification(AuthnRequest authnRequest) {
        this.authnRequest = authnRequest;
    }

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        _log.debug("Verify the ID in Response-Header ...");

        verifyIDs(samlObject, profile);
        verifyTimestamp(samlObject, profile);
        verifyInResponseTo(samlObject, profile);
    }

    private void verifyIDs(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        if (profile.getSamlTokenVerificationChecks().isVerifySAMLResponseID()!=null && profile.getSamlTokenVerificationChecks().isVerifySAMLResponseID()) {
            try {
                Response response;

                response = (Response) samlObject;

                if (!SAMLIDCache.getHandler().get(response.getID()).equals("Recently used!")) {
                    //Apparently it's a new one, so cache it and return true:
                    SAMLIDCache.getHandler().put(response.getID(), "Recently used!");
                }
                else
                {
                    throw new SAMLVerifyException("Verification of the ID in Response-Header FAILED! ID was recently used!");
                }
            } catch (ExecutionException ex) {
                _log.error("Verification of the ID in Response-Header FAILED!");
                throw new SAMLVerifyException("Verification of the ID in Response-Header FAILED!", ex);
            }
        }
    }

    private void verifyTimestamp(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {

        if (profile.getSamlTokenVerificationChecks().isVerifySAMLResponseIssueInstant()!= null && profile.getSamlTokenVerificationChecks().isVerifySAMLResponseIssueInstant()) {
            Response response = ((Response) samlObject);
            if (!response.getIssueInstant().isBeforeNow()) {
                _log.error("Timestamp in the Response is not valid. Timestamp is BeforeNow: " + response.getIssueInstant().toString());
                throw new SAMLVerifyException("Timestamp in the Response is not valid. Timestamp is BeforeNow: " + response.getIssueInstant().toString());
            }
        }
    }

    private void verifyInResponseTo(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        if (profile.getSamlTokenVerificationChecks().isVerifySAMLResponseInResponseTo()!= null && profile.getSamlTokenVerificationChecks().isVerifySAMLResponseInResponseTo()) {
            try {
                Response response = ((Response) samlObject);
                if (!response.getInResponseTo().equalsIgnoreCase(authnRequest.getID())) {
                    _log.error("InResponseTo in the Response is not valid. The current value is: " + response.getInResponseTo() + " and the expected value is: " + authnRequest.getID());
                    throw new SAMLVerifyException("InResponseTo in the Response is not valid. The current value is: " + response.getInResponseTo() + " and the expected value is: " + authnRequest.getID());
                }
            } catch (NullPointerException ex) {
                throw new SAMLVerifyException("AuthnRequest is null OR InResponseTo is empty! No verification is possible!");
            }
        }
    }
}
