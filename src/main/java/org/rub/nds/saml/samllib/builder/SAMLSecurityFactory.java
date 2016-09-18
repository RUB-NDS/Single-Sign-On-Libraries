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

import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureException;
import org.opensaml.xml.signature.Signer;
import org.rub.nds.elearning.sso.saml.api.TokenSignatureDecoratorType;
import org.rub.nds.saml.samllib.decorators.SAMLDecorator;
import org.rub.nds.saml.samllib.exceptions.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Factory is responsible for signing the Response/Assertion
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SAMLSecurityFactory implements SAMLBuilderInterface {

    private transient Signature signature;
    private static final Logger _log = LoggerFactory.getLogger(SAMLSecurityFactory.class);
    private transient SAMLObject samlToken;
    private TokenSignatureDecoratorType decorator;

    /**
     * Can be initialized only with the loaded Credential
     *
     * @param signature
     * @throws org.rub.nds.saml.samllib.exceptions.SAMLBuildException
     */
    public SAMLSecurityFactory(SAMLObject samlToken, Signature signature, TokenSignatureDecoratorType decorator) throws SAMLBuildException {
        if (signature == null) {
            _log.error("The Signature cannot be NULL! Cannot create an instance of SAMLSecurityFactory");
            throw new SAMLBuildException("The Signature cannot be NULL! Cannot create an instance of SAMLSecurityFactory");
        }
        if (samlToken == null) {
            _log.error("The SAMLToken cannot be NULL! Cannot create an instance of SAMLSecurityFactory");
            throw new SAMLBuildException("The SAMLToken cannot be NULL! Cannot create an instance of SAMLSecurityFactory");

        }
        if (decorator == null) {
            _log.error("The TokenSignatureDecorator cannot be initialized! Cannot sign SAMLObject");
            throw new SAMLBuildException("The TokenSignatureDecorator cannot be initialized! Cannot sign SAMLObject");

        }

        this.signature = signature;
        this.samlToken = samlToken;
        this.decorator = decorator;
    }

    /**
     * Sign the token
     *
     * @param samlToken token to be signed
     * @param profile contains information how to sign the token: assertion,
     * response, assertion AND response, none
     * @return
     * @throws SAMLBuildException
     */
    @Override
    public SAMLObject build() throws SAMLBuildException {
        try {
            Marshaller marshaller;

            _log.info("Start signing the token!");

            if (decorator.isSignAssertion()) {
                Signature tempSig = SecurityUtils.copySignature(signature);
                _log.debug("Signing the assertion!");
                Assertion samlAssertion = ((Response) samlToken).getAssertions().get(0);
                (samlAssertion).setSignature(tempSig);

                marshaller = org.opensaml.Configuration.getMarshallerFactory().getMarshaller(samlAssertion);
                marshaller.marshall(samlAssertion);

                Signer.signObject(tempSig);
            }

            if (decorator.isSignResponse()) {
                Signature tempSig = SecurityUtils.copySignature(signature);
                _log.debug("Signing the response!");
                Response samlResponse = (Response) samlToken;
                (samlResponse).setSignature(tempSig);

                marshaller = org.opensaml.Configuration.getMarshallerFactory().getMarshaller(samlResponse);
                marshaller.marshall(samlResponse);

                Signer.signObject(tempSig);
            }

        } catch (SignatureException | IndexOutOfBoundsException | MarshallingException | NullPointerException | ConfigurationException ex) {
            _log.error("Cannot sign the token!", ex);
            throw new SAMLBuildException("Cannot sign the token!", ex);
        }
        return samlToken;
    }

    @Override
    public void addDecorator(SAMLDecorator decorator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
