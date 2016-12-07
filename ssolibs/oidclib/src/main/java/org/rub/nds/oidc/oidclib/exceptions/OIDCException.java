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
package org.rub.nds.oidc.oidclib.exceptions;

import org.rub.nds.sso.exceptions.ManagerException;

/**
 * Not used
 * 
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */

public class OIDCException extends ManagerException {
    // private static Log _log = LogFactory.getLog(OIDCException.class);

    /**
     * 
     * @param message
     */
    public OIDCException(final String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param throwable
     */
    public OIDCException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
