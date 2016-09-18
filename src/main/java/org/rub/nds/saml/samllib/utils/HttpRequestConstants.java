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
public class HttpRequestConstants 
{
    public static final String SECURITY_TOKEN = "security_token";
    public static final String TEMPLATE = "template";
    public static final String BROKER_TEMPLATE = "broker_template";
    public static final String SAML_REQUEST = "SAMLRequest";
    public static final String JAVAXSERVLETREQUEST_X509_CERTIFICATE = "javax.servlet.request.X509Certificate";
    public static final String RELAY_STATE = "RelayState"; 
    public static final String ERROR_URL = "error_url";
    public static final String AS_TYPE = "as_type"; // it is not a part of the new Broker
    
    public static final String HttpParamTLSUnique = "tlsunique";
    public static final String HttpParamURIHoK = "holderofkey";
    public static final String HttpParamHoK = "hok";
    public static final String HttpParamNormal = "normal";
    public static final String HttpParamTest = "test";
    public static final String HttpParamXmlsec = "xmlsec";
    public static final String HttpParamSamlsec = "samlsec";
    public static final String HttpParamWebapps = "webapps";
    public static final String HttpParamNPA = "npa";
    public static final String HttpParamCert = "cert";
    public static final String HttpParamInProcess = "&authentication=inprocess";
}
