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

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.opensaml.Configuration;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.SubjectConfirmation;
import org.opensaml.xml.security.keyinfo.KeyInfoHelper;
import org.opensaml.xml.signature.KeyInfo;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Holder-of-Key decorator
 * 
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class HoKDecorator extends SAMLDecorator{
    private static Logger _log = LoggerFactory.getLogger(HoKDecorator.class);
    private transient X509Certificate certificate;
    private transient KeyInfo keyInfo;

    /**
     *
     * @param certificate
     * @throws SAMLBuildException
     */
    public HoKDecorator(X509Certificate certificate) throws SAMLBuildException {
        try {
            keyInfo = (KeyInfo) Configuration.getBuilderFactory().getBuilder(KeyInfo.DEFAULT_ELEMENT_NAME).buildObject(KeyInfo.DEFAULT_ELEMENT_NAME);
            KeyInfoHelper.addCertificate(keyInfo, (java.security.cert.X509Certificate) certificate);
            this.certificate = certificate;
        } 
        catch (CertificateEncodingException | NullPointerException ex) {
            _log.error("Error by converting client's certificate!");
            throw new SAMLBuildException("Error by converting client's certificate!", ex);
        }
    }

    @Override
    public SAMLObject build(SAMLObject samlToken) throws SAMLBuildException {
        Response response = (Response) samlToken;
        
        for (Assertion assertion : response.getAssertions())
        {
            for (SubjectConfirmation sbjConfirm : assertion.getSubject().getSubjectConfirmations())
            {
                sbjConfirm.setMethod(SubjectConfirmation.METHOD_HOLDER_OF_KEY);
                sbjConfirm.getSubjectConfirmationData().getUnknownXMLObjects().add(keyInfo);
            }
        }
        
        return samlToken;
    }  
}
