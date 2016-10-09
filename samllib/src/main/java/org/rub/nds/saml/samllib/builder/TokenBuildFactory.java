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
package org.rub.nds.saml.samllib.builder;

import java.util.ArrayList;
import java.util.List;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Response;
import org.rub.nds.elearning.sso.saml.api.RegisteredSPType;
import org.rub.nds.elearning.sso.saml.api.SamlTokenProfileType;
import org.rub.nds.saml.samllib.decorators.AssertionAuthnStatementDecorator;
import org.rub.nds.saml.samllib.decorators.AssertionHeaderDecorator;
import org.rub.nds.saml.samllib.decorators.ConditionsDecorator;
import org.rub.nds.saml.samllib.decorators.DefaultResponse;
import org.rub.nds.saml.samllib.decorators.ResponseHeaderDecorator;
import org.rub.nds.saml.samllib.decorators.SAMLDecorator;
import org.rub.nds.saml.samllib.decorators.SubjectDecorator;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vmladenov
 */
public class TokenBuildFactory implements SAMLBuilderInterface {

    private static final Logger _log = LoggerFactory.getLogger(TokenBuildFactory.class);
    SamlTokenProfileType profileType;
    RegisteredSPType sp;
    AuthnRequest samlRequest;
    List<SAMLDecorator> decorators = new ArrayList<>();

    public TokenBuildFactory(SamlTokenProfileType profileType) {
        this.profileType = profileType;
    }

    public TokenBuildFactory(SamlTokenProfileType profileType, RegisteredSPType sp) {
        this.profileType = profileType;
        this.sp = sp;
    }

    public TokenBuildFactory(SamlTokenProfileType profileType, RegisteredSPType sp, AuthnRequest samlRequest) {
        this.profileType = profileType;
        this.sp = sp;
        this.samlRequest = samlRequest;
    }

    public TokenBuildFactory(SamlTokenProfileType profileType, RegisteredSPType sp, AuthnRequest samlRequest, List<SAMLDecorator> decorators) {
        this.profileType = profileType;
        this.sp = sp;
        this.samlRequest = samlRequest;
        this.decorators = decorators;
    }

    @Override
    public void addDecorator(SAMLDecorator decorator) {
        decorators.add(decorator);
    }

    @Override
    public SAMLObject build() throws SAMLBuildException {
        checkIfNull(profileType);
        
        _log.info("Creates SAMLToken according to the profile:" + profileType.getName());
        
        _log.debug("Creates a DefaultResponse Object!");
        SAMLObject samlToken = (SAMLObject) new DefaultResponse().build(null);
        
        samlToken = decorateResponseHeader(samlToken);
        samlToken = decorateAssertionHeader(samlToken);
        decorateConditions(samlToken);
        decorateSubject(samlToken);
        decorateAuthnStatement(samlToken);
        
        for (SAMLDecorator decorator : decorators){
            samlToken = decorator.build(samlToken);
        }
        
        return samlToken;
    }

    private void decorateAuthnStatement(SAMLObject samlToken) throws SAMLBuildException {
        _log.debug("Decorates Assertion's AuthnStatement information!");
        if (profileType.getAssertionAuthnStatementDecorator()!= null) {
            AssertionAuthnStatementDecorator decorator = new AssertionAuthnStatementDecorator(profileType.getAssertionAuthnStatementDecorator());
            decorator.build(((Response)samlToken).getAssertions().get(0));
        }
    }

    private void decorateSubject(SAMLObject samlToken) throws SAMLBuildException {
        _log.debug("Decorates Assertion's Subject information!");
        if (profileType.getAssertionSubjectDecorator()!= null) {
            SubjectDecorator decorator = new SubjectDecorator(profileType.getAssertionSubjectDecorator());
            decorator.build(((Response)samlToken).getAssertions().get(0));
        }
    }

    private void decorateConditions(SAMLObject samlToken) throws SAMLBuildException {
        _log.debug("Decorates Assertion's Conditions information!");
        if (profileType.getAssertionConditionsDecorator()!= null) {
            ConditionsDecorator decorator = new ConditionsDecorator(profileType.getAssertionConditionsDecorator());
            decorator.build(((Response)samlToken).getAssertions().get(0));
        }
    }

    private SAMLObject decorateAssertionHeader(SAMLObject samlToken) throws SAMLBuildException {
        _log.debug("Decorates AssertionHeader information!");
        if (profileType.getAssertionHeaderDecorator()!= null) {
            AssertionHeaderDecorator decorator = new AssertionHeaderDecorator(profileType.getAssertionHeaderDecorator());
            samlToken = decorator.build(samlToken);
        }
        return samlToken;
    }

    private SAMLObject decorateResponseHeader(SAMLObject samlToken) throws SAMLBuildException {
        _log.debug("Decorates ResponseHeader information!");
        if (profileType.getResponseHeaderDecorator() != null) {
            ResponseHeaderDecorator decorator = new ResponseHeaderDecorator(profileType.getResponseHeaderDecorator(), sp, samlRequest);
            samlToken = decorator.build(samlToken);
        }
        return samlToken;
    }

    private void checkIfNull(Object obj) throws SAMLBuildException {
        if (obj == null) {
            _log.error("SAMLTokenProfile cannot be NULL!");
            throw new SAMLBuildException("SAMLTokenProfile cannot be NULL!");
        }
    }

}
