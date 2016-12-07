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

    // public EidProviderTest() {
    // }
    //
    // @BeforeClass
    // public static void setUpClass() throws ConfigurationException {
    // DefaultBootstrap.bootstrap();
    // }
    //
    // @AfterClass
    // public static void tearDownClass() {
    // }
    //
    // @Before
    // public void setUp() {
    //
    // }
    //
    // @After
    // public void tearDown() {
    // }
    //
    // /**
    // * Test of verify method, of class EidProvider.
    // */
    // @Test
    // // (expected = SAMLVerifyException.class)
    // public void testVerify() throws Exception {
    // JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.sso.api");
    // Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    // JAXBElement<SamlType> SamlType;
    // SchemaFactory sf =
    // SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    // Schema schema = sf.newSchema(new
    // File("src/test/resources/schema/ssolib_API.xsd"));
    // unmarshaller.setSchema(schema);
    // for (String s :
    // FileUtils.readFilesFromDir("src/test/resources/Saml/valid", "xml")) {
    // StringReader reader = new StringReader(s);
    // SamlType = (JAXBElement<SamlType>) unmarshaller.unmarshal(reader);
    // SamlType samlType = SamlType.getValue();
    //
    // VerificationProfileType verificationProfile = new
    // VerificationProfileType();
    // SamlTokenVerificationChecksType checks = new
    // SamlTokenVerificationChecksType();
    //
    // for (int i = 10; i < 20; i++) {
    // switch (i) {
    // case 1:
    // checks.setVerifySchema(Boolean.TRUE);
    // case 2:
    // checks.setVerifyXSW(Boolean.TRUE);
    // case 3:
    // checks.setVerifySAMLResponseID(Boolean.TRUE);
    // case 4:
    // checks.setVerifySAMLResponseIssueInstant(Boolean.TRUE);
    // case 5:
    // checks.setVerifySAMLResponseSignatureTrusted(Boolean.TRUE);
    // case 6:
    // checks.setVerifySAMLResponseSignature(Boolean.TRUE);
    // case 7:
    // checks.setVerifySAMLResponseInResponseTo(Boolean.TRUE);
    // case 8:
    // checks.setVerifySAMLAssertionID(Boolean.TRUE);
    // case 9:
    // checks.setVerifySAMLAssertionSignatureTrusted(Boolean.TRUE);
    // case 10:
    // checks.setVerifySAMLAssertionSignature(Boolean.TRUE);
    // case 11:
    // checks.setVerifySAMLAssertionInResponseTo(Boolean.TRUE);
    // case 12:
    // checks.setVerifySAMLAssertionIssueInstant(Boolean.TRUE);
    // case 13:
    // checks.setVerifySAMLAssertionSbjConfirmationTimestamps(Boolean.TRUE);
    // case 14:
    // checks.setVerifySAMLAssertionSbjConfirmationDestination(Boolean.TRUE);
    // case 15:
    // checks.setVerifySAMLAssertionSbjInResponseTo(Boolean.TRUE);
    // case 16:
    // checks.setVerifySAMLAssertionConditionsTimestamps(Boolean.TRUE);
    // case 17:
    // checks.setVerifySAMLAssertionConditionsAudience(Boolean.TRUE);
    // case 18:
    // checks.setVerifySAMLAssertionAuthnMethod(Boolean.TRUE);
    // case 19:
    // checks.setVerifyHolderOfKey(Boolean.TRUE);
    // }
    //
    // samlType.setSamlTokenVerificationChecks(checks);
    //
    // SamlVerificationParametersType verificationParameters;
    // String samlVerificationProfile;
    // SamlTokenVerificationChecksType samlTokenVerificationChecks;
    // SamlAuthnRequestVerificationChecksType
    // samlAuthnRequestVerificationChecks;
    // verificationParameters = samlType.getSamlVerificationParameters();
    // samlVerificationProfile = samlType.getSamlVerificationProfile();
    // samlAuthnRequestVerificationChecks =
    // samlType.getSamlAuthnReqVerificationChecks();
    //
    // verificationProfile.setID(UUID.randomUUID().toString());
    // verificationProfile.setSamlAuthnReqVerificationChecks(samlAuthnRequestVerificationChecks);
    // verificationProfile.setSamlTokenVerificationChecks(checks);
    // verificationProfile.setSamlTokenVerificationParameters(verificationParameters);
    //
    // EidProvider instance = new EidProvider(samlType, verificationProfile);
    // try {
    // instance.verify();
    // } catch (SAMLVerifyException e) {
    // } catch (Exception e) {
    // throw e;
    // }
    // }
    //
    // }
    // }

}