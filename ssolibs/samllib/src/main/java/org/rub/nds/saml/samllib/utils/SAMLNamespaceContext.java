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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.NamespaceContext;
import org.opensaml.common.xml.SAMLConstants;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SAMLNamespaceContext implements NamespaceContext {

    private final Map<String, String> PREF_MAP = new HashMap<String, String>();

    public SAMLNamespaceContext() {
        PREF_MAP.put(SAMLConstants.SAML20_PREFIX, SAMLConstants.SAML20_NS);
        PREF_MAP.put(SAMLConstants.SAML20P_PREFIX, SAMLConstants.SAML20P_NS);
        PREF_MAP.put("ds", "http://www.w3.org/2000/09/xmldsig#");
    }

    public String getNamespaceURI(String prefix) {
        return PREF_MAP.get(prefix);
    }

    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }
}
