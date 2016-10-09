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

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.futuretrust.cvs.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.testsuites.III_ReplayAttacksTestSuite;
import org.rub.nds.saml.samllib.testsuites.III_SignatureTestSuite;
import org.rub.nds.saml.samllib.testsuites.I_MainTestSuite;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class Replay_TimestampsTest {

    public Replay_TimestampsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ConfigurationException, IOException {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ResponseIssueInstant() throws SAMLVerifyException {
        SAMLVerifierInterface samlVerifier;
        VerificationProfileType profile;

        samlVerifier = new SAMLVerifierImpl();
        profile = new VerificationProfileType();

        SamlTokenVerificationChecksType check = new SamlTokenVerificationChecksType();
        check.setVerifySAMLResponseIssueInstant(Boolean.TRUE);
        profile.setSamlTokenVerificationChecks(check);

        for (Response token : III_SignatureTestSuite.tokens.values()) {
            samlVerifier.verify(token, profile);
        }
    }

    @Test
    public void AssertionIssueInstant() throws SAMLVerifyException {
        SAMLVerifierInterface samlVerifier;
        VerificationProfileType profile;

        samlVerifier = new SAMLVerifierImpl();
        profile = new VerificationProfileType();

        SamlTokenVerificationChecksType check = new SamlTokenVerificationChecksType();
        check.setVerifySAMLAssertionIssueInstant(Boolean.TRUE);
        profile.setSamlTokenVerificationChecks(check);

        for (Response token : III_SignatureTestSuite.tokens.values()) {
            samlVerifier.verify(token, profile);
        }
    }


    @Test
    public void Conditions_NotBefore() throws SAMLVerifyException {
        SAMLVerifierInterface samlVerifier;
        VerificationProfileType profile;

        samlVerifier = new SAMLVerifierImpl();
        profile = new VerificationProfileType();

        SamlTokenVerificationChecksType check = new SamlTokenVerificationChecksType();
        check.setVerifySAMLAssertionConditionsTimestamps(Boolean.TRUE);
        profile.setSamlTokenVerificationChecks(check);

        for (Response token : III_SignatureTestSuite.tokens.values()) {
            samlVerifier.verify(token, profile);
        }
    }
}
