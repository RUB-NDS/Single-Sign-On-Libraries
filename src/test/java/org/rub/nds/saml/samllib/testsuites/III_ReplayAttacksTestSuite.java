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

import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.builder.SAMLTokenProfile;
import org.rub.nds.saml.samllib.decorators.SAMLDecorator;
import org.rub.nds.saml.samllib.decorators.SPInitiatedSSODecorator;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.SAMLProfileException;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.rub.nds.saml.samllib.verifier.Replay_IDsTest;
import org.rub.nds.saml.samllib.verifier.Replay_InResponseToTest;
import org.rub.nds.saml.samllib.verifier.Replay_TimestampsTest;
import org.rub.nds.saml.samllib.verifier.SAMLIDCache;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Replay_IDsTest.class, Replay_InResponseToTest.class, Replay_TimestampsTest.class})
public class III_ReplayAttacksTestSuite {
    private static final III_ReplayAttacksTestSuite instance = new III_ReplayAttacksTestSuite();
    public static Map<AuthnRequest, Response> tokens;

    private III_ReplayAttacksTestSuite() {
//        try {
//            SAMLIDCache.initialize();
//            tokens = new HashMap<>();
//            
//            XStream xstream = new XStream();
//            xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//            xstream.processAnnotations(SAMLProfileStorage.class);
//            
//            buildNormalTokens(xstream);
//        } catch (IOException ex) {
//            Logger.getLogger(III_ReplayAttacksTestSuite.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SAMLBuildException ex) {
//            Logger.getLogger(III_ReplayAttacksTestSuite.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SAMLProfileException ex) {
//            Logger.getLogger(III_ReplayAttacksTestSuite.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public static III_ReplayAttacksTestSuite getInstance() throws org.opensaml.xml.ConfigurationException, IOException {
        if (instance == null) { throw new RuntimeException("Cannot start JUNit Tests!"); }  
        return instance;
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException, SAMLProfileException, SAMLBuildException {
        
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

//    private static void buildNormalTokens(XStream xstream) throws IOException, SAMLBuildException, SAMLProfileException {
//        SAMLBuildFactory samlFactory;
//        
//        samlFactory = new SAMLBuildFactory();
//        
//        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("samlConfigIdP")), "xml")) {
//            SAMLProfileStorage storage = (SAMLProfileStorage) xstream.fromXML(s);
//            storage.initialize();
//
//            for (SAMLTokenProfile samlProfile : storage.getSamlTokenProfiles()) {
//                SAMLDecorator spinitiatedDecorator;
//                AuthnRequest authnRequest;
//                
//                authnRequest = (AuthnRequest) new SAMLBuildFactory().build(storage.getRequestProfile("default"));
//                
//                spinitiatedDecorator = new SPInitiatedSSODecorator(authnRequest);
//                samlFactory.addDecorator(spinitiatedDecorator);
//                tokens.put(authnRequest, (Response) samlFactory.build(samlProfile));
//            }
//        }
//    }
}
