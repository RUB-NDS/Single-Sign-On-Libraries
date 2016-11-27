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

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class HttpRequestConstants {
    public static final String PROFILE = "profile";
    public static final String Verifier = "verifier";
    public static final String IDP = "idp";
    public static final String SAML_REQUEST = "SAMLRequest";
    public static final String SAML_RESPONSE = "SAMLResponse";
    public static final String SECURITY_BINDING = "sec_binding";
    public static final String RELAY_STATE = "RelayState";

    public static final String JAVAXSERVLETREQUEST_X509_CERTIFICATE = "javax.servlet.request.X509Certificate";
    public static final String tlsUnique = "tlsunique";
    public static final String hok = "holderofkey";
    public static final String TokenBinding = "tokenbinding";
}
