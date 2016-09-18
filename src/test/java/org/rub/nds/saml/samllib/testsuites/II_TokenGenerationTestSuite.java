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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.rub.nds.saml.samllib.decorators.HoKTokenTest;
import org.rub.nds.saml.samllib.decorators.ReadConfigTest;
import org.rub.nds.saml.samllib.decorators.SignedTokensTest;
import org.rub.nds.saml.samllib.decorators.SimpleTokenTests;
import org.rub.nds.saml.samllib.decorators.SpInitiatedTokenTest;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ReadConfigTest.class, SimpleTokenTests.class, HoKTokenTest.class, SignedTokensTest.class, SpInitiatedTokenTest.class})
public class II_TokenGenerationTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
