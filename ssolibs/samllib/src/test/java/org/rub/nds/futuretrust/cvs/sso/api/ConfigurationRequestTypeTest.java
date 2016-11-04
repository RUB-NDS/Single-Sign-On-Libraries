/*
 * Copyright (C) 2016 Ole Lemke <ole.lemke@rub.de>.
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
package org.rub.nds.futuretrust.cvs.sso.api;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rub.nds.saml.samllib.utils.FileUtils;


/**
 *
 * @author Ole Lemke <ole.lemke@rub.de>
 */
public class ConfigurationRequestTypeTest {
    
    public ConfigurationRequestTypeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    
    @Test
    public void testConfigurationRequestType() throws JAXBException, IOException{
        JAXBContext jaxbContext = JAXBContext.newInstance ("org.rub.nds.futuretrust.cvs.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<ConfigurationRequestType> ConfigurationRequestType;
        for (String s : FileUtils.readFilesFromDir("src/test/resources/configurationrequests/valid", "xml")){
            StringReader reader = new StringReader(s);
            ConfigurationRequestType = (JAXBElement<ConfigurationRequestType>) unmarshaller.unmarshal(reader);
        }
    }
    
//    /**
//     * Test of getMode method, of class ConfigurationRequestType.
//     */
//    @Test
//    public void testGetMode() {
//        System.out.println("getMode");
//        ConfigurationRequestType instance = new ConfigurationRequestType();
//        String expResult = "";
//        String result = instance.getMode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMode method, of class ConfigurationRequestType.
//     */
//    @Test
//    public void testSetMode() {
//        System.out.println("setMode");
//        String value = "";
//        ConfigurationRequestType instance = new ConfigurationRequestType();
//        instance.setMode(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAuthentication method, of class ConfigurationRequestType.
//     */
//    @Test
//    public void testGetAuthentication() {
//        System.out.println("getAuthentication");
//        ConfigurationRequestType instance = new ConfigurationRequestType();
//        AuthenticationType expResult = null;
//        AuthenticationType result = instance.getAuthentication();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAuthentication method, of class ConfigurationRequestType.
//     */
//    @Test
//    public void testSetAuthentication() {
//        System.out.println("setAuthentication");
//        AuthenticationType value = null;
//        ConfigurationRequestType instance = new ConfigurationRequestType();
//        instance.setAuthentication(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getConfiguration method, of class ConfigurationRequestType.
//     */
//    @Test
//    public void testGetConfiguration() {
//        System.out.println("getConfiguration");
//        ConfigurationRequestType instance = new ConfigurationRequestType();
//        List<ConfigurationType> expResult = null;
//        List<ConfigurationType> result = instance.getConfiguration();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
