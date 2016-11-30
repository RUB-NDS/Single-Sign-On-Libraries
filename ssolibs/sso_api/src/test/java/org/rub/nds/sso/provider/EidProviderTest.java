/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;

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
    @Test (expected = SAMLVerifyException.class)
    public void testVerify() throws Exception {
        SamlType samlType = new SamlType();
        samlType.setSamlResponse("<samlp:Response xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\" xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\" ID=\"_8e8dc5f69a98cc4c1ff3427e5ce34606fd672f91e6\" Version=\"2.0\" IssueInstant=\"2014-07-17T01:01:48Z\" Destination=\"http://sp.example.com/demo1/index.php?acs\" InResponseTo=\"ONELOGIN_4fee3b046395c4e751011e97f8900b5273d56685\">\n" +
"  <saml:Issuer>http://idp.example.com/metadata.php</saml:Issuer>\n" +
"  <samlp:Status>\n" +
"    <samlp:StatusCode Value=\"urn:oasis:names:tc:SAML:2.0:status:Success\"/>\n" +
"  </samlp:Status>\n" +
"  <saml:Assertion xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" ID=\"pfx209f6685-5971-5225-aafd-5a619933a1b7\" Version=\"2.0\" IssueInstant=\"2014-07-17T01:01:48Z\">\n" +
"    <saml:Issuer>http://idp.example.com/metadata.php</saml:Issuer><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
"  <ds:SignedInfo><ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
"    <ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
"  <ds:Reference URI=\"#pfx209f6685-5971-5225-aafd-5a619933a1b7\"><ds:Transforms><ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/></ds:Transforms><ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><ds:DigestValue>HYYH8QIVg+qjptGqnqTScdZBSlA=</ds:DigestValue></ds:Reference></ds:SignedInfo><ds:SignatureValue>k5jyKq2mH/3uzhXBrIHY++lKw0p7LmpRATS7r4JvksdLeyluLmXYJ7xp/EOKgZEaaCKgn1ZYpKv3iwk/FxHrnaomX5W68tlc4oB1hkqiF/FEaa2DDc2EBUaGubACPDkxUJcuhfXYkKRyZmkMGD1EldwHEYEQqwK/X3crrIkdvcU=</ds:SignatureValue>\n" +
"<ds:KeyInfo><ds:X509Data><ds:X509Certificate>MIICajCCAdOgAwIBAgIBADANBgkqhkiG9w0BAQ0FADBSMQswCQYDVQQGEwJ1czETMBEGA1UECAwKQ2FsaWZvcm5pYTEVMBMGA1UECgwMT25lbG9naW4gSW5jMRcwFQYDVQQDDA5zcC5leGFtcGxlLmNvbTAeFw0xNDA3MTcxNDEyNTZaFw0xNTA3MTcxNDEyNTZaMFIxCzAJBgNVBAYTAnVzMRMwEQYDVQQIDApDYWxpZm9ybmlhMRUwEwYDVQQKDAxPbmVsb2dpbiBJbmMxFzAVBgNVBAMMDnNwLmV4YW1wbGUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZx+ON4IUoIWxgukTb1tOiX3bMYzYQiwWPUNMp+Fq82xoNogso2bykZG0yiJm5o8zv/sd6pGouayMgkx/2FSOdc36T0jGbCHuRSbtia0PEzNIRtmViMrt3AeoWBidRXmZsxCNLwgIV6dn2WpuE5Az0bHgpZnQxTKFek0BMKU/d8wIDAQABo1AwTjAdBgNVHQ4EFgQUGHxYqZYyX7cTxKVODVgZwSTdCnwwHwYDVR0jBBgwFoAUGHxYqZYyX7cTxKVODVgZwSTdCnwwDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQ0FAAOBgQByFOl+hMFICbd3DJfnp2Rgd/dqttsZG/tyhILWvErbio/DEe98mXpowhTkC04ENprOyXi7ZbUqiicF89uAGyt1oqgTUCD1VsLahqIcmrzgumNyTwLGWo17WDAa1/usDhetWAMhgzF/Cnf5ek0nK00m0YZGyc4LzgD0CROMASTWNg==</ds:X509Certificate></ds:X509Data></ds:KeyInfo></ds:Signature>\n" +
"    <saml:Subject>\n" +
"      <saml:NameID SPNameQualifier=\"http://sp.example.com/demo1/metadata.php\" Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:transient\">_ce3d2948b4cf20146dee0a0b3dd6f69b6cf86f62d7</saml:NameID>\n" +
"      <saml:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\">\n" +
"        <saml:SubjectConfirmationData NotOnOrAfter=\"2024-01-18T06:21:48Z\" Recipient=\"http://sp.example.com/demo1/index.php?acs\" InResponseTo=\"ONELOGIN_4fee3b046395c4e751011e97f8900b5273d56685\"/>\n" +
"      </saml:SubjectConfirmation>\n" +
"    </saml:Subject>\n" +
"    <saml:Conditions NotBefore=\"2014-07-17T01:01:18Z\" NotOnOrAfter=\"2024-01-18T06:21:48Z\">\n" +
"      <saml:AudienceRestriction>\n" +
"        <saml:Audience>http://sp.example.com/demo1/metadata.php</saml:Audience>\n" +
"      </saml:AudienceRestriction>\n" +
"    </saml:Conditions>\n" +
"    <saml:AuthnStatement AuthnInstant=\"2014-07-17T01:01:48Z\" SessionNotOnOrAfter=\"2024-07-17T09:01:48Z\" SessionIndex=\"_be9967abd904ddcae3c0eb4189adbe3f71e327cf93\">\n" +
"      <saml:AuthnContext>\n" +
"        <saml:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:Password</saml:AuthnContextClassRef>\n" +
"      </saml:AuthnContext>\n" +
"    </saml:AuthnStatement>\n" +
"    <saml:AttributeStatement>\n" +
"      <saml:Attribute Name=\"uid\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" +
"        <saml:AttributeValue xsi:type=\"xs:string\">test</saml:AttributeValue>\n" +
"      </saml:Attribute>\n" +
"      <saml:Attribute Name=\"mail\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" +
"        <saml:AttributeValue xsi:type=\"xs:string\">test@example.com</saml:AttributeValue>\n" +
"      </saml:Attribute>\n" +
"      <saml:Attribute Name=\"eduPersonAffiliation\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" +
"        <saml:AttributeValue xsi:type=\"xs:string\">users</saml:AttributeValue>\n" +
"        <saml:AttributeValue xsi:type=\"xs:string\">examplerole1</saml:AttributeValue>\n" +
"      </saml:Attribute>\n" +
"    </saml:AttributeStatement>\n" +
"  </saml:Assertion>\n" +
"</samlp:Response>");
        
        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();
        checks.setVerifiySAMLAssertionSignature(Boolean.TRUE);
        samlType.setSamlTokenVerificationChecks(checks);
        EidProvider instance = new EidProvider(samlType);
        instance.verify();
    }
    
}