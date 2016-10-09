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
package org.rub.nds.saml.samllib.testsuites;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.signature.Signature;
import org.rub.nds.elearning.sso.saml.api.SAMLProfileStorageType;
import org.rub.nds.elearning.sso.saml.api.SamlTokenProfileType;
import org.rub.nds.elearning.sso.saml.api.TokenSignatureDecoratorType;


import org.rub.nds.saml.samllib.builder.SAMLSecurityFactory;

import org.rub.nds.saml.samllib.builder.TokenBuildFactory;
import org.rub.nds.saml.samllib.exceptions.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.SAMLProfileException;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.rub.nds.saml.samllib.utils.SecurityUtils;
import org.rub.nds.saml.samllib.verifier.Signature_UntrustedVerificationTest;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Signature_UntrustedVerificationTest.class})
public class III_SignatureTestSuite {

    private static final III_SignatureTestSuite instance = new III_SignatureTestSuite();
    private static Signature signature;
    public static Map<String, Response> tokens;

    private III_SignatureTestSuite() {
        try {
            tokens = new HashMap<>();
            String filePath = I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("key_filepath"));
            String keyStore_pass = I_MainTestSuite.properties.getProperty("key_keystore_password");
            String keyStore_alias = I_MainTestSuite.properties.getProperty("key_alias");
            String keyStoreTrust_pass = I_MainTestSuite.properties.getProperty("key_truststore_password");

            signature = SecurityUtils.getSignatureFromFileJKS(new File(filePath), keyStore_pass.toCharArray(), keyStoreTrust_pass.toCharArray(), keyStore_alias);
            buildNormalTokens();
        } catch (KeyException ex) {
            Logger.getLogger(III_SignatureTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAMLBuildException ex) {
            Logger.getLogger(III_SignatureTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(III_SignatureTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAMLProfileException ex) {
            Logger.getLogger(III_SignatureTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConfigurationException ex) {
            Logger.getLogger(III_SignatureTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(III_SignatureTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static III_SignatureTestSuite getInstance() throws org.opensaml.xml.ConfigurationException, IOException {
        if (instance == null) {
            throw new RuntimeException("Cannot start JUNit Tests!");
        }
        return instance;
    }

    @BeforeClass
    public static void setUpClass() throws KeyException, SAMLBuildException, IOException, SAMLProfileException, ConfigurationException {

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
        SAMLSecurityFactory samlSecFactory;
        SAMLObject samlToken;

        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("samlConfigIdP")), "xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.elearning.sso.saml.api");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<SAMLProfileStorageType> samlStorage = (JAXBElement<SAMLProfileStorageType>) unmarshaller.unmarshal(new StringReader(s));
            SAMLProfileStorageType storage = samlStorage.getValue();

            for (SamlTokenProfileType samlProfile : storage.getSamlTokenProfiles().getSamlTokenProfile()) {
                TokenBuildFactory samlFactory;
                samlFactory = new TokenBuildFactory(samlProfile);
                samlToken = samlFactory.build();
                
                TokenSignatureDecoratorType decorator = new TokenSignatureDecoratorType();
                samlSecFactory = new SAMLSecurityFactory(samlToken, SecurityUtils.copySignature(signature), samlProfile.getTokenSignatureDecorator());
                samlToken = samlSecFactory.build();
                tokens.put(samlProfile.getName(), (Response) samlToken);
            }
        }
    }

}
