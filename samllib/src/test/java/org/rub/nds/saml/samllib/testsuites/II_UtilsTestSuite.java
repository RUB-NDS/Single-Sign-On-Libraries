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

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.utils.FileUtilsTest;
import org.rub.nds.saml.samllib.utils.HTTPUtilsTest;
import org.rub.nds.saml.samllib.utils.SAMLUtilsTest;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ FileUtilsTest.class, HTTPUtilsTest.class, SAMLUtilsTest.class})
public class II_UtilsTestSuite {
    
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ConfigurationException, IOException {
        
    }
    
    @After
    public void tearDown() {
    }
    
}
