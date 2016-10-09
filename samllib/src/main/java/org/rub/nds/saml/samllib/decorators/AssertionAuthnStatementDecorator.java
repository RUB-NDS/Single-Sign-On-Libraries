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
import org.opensaml.saml2.core.*;
import org.rub.nds.elearning.sso.saml.api.AssertionAuthnStatementDecoratorType;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class decorates/extends the Assertion by generating the
 * AuthenticationStatement
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */

public class AssertionAuthnStatementDecorator extends SAMLDecorator {

    private static final Logger _log = LoggerFactory.getLogger(AssertionAuthnStatementDecorator.class);
    //time frame for the validity of the token
    private int timestamps = 30; //minutes
    //not set up by default
    private String sbjLocalityAddress;
    private String sbjLocalityDNS;
    private String authnContextDeclStr;
    //Default value can be changed by the configuration
    private String authnContextClassRefStr = AuthnContext.PPT_AUTHN_CTX;
    //Default value can be changed by the configuration
    private String authnContextDeclRefStr;     //Jk change

    public AssertionAuthnStatementDecorator(AssertionAuthnStatementDecoratorType decorator) {
        authnContextClassRefStr = decorator.getAuthnContextClassRefStr();
        authnContextDeclRefStr = decorator.getAuthnContextDeclRefStr();
        authnContextDeclStr = decorator.getAuthnContextDeclStr();
        sbjLocalityAddress = decorator.getSbjLocalityAddress();
        sbjLocalityDNS = decorator.getSbjLocalityDNS();
        
        if (decorator.getTimestamps()!=null)
            timestamps = decorator.getTimestamps();
    }

    /**
     * Build the AuthnStatement and add it to the Assertion
     *
     * @param samlToken
     * @throws SAMLBuildException
     */
    @Override
    public SAMLObject build(final SAMLObject samlToken) throws SAMLBuildException {
        _log.debug(AssertionAuthnStatementDecorator.class.toString() + ": Start building the AttributeStatement");

        Assertion samlAssertion;
        AuthnStatement authnStatement;
        SubjectLocality sbjLocality;
        AuthnContext authnContext;
        AuthnContextClassRef authnContextClassRef;
        AuthnContextDecl authnContextDecl;
        AuthnContextDeclRef authnContextDeclRef;

        samlAssertion = (Assertion) samlToken;

        _log.debug("Start building ...");
        authnStatement = (AuthnStatement) SAMLUtils.getSAMLBuilder(AuthnStatement.DEFAULT_ELEMENT_NAME).buildObject();
        sbjLocality = (SubjectLocality) SAMLUtils.getSAMLBuilder(SubjectLocality.DEFAULT_ELEMENT_NAME).buildObject();

        authnContext = (AuthnContext) SAMLUtils.getSAMLBuilder(AuthnContext.DEFAULT_ELEMENT_NAME).buildObject();

        if (authnContextDeclStr != null && !authnContextDeclStr.isEmpty()) {
            authnContextDecl = (AuthnContextDecl) SAMLUtils.getSAMLBuilder(AuthnContextDecl.DEFAULT_ELEMENT_NAME).buildObject();
            authnContextDecl.setTextContent(authnContextDeclStr);
            authnContext.setAuthnContextDecl(authnContextDecl);
        }

        if (authnContextClassRefStr != null && !authnContextClassRefStr.isEmpty()) {
            authnContextClassRef = (AuthnContextClassRef) SAMLUtils.getSAMLBuilder(AuthnContextClassRef.DEFAULT_ELEMENT_NAME).buildObject();
            authnContextClassRef.setAuthnContextClassRef(authnContextClassRefStr);
            authnContext.setAuthnContextClassRef(authnContextClassRef);
        }

        if (authnContextDeclRefStr != null && !authnContextDeclRefStr.isEmpty()) {
            authnContextDeclRef = (AuthnContextDeclRef) SAMLUtils.getSAMLBuilder(AuthnContextDeclRef.DEFAULT_ELEMENT_NAME).buildObject();
            authnContextDeclRef.setAuthnContextDeclRef(authnContextDeclRefStr);
            authnContext.setAuthnContextDeclRef(authnContextDeclRef);
        }

        _log.debug("Fill the elements with content ... ");
        authnStatement.setAuthnInstant(SAMLUtils.getDateTime());
        authnStatement.setSessionIndex(SAMLUtils.getID());
        authnStatement.setSessionNotOnOrAfter(SAMLUtils.getDateTime().plusMinutes(timestamps));

        sbjLocality.setAddress(sbjLocalityAddress);
        sbjLocality.setDNSName(sbjLocalityDNS);
        authnStatement.setSubjectLocality(sbjLocality);

        authnStatement.setAuthnContext(authnContext);

        _log.debug("Add generated AuthenticationStatement to the assertion");
        samlAssertion.getAuthnStatements().add(authnStatement);

        return samlToken;
    }
}
