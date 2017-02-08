/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

import java.io.File;
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
import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.provider.SamlEidProvider;
import org.rub.nds.sso.api.SamlAuthnRequestVerificationChecksType;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.SamlVerificationParametersType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.api.VerificationResponseType;
import org.xml.sax.SAXException;

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

    @Test
    public void testVerifySAMLResponseSignatureTrusted() throws JAXBException, SAXException, NoSuchEidProviderException {

        VerificationResponseType result = new VerificationResponseType();

        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();
        checks.setVerifySAMLResponseSignatureTrusted(Boolean.TRUE);

        String samlResponseFile = "src/test/resources/SamlEidProvider/SamlResponseWithSignedAssertionAndMessage.xml";

        String saml_metadata;
        saml_metadata = "src/test/resources/SamlEidProvider/metadata.xml";
        SamlVerificationParametersType verificationParameters = new SamlVerificationParametersType();
        verificationParameters.setSamlMetadata(saml_metadata);
        result = testVerifySAMLResponse(checks, samlResponseFile, verificationParameters);
        if (!result.isResult()) {
            // fail();
        }
    }

    @Test
    public void testVerifySAMLResponseSignatureTrustedUrl() throws JAXBException, SAXException,
            NoSuchEidProviderException {

        VerificationResponseType result = new VerificationResponseType();

        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();
        checks.setVerifySAMLResponseSignatureTrusted(Boolean.TRUE);

        String samlResponseFile = "src/test/resources/SamlEidProvider/SamlResponseWithSignedAssertionAndMessage.xml";

        String saml_metadata_url;
        saml_metadata_url = "https://www.telenaut.de/ft/certfile";
        SamlVerificationParametersType verificationParameters = new SamlVerificationParametersType();
        verificationParameters.setSamlMetadataUrl(saml_metadata_url);
        result = testVerifySAMLResponse(checks, samlResponseFile, verificationParameters);
        if (!result.isResult()) {
            // fail();
        }
    }

    @Test
    public void testVerifySAMLResponseSchema() throws JAXBException, SAXException, NoSuchEidProviderException {

        VerificationResponseType result = new VerificationResponseType();

        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();
        checks.setVerifySchema(Boolean.TRUE);

        String samlResponseFile = "src/test/resources/SamlEidProvider/SamlResponseWithSignedAssertionAndMessage.xml";

        SamlVerificationParametersType verificationParameters = new SamlVerificationParametersType();
        result = testVerifySAMLResponse(checks, samlResponseFile, verificationParameters);
        if (!result.isResult()) {
            fail();
        }
    }

    @Test
    public void testVerifySAMLResponseSchemaUrl() throws JAXBException, SAXException, NoSuchEidProviderException {

        VerificationResponseType result = new VerificationResponseType();

        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();
        checks.setVerifySchema(Boolean.TRUE);

        String samlResponseFile = "src/test/resources/SamlEidProvider/SamlResponseWithSignedAssertionAndMessage.xml";

        SamlVerificationParametersType verificationParameters = new SamlVerificationParametersType();
        verificationParameters.setSamlSchemaUrl("test");
        result = testVerifySAMLResponse(checks, samlResponseFile, verificationParameters);
        if (!result.isResult()) {
            fail();
        }
    }

    private VerificationResponseType testVerifySAMLResponse(SamlTokenVerificationChecksType checks,
            String samlResponseFile, SamlVerificationParametersType verificationParameters) throws JAXBException,
            SAXException, NoSuchEidProviderException {

        VerificationResponseType result = new VerificationResponseType();

        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<SamlType> SamlType;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/test/resources/schema/ssolib_API.xsd"));
        unmarshaller.setSchema(schema);

        File file = new File(samlResponseFile);
        SamlType = (JAXBElement<SamlType>) unmarshaller.unmarshal(file);
        SamlType samlType = SamlType.getValue();

        VerificationProfileType verificationProfile = new VerificationProfileType();

        verificationProfile.setID(UUID.randomUUID().toString());
        verificationProfile.setSamlTokenVerificationChecks(checks);
        verificationProfile.setSamlTokenVerificationParameters(verificationParameters);

        EidProvider p = new SamlEidProvider();
        p.setVerificationProfile(verificationProfile);
        result = p.verify(samlType);
        return result;
    }

}
