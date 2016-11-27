/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.api;

import java.io.IOException;
import java.io.File;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rub.nds.sso.utils.FileUtils;

/**
 *
 * @author Ole Lemke <ole.lemke@rub.de>
 */
public class SamlTypeTest {

    public SamlTypeTest() {
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
     * Test of SamlRequestType
     */
    @Test
    public void testSamlType() throws JAXBException, IOException, Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<SamlType> SamlType;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/test/resources/schema/ssolib_API.xsd"));
        unmarshaller.setSchema(schema);
        for (String s : FileUtils.readFilesFromDir("src/test/resources/Saml/valid", "xml")) {
            StringReader reader = new StringReader(s);
            SamlType = (JAXBElement<SamlType>) unmarshaller.unmarshal(reader);
        }
    }

    @Test(expected = Exception.class)
    public void testInvalidSamlType() throws JAXBException, IOException, Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance("org.rub.nds.sso.api");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<SamlType> SamlType;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/test/resources/schema/ssolib_API.xsd"));
        unmarshaller.setSchema(schema);
        for (String s : FileUtils.readFilesFromDir("src/test/resources/Saml/invalid", "xml")) {
            StringReader reader = new StringReader(s);
            SamlType = (JAXBElement<SamlType>) unmarshaller.unmarshal(reader);
        }
    }

}
