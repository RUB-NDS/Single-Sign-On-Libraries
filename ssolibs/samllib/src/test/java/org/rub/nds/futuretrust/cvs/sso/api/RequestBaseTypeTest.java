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
public class RequestBaseTypeTest {
    
    public RequestBaseTypeTest() {
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
    public void testRequestBaseType() throws JAXBException, IOException{
        JAXBContext jaxbContext = JAXBContext.newInstance ("org.rub.nds.futuretrust.cvs.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<RequestBaseType> RequestBaseType;
        for (String s : FileUtils.readFilesFromDir("src/test/resources/requestbasetypes/valid", "xml")){
            StringReader reader = new StringReader(s);
            RequestBaseType = (JAXBElement<RequestBaseType>) unmarshaller.unmarshal(reader);
        }
    }

//    /**
//     * Test of getOptionalInputs method, of class RequestBaseType.
//     */
//    @Test
//    public void testGetOptionalInputs() {
//        System.out.println("getOptionalInputs");
//        RequestBaseType instance = new RequestBaseType();
//        RequestBaseType.OptionalInputs expResult = null;
//        RequestBaseType.OptionalInputs result = instance.getOptionalInputs();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setOptionalInputs method, of class RequestBaseType.
//     */
//    @Test
//    public void testSetOptionalInputs() {
//        System.out.println("setOptionalInputs");
//        RequestBaseType.OptionalInputs value = null;
//        RequestBaseType instance = new RequestBaseType();
//        instance.setOptionalInputs(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getInputDocuments method, of class RequestBaseType.
//     */
//    @Test
//    public void testGetInputDocuments() {
//        System.out.println("getInputDocuments");
//        RequestBaseType instance = new RequestBaseType();
//        RequestBaseType.InputDocuments expResult = null;
//        RequestBaseType.InputDocuments result = instance.getInputDocuments();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setInputDocuments method, of class RequestBaseType.
//     */
//    @Test
//    public void testSetInputDocuments() {
//        System.out.println("setInputDocuments");
//        RequestBaseType.InputDocuments value = null;
//        RequestBaseType instance = new RequestBaseType();
//        instance.setInputDocuments(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRequestID method, of class RequestBaseType.
//     */
//    @Test
//    public void testGetRequestID() {
//        System.out.println("getRequestID");
//        RequestBaseType instance = new RequestBaseType();
//        String expResult = "";
//        String result = instance.getRequestID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRequestID method, of class RequestBaseType.
//     */
//    @Test
//    public void testSetRequestID() {
//        System.out.println("setRequestID");
//        String value = "";
//        RequestBaseType instance = new RequestBaseType();
//        instance.setRequestID(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getProfile method, of class RequestBaseType.
//     */
//    @Test
//    public void testGetProfile() {
//        System.out.println("getProfile");
//        RequestBaseType instance = new RequestBaseType();
//        String expResult = "";
//        String result = instance.getProfile();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setProfile method, of class RequestBaseType.
//     */
//    @Test
//    public void testSetProfile() {
//        System.out.println("setProfile");
//        String value = "";
//        RequestBaseType instance = new RequestBaseType();
//        instance.setProfile(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
