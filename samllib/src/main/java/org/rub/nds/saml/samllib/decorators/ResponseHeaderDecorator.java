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
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Status;
import org.opensaml.saml2.core.StatusCode;
import org.rub.nds.elearning.sso.saml.api.RegisteredSPType;
import org.rub.nds.elearning.sso.saml.api.ResponseHeaderDecoratorType;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLDefaultConstants;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */
public class ResponseHeaderDecorator extends SAMLDecorator {

    private static final Logger _log = LoggerFactory.getLogger(ResponseHeaderDecorator.class);
    private String inResponseTo;
    private String destination;
    private String issuerStr;
    private String schemaLocation = "urn:oasis:names:tc:SAML:2.0:protocol"; //default value
    private String statusCodeURI = StatusCode.SUCCESS_URI;

    /**
     *
     */
    public ResponseHeaderDecorator(ResponseHeaderDecoratorType decorator, RegisteredSPType sp, AuthnRequest authnRequest) {
        issuerStr = decorator.getIssuerStr();        
        addStatus(decorator);
        addDestination(sp);
        addInResponseTo(decorator, authnRequest);
    }

    private void addInResponseTo(ResponseHeaderDecoratorType decorator, AuthnRequest authnRequest) {
        if (decorator.isAddInResponseTo()){
            try{
                inResponseTo = authnRequest.getID();
            }catch(NullPointerException ex){
                _log.warn("Cannot add InResponseTo. ", ex.getMessage());
            }
        }
    }

    private void addStatus(ResponseHeaderDecoratorType decorator) {
        if (decorator.getStatusCodeURI()!=null && !decorator.getStatusCodeURI().isEmpty())
        {
            statusCodeURI = decorator.getStatusCodeURI();
        }
    }

    private void addDestination(RegisteredSPType sp) {
        try {
            if (sp != null) {
                destination = sp.getAcsURL().get(0);
            }
        } catch (NullPointerException ex) {
            _log.warn("Empty AcsURLs in RegisteredSP: " + sp.getIssuer());
        }
    }

    @Override
    public SAMLObject build(final SAMLObject samlToken) throws SAMLBuildException {
        Issuer issuer;
        Status status;
        StatusCode statusCode;

        issuer = (Issuer) SAMLUtils.getSAMLBuilder(Issuer.DEFAULT_ELEMENT_NAME).buildObject();

        //If issuerStr is not set up, use a default-value
        if (issuerStr == null) {
            issuer.setValue(SAMLDefaultConstants.ISSUER);
        } else {
            issuer.setValue(issuerStr);
        }

        status = (Status) SAMLUtils.getSAMLBuilder((Status.DEFAULT_ELEMENT_NAME)).buildObject();
        statusCode = (StatusCode) SAMLUtils.getSAMLBuilder(StatusCode.DEFAULT_ELEMENT_NAME).buildObject();
        statusCode.setValue(statusCodeURI);
        status.setStatusCode(statusCode);

        Response resp = (Response) samlToken;
        resp.setDestination(destination);
        resp.setSchemaLocation(schemaLocation);

        if (inResponseTo != null) {
            resp.setInResponseTo(inResponseTo);
        }

        resp.setID(SAMLUtils.getID());
        resp.setIssueInstant(SAMLUtils.getDateTime());
        resp.setVersion(SAMLVersion.VERSION_20);
        resp.setIssuer(issuer);
        resp.setStatus(status);

        return samlToken;
    }
}
