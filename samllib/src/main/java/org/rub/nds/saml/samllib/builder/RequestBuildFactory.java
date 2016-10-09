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
import org.rub.nds.elearning.sso.saml.api.RegisteredIdPType;
import org.rub.nds.elearning.sso.saml.api.SamlRequestProfileType;
import org.rub.nds.saml.samllib.decorators.AuthnRequestHeaderDecorator;
import org.rub.nds.saml.samllib.decorators.DefaultAuthnRequest;
import org.rub.nds.saml.samllib.decorators.SAMLDecorator;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vmladenov
 */
public class RequestBuildFactory implements SAMLBuilderInterface {

    private static final Logger _log = LoggerFactory.getLogger(RequestBuildFactory.class);
    SamlRequestProfileType profileType;
    RegisteredIdPType idp;
    List<SAMLDecorator> decorators = new ArrayList<>();

    public RequestBuildFactory(SamlRequestProfileType profileType) {
        this.profileType = profileType;
    }

    @Override
    public void addDecorator(SAMLDecorator decorator) {
        decorators.add(decorator);
    }

    @Override
    public SAMLObject build() throws SAMLBuildException {
        SAMLObject samlToken = (SAMLObject) new DefaultAuthnRequest().build(null);

        if (profileType != null) {
            _log.debug("Decorates the AuthnRequest Header information!");
            AuthnRequestHeaderDecorator decorator = new AuthnRequestHeaderDecorator(profileType);
            samlToken = decorator.build(samlToken);
        }

        _log.debug("Further Decorate the AuthnRequest!");
        for (SAMLDecorator decorator : decorators) {
            samlToken = decorator.build(samlToken);
        }

        return samlToken;
    }
}
//SAMLObject samlToken = (SAMLObject) new DefaultAuthnRequest().build(null);
//
//        if (profile.getRequestHeaderDecorator() != null) {
//            decorators.add(profile.getRequestHeaderDecorator());
//        }
//        if (profile.getRequestConditionsDecorator() != null) {
//            decorators.add(profile.getRequestConditionsDecorator());
//        }
//        if (profile.getRequestSubjectDecorator() != null) {
//            decorators.add(profile.getRequestSubjectDecorator());
//        }
//
//        for (SAMLDecorator decorator : decorators) {
//            samlToken = decorator.build(samlToken);
//        }
//
//        return samlToken;
