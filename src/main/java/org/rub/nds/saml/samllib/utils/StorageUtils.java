/*
 * Copyright (C) 2016 vmladenov.
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

import org.rub.nds.elearning.sso.saml.api.RegisteredIdPType;
import org.rub.nds.elearning.sso.saml.api.RegisteredSPType;
import org.rub.nds.elearning.sso.saml.api.SAMLProfileStorageType;
import org.rub.nds.elearning.sso.saml.api.SamlRequestProfileType;
import org.rub.nds.elearning.sso.saml.api.SamlTokenProfileType;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationProfileType;

/**
 *
 * @author vmladenov
 */
    public class StorageUtils {

    public static SamlTokenProfileType getSamlTokenProfileType(SAMLProfileStorageType samlstorage, String profile) {
        for (SamlTokenProfileType p : samlstorage.getSamlTokenProfiles().getSamlTokenProfile()) {
            if (p.getName().equalsIgnoreCase(profile)) {
                return p;
            }
        }
        return null;
    }

    public static RegisteredIdPType getRegisteredIdPType(SAMLProfileStorageType samlstorage, String name) {
        for (RegisteredIdPType p : samlstorage.getRegisteredIdPs().getRegisteredIdP()) {
            if (p.getIssuer().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    public static RegisteredSPType getRegisteredSPType(SAMLProfileStorageType samlstorage, String name) {
        for (RegisteredSPType p : samlstorage.getRegisteredSPs().getRegisteredSP()) {
            if (p.getIssuer().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    public static SamlRequestProfileType getSamlRequestProfileType(SAMLProfileStorageType samlstorage, String name) {
        for (SamlRequestProfileType p : samlstorage.getSamlRequestProfiles().getSamlRequestProfile()) {
            if (p.getIssuer().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    public static VerificationProfileType getVerificationProfileType(SAMLProfileStorageType samlstorage, String name) {
        for (VerificationProfileType p : samlstorage.getSamlVerificationProfiles().getSamlVerificationProfile()) {
            if (p.getID().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
