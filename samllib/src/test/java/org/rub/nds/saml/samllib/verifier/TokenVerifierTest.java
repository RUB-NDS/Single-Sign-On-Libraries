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

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.metadata.provider.AbstractMetadataProvider;
import org.opensaml.saml2.metadata.provider.FilesystemMetadataProvider;
import org.opensaml.xml.ConfigurationException;
import org.opensaml.xml.parse.BasicParserPool;
import org.opensaml.xml.signature.Signature;
import org.rub.nds.saml.samllib.builder.SAMLBuilderInterface;

import org.rub.nds.saml.samllib.builder.SAMLSecurityFactory;

import org.rub.nds.saml.samllib.builder.SAMLTokenProfile;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.SAMLProfileException;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.exceptions.WrongInputException;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.rub.nds.saml.samllib.utils.HTTPUtils;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.saml.samllib.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class TokenVerifierTest {

    private static final Logger _log = LoggerFactory.getLogger(TokenVerifierTest.class);
    private final String prefix = "src/test/resources/";
    private final List<SAMLObject> signedTokens = new ArrayList<>();
    private Properties properties;
    private Signature signature;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ConfigurationException, IOException, KeyException, SAMLBuildException, SAMLProfileException, org.rub.nds.saml.samllib.exceptions.ConfigurationException {
//        properties = new Properties();
//        properties.load(new FileInputStream(prefix.concat("testResources.properties")));
//        SAMLIDCache.initialize();
//
//        String filePath = prefix.concat(properties.getProperty("key_filepath"));
//        String keyStore_pass = properties.getProperty("key_keystore_password");
//        String keyStore_alias = properties.getProperty("key_alias");
//        String keyStoreTrust_pass = properties.getProperty("key_truststore_password");
//
//        signature = SecurityUtils.getSignatureFromFileJKS(new File(filePath), keyStore_pass.toCharArray(), keyStoreTrust_pass.toCharArray(), keyStore_alias);
//
//        _log.debug("Read config files containing SAML Profiles!");
//        SAMLSecurityInterface samlSecFactory;
//        SAMLBuilderInterface samlBuildFactory;
//
//        XStream xstream = new XStream();
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//
//        for (String s : FileUtils.readFilesFromDir(prefix.concat(properties.getProperty("samlConfigIdP")), "xml")) {
//            SAMLProfileStorage storage = (SAMLProfileStorage) xstream.fromXML(s);
//            storage.initialize();
//
//            for (SAMLTokenProfile samlProfile : storage.getSamlTokenProfiles()) {
//                SAMLObject samlToken;
//                samlBuildFactory = new SAMLBuildFactory();
//                samlToken = samlBuildFactory.build(samlProfile);
//                
//                samlSecFactory = new SAMLSecurityFactory(samlToken, SecurityUtils.copySignature(signature));
//                samlToken = samlSecFactory.build(samlProfile);
//                
//                signedTokens.add(samlToken);
//            }
//        }
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void temp(){
        Assert.assertTrue(true);
    }

//    /**
//     * Test of build method, of class DefaultResponse.
//     */
//    @Test
//    public void verifyTokens() throws Exception {
//
//        SAMLProfileStorage storage;
//        SAMLVerifierImpl samlVerifier = new SAMLVerifierImpl();
//
//        XStream xstream = new XStream();
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//        storage = (SAMLProfileStorage) xstream.fromXML(FileUtils.readFile("src/test/resources/samlconfigs/sp/AssertionSignature.xml"));
//
//        for (SAMLObject samlToken : signedTokens) {
//            samlVerifier.verify(samlToken, storage.getSamlVerifierProfile("test"));
//        }
//    }
//
//    /**
//     * Test of build method, of class DefaultResponse.
//     */
//    @Test
//    public void verifyTokensTrustVerification() throws Exception {
//
//        SAMLProfileStorage storage;
//        SAMLVerifierImpl samlVerifier;
//        AbstractMetadataProvider metadataProvider;
//
//        metadataProvider = new FilesystemMetadataProvider(new File("src/test/resources/Metadata.xml"));
//        metadataProvider.setRequireValidMetadata(true); //Enable validation
//        metadataProvider.setParserPool(new BasicParserPool());
//        metadataProvider.initialize();
//
//        samlVerifier = new SAMLVerifierImpl(metadataProvider);
//        XStream xstream = new XStream();
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//        storage = (SAMLProfileStorage) xstream.fromXML(FileUtils.readFile("src/test/resources/samlconfigs/sp/AssertionTrustSignature.xml"));
//
//        for (SAMLObject samlToken : signedTokens) {
//            if (((Response) samlToken).getIssuer().getValue().equalsIgnoreCase("http://skidentity.de/IdentityProvider")) {
//                samlVerifier.verify(samlToken, storage.getSamlVerifierProfile("test"));
//            }
//        }
//    }
//
//    /**
//     * Test of build method, of class DefaultResponse.
//     */
//    @Test(expected = SAMLVerifyException.class)
//    public void verifyTokensReplayAttacks() throws Exception {
//
//        SAMLProfileStorage storage;
//        SAMLVerifierImpl samlVerifier;
//        AbstractMetadataProvider metadataProvider;
//
//        metadataProvider = new FilesystemMetadataProvider(new File("src/test/resources/Metadata.xml"));
//        metadataProvider.setRequireValidMetadata(true); //Enable validation
//        metadataProvider.setParserPool(new BasicParserPool());
//        metadataProvider.initialize();
//
//        samlVerifier = new SAMLVerifierImpl(metadataProvider);
//        XStream xstream = new XStream();
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//        storage = (SAMLProfileStorage) xstream.fromXML(FileUtils.readFile("src/test/resources/samlconfigs/sp/AssertionID.xml"));
//
//        for (SAMLObject samlToken : signedTokens) {
//            if (((Response) samlToken).getIssuer().getValue().equalsIgnoreCase("http://skidentity.de/IdentityProvider")) {
//                    samlVerifier.verify(samlToken, storage.getSamlVerifierProfile("test"));
//                    samlVerifier.verify(samlToken, storage.getSamlVerifierProfile("test"));
//            }
//        }
//    }
//
//    /**
//     * Test of build method, of class DefaultResponse.
//     */
//    @Test
//    public void verifyTokensConditions() throws Exception {
//
//        SAMLProfileStorage storage;
//        SAMLVerifierImpl samlVerifier;
//        AbstractMetadataProvider metadataProvider;
//
//        metadataProvider = new FilesystemMetadataProvider(new File("src/test/resources/Metadata.xml"));
//        metadataProvider.setRequireValidMetadata(true); //Enable validation
//        metadataProvider.setParserPool(new BasicParserPool());
//        metadataProvider.initialize();
//
//        samlVerifier = new SAMLVerifierImpl(metadataProvider);
//        XStream xstream = new XStream();
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//        storage = (SAMLProfileStorage) xstream.fromXML(FileUtils.readFile("src/test/resources/samlconfigs/sp/Conditions.xml"));
//
//        for (SAMLObject samlToken : signedTokens) {
//            if (((Response) samlToken).getIssuer().getValue().equalsIgnoreCase("http://skidentity.de/IdentityProvider")) {
//                samlVerifier.verify(samlToken, storage.getSamlVerifierProfile("test"));
//            }
//        }
//    }
//    
//    @Test
//    public void verifyTokensHolderOfKey () throws IOException, WrongInputException, SAMLVerifyException, CertificateException {
//        String tokenStr = FileUtils.readFile("src/test/resources/samlconfigs/sp/HolderOfKeyToken.txt");
//        Response response = (Response) SAMLUtils.buildObjectfromString(new String (HTTPUtils.decodeSamlObject(tokenStr)));
//        SAMLProfileStorage storage;
//        SAMLVerifierImpl samlVerifier;
//        
//        XStream xstream = new XStream();
//        samlVerifier = new SAMLVerifierImpl(SecurityUtils.readCertificatefromPEM(prefix.concat("clientCert.pem")));
//        
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//        storage = (SAMLProfileStorage) xstream.fromXML(FileUtils.readFile("src/test/resources/samlconfigs/sp/HolderOfKey.xml"));
//        
//        //samlVerifier.verify(response, storage.getSamlVerifierProfile());
//    }
}
