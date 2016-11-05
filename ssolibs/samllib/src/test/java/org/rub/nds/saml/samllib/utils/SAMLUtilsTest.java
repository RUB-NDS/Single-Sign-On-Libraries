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
package org.rub.nds.saml.samllib.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Subject;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.WrongInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SAMLUtilsTest{

    private static Logger _log = LoggerFactory.getLogger(SAMLUtilsTest.class);

    /**
     *
     */
    public SAMLUtilsTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     * @throws ConfigurationException
     * @throws IOException
     */
    @Before
    public void setUp() throws ConfigurationException, IOException {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class SAMLUtils.
     */
    @Test
    public void testGetInstance() {
        _log.debug("Test SAMLUtils create instance!");
        assertNotNull(SAMLUtils.getInstance());
    }

    /**
     * Test of getID method, of class SAMLUtils.
     */
    @Test
    public void testGetID() {
        _log.debug("Test SAMLUtils:getID()");

        assertNotNull(SAMLUtils.getID());
        assertNotEquals(SAMLUtils.getID(), SAMLUtils.getID());
    }

    /**
     * Test of getDateTime method, of class SAMLUtils.
     */
    @Test
    public void testGetDateTime() {
        _log.debug("Test SAMLUtils:getDateTime()");
        assertNotNull(SAMLUtils.getDateTime());
    }

    /**
     * Test of getSAMLBuilder method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testGetSAMLBuilder() throws Exception {
        _log.debug("Test SAMLUtils:getSAMLBuilder()");
        assertNotNull(SAMLUtils.getSAMLBuilder());
        assertNotNull(SAMLUtils.getSAMLBuilder(Assertion.DEFAULT_ELEMENT_NAME));

        //Check if Exception will be catched
        try {
            Element e = null;
            QName q = null;

            assertNotNull(SAMLUtils.getSAMLBuilder(e));
            assertNotNull(SAMLUtils.getSAMLBuilder(q));
        } catch (SAMLBuildException ex) {
            //expected exceptions will be catched 
        }
    }

    /**
     * Test of buildObjectfromString method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testBuildObjectfromString() throws Exception {
        _log.debug("Test SAMLUtils:BuildObjectfromString()");

        _log.trace("Test SAMLUtils:BuildObjectfromString() - test valid tokens");
        //Convert the stored tokens: xml-File To SAMLObject
        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_decoded)), "xml")) {
            assertNotNull(SAMLUtils.buildObjectfromString(s));
        }

        _log.trace("Test SAMLUtils:BuildObjectfromString() - test valid authRequests");
        //Convert the stored AuthnRequests: xml-File To SAMLObject
        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)), "xml")) {
            assertNotNull(SAMLUtils.buildObjectfromString(s));
        }

        _log.trace("Test SAMLUtils:BuildObjectfromString() - test invalid tokens");
        //Convert error messages -> All possible Exception MUST be catched
        try {
            assertNotNull(SAMLUtils.buildObjectfromString(null));
            assertNotNull(SAMLUtils.buildObjectfromString(""));

            for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_error)), "xml")) {
                assertNotNull(SAMLUtils.buildObjectfromString(s));
            }
        } catch (WrongInputException ex) {
            //expected Exception
        }
    }

    /**
     * Test of getAuthnRequestAttributes method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testGetAuthnRequestAttributes() throws Exception {
        _log.debug("Test SAMLUtils:getAuthnRequestAttributes()");
        String authnReqStr;
        AuthnRequest authnReq;
        List<String> expected;

        //Test with AuthnRequest containing some attributes
        expected = new ArrayList<>();
        expected.add("http://www.skidentity.de/policy/eGK-IS");
        expected.add("http://www.skidentity.de/att/email");
        expected.add("http://www.skidentity.de/att/eIdentifier");

        authnReqStr = FileUtils.readFile(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)).concat("/authreq2.xml"));
        authnReq = (AuthnRequest) SAMLUtils.buildObjectfromString(authnReqStr);
        assertArrayEquals(expected.toArray(), SAMLUtils.getAuthnRequestAttributes(authnReq).toArray());


        //Test with invalid AuthnRequest
        //  - AuthnRequest does not contain any attributes
        //  - AuthnRequest is NULL
        //  - AuthnRequest is empty
        authnReqStr = FileUtils.readFile(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)).concat("/authreq1.xml"));
        authnReq = (AuthnRequest) SAMLUtils.buildObjectfromString(authnReqStr);

        try {
            SAMLUtils.getAuthnRequestAttributes(authnReq);
            SAMLUtils.getAuthnRequestAttributes(null);
            SAMLUtils.getAuthnRequestAttributes((AuthnRequest) SAMLUtils.getSAMLBuilder(AuthnRequest.DEFAULT_ELEMENT_NAME));
        } catch (WrongInputException ex) {
            //expected exception - do nothing
        }
    }

    /**
     * Test of getIssuer method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testGetIssuer() throws Exception {
        _log.debug("Test SAMLUtils:getIssuer()");

        List<String> expected;

        expected = new ArrayList<>();
        expected.add("RUB-NDS Service Provider");
        expected.add("http://mladevbb.cloudseal.com/saml/sp");
        expected.add("http://idp.id4health.com:8084/openam");
        expected.add("https://app.onelogin.com/saml/metadata/52424");
        expected.add("http://cloudseal.com");
        expected.add("http://skidentity.de/IdentityProvider");


        //Convert the stored tokens: xml-File To SAMLObject
        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_decoded)), "xml")) {
            assertTrue(expected.contains(SAMLUtils.getIssuer(SAMLUtils.buildObjectfromString(s))));
        }

        //Convert the stored AuthnRequests: xml-File To SAMLObject
        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)), "xml")) {
            assertTrue(expected.contains(SAMLUtils.getIssuer(SAMLUtils.buildObjectfromString(s))));
        }


        //Test error scenarios
        try {
            assertNotNull(SAMLUtils.getIssuer(null));
            assertNotNull(SAMLUtils.getIssuer((Assertion) SAMLUtils.getSAMLBuilder(Assertion.DEFAULT_ELEMENT_NAME).buildObject()));
            assertNotNull(SAMLUtils.getIssuer((Response) SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject()));
            assertNotNull(SAMLUtils.getIssuer((AuthnRequest) SAMLUtils.getSAMLBuilder(AuthnRequest.DEFAULT_ELEMENT_NAME).buildObject()));
        } catch (WrongInputException ex) {
            //expected Exceptions
        }
    }

    /**
     * Test of getCredential method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testGetCredential() throws Exception {
        //TODO
    }

    /**
     * Test of isSigned method, of class SAMLUtils.
     * @throws IOException
     * @throws WrongInputException
     * @throws SAMLBuildException  
     */
    @Test
    public void testIsSigned_SAMLObject() throws IOException, WrongInputException, SAMLBuildException {
        _log.debug("Test SAMLUtils:isSigned_SAMLObject()");

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_decoded)), "xml")) {
            Response response = (Response) SAMLUtils.buildObjectfromString(s);

            assertFalse(SAMLUtils.isSigned(response));
            assertTrue(SAMLUtils.isSigned(response.getAssertions().get(0)));
        }

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)), "xml")) {
            assertFalse(SAMLUtils.isSigned(SAMLUtils.buildObjectfromString(s)));
        }


        //Test error scenarios
        try {
            SAMLObject obj = null;
            List<SAMLObject> objList = null;


            SAMLUtils.isSigned((SAMLObject) SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject());
            SAMLUtils.isSigned((SAMLObject) SAMLUtils.getSAMLBuilder(Subject.DEFAULT_ELEMENT_NAME).buildObject());
            SAMLUtils.isSigned(obj);
            SAMLUtils.isSigned(objList);

            objList = new ArrayList<>();
            SAMLUtils.isSigned(objList);

        } catch (WrongInputException ex) {
            //expected Exceptions
        }
    }

    /**
     * Test of getHokCertificate method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testGetHokCertificate() throws Exception {
        _log.debug("Test SAMLUtils:getHokCertificate()");

        Response response;
        String xpathHOK = "//saml2:Assertion[name(parent::node())='saml2p:Response']/saml2:Subject/saml2:SubjectConfirmation[@Method='urn:oasis:names:tc:SAML:2.0:cm:holder-of-key']/saml2:SubjectConfirmationData/ds:KeyInfo/ds:X509Data/ds:X509Certificate";
        String expected = "MIIEwDCCAqigAwIBAgIBajANBgkqhkiG9w0BAQsFADCBjDELMAkGA1UEBhMCREUxDzANBgNVBAgTBkJheWVybjERMA8GA1UEBxMITWljaGVsYXUxEzARBgNVBAoTCmVjc2VjIEdtYkgxDDAKBgNVBAsTA1BLSTEZMBcGA1UEAxMQZWNzZWMtUGFydG5lci1DQTEbMBkGCSqGSIb3DQEJARYMcGtpQGVjc2VjLmRlMB4XDTEzMDMyMjEzMTMwMFoXDTE1MDExNTEzMTMwMFowZjELMAkGA1UEBhMCREUxGDAWBgNVBAoTD1NrSURlbnRpdHkgVGVhbTEYMBYGA1UEAxMPU2tJRGVudGl0eSBUZWFtMSMwIQYJKoZIhvcNAQkBFhRpbnRlcm5Ac2tpZGVudGl0eS5kZTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALoajUVMAGawbqNnMHrIBVY3jpiA+3gJVOEF0zTDFJSNqvQVKNQUyhUxuuWNHW6hDhVc3lp1B4GmYJxafM5cdTRWqi2dsGo0/0p8yGUCScA8hXhOBrY0yvH7sJLBsOKDCC3K4/i0dw8cwvuukjXOtmR6NMZiCpzyh1sUFj7DqBB28tYSfGatSReG5jDSYJFfh07xuKsP5SjziKQC0Fh0EuX/IMwXIayuK0g8nzLpQ7CjuGsuoa8u/1oFGiyp/FoSXQswkBFeh+ifMD5HlJBtFl/Xfyn+3PqI1il7e0me221BsGH6xZ025wgq4LvTB02f50YJxVNKgYkrrcA7h2RxHq0CAwEAAaNSMFAwDAYDVR0TAQH/BAIwADAdBgNVHQ4EFgQUAdaRtdv80Re3RSBspDv8r6GLxxcwDgYDVR0PAQH/BAQDAgO4MBEGCWCGSAGG+EIBAQQEAwIFoDANBgkqhkiG9w0BAQsFAAOCAgEAcg9tw+juqV4TTAyN1VGvY0Vff41cwQ/2gVn6UxoLHJVe4uIOPhxZNj18aYZWJKlUL05oLiXo0ZIUabtyxCYl/lSdQZpAxL/OUFo2NKiLrd40CQzX4arBG42q1gROCZUs8xMtXAqTBUUZ1PVSosVQj28kr26HeweW39da0rVStCW4zB3rZC/ENMeIvS3dwMCd2Dg1FooHR0EkERad4dy1RYdmVsR/22xrtJFywnuU3yNB+yt6KRKvf1WwQvhL0bNYgCLGmnz5Fv95YfYcGvZ1cqJUvZpyOnMbwZgojnJbqiMbGcZ95b2HRKblMBhHsnkIIxwEeeroIL4pH5Ktc8ogCGCYXmotMJs6ykljAn9V4BsfCTwZk48OcovPoFwmt9ZvOmwa19daABx+8f5TSVS9okwYd4y/RSaNIikJ2tahwofqFvCi/kh+3qsPsqxODUWb7SYMaThkRJbrFpfutLOOIGYNE7BaSYdqdIaf6QedPd9AnEhQ3Ltokr8C+P9nt9l9WeX070IPxZZ69A877pVnvgCDQzbjOifrHVlGVwG1VZZreYDgssbLG2WU7E5YqUs9WSzIXcU07Y4z1XG/31beMd/4ixQ8bOTwEzn3WwEpjNJW6oQHWY1kOga41gGov61nYpO/ncfVaGWCrxk+h94Rznkfq4+F40LwvLnNNYstFDU=";

        response = (Response) SAMLUtils.buildObjectfromString(FileUtils.readFile(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_decoded)).concat("/token4.xml")));
        assertEquals(SAMLUtils.getHokCertificate(response, xpathHOK).item(0).getTextContent().replace("\n", ""), expected);

        //Test error scenarios
        try {
            assertNotNull(SAMLUtils.getHokCertificate(null, xpathHOK));
            assertNotNull(SAMLUtils.getHokCertificate(null, null));
            assertNotNull(SAMLUtils.getHokCertificate(response, null));
            assertNotNull(SAMLUtils.getHokCertificate(SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject(), ""));
        } catch (WrongInputException ex) {
        }

    }

    /**
     * Test of saml2xml method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testSaml2xml() throws Exception {
        _log.debug("Test SAMLUtils:saml2xml()");

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_decoded)), "xml")) {
            assertNotNull(SAMLUtils.saml2xml(SAMLUtils.buildObjectfromString(s)));
        }

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)), "xml")) {
            assertNotNull(SAMLUtils.saml2xml(SAMLUtils.buildObjectfromString(s)));
        }

        //Test error scenarios
        try {
            assertNotNull(SAMLUtils.saml2xml(null));
            assertNotNull(SAMLUtils.saml2xml(SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject()));
        } catch (WrongInputException ex) {
        }

    }
    
    
    /**
     * Test of samlObj2String method, of class SAMLUtils.
     * @throws Exception 
     */
    @Test
    public void testSamlObj2String() throws Exception {
        _log.debug("Test SAMLUtils:samlObj2String()");
        List<String> expected;
        
        expected = new ArrayList<>();
     
        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_token_decoded)), "xml")) {
            assertNotNull(SAMLUtils.samlObj2String(SAMLUtils.buildObjectfromString(s)));
        }

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty(I_MainTestSuite.path_authRequest_decoded)), "xml")) {
            assertNotNull(SAMLUtils.samlObj2String(SAMLUtils.buildObjectfromString(s)));
        }

        //Test error scenarios
        try {
            assertNotNull(SAMLUtils.samlObj2String(null));
            assertNotNull(SAMLUtils.samlObj2String(SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject()));
            assertNotEquals("", SAMLUtils.samlObj2String(SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject()));
        } catch (WrongInputException ex) {
        }
    }
}