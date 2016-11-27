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
package org.rub.nds.saml.samllib.verifier;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.util.Base64;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.exceptions.WrongInputException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.rub.nds.sso.api.VerificationProfileType;
import org.w3c.dom.NodeList;

/**
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 * @author Julian Krautwald <julian.krautwald@rub.de>
 */
public class HolderOfKeyVerification implements SAMLVerifierInterface {

    final String xPathExpression = "/saml2:Subject/saml2:SubjectConfirmation[@Method='urn:oasis:names:tc:SAML:2.0:cm:holder-of-key']/saml2:SubjectConfirmationData/ds:KeyInfo/ds:X509Data/ds:X509Certificate";
    final String xPathResponsePrefix = "//saml2:Assertion[name(parent::node())='saml2p:Response']";
    final String xPathAssertionPrefix = "//saml2:Assertion";
    X509Certificate certificate;

    public HolderOfKeyVerification(X509Certificate certificate) {
        this.certificate = certificate;
    }

    private String createXPathExpression(SAMLObject obj) {
        String result = "";

        if (obj instanceof Response) {
            result = xPathResponsePrefix.concat(xPathExpression);
        } else if (obj instanceof Assertion) {
            result = xPathAssertionPrefix.concat(xPathExpression);
        }

        return result;
    }

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        if (profile.getSamlTokenVerificationChecks().isVerifiyHolderOfKey() != null
                && profile.getSamlTokenVerificationChecks().isVerifiyHolderOfKey()) {
            try {
                NodeList results = SAMLUtils.getHokCertificate(samlObject, createXPathExpression(samlObject));
                // Compare client certificate of SAML response with given TLS
                // channel cert:
                if (results.getLength() == 0) {
                    throw new SAMLVerifyException(
                            "Verification of the Holder-of-Key was not successful! No certificates werre found!");
                }

                for (int i = 0; i < results.getLength(); i++) {
                    String expected = results.item(i).getTextContent().replaceAll("\r", "").replaceAll("\n", "");
                    String current = Base64.encodeBytes(certificate.getEncoded(), Base64.DONT_BREAK_LINES);
                    if (!expected.contentEquals(current)) {
                        throw new SAMLVerifyException("Certificate missmatch! \n\n Expected ceritifcate:" + expected
                                + "\n\n Current certificate: " + current);
                    }
                }
            } catch (WrongInputException ex) {
                throw new SAMLVerifyException("Error decoding certificate!", ex);
            } catch (CertificateEncodingException ex) {
                throw new SAMLVerifyException("Error decoding certificate!", ex);
            } catch (NullPointerException ex) {
                throw new SAMLVerifyException("Cannot find certificate!", ex);
            }
        }
    }
}
