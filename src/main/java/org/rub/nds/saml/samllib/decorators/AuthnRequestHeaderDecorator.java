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
import org.opensaml.common.SAMLVersion;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Issuer;
import org.rub.nds.elearning.sso.saml.api.SamlRequestProfileType;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */

public class AuthnRequestHeaderDecorator extends SAMLDecorator {
    private String assertionConsumerServiceURL;
    private int assertionConsumerServiceIndex;
    private int attributeConsumingServiceIndex;
    private String consent;
    private String destination;
    private boolean forceAuthn;
    private boolean isPassive;
    private String issuerStr;
    private String protocolBinding;
    private String providerName;
    private String schemaLocation;

    public AuthnRequestHeaderDecorator(SamlRequestProfileType profile) {
        assertionConsumerServiceURL = profile.getAssertionConsumerServiceURL();
        destination = profile.getDestination();
        forceAuthn = profile.isForceAuthn();
    }
    
    
    
    @Override
    public SAMLObject build(SAMLObject samlToken) throws SAMLBuildException {
        AuthnRequest authnRequest;
        Issuer issuer;
        
        authnRequest = (AuthnRequest) samlToken;
        authnRequest.setAssertionConsumerServiceURL(assertionConsumerServiceURL);
        authnRequest.setAssertionConsumerServiceIndex(assertionConsumerServiceIndex);
        authnRequest.setAttributeConsumingServiceIndex(attributeConsumingServiceIndex);
        authnRequest.setConsent(consent);
        authnRequest.setDestination(destination);
        authnRequest.setForceAuthn(forceAuthn);
        authnRequest.setID(SAMLUtils.getID());
        authnRequest.setIsPassive(isPassive);
        authnRequest.setIssueInstant(SAMLUtils.getDateTime());
        
        issuer = (Issuer) SAMLUtils.getSAMLBuilder(Issuer.DEFAULT_ELEMENT_NAME).buildObject();
        issuer.setValue(issuerStr);
        authnRequest.setIssuer(issuer);
        
        authnRequest.setProtocolBinding(protocolBinding);
        authnRequest.setProviderName(providerName);
        authnRequest.setSchemaLocation(schemaLocation);
        authnRequest.setVersion(SAMLVersion.VERSION_20);
        
        return authnRequest;
    }
    
}
