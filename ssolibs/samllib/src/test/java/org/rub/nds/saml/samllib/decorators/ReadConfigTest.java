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

import java.io.File;
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
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.elearning.sso.saml.api.SAMLProfileStorageType;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.SAMLProfileException;
import org.rub.nds.saml.samllib.testsuites.I_MainTestSuite;
import org.rub.nds.saml.samllib.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class ReadConfigTest {

    private static Logger _log = LoggerFactory.getLogger(ReadConfigTest.class);

    public ReadConfigTest() {
    }

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
    public void readConfig() throws IOException, SAMLProfileException, JAXBException {
        _log.debug("Read config files containing SAML Profiles!");

        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.elearning.sso.saml.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        for (String s : FileUtils.readFilesFromDir(I_MainTestSuite.prefix.concat(I_MainTestSuite.properties.getProperty("samlConfigIdP")), "xml")) {
            JAXBElement<SAMLProfileStorageType> samlStorage = (JAXBElement<SAMLProfileStorageType>) unmarshaller.unmarshal(new StringReader(s));
        }
    }

    /**
     * Test of build method, of class DefaultResponse.
     *
     * @throws java.io.IOException
     * @throws javax.xml.bind.JAXBException
     */
    @Test(expected = IOException.class)
    public void readWrongConfig() throws IOException, JAXBException {
        _log.debug("Read config files containing SAML Profiles!");
        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.elearning.sso.saml.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<SAMLProfileStorageType> samlStorage;
        for (String s : FileUtils.readFilesFromDir("wrongFile", "xml")) {
            samlStorage = (JAXBElement<SAMLProfileStorageType>) unmarshaller.unmarshal(new File(s));
        }
    }
}
