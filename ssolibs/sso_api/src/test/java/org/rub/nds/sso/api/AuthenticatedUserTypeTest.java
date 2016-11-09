/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.api;

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
public class AuthenticatedUserTypeTest {
    
    public AuthenticatedUserTypeTest() {
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

    /**
     * Test of getUserID method, of class AuthenticatedUserType.
     */
    @Test
    public void testAuthenticatedUserType() throws JAXBException, IOException{
        JAXBContext jaxbContext = JAXBContext.newInstance ("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<AuthenticatedUserType> AuthenticatedUserType;
        for (String s : FileUtils.readFilesFromDir("src/test/resources/AuthenticatedUser/valid", "xml")){
            StringReader reader = new StringReader(s);
            AuthenticatedUserType = (JAXBElement<AuthenticatedUserType>) unmarshaller.unmarshal(reader);
        }
    }
    
    @Test(expected = Exception.class)  
    public void testInvalidAuthenticatedUserType() throws JAXBException, IOException{
        JAXBContext jaxbContext = JAXBContext.newInstance ("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<AuthenticatedUserType> AuthenticatedUserType;
        for (String s : FileUtils.readFilesFromDir("src/test/resources/AuthenticatedUser/invalid", "xml")){
            StringReader reader = new StringReader(s);
            AuthenticatedUserType = (JAXBElement<AuthenticatedUserType>) unmarshaller.unmarshal(reader);
        }
    }
    
}
