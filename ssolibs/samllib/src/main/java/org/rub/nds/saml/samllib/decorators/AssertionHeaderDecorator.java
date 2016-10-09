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

import org.opensaml.common.SAMLObject;
import org.opensaml.common.SAMLVersion;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.Response;
import org.rub.nds.elearning.sso.saml.api.AssertionHeaderDecoratorType;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLDefaultConstants;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class decorates/extends the header of the Assertion
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */

public class AssertionHeaderDecorator extends SAMLDecorator {

    private static Logger _log = LoggerFactory.getLogger(AssertionHeaderDecorator.class);

    private String issuerStr;
    private String schemaLocation = "urn:oasis:names:tc:SAML:2.0:protocol"; //default value

    public AssertionHeaderDecorator(AssertionHeaderDecoratorType decorator) {
        issuerStr = decorator.getIssuerStr();
    }

    @Override
    public SAMLObject build(final SAMLObject samlToken) throws SAMLBuildException {
        Assertion samlAssertion = (Assertion) new DefaultAssertion().build(null);
        Issuer issuer;
        
        _log.debug("Start building ...");
        issuer = (Issuer) SAMLUtils.getSAMLBuilder(Issuer.DEFAULT_ELEMENT_NAME).buildObject();

        //If issuerStr is not set up, use a default-value
        if (issuerStr == null) {
            issuer.setValue(SAMLDefaultConstants.ISSUER);
        } else {
            issuer.setValue(issuerStr);
        }

        _log.debug("Fill the elements with content ... ");
        samlAssertion.setID(SAMLUtils.getID());
        samlAssertion.setIssuer(issuer);
        samlAssertion.setIssueInstant(SAMLUtils.getDateTime());
        samlAssertion.setVersion(SAMLVersion.VERSION_20);
        samlAssertion.setSchemaLocation(schemaLocation);
        ((Response)samlToken).getAssertions().add(samlAssertion);
                
        return samlToken;
    }
}
