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
import java.net.URLEncoder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opensaml.DefaultBootstrap;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.sso.exceptions.WrongInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class HTTPUtilsTest {

    private static Logger _log = LoggerFactory.getLogger(HTTPUtilsTest.class);
    String httpResponse;
    String destination;
    String encodedResponse;

    String text;
    String samlObjectStr;
    SAMLObject samlObject;

    String decoded;
    String encoded;

    String encodedAuthnReqURLenc;
    String authnReqresult;
    String encodedAuthnReq;
    
    String deflatedResponse;

    public HTTPUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        DefaultBootstrap.bootstrap();
        destination = "http://test.com";
        encodedResponse = "SAMLRESPONSE";

        httpResponse = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">"
                + "<head>"
                + "<meta http-equiv=\"contet-type\" content=\"text/html; charset=utf-8\" />"
                + "<title>POST data</title></head>"
                + "<body onload=\"document.forms[0].submit()\">"
                + "<noscript>"
                + "<p><strong>Note:</strong> Since your browser does not support JavaScript, you must press the button below once to proceed.</p>"
                + "</noscript>" + "<form method=\"post\" action=\"" + destination + "\">"
                + "<input type=\"hidden\" name=\"SAMLResponse\" value=\"" + encodedResponse + "\" />"
                + "<noscript><input type=\"submit\" value=\"Submit\" /></noscript>" + "</form></body></html>";

        text = "CjxzYW1scDpBdXRoblJlcXVlc3QgQXNzZXJ0aW9uQ29uc3VtZXJTZXJ2aWNlVVJMPSJodHRwczovL3d3dy5nb29nbGUuY29tL2Evc29sd2ViLm5vL2FjcyIgSUQ9ImFnZG9iamNmaWtuZW9tbWZqYW1kY2xlbmpjcGNqbWdkZ2JtcGdqbW8iIElzUGFzc2l2ZT0idHJ1ZSIgSXNzdWVJbnN0YW50PSIyMDA3LTA0LTI2VDEzOjUxOjU2WiIgUHJvdG9jb2xCaW5kaW5nPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YmluZGluZ3M6SFRUUC1QT1NUIiBQcm92aWRlck5hbWU9Imdvb2dsZS5jb20iIFZlcnNpb249IjIuMCIgeG1sbnM6c2FtbHA9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpwcm90b2NvbCI+PHNhbWw6SXNzdWVyIHhtbG5zOnNhbWw9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iPmdvb2dsZS5jb208L3NhbWw6SXNzdWVyPjxzYW1scDpOYW1lSURQb2xpY3kgQWxsb3dDcmVhdGU9InRydWUiIEZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOm5hbWVpZC1mb3JtYXQ6dW5zcGVjaWZpZWQiLz48L3NhbWxwOkF1dGhuUmVxdWVzdD4=";
        samlObjectStr = "<samlp:AuthnRequest xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\" ID=\"agdobjcfikneommfjamdclenjcpcjmgdgbmpgjmo\" Version=\"2.0\" IssueInstant=\"2007-04-26T13:51:56Z\" ProtocolBinding=\"urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST\" ProviderName=\"google.com\" AssertionConsumerServiceURL=\"https://www.google.com/a/solweb.no/acs\" IsPassive=\"true\"><saml:Issuer xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\">google.com</saml:Issuer><samlp:NameIDPolicy AllowCreate=\"true\" Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:unspecified\" /></samlp:AuthnRequest>";

        samlObject = SAMLUtils.buildObjectfromString(samlObjectStr);

        decoded = "PHNhbWxwOkF1dGhuUmVxdWVzdCB4bWxuczpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIiBBc3NlcnRpb25Db25zdW1lclNlcnZpY2VVUkw9Imh0dHBzOi8vd3d3Lmdvb2dsZS5jb20vYS9zb2x3ZWIubm8vYWNzIiBJRD0iYWdkb2JqY2Zpa25lb21tZmphbWRjbGVuamNwY2ptZ2RnYm1wZ2ptbyIgSXNQYXNzaXZlPSJ0cnVlIiBJc3N1ZUluc3RhbnQ9IjIwMDctMDQtMjZUMTM6NTE6NTZaIiBQcm90b2NvbEJpbmRpbmc9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpiaW5kaW5nczpIVFRQLVBPU1QiIFByb3ZpZGVyTmFtZT0iZ29vZ2xlLmNvbSIgVmVyc2lvbj0iMi4wIj48c2FtbDpJc3N1ZXIgeG1sbnM6c2FtbD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiI+Z29vZ2xlLmNvbTwvc2FtbDpJc3N1ZXI+PHNhbWxwOk5hbWVJRFBvbGljeSBBbGxvd0NyZWF0ZT0idHJ1ZSIgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDp1bnNwZWNpZmllZCIvPjwvc2FtbHA6QXV0aG5SZXF1ZXN0Pg==";
        encoded = "PHNhbWxwOkF1dGhuUmVxdWVzdCB4bWxuczpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIiBBc3NlcnRpb25Db25zdW1lclNlcnZpY2VVUkw9Imh0dHBzOi8vd3d3Lmdvb2dsZS5jb20vYS9zb2x3ZWIubm8vYWNzIiBJRD0iYWdkb2JqY2Zpa25lb21tZmphbWRjbGVuamNwY2ptZ2RnYm1wZ2ptbyIgSXNQYXNzaXZlPSJ0cnVlIiBJc3N1ZUluc3RhbnQ9IjIwMDctMDQtMjZUMTM6NTE6NTZaIiBQcm90b2NvbEJpbmRpbmc9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpiaW5kaW5nczpIVFRQLVBPU1QiIFByb3ZpZGVyTmFtZT0iZ29vZ2xlLmNvbSIgVmVyc2lvbj0iMi4wIj48c2FtbDpJc3N1ZXIgeG1sbnM6c2FtbD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiI%2BZ29vZ2xlLmNvbTwvc2FtbDpJc3N1ZXI%2BPHNhbWxwOk5hbWVJRFBvbGljeSBBbGxvd0NyZWF0ZT0idHJ1ZSIgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDp1bnNwZWNpZmllZCIvPjwvc2FtbHA6QXV0aG5SZXF1ZXN0Pg%3D%3D";

        encodedAuthnReqURLenc = "nVTbctowEP0Vjd6NL5DYaGIyJExaprkwmPQhLx1FXhc1tkSlNYS%2Fj2wgCXRKm7zu5ezZs5ez8%2BeqJEswVmqV0rATUAJK6Fyqnym9n115CT0fnFleldGCDWucqyn8rsEicYnKso0npbVRTHMrLVO8AstQsGx4c82iTsAWRqMWuqRkaC0YdKUutbJ1BSYDs5QC7qfXKZ0jLizz%2FVILXs61RZb0el0%2FexqPQKHEdTbxpcrhuTPHyoFdaSOgpZRSNDVQMh6l9EfSL5Je2E3iJIhD3hen0Wl8GvfiMAx7PBaxC7MTbq1cQkoLXtom0doaxsoiV5jSKAi7XhB5QTILE3ZywrpRpx%2F0HyiZbDu5cDxahY61%2FbgJsuzrbDbxppBLAwIp%2Bb5T2wXRrbasZWDei3ocnO%2BUpIPp%2FYV3O8rIVsuG5FLmYM7899C7Qln9%2BMvR%2BFSlLcStixmP%2FANEN9JCmoo3oeQGcK7z48CiYnNdOqKeLrwnWH8Af8SRk1uNd%2BrODAsEsz%2B0Pos2QwuDh1fUIaKRjzUCuTISVF6umzqbtXNbt1qtOvbJ6dauWicHf6FLKdY%2BfPnmjTNKPhTt%2F1n1H%2Fkc0YeKy%2FKzuePWUEgwDYJ%2FVLtj%2FkPf6%2FVvxjJp%2ByTDstSrSwMc367IHaSDOD70xiJzr2hDGRqurBsGvjXtqOSy4WE%2Fs6LNUlyAQ4e%2FnHEYPtD%2F2pzw3ebUueMoYOrenpFiI9K%2Ba%2FCx57WT%2BDX90LBXyj9UZmfa%2F8iDFw%3D%3D";

        encodedAuthnReq = "nVTbctowEP0Vjd6NL5DYaGIyJExaprkwmPQhLx1FXhc1tkSlNYS/j2wgCXRKm7zu5ezZs5ez8+eqJEswVmqV0rATUAJK6Fyqnym9n115CT0fnFleldGCDWucqyn8rsEicYnKso0npbVRTHMrLVO8AstQsGx4c82iTsAWRqMWuqRkaC0YdKUutbJ1BSYDs5QC7qfXKZ0jLizz/VILXs61RZb0el0/exqPQKHEdTbxpcrhuTPHyoFdaSOgpZRSNDVQMh6l9EfSL5Je2E3iJIhD3hen0Wl8GvfiMAx7PBaxC7MTbq1cQkoLXtom0doaxsoiV5jSKAi7XhB5QTILE3ZywrpRpx/0HyiZbDu5cDxahY61/bgJsuzrbDbxppBLAwIp+b5T2wXRrbasZWDei3ocnO+UpIPp/YV3O8rIVsuG5FLmYM7899C7Qln9+MvR+FSlLcStixmP/ANEN9JCmoo3oeQGcK7z48CiYnNdOqKeLrwnWH8Af8SRk1uNd+rODAsEsz+0Pos2QwuDh1fUIaKRjzUCuTISVF6umzqbtXNbt1qtOvbJ6dauWicHf6FLKdY+fPnmjTNKPhTt/1n1H/kc0YeKy/KzuePWUEgwDYJ/VLtj/kPf6/VvxjJp+yTDstSrSwMc367IHaSDOD70xiJzr2hDGRqurBsGvjXtqOSy4WE/s6LNUlyAQ4e/nHEYPtD/2pzw3ebUueMoYOrenpFiI9K+a/Cx57WT+DX90LBXyj9UZmfa/8iDFw==";

        authnReqresult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><saml2p:AuthnRequest xmlns:saml2p=\"urn:oasis:names:tc:SAML:2.0:protocol\" AssertionConsumerServiceURL=\"https://localhost:8443/SkIDentitySP/index.html\" ForceAuthn=\"true\" ID=\"_89f8413878071a9c626767471114a7c7\" IsPassive=\"false\" IssueInstant=\"2013-02-08T18:55:32.909Z\" ProtocolBinding=\"urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect\" Version=\"2.0\"><saml2:Issuer xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">RUB-NDS Service Provider</saml2:Issuer><saml2:Subject xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\"><saml2:NameID/><saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:holder-of-key\"><saml2:NameID/><saml2:SubjectConfirmationData NotOnOrAfter=\"2013-02-08T19:25:32.910Z\"><saml2:Attribute FriendlyName=\"http://www.skidentity.de/policy/eGK-IS\" Name=\"http://www.skidentity.de/policy/eGK-IS\"/><saml2:Attribute Name=\"http://www.skidentity.de/att/email\"/><saml2:Attribute Name=\"http://www.skidentity.de/att/eIdentifier\"/></saml2:SubjectConfirmationData></saml2:SubjectConfirmation></saml2:Subject><saml2p:NameIDPolicy AllowCreate=\"false\" Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:transient\"/><saml2:Conditions xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" NotBefore=\"2013-02-08T18:55:32.911Z\" NotOnOrAfter=\"2013-02-08T19:25:32.911Z\"><saml2:AudienceRestriction><saml2:Audience>https://localhost:8443/SkIDentitySP/index.html</saml2:Audience></saml2:AudienceRestriction></saml2:Conditions></saml2p:AuthnRequest>";
        
        deflatedResponse = "s7GvyM1RKEstKs7Mz7NVMtQzUFJIzUvOT8nMS7dVCg1x07VQsrfjsilOzM0xKrAKSi0uyM8rTlUIg%2BkwAukAmpFXbAVRY6tUWpRnlZ9YnFlslZeYm1psVZJsFezo62MFVGpVUJRfkp%2Bcn6OkbwcA";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHttpPostResponse method, of class HTTPUtils.
     */
    @Test
    public void testGetHttpPostResponseNull() {

        assertNotNull(HTTPUtils.getHttpPostResponse(null, null, null));
    }

    @Test
    public void testGetHttpPostResponse() {
        assertEquals(HTTPUtils.getHttpPostResponse(encodedResponse, destination), httpResponse);
    }

    @Test
    public void testEncodeSamlObject_WithoutURLEncoding() throws Exception {
        assertEquals(text, HTTPUtils.encodeSamlObject(samlObject, false));
    }

    @Test
    public void testEncodeSamlObject_WithURLEncoding() throws Exception {
        assertEquals(URLEncoder.encode(text, "UTF-8"), HTTPUtils.encodeSamlObject(samlObject, true));
    }

    @Test(expected = WrongInputException.class)
    public void testEncodeSamlObject() throws Exception {
        HTTPUtils.encodeSamlObject(null, true);
    }

    /**
     * Test of decodeSamlObject method, of class HTTPUtils.
     */
    @Test(expected = WrongInputException.class)
    public void testDecodeSamlObjectNull() throws Exception {
        HTTPUtils.decodeSamlObject(null);
    }

    @Test
    public void testDecodeSamlObjectEmpty() throws Exception {
        assertArrayEquals(new byte[0], HTTPUtils.decodeSamlObject(""));
    }

    /**
     * Test of isURLEncoded method, of class HTTPUtils.
     */
    @Test
    public void testIsURLEncoded_notEncoded() throws Exception {
        assertFalse(HTTPUtils.isURLEncoded(decoded));
    }

    @Test
    public void testIsURLEncoded_Encoded() throws Exception {
        assertTrue(HTTPUtils.isURLEncoded(encoded));
    }

    /**
     * Test of decodeURLString method, of class HTTPUtils.
     */
    @Test
    public void testDecodeURLString() throws Exception {
        assertEquals(decoded, HTTPUtils.decodeURLString(encoded));
    }

    @Test(expected = WrongInputException.class)
    public void testDecodeURLStringNULL() throws Exception {
        assertNotNull(HTTPUtils.decodeURLString(null));
    }

    /**
     * Test of inflateSamlObject method, of class HTTPUtils.
     */
    @Test(expected = WrongInputException.class)
    public void testInflateSamlObjectNULL() throws Exception {
        HTTPUtils.inflateSamlObject(null, true);
    }

    @Test
    public void testInflateSamlObject_URLEncoded() throws Exception {
        assertEquals(authnReqresult, HTTPUtils.inflateSamlObject(encodedAuthnReqURLenc, true));
    }

    @Test
    public void testInflateSamlObject_NotURLEncoded() throws Exception {
        assertEquals(authnReqresult, HTTPUtils.inflateSamlObject(encodedAuthnReq, false));
    }

    /**
     * Test of deflateSamlObject method, of class HTTPUtils.
     */
    @Test(expected = WrongInputException.class)
    public void testDeflateSamlObjectNULL() throws Exception {
        HTTPUtils.deflateSamlObject(null);
    }

    @Test
    public void testDeflateSamlObject() throws Exception {
        String result = HTTPUtils.deflateSamlObject(SAMLUtils.getSAMLBuilder(Response.DEFAULT_ELEMENT_NAME).buildObject());
        assertArrayEquals(deflatedResponse.getBytes(), result.getBytes());
    }
}
