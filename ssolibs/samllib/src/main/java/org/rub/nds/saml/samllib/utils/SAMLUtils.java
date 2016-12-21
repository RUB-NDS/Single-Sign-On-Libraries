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
package org.rub.nds.saml.samllib.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.security.cert.CertificateException;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.joda.time.DateTime;
import org.opensaml.Configuration;
import org.opensaml.DefaultBootstrap;
import org.opensaml.common.IdentifierGenerator;
import org.opensaml.common.SAMLObject;
import org.opensaml.common.SAMLObjectBuilder;
import org.opensaml.common.SignableSAMLObject;
import org.opensaml.common.impl.RandomIdentifierGenerator;
import org.opensaml.saml2.core.*;
import org.opensaml.xml.ConfigurationException;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.XMLObjectBuilderFactory;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.security.credential.BasicCredential;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.signature.KeyInfo;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.X509Data;
import org.opensaml.xml.util.XMLHelper;
import org.rub.nds.sso.exceptions.ManagerException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.sso.exceptions.WrongInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * SAML Utilities needed for the processing of SAML messages
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */
public final class SAMLUtils {

    private static final SAMLUtils INSTANCE = new SAMLUtils();
    private static XMLObjectBuilderFactory builderFactory = null;
    private static Logger _log = LoggerFactory.getLogger(SAMLUtils.class);

    private SAMLUtils() {
    }

    /**
     * returns Instance of the class
     *
     * @return
     */
    public static SAMLUtils getInstance() {
        if (INSTANCE == null) {
            throw new RuntimeException("No singleton instance available");
        }

        return INSTANCE;
    }

    /**
     * Returns unique ID for a SAML element
     *
     * @return unique ID as a String
     */
    public static String getID() {
        _log.trace(SAMLUtils.class.toString() + ": Generate SAML-ID");
        IdentifierGenerator idGenerator = new RandomIdentifierGenerator();
        return idGenerator.generateIdentifier();
    }

    /**
     * Returns the current GMT-time
     *
     * @return the current GMT-time
     */
    public static DateTime getDateTime() {
        _log.trace(SAMLUtils.class.toString() + ": Generate SAML-Timestamp");
        return new DateTime();
    }

    /**
     * Returns a XML-ObjectBuilder to create xml-Elements
     *
     * @return XML-ObjectBuilder to create xml-Elements
     * @throws SAMLBuildException
     */
    public static XMLObjectBuilderFactory getSAMLBuilder() throws SAMLBuildException {
        if (builderFactory != null) {
            return builderFactory;
        }

        try {
            DefaultBootstrap.bootstrap();
            builderFactory = Configuration.getBuilderFactory();
        } catch (ConfigurationException ex) {
            throw new SAMLBuildException(ex.toString(), ex);
        }

        return builderFactory;
    }

    /**
     * Returns a SAML-ObjectBuilder to create saml-Elements
     *
     * @param elementName
     * @return SAML-ObjectBuilder to create saml-Elements
     * @throws SAMLBuildException
     */
    public static SAMLObjectBuilder getSAMLBuilder(final QName elementName) throws SAMLBuildException {
        SAMLObjectBuilder samlBuilder;

        samlBuilder = (SAMLObjectBuilder) getSAMLBuilder().getBuilder(elementName);
        if (samlBuilder == null) {
            throw new SAMLBuildException("SAMLObjectBuilder is NULL");
        }

        return samlBuilder;
    }

    /**
     * Returns a SAML-ObjectBuilder to create saml-Elements
     *
     * @param elementName
     * @return SAML-ObjectBuilder to create saml-Elements
     * @throws SAMLBuildException
     */
    public static SAMLObjectBuilder getSAMLBuilder(final Element elementName) throws SAMLBuildException {
        SAMLObjectBuilder samlBuilder;

        samlBuilder = (SAMLObjectBuilder) getSAMLBuilder().getBuilder(elementName);

        if (samlBuilder == null) {
            throw new SAMLBuildException("SAMLObjectBuilder is NULL");
        }

        return samlBuilder;
    }

