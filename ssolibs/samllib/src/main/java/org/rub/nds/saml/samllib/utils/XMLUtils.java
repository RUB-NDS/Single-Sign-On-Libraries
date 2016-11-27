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

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.rub.nds.sso.exceptions.WrongInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */
public class XMLUtils {
    private static Logger _log = LoggerFactory.getLogger(XMLUtils.class);

    /**
     * Reading the content of the file "configPath" and converting the content
     * in xml-Object<br>
     * <br>
     *
     * @param configPath
     * @return xml-Document of the input file
     * @throws WrongInputException
     */
    public static Document readConfigFile(final String configPath) throws WrongInputException {
        if (configPath == null) {
            _log.error("Can't find configuration File: NULL");
            throw new WrongInputException("Can't find configuration File: NULL");
        }

        final File configFile = new File(configPath);
        Document doc;

        if (!configFile.exists()) {
            _log.error("Can't find configuration File: " + configPath);
            throw new WrongInputException("Can't find configuration File: " + configPath);
        }

        try {
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(configFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            _log.error("Error reading/parsing xml-ConfigrationFile");
            throw new WrongInputException("Error reading/parsing xml-ConfigrationFile: ", ex);
        }

        return doc;
    }

    /**
     * Read the content of the element "element2Get" from the xml-Document
     * "configFile"<br>
     * <br>
     *
     * @param configFile
     * @param element2Get
     * @return the content of the element "element2Get"
     * @throws WrongInputException
     */
    public static String readConfigFile(final Document configFile, final String element2Get) throws WrongInputException {
        Node tempNode;

        if (configFile == null || element2Get == null) {
            _log.error("Can't retrieve information about: " + element2Get + ". The xml-Document is NULL!");
            throw new WrongInputException("Can't retrieve information about: " + element2Get
                    + ". The xml-Document is NULL!");
        }

        tempNode = configFile.getElementsByTagName(element2Get).item(0);
        if (tempNode == null) {
            // _log.error("Can't retrieve information about: " + element2Get);
            throw new WrongInputException("Can't retrieve information about: " + element2Get);
        }

        return tempNode.getTextContent();

    }

    /**
     * Needed by downloading the metadata-information over HTTSP
     * 
     * @param toConvert
     * @return
     * @throws WrongInputException
     */
    public static Element convertString2DOM(final String toConvert) throws WrongInputException {
        try {
            Document document;
            DocumentBuilder builder;
            DocumentBuilderFactory factory;
            InputSource inputSource;

            factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            builder = factory.newDocumentBuilder();
            inputSource = new InputSource(new StringReader(toConvert));
            document = builder.parse(inputSource);

            return document.getDocumentElement();
        } catch (SAXException | ParserConfigurationException | NullPointerException | IOException ex) {
            throw new WrongInputException("Cannot convert String to XML element!", ex);
        }
    }

    /**
     *
     * @param toConvert
     * @return
     * @throws WrongInputException
     */
    public static String convertDOM2String(final Element toConvert) throws WrongInputException {
        try {
            // set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            // create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(toConvert);
            trans.transform(source, result);
            return sw.toString();
        } catch (TransformerException | NullPointerException ex) {
            throw new WrongInputException("Cannot convert XML to String", ex);
        }
    }
}
