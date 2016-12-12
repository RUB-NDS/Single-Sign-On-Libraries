//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.12 um 02:23:52 PM CET 
//

package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für samlTokenProfileType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="samlTokenProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responseHeaderDecorator" type="{http://www.api.sso.nds.rub.org}responseHeaderDecoratorType"/>
 *         &lt;element name="assertionHeaderDecorator" type="{http://www.api.sso.nds.rub.org}assertionHeaderDecoratorType"/>
 *         &lt;element name="assertionConditionsDecorator" type="{http://www.api.sso.nds.rub.org}assertionConditionsDecoratorType"/>
 *         &lt;element name="assertionSubjectDecorator" type="{http://www.api.sso.nds.rub.org}assertionSubjectDecoratorType"/>
 *         &lt;element name="assertionAuthnStatementDecorator" type="{http://www.api.sso.nds.rub.org}assertionAuthnStatementDecoratorType"/>
 *         &lt;element name="tokenSignatureDecorator" type="{http://www.api.sso.nds.rub.org}tokenSignatureDecoratorType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samlTokenProfileType", propOrder = { "id", "responseHeaderDecorator", "assertionHeaderDecorator",
        "assertionConditionsDecorator", "assertionSubjectDecorator", "assertionAuthnStatementDecorator",
        "tokenSignatureDecorator" })
public class SamlTokenProfileType {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(required = true)
    protected ResponseHeaderDecoratorType responseHeaderDecorator;
    @XmlElement(required = true)
    protected AssertionHeaderDecoratorType assertionHeaderDecorator;
    @XmlElement(required = true)
    protected AssertionConditionsDecoratorType assertionConditionsDecorator;
    @XmlElement(required = true)
    protected AssertionSubjectDecoratorType assertionSubjectDecorator;
    @XmlElement(required = true)
    protected AssertionAuthnStatementDecoratorType assertionAuthnStatementDecorator;
    @XmlElement(required = true)
    protected TokenSignatureDecoratorType tokenSignatureDecorator;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der responseHeaderDecorator-Eigenschaft ab.
     * 
     * @return possible object is {@link ResponseHeaderDecoratorType }
     * 
     */
    public ResponseHeaderDecoratorType getResponseHeaderDecorator() {
        return responseHeaderDecorator;
    }

    /**
     * Legt den Wert der responseHeaderDecorator-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link ResponseHeaderDecoratorType }
     * 
     */
    public void setResponseHeaderDecorator(ResponseHeaderDecoratorType value) {
        this.responseHeaderDecorator = value;
    }

    /**
     * Ruft den Wert der assertionHeaderDecorator-Eigenschaft ab.
     * 
     * @return possible object is {@link AssertionHeaderDecoratorType }
     * 
     */
    public AssertionHeaderDecoratorType getAssertionHeaderDecorator() {
        return assertionHeaderDecorator;
    }

    /**
     * Legt den Wert der assertionHeaderDecorator-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link AssertionHeaderDecoratorType }
     * 
     */
    public void setAssertionHeaderDecorator(AssertionHeaderDecoratorType value) {
        this.assertionHeaderDecorator = value;
    }

    /**
     * Ruft den Wert der assertionConditionsDecorator-Eigenschaft ab.
     * 
     * @return possible object is {@link AssertionConditionsDecoratorType }
     * 
     */
    public AssertionConditionsDecoratorType getAssertionConditionsDecorator() {
        return assertionConditionsDecorator;
    }

    /**
     * Legt den Wert der assertionConditionsDecorator-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link AssertionConditionsDecoratorType }
     * 
     */
    public void setAssertionConditionsDecorator(AssertionConditionsDecoratorType value) {
        this.assertionConditionsDecorator = value;
    }

    /**
     * Ruft den Wert der assertionSubjectDecorator-Eigenschaft ab.
     * 
     * @return possible object is {@link AssertionSubjectDecoratorType }
     * 
     */
    public AssertionSubjectDecoratorType getAssertionSubjectDecorator() {
        return assertionSubjectDecorator;
    }

    /**
     * Legt den Wert der assertionSubjectDecorator-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link AssertionSubjectDecoratorType }
     * 
     */
    public void setAssertionSubjectDecorator(AssertionSubjectDecoratorType value) {
        this.assertionSubjectDecorator = value;
    }

    /**
     * Ruft den Wert der assertionAuthnStatementDecorator-Eigenschaft ab.
     * 
     * @return possible object is {@link AssertionAuthnStatementDecoratorType }
     * 
     */
    public AssertionAuthnStatementDecoratorType getAssertionAuthnStatementDecorator() {
        return assertionAuthnStatementDecorator;
    }

    /**
     * Legt den Wert der assertionAuthnStatementDecorator-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link AssertionAuthnStatementDecoratorType }
     * 
     */
    public void setAssertionAuthnStatementDecorator(AssertionAuthnStatementDecoratorType value) {
        this.assertionAuthnStatementDecorator = value;
    }

    /**
     * Ruft den Wert der tokenSignatureDecorator-Eigenschaft ab.
     * 
     * @return possible object is {@link TokenSignatureDecoratorType }
     * 
     */
    public TokenSignatureDecoratorType getTokenSignatureDecorator() {
        return tokenSignatureDecorator;
    }

    /**
     * Legt den Wert der tokenSignatureDecorator-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link TokenSignatureDecoratorType }
     * 
     */
    public void setTokenSignatureDecorator(TokenSignatureDecoratorType value) {
        this.tokenSignatureDecorator = value;
    }

}
