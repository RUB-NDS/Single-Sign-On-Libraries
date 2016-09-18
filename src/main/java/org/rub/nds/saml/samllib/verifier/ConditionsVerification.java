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

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Audience;
import org.opensaml.saml2.core.AudienceRestriction;
import org.opensaml.saml2.core.Response;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class ConditionsVerification implements SAMLVerifierInterface {

    private static Logger _log = LoggerFactory.getLogger(ConditionsVerification.class);

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        _log.debug("Verify the ID in Response-Header ...");

        verifyTimestamp(samlObject, profile);
        verifyAudience(samlObject, profile);
    }

    private void verifyTimestamp(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        if (profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionConditionsTimestamps()) {
            try {
                for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                    DateTime notBefore = assertion.getConditions().getNotBefore();
                    DateTime notAfter = assertion.getConditions().getNotOnOrAfter();

                    if (notBefore == null) {
                        notBefore = new DateTime().minusYears(10);
                    }
                    if (notAfter == null) {
                        notAfter = new DateTime().minusYears(10);
                    }

                    if (!notBefore.isAfterNow()) {
                    } else {
                        throw new SAMLVerifyException("Timestamp NotBefore in the Conditions is not valid! Timestamp: " + notBefore.toString());
                    }

                    if (!notAfter.isBeforeNow()) {
                    } else {
                        throw new SAMLVerifyException("Timestamp NotOnOrAfter in the Conditions is not valid! Timestamp: " + notAfter.toString());
                    }
                }
            } catch (NullPointerException ex) {
                throw new SAMLVerifyException("Some Conditions-timestamp element is missing. NullPointerException: ", ex);
            }
        }
    }

    private void verifyAudience(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        List<String> audienceStrings = new ArrayList<>();

        if (profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionConditionsAudience()) {
            try {
                for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                    for (AudienceRestriction restrict : assertion.getConditions().getAudienceRestrictions()) {
                        for (Audience audience : restrict.getAudiences()) {
                            audienceStrings.add(audience.getAudienceURI());
                        }
                    }
                }

                if (!audienceStrings.contains(profile.getSamlTokenVerificationParameters().getAudience().get(0))) {
                    throw new SAMLVerifyException("Audience element was nto found in the token! Expected Audience: " + profile.getSamlTokenVerificationParameters().getAudience().get(0));
                }
            } catch (NullPointerException ex) {
                throw new SAMLVerifyException("Some element is missing. NullPointerException: ", ex);
            }
        }
    }
}
