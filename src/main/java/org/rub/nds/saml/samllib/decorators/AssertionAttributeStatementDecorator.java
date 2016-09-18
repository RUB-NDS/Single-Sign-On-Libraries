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

import java.util.List;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.Response;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class decorates/extends the Assertion by generating the
 * AttributeStatement
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */
public class AssertionAttributeStatementDecorator extends SAMLDecorator {

    private static Logger _log = LoggerFactory.getLogger(AssertionAttributeStatementDecorator.class);
    //Default value - empty list
    private List<Attribute> attributes;

    /**
     *
     * @param attributes
     */
    public AssertionAttributeStatementDecorator(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /*
     * Build the AttributeSteement and add it to the Assertion
     *
     * @throws SAMLBuildException
     */
    @Override
    public SAMLObject build(final SAMLObject samlToken) throws SAMLBuildException {
        try {
            _log.debug(AssertionAttributeStatementDecorator.class.toString() + ": Start building the AttributeStatement");

            AttributeStatement attrStatement;

            for (Assertion assertion : ((Response) samlToken).getAssertions()) {
                
                if (!attributes.isEmpty()) { /* AttributeStatement should not be empty */

                    if (assertion.getAttributeStatements() == null || assertion.getAttributeStatements().isEmpty()) {
                        _log.debug("No AttributeStatement found! Generate new one ...");

                        attrStatement = (AttributeStatement) SAMLUtils.getSAMLBuilder(AttributeStatement.DEFAULT_ELEMENT_NAME).buildObject();
                        assertion.getAttributeStatements().add(attrStatement);
                    } else {
                        _log.debug("AttributeStatement found. Extending it!");
                        attrStatement = assertion.getAttributeStatements().get(0);
                    }


                    _log.debug("Adding attributes to the Attribute statement");
                    for (Attribute attr : attributes) {
                        attrStatement.getAttributes().add(attr);
                    }

                }


            }
            return samlToken;

        } catch (NullPointerException | UnsupportedOperationException ex) {
            _log.error("Cannot create AttributeStatement!");
            throw new SAMLBuildException("Cannot create AttributeStatement!", ex);
        }
    }
}