    /**
     *
     * @param decodedObject
     * @return
     * @throws WrongInputException
     */
    public static SAMLObject buildObjectfromString(final String decodedObject) throws WrongInputException {
        try {
            DocumentBuilderFactory dbf;
            DocumentBuilder docBuilder;
            InputSource is2;
            Element samlElement;

            dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            docBuilder = dbf.newDocumentBuilder();

            is2 = new InputSource();
            is2.setCharacterStream(new StringReader(decodedObject));
            samlElement = docBuilder.parse(is2).getDocumentElement();
            return (SAMLObject) Configuration.getUnmarshallerFactory().getUnmarshaller(samlElement)
                    .unmarshall(samlElement);
        } catch (UnmarshallingException | SAXException | IOException | ParserConfigurationException
                | NullPointerException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }
    }

    /**
     *
     * @param authnRequest
     * @return a list of attributes requested in an AuthnRequest
     * @throws WrongInputException
     */
    public static List<String> getAuthnRequestAttributes(final AuthnRequest authnRequest) throws WrongInputException {
        List<String> attributes;

        attributes = new ArrayList<>();

        try {
            if (authnRequest.getExtensions() != null && !authnRequest.getExtensions().getUnknownXMLObjects().isEmpty()) {
                List<XMLObject> xmlObjects = authnRequest.getExtensions().getUnknownXMLObjects(
                        Attribute.DEFAULT_ELEMENT_NAME);
                for (int i = 0; i < xmlObjects.size(); i++) {
                    attributes.add(((Attribute) xmlObjects.get(i)).getName());
                }
            } else {
                List<XMLObject> xmlObjects = authnRequest.getSubject().getSubjectConfirmations().get(0)
                        .getSubjectConfirmationData().getUnknownXMLObjects(Attribute.DEFAULT_ELEMENT_NAME);
                for (int i = 0; i < xmlObjects.size(); i++) {
                    attributes.add(((Attribute) xmlObjects.get(i)).getName());
                }
            }
        } catch (NullPointerException | ClassCastException ex) {
            throw new WrongInputException("Cannot extract Attributes from AuthnRequest!");
        }

        return attributes;
    }

    /**
     *
     * @param samlObject
     * @return the Issuer element of a SAMLObject
     * @throws WrongInputException
     */
    public static String getIssuer(final SAMLObject samlObject) throws WrongInputException {
        String result = "";

        try {
            if (samlObject instanceof Assertion) {
                result = ((Assertion) samlObject).getIssuer().getValue();
            } else if (samlObject instanceof Response) {
                result = ((Response) samlObject).getIssuer().getValue();
            } else if (samlObject instanceof AuthnRequest) {
                result = ((AuthnRequest) samlObject).getIssuer().getValue();
            }
        } catch (ClassCastException | NullPointerException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }

        return result;
    }

    /**
     *
     * @param signature
     * @return
     * @throws WrongInputException
     */
    public static Credential getCredential(final Signature signature) throws WrongInputException {
        BasicCredential publicCredential = null;

        try {
            // Get the KeyInfo node
            KeyInfo keyInfo = signature.getKeyInfo();

            // Get the list of certificates
            java.util.List<X509Data> x509List = keyInfo.getX509Datas();

            // Pull out the first x509 data element
            X509Data x509Data = x509List.get(0);

            // Get the current Issuer Signing certificate String of the current
            // assertion and current x509Data:
            String base64BinaryCert = x509Data.getX509Certificates().get(0).getValue();
            // Get decoded certificate:
            byte[] decoded = org.apache.xml.security.utils.Base64.decode(base64BinaryCert);
            javax.security.cert.X509Certificate x509Certificate;

            x509Certificate = javax.security.cert.X509Certificate.getInstance(decoded);

            // Validate the signature based on public key.
            publicCredential = new BasicCredential();
            publicCredential.setPublicKey(x509Certificate.getPublicKey());
        } catch (NullPointerException | Base64DecodingException | CertificateException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }

        return publicCredential;
    }

    /**
     *
     * @param obj
     * @return
     */
    public static boolean isSigned(final SAMLObject obj) {
        boolean issigned = false;

        if (obj instanceof Response) {
            issigned = ((Response) obj).isSigned();
        } else if (obj instanceof Assertion) {
            issigned = ((Assertion) obj).isSigned();
        } else if (obj instanceof AuthnRequest) {
            issigned = ((AuthnRequest) obj).isSigned();
        }

        return issigned;
    }

    /**
     *
     * @param samlObjects
     * @return
     * @throws WrongInputException
     */
    public static List<SignableSAMLObject> isSigned(final List<SAMLObject> samlObjects) throws WrongInputException {
        List<SignableSAMLObject> signObjects;
        signObjects = new ArrayList<>();

        try {
            for (SAMLObject obj : samlObjects) {
                if (isSigned(obj)) {
                    signObjects.add((SignableSAMLObject) obj);
                }
            }
        } catch (NullPointerException ex) {
            throw new WrongInputException("The list is empty!");
        }

        return signObjects;
    }

