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

import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AuthnContext;
import org.opensaml.saml2.core.NameIDType;
import org.opensaml.saml2.core.SubjectConfirmation;

/**
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */
public class SAMLDefaultConstants {
    /**
     * 
     */
    public final static String ISSUER = "http://skidentity.de/IdentityProvider";

    /**
     * 
     */
    public final static String SbjConfirmationMethod = SubjectConfirmation.METHOD_BEARER;

    /**
     * 
     */
    public final static String NameIDFormat = NameIDType.TRANSIENT;

    /**
     * 
     */
    public final static String NameIDValue = "Test123@web.de"; // JK change

    /**
     * 
     */
    public final static String AttrNameFormat = Attribute.URI_REFERENCE;

    /**
     * 
     */
    public final static String AttrName = "TestAttributName"; // JK change

    /**
     * 
     */
    public final static String AuthnContextClassRef = AuthnContext.PPT_AUTHN_CTX;

    /**
     * 
     */
    public final static String AuthnContextDeclRef = "http://skidentity.de/IdentityProvider"; // JK
                                                                                              // change

    public static final String MetadataProtocolSP = "urn:oasis:names:tc:SAML:1.1:protocol urn:oasis:names:tc:SAML:2.0:protocol";
    public static final String MetadataPOSTBinding = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST";
}
