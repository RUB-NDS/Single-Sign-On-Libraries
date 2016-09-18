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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.servlet.http.HttpServletResponse;
import org.opensaml.common.SAMLObject;
import org.opensaml.common.SAMLObjectBuilder;
import org.opensaml.common.binding.BasicSAMLMessageContext;
import org.opensaml.saml2.binding.encoding.HTTPRedirectDeflateEncoder;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.Endpoint;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.ws.message.encoder.MessageEncodingException;
import org.opensaml.ws.transport.http.HttpServletResponseAdapter;
import org.opensaml.xml.util.Base64;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.exceptions.WrongInputException;
import static org.rub.nds.saml.samllib.utils.SAMLUtils.samlObj2String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class HTTPUtils {

    private static Logger _log = LoggerFactory.getLogger(HTTPUtils.class);
    /**
     * Creates a self-submitting HTML-form needed for the POST-Redirection
     *
     * @param encodedResponse
     * @param destination
     * @return
     */
    public static String getHttpPostResponse(final String encodedResponse, final String destination) {
        return getHttpPostResponse(encodedResponse, destination, null);
    }

    /**
     *
     * @param encodedResponse
     * @param destination
     * @param relayState
     * @return
     */
    public static String getHttpPostResponse(String encodedResponse, String destination, String relayState) {
        String prefix = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">"
                + "<head>"
                + "<meta http-equiv=\"contet-type\" content=\"text/html; charset=utf-8\" />"
                + "<title>POST data</title></head>"
                + "<body onload=\"document.forms[0].submit()\">"
                + "<noscript>"
                + "<p><strong>Note:</strong> Since your browser does not support JavaScript, you must press the button below once to proceed.</p>"
                + "</noscript>"
                + "<form method=\"post\" action=\"" + destination + "\">";

        String suffix = "<input type=\"hidden\" name=\"SAMLResponse\" value=\"" + encodedResponse + "\" />"
                + "<noscript><input type=\"submit\" value=\"Submit\" /></noscript>"
                + "</form></body></html>";

        String relayStateInput = "<input type=\"hidden\" name=\"RelayState\" value=\"" + relayState + "\" />";

        String httpResponse = "";

        if (relayState == null || relayState.isEmpty()) {
            httpResponse = prefix;
        } else {
            httpResponse = prefix.concat(relayStateInput);
        }

        httpResponse = httpResponse.concat(suffix);



        return httpResponse;
    }

    /**
     * Returns a SAMLObject decoded
     *
     * @param object2encode
     * @param urlEncoding
     * @return the Base64-decoded Object, transformed in a SAMLObject
     * @throws WrongInputException
     */
    public static String encodeSamlObject(final SAMLObject object2encode, final boolean urlEncoding) throws WrongInputException {
        String encodedObject;
        String responseAsString;

        try{
        responseAsString = samlObj2String(object2encode).replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");

        encodedObject = Base64.encodeBytes(responseAsString.getBytes("UTF-8"), Base64.DONT_BREAK_LINES);

        if (urlEncoding) {
            encodedObject = URLEncoder.encode(encodedObject, "UTF-8");
        }
        }catch (UnsupportedEncodingException | NullPointerException ex)
        {
            _log.error("Cannot convert SamlObject to String!");
            throw new WrongInputException("Cannot convert SamlObject to String!", ex);
        }

        return encodedObject;
    }

    /**
     * Returns a SAMLObject decoded
     *
     * @param object2decode Base64-encoded SAMLObject
     * @return the Base64-decoded Object, transformed in a SAMLObject
     * @throws WrongInputException
     */
    public static byte[] decodeSamlObject(final String object2decode) throws WrongInputException {
        try {
            String decodedObject = object2decode;

            org.apache.commons.codec.binary.Base64 base64Decoder = new org.apache.commons.codec.binary.Base64();
            byte[] xmlBytes = decodedObject.getBytes("UTF-8");
            byte[] base64DecodedByteArray = base64Decoder.decode(xmlBytes);

            return base64DecodedByteArray;
        } catch (UnsupportedEncodingException | NullPointerException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }
    }

    /**
     *
     * @param url
     * @return
     * @throws WrongInputException
     */
    public static boolean isURLEncoded(final String url) throws WrongInputException {
        try {
            if (url.equals(new java.net.URI(url).getPath())) {
                return false;
            } else {
                return true;
            }
        } catch (URISyntaxException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }
    }

    public static boolean isBase64Encoded (String str){
        return org.apache.commons.codec.binary.Base64.isBase64(str);
    }
    
    public static boolean isDeflated (byte[] str){
        if (str== null || str.length==0)
        {
            return false;
        }
        
        try {
            try {
                
                Inflater inflater = new Inflater(true);
                inflater.setInput(str);
                byte[] xmlMessageBytes = new byte[5000];
                int resultLength = inflater.inflate(xmlMessageBytes);

                if (!inflater.finished()) {
                    throw new RuntimeException("didn't allocate enough space to hold "
                            + "decompressed data");
                }

                inflater.end();
                return true;
            } catch (DataFormatException e) {
                ByteArrayInputStream bais = new ByteArrayInputStream(
                        str);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (InflaterInputStream iis = new InflaterInputStream(bais)) {
                    byte[] buf = new byte[1024];
                    int count = iis.read(buf);
                    while (count != -1) {
                        baos.write(buf, 0, count);
                        count = iis.read(buf);
                    }
                    iis.close();
                    return true;
                }
            }
        } catch (IOException ex) {
            return false;
        }
    }
    
    /**
     *
     * @param urlEncodedString
     * @return
     * @throws WrongInputException  
     */
    public static String decodeURLString(final String urlEncodedString) throws WrongInputException {
        String decodedString;

        try {
            decodedString = URLDecoder.decode(urlEncodedString, "UTF-8");

            return decodedString;
        } catch (NullPointerException | UnsupportedEncodingException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }
    }

    /**
     * The method does the following operations: URL-encode, Base64-encode, Inflate
     * @param object2encode
     * @param urlEncoded
     * @return
     * @throws WrongInputException
     */
    public static String inflateSamlObject(final String object2encode, boolean urlEncoded) throws WrongInputException {
        String decodedObject;

        decodedObject = object2encode;

        if (urlEncoded) {
            decodedObject = decodeURLString(decodedObject);
        }

        byte[] base64DecodedByteArray = decodeSamlObject(decodedObject);

        try {
            try {
                Inflater inflater = new Inflater(true);
                inflater.setInput(base64DecodedByteArray);
                byte[] xmlMessageBytes = new byte[5000];
                int resultLength = inflater.inflate(xmlMessageBytes);

                if (!inflater.finished()) {
                    throw new RuntimeException("didn't allocate enough space to hold "
                            + "decompressed data");
                }

                inflater.end();
                decodedObject = new String(xmlMessageBytes, 0, resultLength, "UTF-8");

            } catch (DataFormatException e) {
                ByteArrayInputStream bais = new ByteArrayInputStream(
                        base64DecodedByteArray);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (InflaterInputStream iis = new InflaterInputStream(bais)) {
                    byte[] buf = new byte[1024];
                    int count = iis.read(buf);
                    while (count != -1) {
                        baos.write(buf, 0, count);
                        count = iis.read(buf);
                    }
                    iis.close();
                    String decodedStr = new String(baos.toByteArray(), "UTF-8");
                    decodedObject = decodedStr;
                }
            }
        } catch (IOException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }

        return decodedObject;
    }
    
    public static String inflateSamlObject(byte [] str) throws WrongInputException {
        try {
            String decodedObject;
            
            Inflater inflater = new Inflater(true);
            inflater.setInput(str);
            byte[] xmlMessageBytes = new byte[5000];
            int resultLength = inflater.inflate(xmlMessageBytes);
            
            if (!inflater.finished()) {
                throw new RuntimeException("didn't allocate enough space to hold "
                        + "decompressed data");
            }
            
            inflater.end();
            decodedObject = new String(xmlMessageBytes, 0, resultLength, "UTF-8");
            
            return decodedObject;
        } catch (UnsupportedEncodingException | DataFormatException ex) {
            throw new WrongInputException(ex.getMessage(), ex);
        }
    }
    
    
    public static String decode(String samlEncoded) throws WrongInputException{
        byte[] byteStr = null;

        try {
            if (HTTPUtils.isURLEncoded(samlEncoded)) {
                samlEncoded = HTTPUtils.decodeURLString(samlEncoded);
            }

            if (org.apache.commons.codec.binary.Base64.isBase64(samlEncoded)) {
                byteStr = HTTPUtils.decodeSamlObject(samlEncoded);
                samlEncoded = new String(byteStr, "UTF-8");
            }

            if (HTTPUtils.isDeflated(byteStr)) {
                samlEncoded = HTTPUtils.inflateSamlObject(byteStr);
            }
        } catch (WrongInputException | UnsupportedEncodingException ex) {
            throw new WrongInputException("Cannot encode Message", ex);
        }
        
        return samlEncoded;
    }
    
    /**
     *
     * @param samlObject
     * @return
     * @throws WrongInputException
     */
    public static String deflateSamlObject(final SAMLObject samlObject) throws WrongInputException {
        try {
            Deflater deflater = new Deflater(Deflater.DEFLATED, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater)) {
                deflaterOutputStream.write(samlObj2String(samlObject).getBytes("UTF-8"));
                deflaterOutputStream.close();
                String deflatedStr = Base64.encodeBytes(byteArrayOutputStream.toByteArray(), Base64.DONT_BREAK_LINES);
                deflatedStr = URLEncoder.encode(deflatedStr, "UTF-8");
                return deflatedStr;
            }
        } catch (IOException | NullPointerException ex) {
            throw new WrongInputException("Cannot decode SAML Object", ex);
        }
    }

    public static void doEncode(HttpServletResponse response, EntityDescriptor entity, AuthnRequest authnRequest) throws MetadataProviderException {
        try {
            Endpoint endpoint;
            //endpoint = (Endpoint) SAMLUtils.getSAMLBuilder(Endpoint.DEFAULT_ELEMENT_NAME).buildObject();
            SAMLObjectBuilder<Endpoint> endpointBuilder = (SAMLObjectBuilder<Endpoint>) SAMLUtils.getSAMLBuilder().getBuilder(AssertionConsumerService.DEFAULT_ELEMENT_NAME);
            endpoint = endpointBuilder.buildObject();
            String binding = "";
            String location = "";

            binding = entity.getIDPSSODescriptor("urn:oasis:names:tc:SAML:2.0:protocol").getSingleSignOnServices().get(0).getBinding();
            location = entity.getIDPSSODescriptor("urn:oasis:names:tc:SAML:2.0:protocol").getSingleSignOnServices().get(0).getLocation();


            endpoint.setBinding(binding);
            endpoint.setLocation(location);
            endpoint.setResponseLocation(authnRequest.getAssertionConsumerServiceURL());

            BasicSAMLMessageContext<SAMLObject, AuthnRequest, SAMLObject> samlContext = new BasicSAMLMessageContext<>();
            samlContext.setOutboundMessageTransport(new HttpServletResponseAdapter(response, true));
            samlContext.setOutboundSAMLMessage(authnRequest);
            samlContext.setPeerEntityEndpoint(endpoint);
            HTTPRedirectDeflateEncoder encoder = new HTTPRedirectDeflateEncoder();
            encoder.encode(samlContext);
        } catch (MessageEncodingException | SAMLBuildException ex) {
            _log.warn("SAMLManager is not able to encode and send the generated AuthnRequest!");
            throw new MetadataProviderException("Cannot encode the AuthnRequest.", ex);
        }
    }
    
    public static String deflateString (String toEncode) throws WrongInputException{
        try {
            Deflater deflater = new Deflater(Deflater.DEFLATED, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater)) {
                deflaterOutputStream.write(toEncode.getBytes());
                deflaterOutputStream.close();
                String deflatedStr = Base64.encodeBytes(byteArrayOutputStream.toByteArray(), Base64.DONT_BREAK_LINES);
                return deflatedStr;
            }
        } catch (IOException | NullPointerException ex) {
            throw new WrongInputException("Cannot decode SAML Object", ex);
        }
    }
    
    public static String base64Encode (String toEncode){
        return Base64.encodeBytes(toEncode.getBytes(), Base64.DONT_BREAK_LINES);
    }
}
