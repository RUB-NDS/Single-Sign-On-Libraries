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
package org.rub.nds.saml.samllib.builder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import org.rub.nds.saml.samllib.decorators.ResponseHeaderDecorator;
import org.rub.nds.saml.samllib.decorators.SignatureDecorator;

/**
 * This Decorator-class contains the decorators of the Token initialized
 * by the configuration file
 * 
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */

@XStreamAlias("samlTokenProfile")
public class SAMLTokenProfile {
    
    @XStreamAsAttribute
    private String name;
    
    private String responseHeaderDec;
    private String tokenSignatureDec;
    private String assertionConsumerService;
    private String relayState;
    private String errorRedirectURL;
    
    private List<AssertionProfile> assertions;
    private transient ResponseHeaderDecorator responseHeaderDecorator;
    private transient SignatureDecorator tokenSignatureDecorator;
    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    public SAMLTokenProfile() {
    }
    
    

    /**
     *
     * @param responseHeaderDecorator
     */
    public void setResponseHeaderDecorator(ResponseHeaderDecorator responseHeaderDecorator) {
        this.responseHeaderDecorator = responseHeaderDecorator;
    }

    /**
     *
     * @return
     */
    public ResponseHeaderDecorator getResponseHeaderDecorator() {
        return responseHeaderDecorator;
    }

    /**
     *
     * @return
     */
    public List<AssertionProfile> getAssertions() {
        return assertions;
    }

    /**
     *
     * @param assertions
     */
    public void setAssertions(List<AssertionProfile> assertions) {
        this.assertions = assertions;
    }
    

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getResponseHeaderDec() {
        return responseHeaderDec;
    }

    /**
     *
     * @param tokenSignatureDecorator
     */
    public void setTokenSignatureDecorator(SignatureDecorator tokenSignatureDecorator) {
        this.tokenSignatureDecorator = tokenSignatureDecorator;
    }

    /**
     *
     * @return
     */
    public SignatureDecorator getTokenSignatureDecorator() {
        return tokenSignatureDecorator;
    }

    /**
     *
     * @return
     */
    public String getTokenSignatureDec() {
        return tokenSignatureDec;
    }

    /**
     *
     * @return
     */
    public String getAssertionConsumerService() {
        return assertionConsumerService;
    }

    /**
     *
     * @return
     */
    public String getRelayState() {
        return relayState;
    }

    /**
     *
     * @return
     */
    public String getErrorRedirectURL() {
        return errorRedirectURL;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (propertySupport == null) { propertySupport = new PropertyChangeSupport(this); }
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
