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
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Response;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class AssertionHeaderVerification implements SAMLVerifierInterface {

    private static Logger _log = LoggerFactory.getLogger(AssertionHeaderVerification.class);

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        _log.debug("Verify the ID in Response-Header ...");

        verifyIDs(samlObject, profile);
        verifyTimestamp(samlObject, profile);

    }

    private void verifyIDs(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        if (profile.getSamlTokenVerificationChecks().isVerifiySAMLAssertionID()!=null && profile.getSamlTokenVerificationChecks().isVerifiySAMLAssertionID()) {
            for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                try {
                    if (!SAMLIDCache.getHandler().get(assertion.getID()).equals("Recently used!")) {
                        //Apparently it's a new one, so cache it and return true:
                        SAMLIDCache.getHandler().put(assertion.getID(), "Recently used!");
                    }
                    else{
                        throw new SAMLVerifyException("Verification of the ID in Assertion-Header FAILED! ID was recently used!");
                    }
                } catch (ExecutionException ex) {
                    _log.error("ExecutionException in SAMLIDCache!");
                    throw new SAMLVerifyException("ExecutionException in SAMLIDCache!", ex);
                }
            }
        }
    }
    
    private void verifyTimestamp (SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException
    {
        
        if (profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionIssueInstant()!=null && profile.getSamlTokenVerificationChecks().isVerifySAMLAssertionIssueInstant())
        {
            for (Assertion assertion : ((Response) samlObject).getAssertions()) {
                if (!assertion.getIssueInstant().isBeforeNow())
                {
                    throw new SAMLVerifyException("Timestamp in the Assertion is not valid. Timestamp is BeforeNow: " + assertion.getIssueInstant().toString());
                }
            }
        }
    }
}
