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

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.StringReader;


/**
 *
 * @author Ole Lemke <ole.lemke@rub.de>
 */
public class ConfigurationTypeTest {
    
    private static Logger _log = LoggerFactory.getLogger(ConfigurationTypeTest.class);

    
    public ConfigurationTypeTest() {
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
     * Test of getID method, of class ConfigurationType.
     */
    @Test
    public void testConfigurationType() throws JAXBException, IOException{
        JAXBContext jaxbContext = JAXBContext.newInstance ("org.rub.nds.futuretrust.cvs.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<ConfigurationType> ConfigurationType;
        for (String s : FileUtils.readFilesFromDir("src/test/resources/futuretrustcvsconfigs", "xml")){
            StringReader reader = new StringReader(s);
            ConfigurationType = (JAXBElement<ConfigurationType>) unmarshaller.unmarshal(reader);
        }
    }
    
}