    /**
     *
     * @param obj
     * @param xpathExpression
     * @return
     * @throws WrongInputException
     */
    public static NodeList getHokCertificate(final SAMLObject obj, final String xpathExpression)
            throws WrongInputException {

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        try {
            NamespaceContext nsContext = new SAMLNamespaceContext();
            // nsContext.setPrefix(SAMLConstants.SAML20_PREFIX,
            // SAMLConstants.SAML20_NS);
            // nsContext.setPrefix(SAMLConstants.SAML20P_PREFIX,
            // SAMLConstants.SAML20P_NS);
            // nsContext.setPrefix("ds", "http://www.w3.org/2000/09/xmldsig#");
            xpath.setNamespaceContext(nsContext);

            XPathExpression xpathExpr = xpath.compile(xpathExpression);

            return ((NodeList) xpathExpr.evaluate(saml2xml(obj), XPathConstants.NODESET));
        } catch (XPathExpressionException | NullPointerException ex) {
            _log.error("Cannot extract HoK-certificate from SAMLObject", ex);
            throw new WrongInputException("Cannot extract HoK-certificate from SAMLObject", ex);
        }
    }

    /**
     *
     * @param samlObj
     * @return
     * @throws WrongInputException
     */
    public static Element saml2xml(final SAMLObject samlObj) throws WrongInputException {
        try {
            Marshaller marshaller = org.opensaml.Configuration.getMarshallerFactory().getMarshaller(samlObj);
            return marshaller.marshall(samlObj);
        } catch (MarshallingException | NullPointerException ex) {
            _log.error("Wrong input!", ex);
            throw new WrongInputException("Wrong input!", ex);
        }
    }

    /**
     * SAML Printer method<br>
     * <br>
     *
     * @param toPrint
     * @return converted SAMLObject into String
     * @throws WrongInputException
     */
    public static String samlObj2String(final SAMLObject toPrint) throws WrongInputException {
        try {
            // Now we must build our representation to put into the html form to
            // be submitted to the idp
            Marshaller marshaller = org.opensaml.Configuration.getMarshallerFactory().getMarshaller(toPrint);
            org.w3c.dom.Element authDOM = marshaller.marshall(toPrint);
            StringWriter rspWrt = new StringWriter();
            XMLHelper.writeNode(authDOM, rspWrt);
            String samlObjectAsString = rspWrt.toString();
            return samlObjectAsString;
        } catch (MarshallingException | NullPointerException ex) {
            _log.error("Error converting SAMLObject -> String: " + ex);
            throw new WrongInputException("Error converting SAMLObject -> String", ex);
        }
    }

    /**
     *
     * @param authnRequest
     * @return
     * @throws WrongInputException
     */
    public static AuthnRequest getAuthnRequest(String authnRequest) throws WrongInputException {
        try {
            String inflatedAuthnRequest = HTTPUtils.inflateSamlObject(authnRequest, false);
            return (AuthnRequest) SAMLUtils.buildObjectfromString(inflatedAuthnRequest);
        } catch (WrongInputException ex) {
            _log.error("Cannot retrieve informations from the AuthnRequest", ex);
            throw new WrongInputException("Cannot retrieve informations from the AuthnRequest");
        }
    }

    /**
     *
     * @param authnRequest
     * @return
     * @throws WrongInputException
     */
    public static String getAuthnRequestIssuer(String authnRequest) throws WrongInputException {
        try {
            String inflatedAuthnRequest = HTTPUtils.inflateSamlObject(authnRequest, false);
            AuthnRequest request = (AuthnRequest) SAMLUtils.buildObjectfromString(inflatedAuthnRequest);
            return getIssuer(request);
        } catch (WrongInputException ex) {
            _log.error("Cannot retrieve Issuer from the AuthnRequest", ex);
            throw new WrongInputException("Cannot retrieve Issuer from the AuthnRequest");
        }
    }

    public static String getAuthenticatedUser(Response response) throws WrongInputException {
        try {
            return response.getAssertions().get(0).getSubject().getNameID().getValue();
        } catch (NullPointerException ex) {
            _log.error("No authenticated user was found in the token!", ex);
            throw new WrongInputException("No authenticated user was found in the token!");
        }
    }
}
