/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

import java.io.File;
import java.io.StringReader;
import java.util.UUID;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.api.SamlAuthnRequestVerificationChecksType;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.SamlVerificationParametersType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.utils.FileUtils;

/**
 *
 * @author vmladenov
 */
public class EidProviderTest {

    public EidProviderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ConfigurationException {
        DefaultBootstrap.bootstrap();
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

    /**
     * Test of verify method, of class EidProvider.
     */
    @Test
    // (expected = SAMLVerifyException.class)
    public void testVerify() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<SamlType> SamlType;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/test/resources/schema/ssolib_API.xsd"));
        unmarshaller.setSchema(schema);
        for (String s : FileUtils.readFilesFromDir("src/test/resources/Saml/valid", "xml")) {
            StringReader reader = new StringReader(s);
            SamlType = (JAXBElement<SamlType>) unmarshaller.unmarshal(reader);
            SamlType samlType = SamlType.getValue();

            VerificationProfileType verificationProfile = new VerificationProfileType();
            SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();

            checks.setVerifiySAMLAssertionSignature(Boolean.TRUE);
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

            EidProvider instance = new EidProvider(samlType, verificationProfile);
            try {
                instance.verify();
            } catch (SAMLVerifyException e) {
            } catch (Exception e) {
                fail(e.getMessage());
            }

        }
    }

}
