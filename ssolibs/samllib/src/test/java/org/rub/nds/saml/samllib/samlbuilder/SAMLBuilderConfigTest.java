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
package org.rub.nds.saml.samllib.samlbuilder;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SAMLBuilderConfigTest {

    public static final String prefix = "src/test/resources/";

    public SAMLBuilderConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        // xstream = new XStream();
        // xstream.setClassLoader(SAMLProfileStorage.class.getClassLoader());
        // xstream.processAnnotations(SAMLProfileStorage.class);
    }

    @After
    public void tearDown() {
    }

    // @Test(expected = StreamException.class)
    // public void emptyInput() throws IOException, SAMLProfileException {
    // String s = null;
    // File file = null;
    //
    // SAMLProfileStorage samlStorage = (SAMLProfileStorage)
    // xstream.fromXML("");
    // samlStorage = (SAMLProfileStorage) xstream.fromXML(file);
    // samlStorage.initialize();
    // }
    //
    // @Test(expected = StreamException.class)
    // public void emptyInput2() throws IOException, SAMLProfileException {
    // String s = null;
    // File file = null;
    //
    // SAMLProfileStorage samlStorage = (SAMLProfileStorage)
    // xstream.fromXML("");
    // samlStorage = (SAMLProfileStorage) xstream.fromXML(new File(""));
    // samlStorage.initialize();
    // }
    //
    // @Test(expected = StreamException.class)
    // public void emptyInput3() throws IOException, SAMLProfileException {
    // String s = null;
    // File file = null;
    //
    // SAMLProfileStorage samlStorage = (SAMLProfileStorage)
    // xstream.fromXML("");
    // samlStorage = (SAMLProfileStorage) xstream.fromXML(s);
    // samlStorage.initialize();
    // }
    //
    // @Test
    // public void wrongFiles() throws IOException {
    //
    // for (String s :
    // FileUtils.readFilesFromDir(prefix.concat("wrongProfiles"), "xml")) {
    // try {
    // SAMLProfileStorage samlStorage = (SAMLProfileStorage) xstream.fromXML(s);
    // samlStorage.initialize();
    // } catch (ConversionException | SAMLProfileException ex) {
    // }
    // }
    // }
}
