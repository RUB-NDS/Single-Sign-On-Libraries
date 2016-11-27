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
package org.rub.nds.saml.samllib.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */

@RunWith(Suite.class)
public class I_MainTestSuite {
    private static final I_MainTestSuite instance = new I_MainTestSuite();

    public static final String prefix = "src/test/resources/";
    public static Properties properties;
    public final static String path_token_decoded = "tokensDecoded";
    public final static String path_token_encoded = "tokensEncoded";
    public final static String path_token_error = "tokensError";
    public final static String path_authRequest_decoded = "authnRequestsDecoded";
    public final static String path_authRequest_encoded = "authnRequestsDecoded";
    public final static String path_authRequest_error = "authnRequestsError";

    private I_MainTestSuite() {
        try {
            DefaultBootstrap.bootstrap();

            properties = new Properties();
            properties.load(new FileInputStream(prefix.concat("testResources.properties")));

        } catch (ConfigurationException ex) {
            java.util.logging.Logger.getLogger(I_MainTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(I_MainTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static I_MainTestSuite getInstance() throws ConfigurationException, IOException {
        if (instance == null) {
            throw new RuntimeException("Cannot start JUNit Tests!");
        }
        return instance;
    }

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
