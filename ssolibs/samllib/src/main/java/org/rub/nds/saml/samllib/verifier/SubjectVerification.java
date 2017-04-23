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

import org.joda.time.DateTime;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.SubjectConfirmation;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.api.VerificationProfileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SubjectVerification implements SAMLVerifierInterface {

    private static Logger _log = LoggerFactory.getLogger(SubjectVerification.class);
    private transient AuthnRequest authnRequest;

    public SubjectVerification(AuthnRequest authnRequest) {
        this.authnRequest = authnRequest;
    }

    public SubjectVerification() {
    }

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        _log.debug("Verify the ID in Response-Header ...");

        verifyTimestamp(samlObject, profile);
        verifyRecipient(samlObject, profile);
        veridyInResponseTo(samlObject, profile);
    }

    private void verifyTimestamp(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        if (profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionSbjConfirmationTimestamps() != null
                && profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionSbjConfirmationTimestamps()) {
            try {
                for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                    for (SubjectConfirmation sbjConfirmation : assertion.getSubject().getSubjectConfirmations()) {
                        DateTime notBefore = sbjConfirmation.getSubjectConfirmationData().getNotBefore();
                        DateTime notAfter = sbjConfirmation.getSubjectConfirmationData().getNotOnOrAfter();

                        if (notBefore == null) {
                            notBefore = new DateTime().minusYears(10);
                        }
                        if (notAfter == null) {
                            notAfter = new DateTime().minusYears(10);
                        }

                        if (!notBefore.isAfterNow()) {
                        } else {
                            throw new SAMLVerifyException(
                                    "Timestamp NotBefore in the Subject is not valid! Timestamp: "
                                            + notBefore.toString());
                        }

                        if (!notAfter.isBeforeNow()) {
                        } else {
                            throw new SAMLVerifyException(
                                    "Timestamp NotOnOrAfter in the Subject is not valid! Timestamp: "
                                            + notAfter.toString());
                        }
                    }
                }
            } catch (NullPointerException ex) {
                throw new SAMLVerifyException("Some element is missing. NullPointerException: ", ex);
            }
        }
    }

    private void verifyRecipient(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        try {
            if (profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionSbjConfirmationDestination() != null
                    && profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionSbjConfirmationDestination()) {
                for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                    for (SubjectConfirmation sbjConfirmation : assertion.getSubject().getSubjectConfirmations()) {

                        if (profile.getSamlTokenVerificationParameters().getDestination()
                                .equalsIgnoreCase(sbjConfirmation.getSubjectConfirmationData().getRecipient())) {
                        } else {
                            throw new SAMLVerifyException("Recipient in the Subject is not valid! Recipient: "
                                    + sbjConfirmation.getSubjectConfirmationData().getRecipient());
                        }
                    }

                }
            }
        } catch (NullPointerException ex) {
            throw new SAMLVerifyException("Subject Destination cannot be verified. NullPointerException: ", ex);
        }
    }

    //
    private void veridyInResponseTo(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        try {
            if (profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionSbjInResponseTo() != null
                    && profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionSbjInResponseTo()) {
                for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                    for (SubjectConfirmation sbjConfirmation : assertion.getSubject().getSubjectConfirmations()) {

                        if (authnRequest.getID().equalsIgnoreCase(
                                sbjConfirmation.getSubjectConfirmationData().getInResponseTo())) {
                        } else {
                            throw new SAMLVerifyException("InResponseTo in the Subject is not valid! InResponseTo: "
                                    + sbjConfirmation.getSubjectConfirmationData().getInResponseTo());
                        }
                    }
                }
            }
        } catch (NullPointerException ex) {
            throw new SAMLVerifyException("Some element is missing. NullPointerException: ", ex);
        }
    }
}
