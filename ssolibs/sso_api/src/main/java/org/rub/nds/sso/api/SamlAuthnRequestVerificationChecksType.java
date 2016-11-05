//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.11.04 um 11:43:03 PM CET 
//


package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für samlAuthnRequestVerificationChecksType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="samlAuthnRequestVerificationChecksType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verifySchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifyXSW" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifyAuthnReqSignatureTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifyAuthnReqSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifyAuthnReqIssueInstant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifyAuthnReqID" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samlAuthnRequestVerificationChecksType", propOrder = {
    "verifySchema",
    "verifyXSW",
    "verifyAuthnReqSignatureTrusted",
    "verifyAuthnReqSignature",
    "verifyAuthnReqIssueInstant",
    "verifyAuthnReqID"
})
public class SamlAuthnRequestVerificationChecksType {

    protected Boolean verifySchema;
    protected Boolean verifyXSW;
    protected Boolean verifyAuthnReqSignatureTrusted;
    protected Boolean verifyAuthnReqSignature;
    protected Boolean verifyAuthnReqIssueInstant;
    protected Boolean verifyAuthnReqID;

    /**
     * Ruft den Wert der verifySchema-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySchema() {
        return verifySchema;
    }

    /**
     * Legt den Wert der verifySchema-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySchema(Boolean value) {
        this.verifySchema = value;
    }

    /**
     * Ruft den Wert der verifyXSW-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifyXSW() {
        return verifyXSW;
    }

    /**
     * Legt den Wert der verifyXSW-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifyXSW(Boolean value) {
        this.verifyXSW = value;
    }

    /**
     * Ruft den Wert der verifyAuthnReqSignatureTrusted-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifyAuthnReqSignatureTrusted() {
        return verifyAuthnReqSignatureTrusted;
    }

    /**
     * Legt den Wert der verifyAuthnReqSignatureTrusted-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifyAuthnReqSignatureTrusted(Boolean value) {
        this.verifyAuthnReqSignatureTrusted = value;
    }

    /**
     * Ruft den Wert der verifyAuthnReqSignature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifyAuthnReqSignature() {
        return verifyAuthnReqSignature;
    }

    /**
     * Legt den Wert der verifyAuthnReqSignature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifyAuthnReqSignature(Boolean value) {
        this.verifyAuthnReqSignature = value;
    }

    /**
     * Ruft den Wert der verifyAuthnReqIssueInstant-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifyAuthnReqIssueInstant() {
        return verifyAuthnReqIssueInstant;
    }

    /**
     * Legt den Wert der verifyAuthnReqIssueInstant-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifyAuthnReqIssueInstant(Boolean value) {
        this.verifyAuthnReqIssueInstant = value;
    }

    /**
     * Ruft den Wert der verifyAuthnReqID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifyAuthnReqID() {
        return verifyAuthnReqID;
    }

    /**
     * Legt den Wert der verifyAuthnReqID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifyAuthnReqID(Boolean value) {
        this.verifyAuthnReqID = value;
    }

}
