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
package org.rub.nds.saml.samllib.builder;

import org.opensaml.common.SAMLObject;
import org.rub.nds.saml.samllib.decorators.SAMLDecorator;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public interface SAMLBuilderInterface{

    /**
     * Adds further decorators, e.g. AuthenticationDecorator, HoK-Decorator ...
     *
     * @param decorator
     */
    void addDecorator(SAMLDecorator decorator);

    /**
     * Creates the SAMLToken according to the selected SAMLTokenProfile
     * Phase 1: Build the token according the configuration
     * Phase 2: Extend the token according to further informations:
     *  - ServiceProvider initiated SSO
     *  - Authenticated user's information
     *  - Holder-of-key Certificate
     *  - ...
     *
     * @param profile selected by the user/application/ServiceProvider
     * @return the created SAMLToken
     * @throws SAMLBuildException
     */
    SAMLObject build() throws SAMLBuildException;
}
