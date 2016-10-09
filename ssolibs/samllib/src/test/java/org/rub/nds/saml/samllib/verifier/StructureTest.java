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

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.signature.Signature;
import org.rub.nds.elearning.sso.saml.api.SAMLProfileStorageType;
import org.rub.nds.elearning.sso.saml.api.SamlTokenProfileType;
import org.rub.nds.elearning.sso.saml.api.TokenSignatureDecoratorType;
import org.rub.nds.futuretrust.cvs.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;

import org.rub.nds.saml.samllib.builder.SAMLSecurityFactory;

import org.rub.nds.saml.samllib.builder.TokenBuildFactory;
import org.rub.nds.saml.samllib.exceptions.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.SAMLProfileException;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.saml.samllib.testsuites.I_MainTestSuite;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.rub.nds.saml.samllib.utils.SecurityUtils;
import static org.rub.nds.saml.samllib.verifier.StructureTest.tokens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class StructureTest {

    private static Logger _log = LoggerFactory.getLogger(StructureTest.class);
    

    public StructureTest() {
    }

    private static Signature signature;
    public static Map<String, Response> tokens;

    @BeforeClass
    public static void setUpClass() throws KeyException, SAMLBuildException, IOException, SAMLProfileException, ConfigurationException, JAXBException {
        tokens = new HashMap<>();
        String filePath = I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("key_filepath"));
        String keyStore_pass = I_MainTestSuite.properties.getProperty("key_keystore_password");
        String keyStore_alias = I_MainTestSuite.properties.getProperty("key_alias");
        String keyStoreTrust_pass = I_MainTestSuite.properties.getProperty("key_truststore_password");

        signature = SecurityUtils.getSignatureFromFileJKS(new File(filePath), keyStore_pass.toCharArray(), keyStoreTrust_pass.toCharArray(), keyStore_alias);

        buildNormalTokens();
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

    private static void buildNormalTokens() throws IOException, SAMLBuildException, SAMLProfileException, ConfigurationException, JAXBException {
        SAMLObject samlToken;
        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.elearning.sso.saml.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("samlConfigIdP")), "xml")) {

            JAXBElement<SAMLProfileStorageType> samlStorage = (JAXBElement<SAMLProfileStorageType>) unmarshaller.unmarshal(new StringReader(s));
            SAMLProfileStorageType storage = samlStorage.getValue();

            for (SamlTokenProfileType samlProfile : storage.getSamlTokenProfiles().getSamlTokenProfile()) {
                TokenBuildFactory samlFactory;
                samlFactory = new TokenBuildFactory(samlProfile);
                samlToken = samlFactory.build();
                _log.debug("Sign Token");
                TokenSignatureDecoratorType decorator = new TokenSignatureDecoratorType();
                
                SAMLSecurityFactory samlSecFactory = new SAMLSecurityFactory(samlToken, SecurityUtils.copySignature(signature), samlProfile.getTokenSignatureDecorator());
                samlToken = samlSecFactory.build();
                tokens.put(samlProfile.getName(), (Response) samlToken);
            }
        }
    }

    @Test
    public void schemaValidation () throws SAMLVerifyException
    {
        SAMLVerifierInterface samlVerifier;
        VerificationProfileType profile;

        samlVerifier = new SAMLVerifierImpl();
        profile = new VerificationProfileType();

        SamlTokenVerificationChecksType check = new SamlTokenVerificationChecksType();
        check.setVerifySchema(Boolean.TRUE);
        profile.setSamlTokenVerificationChecks(check);

        for (Response token : tokens.values()) {
            samlVerifier.verify(token, profile);
        }
    }
//    
//    public void structureValidation() throws SAMLVerifyException{
//        SAMLVerifierInterface samlVerifier;
//        SAMLVerifierProfile profile;
//
//        samlVerifier = new SAMLVerifierImpl();
//        profile = new SAMLVerifierProfile();
//        
//        profile.setSignatureStructure(true);
//        
//        
//        for (Response token : tokens.values())
//        {
//            samlVerifier.verify(token, profile);
//        }
//    }
//    }
    
    public void structureValidation() throws SAMLVerifyException{
        SAMLVerifierInterface samlVerifier;
        VerificationProfileType profile;

        samlVerifier = new SAMLVerifierImpl();
        profile = new VerificationProfileType();

        SamlTokenVerificationChecksType check = new SamlTokenVerificationChecksType();
        check.setVerifyXSW(Boolean.TRUE);
        profile.setSamlTokenVerificationChecks(check);

        for (Response token : tokens.values()) {
            samlVerifier.verify(token, profile);
        }
    }
}
