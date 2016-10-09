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
package org.rub.nds.saml.samllib.decorators;

import org.rub.nds.saml.samllib.builder.SAMLTokenProfile;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.ConfigurationException;
import org.opensaml.xml.signature.Signature;
import org.rub.nds.elearning.sso.saml.api.SAMLProfileStorageType;
import org.rub.nds.elearning.sso.saml.api.SamlTokenProfileType;
import org.rub.nds.elearning.sso.saml.api.TokenSignatureDecoratorType;
import org.rub.nds.saml.samllib.builder.RequestBuildFactory;
import org.rub.nds.saml.samllib.builder.SAMLSecurityFactory;
import org.rub.nds.saml.samllib.builder.TokenBuildFactory;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import static org.rub.nds.saml.samllib.testsuites.III_SignatureTestSuite.tokens;
import org.rub.nds.saml.samllib.testsuites.I_MainTestSuite;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.saml.samllib.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SpInitiatedTokenTest {

    private static Logger _log = LoggerFactory.getLogger(SpInitiatedTokenTest.class);
    private Signature signature;

    @BeforeClass
    public static void setUpClass() throws ConfigurationException, IOException {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ConfigurationException, IOException, KeyException, SAMLBuildException {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of build method, of class DefaultResponse.
     */
    @Test
    public void createTokens() throws Exception {
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
                
                RequestBuildFactory reqBuilder = new RequestBuildFactory(null);
                SPInitiatedSSODecorator decorator = new SPInitiatedSSODecorator((AuthnRequest)reqBuilder.build());
                samlFactory.addDecorator(decorator);
                
                samlToken = samlFactory.build();
            }
        }
    }
}
