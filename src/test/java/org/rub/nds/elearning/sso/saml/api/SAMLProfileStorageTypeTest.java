/*
 * Copyright (C) 2016 vmladenov.
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
package org.rub.nds.elearning.sso.saml.api;

import java.io.File;
import java.io.IOException;
import javax.validation.constraints.AssertTrue;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vmladenov
 */
public class SAMLProfileStorageTypeTest {
    
    public SAMLProfileStorageTypeTest() {
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
     * Test of getRegisteredSPs method, of class SAMLProfileStorageType.
     */
    @Test
    public void testGetRegisteredSPs() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance ("org.rub.nds.elearning.sso.saml.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         JAXBElement<SAMLProfileStorageType> samlStorage = (JAXBElement<SAMLProfileStorageType>) unmarshaller.unmarshal( 
                 new File("src/test/resources/samlconfigs/idp/newInterface.xml"));
         SAMLProfileStorageType storage = samlStorage.getValue();
         Assert.assertEquals("http://carbon.cloud.nds.rub.de:8080/sp/index.html", storage.getRegisteredSPs().getRegisteredSP().get(0).issuer);
    }    
}
