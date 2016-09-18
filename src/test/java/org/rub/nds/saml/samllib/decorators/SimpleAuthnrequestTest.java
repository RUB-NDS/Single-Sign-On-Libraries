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

import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.testsuites.I_MainTestSuite;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SimpleAuthnrequestTest {
private static Logger _log = LoggerFactory.getLogger(SimpleAuthnrequestTest.class);

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
    
    @Test
    public void success(){
        Assert.assertTrue(true);
    }

//    /**
//     * Test of build method, of class DefaultResponse.
//     */
//    @Test
//    public void createTokens() throws Exception {
//        _log.debug("Read config files containing SAML Profiles!");
//
//        XStream xstream = new XStream();
//        xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
//        xstream.processAnnotations(SAMLProfileStorage.class);
//
//        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("samlConfigSP")), "xml")) {
//            SAMLProfileStorage storage = (SAMLProfileStorage) xstream.fromXML(s);
//            storage.initialize();
//
//            for (SAMLRequestProfile samlProfile : storage.getSamlRequestProfiles()) {
//                System.out.println(SAMLUtils.samlObj2String(new SAMLBuildFactory().build(samlProfile)));
//            }
//        }
//    }
}
