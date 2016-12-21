/*
 * Copyright (C) 2016 Ole Lemke <ole.lemke@rub.de>.
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
package org.rub.nds.saml.samllib.provider;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.rub.nds.sso.api.SamlAuthnRequestVerificationChecksType;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.SamlVerificationParametersType;
import org.rub.nds.sso.api.SsoType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.api.VerificationResponseType;
import org.rub.nds.sso.provider.EidProvider;
import org.rub.nds.sso.provider.EidSecurity;
import org.rub.nds.sso.provider.NoSuchEidProviderException;
import org.rub.nds.sso.utils.FileUtils;
import org.xml.sax.SAXException;

/**
 *
 * @author Ole Lemke <ole.lemke@rub.de>
 */
@RunWith(Parameterized.class)
public class SamlEidProviderTest {

    @Before
    public void init() {
        EidSecurity.addEidProvider(new SamlEidProvider());
    }

    @Parameters
    public static List<Object[]> data() throws IOException, JAXBException, SAXException {

        List result;
        result = new ArrayList<>();

        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<SamlType> SamlType;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/test/resources/schema/ssolib_API.xsd"));
        unmarshaller.setSchema(schema);

        for (String s : FileUtils.readFilesFromDir("src/test/resources/SamlType/valid", "xml")) {
            StringReader reader = new StringReader(s);
            SamlType = (JAXBElement<SamlType>) unmarshaller.unmarshal(reader);
            SamlType samlType = SamlType.getValue();

            VerificationProfileType verificationProfile = new VerificationProfileType();
            SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();

            for (int i = 19; i < 20; i++) {
                switch (i) {
                    case 1:
                        checks.setVerifySchema(Boolean.TRUE);
                    case 2:
                        checks.setVerifyXSW(Boolean.TRUE);
                    case 3:
                        checks.setVerifySAMLResponseID(Boolean.TRUE);
                    case 4:
                        checks.setVerifySAMLResponseIssueInstant(Boolean.TRUE);
                    case 5:
                        checks.setVerifySAMLResponseSignatureTrusted(Boolean.TRUE);
                    case 6:
                        checks.setVerifySAMLResponseSignature(Boolean.TRUE);
                    case 7:
                        checks.setVerifySAMLResponseInResponseTo(Boolean.TRUE);
                    case 8:
                        checks.setVerifySAMLAssertionID(Boolean.TRUE);
                    case 9:
                        checks.setVerifySAMLAssertionSignatureTrusted(Boolean.TRUE);
                    case 10:
                        checks.setVerifySAMLAssertionSignature(Boolean.TRUE);
                    case 11:
                        checks.setVerifySAMLAssertionInResponseTo(Boolean.TRUE);
                    case 12:
                        checks.setVerifySAMLAssertionIssueInstant(Boolean.TRUE);
                    case 13:
                        checks.setVerifySAMLAssertionSbjConfirmationTimestamps(Boolean.TRUE);
                    case 14:
                        checks.setVerifySAMLAssertionSbjConfirmationDestination(Boolean.TRUE);
                    case 15:
                        checks.setVerifySAMLAssertionSbjInResponseTo(Boolean.TRUE);
                    case 16:
                        checks.setVerifySAMLAssertionConditionsTimestamps(Boolean.TRUE);
                    case 17:
                        checks.setVerifySAMLAssertionConditionsAudience(Boolean.TRUE);
                    case 18:
                        checks.setVerifySAMLAssertionAuthnMethod(Boolean.TRUE);
                    case 19:
                        checks.setVerifyHolderOfKey(Boolean.TRUE);
                }

                samlType.setSamlTokenVerificationChecks(checks);

                SamlVerificationParametersType verificationParameters;
                String samlVerificationProfile;
                SamlTokenVerificationChecksType samlTokenVerificationChecks;
                SamlAuthnRequestVerificationChecksType samlAuthnRequestVerificationChecks;
                verificationParameters = samlType.getSamlVerificationParameters();
                samlVerificationProfile = samlType.getSamlVerificationProfile();
                samlAuthnRequestVerificationChecks = samlType.getSamlAuthnReqVerificationChecks();

                verificationProfile.setID(UUID.randomUUID().toString());
                verificationProfile.setSamlAuthnReqVerificationChecks(samlAuthnRequestVerificationChecks);
                verificationProfile.setSamlTokenVerificationChecks(checks);
                verificationProfile.setSamlTokenVerificationParameters(verificationParameters);

                result.add(new Object[] { samlType, verificationProfile, i, s });
            }
        }
        return result;
    }

    private SamlType samlType;
    private VerificationProfileType verificationProfile;
    private int profileID;
    private String saml;

    public SamlEidProviderTest(SamlType s, VerificationProfileType v, int ID, String string) {
        samlType = s;
        verificationProfile = v;
        profileID = ID;
        saml = string;
    }

    @Test
    public void testVerify() throws NoSuchEidProviderException, Exception {
        try {
            if (verificationProfile != null && samlType != null) {
                EidProvider p = EidSecurity.getEidProviderInstance("saml");
                p.setVerificationProfile(verificationProfile);
                p.verify(samlType);
            }
        } catch (Exception e) {
            System.out.println("Failed with Verification Profile ID:");
            System.out.println(profileID);
            System.out.println(saml);
            throw e;
        }

    }

}
