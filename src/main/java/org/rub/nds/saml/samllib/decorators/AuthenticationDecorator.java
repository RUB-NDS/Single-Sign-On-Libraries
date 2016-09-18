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

import java.util.ArrayList;
import java.util.List;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Subject;
import org.rub.nds.saml.samllib.builder.SAMLTokenProfile;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class decorates/extends the Assertion according to the authenticated
 * user The generation of the token contains two steps: - Step 1: Read the
 * config-file, select a profile and Build the token - Step 2: Add information
 * received after the authentication, e.g. user's identity and further
 * information
 *
 * This class is the representation of Step 2
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class AuthenticationDecorator extends SAMLDecorator {

    private static Logger _log = LoggerFactory.getLogger(AuthenticationDecorator.class);
    private List<Attribute> attributes;
    private String sbjNameIDValue;
    private SAMLTokenProfile samlProfile;

    /**
     *
     * @param attributes
     */
    public AuthenticationDecorator(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     *
     * @param sbjNameIDValue
     */
    public AuthenticationDecorator(String sbjNameIDValue) {
        this.sbjNameIDValue = sbjNameIDValue;
        this.attributes = new ArrayList<>();
    }

    @Override
    public SAMLObject build(SAMLObject samlToken) throws SAMLBuildException {
        addAttributes(samlToken);
        addSubjectNameIDValue(samlToken);
        return samlToken;
    }

    /*
     * Add attributes of the authenticated user to the AttributeStatement
     */
    private void addAttributes(SAMLObject samlToken) throws SAMLBuildException {
        SAMLDecorator attributeDecorator;
        attributeDecorator = new AssertionAttributeStatementDecorator(attributes);
        samlToken = attributeDecorator.build(samlToken);
    }

    private void addSubjectNameIDValue(SAMLObject samlToken) throws SAMLBuildException {
        Subject subject;

        if (samlToken instanceof Response) {
            for (Assertion assertion : ((Response) samlToken).getAssertions()) {
                assertion.getSubject().getNameID().setValue(sbjNameIDValue);
            }
        } else {
            throw new SAMLBuildException("Not implemented yet!");
        }
    }
}
