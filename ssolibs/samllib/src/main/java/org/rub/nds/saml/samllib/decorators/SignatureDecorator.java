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
package org.rub.nds.saml.samllib.decorators;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.opensaml.common.SAMLObject;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@XStreamAlias("tokenSignatureDecorator")
public class SignatureDecorator extends SAMLDecorator{
    private boolean assertionSigned;
    private boolean responseSigned;
    private static Logger _log = LoggerFactory.getLogger(SignatureDecorator.class);


    @Override
    public SAMLObject build(SAMLObject samlToken) throws SAMLBuildException {
        throw new SAMLBuildException("Please use the SAMLSecurityFactory for signing the token!");
    }

    /**
     *
     * @return
     */
    public boolean isAssertionSigned() {
        return assertionSigned;
    }

    /**
     *
     * @return
     */
    public boolean isResponseSigned() {
        return responseSigned;
    }
    
    
}
