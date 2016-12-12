//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.12 um 02:23:52 PM CET 
//

package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für tokenSignatureDecoratorType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="tokenSignatureDecoratorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signAssertion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="signResponse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="signAuthnRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tokenSignatureDecoratorType", propOrder = { "signAssertion", "signResponse", "signAuthnRequest" })
public class TokenSignatureDecoratorType {

    protected Boolean signAssertion;
    protected Boolean signResponse;
    protected Boolean signAuthnRequest;

    /**
     * Ruft den Wert der signAssertion-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isSignAssertion() {
        return signAssertion;
    }

    /**
     * Legt den Wert der signAssertion-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setSignAssertion(Boolean value) {
        this.signAssertion = value;
    }

    /**
     * Ruft den Wert der signResponse-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isSignResponse() {
        return signResponse;
    }

    /**
     * Legt den Wert der signResponse-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setSignResponse(Boolean value) {
        this.signResponse = value;
    }

    /**
     * Ruft den Wert der signAuthnRequest-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isSignAuthnRequest() {
        return signAuthnRequest;
    }

    /**
     * Legt den Wert der signAuthnRequest-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setSignAuthnRequest(Boolean value) {
        this.signAuthnRequest = value;
    }

}
