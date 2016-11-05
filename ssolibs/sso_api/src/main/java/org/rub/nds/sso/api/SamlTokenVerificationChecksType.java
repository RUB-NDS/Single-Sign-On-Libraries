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
 * <p>Java-Klasse für samlTokenVerificationChecksType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="samlTokenVerificationChecksType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verifySchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifyXSW" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLResponseID" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLResponseIssueInstant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLResponseSignatureTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLResponseSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLResponseInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLAssertionID" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLAssertionSignatureTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLAssertionSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLAssertionInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionIssueInstant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionSbjConfirmationTimestamps" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiySAMLAssertionSbjConfirmationDestination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionSbjInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionConditionsTimestamps" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionConditionsAudience" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionAuthnMethod" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifiyHolderOfKey" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samlTokenVerificationChecksType", propOrder = {
    "verifySchema",
    "verifyXSW",
    "verifySAMLResponseID",
    "verifySAMLResponseIssueInstant",
    "verifiySAMLResponseSignatureTrusted",
    "verifiySAMLResponseSignature",
    "verifySAMLResponseInResponseTo",
    "verifiySAMLAssertionID",
    "verifiySAMLAssertionSignatureTrusted",
    "verifiySAMLAssertionSignature",
    "verifiySAMLAssertionInResponseTo",
    "verifySAMLAssertionIssueInstant",
    "verifySAMLAssertionSbjConfirmationTimestamps",
    "verifiySAMLAssertionSbjConfirmationDestination",
    "verifySAMLAssertionSbjInResponseTo",
    "verifySAMLAssertionConditionsTimestamps",
    "verifySAMLAssertionConditionsAudience",
    "verifySAMLAssertionAuthnMethod",
    "verifiyHolderOfKey"
})
public class SamlTokenVerificationChecksType {

    protected Boolean verifySchema;
    protected Boolean verifyXSW;
    protected Boolean verifySAMLResponseID;
    protected Boolean verifySAMLResponseIssueInstant;
    protected Boolean verifiySAMLResponseSignatureTrusted;
    protected Boolean verifiySAMLResponseSignature;
    protected Boolean verifySAMLResponseInResponseTo;
    protected Boolean verifiySAMLAssertionID;
    protected Boolean verifiySAMLAssertionSignatureTrusted;
    protected Boolean verifiySAMLAssertionSignature;
    protected Boolean verifiySAMLAssertionInResponseTo;
    protected Boolean verifySAMLAssertionIssueInstant;
    protected Boolean verifySAMLAssertionSbjConfirmationTimestamps;
    protected Boolean verifiySAMLAssertionSbjConfirmationDestination;
    protected Boolean verifySAMLAssertionSbjInResponseTo;
    protected Boolean verifySAMLAssertionConditionsTimestamps;
    protected Boolean verifySAMLAssertionConditionsAudience;
    protected Boolean verifySAMLAssertionAuthnMethod;
    protected Boolean verifiyHolderOfKey;

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
     * Ruft den Wert der verifySAMLResponseID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLResponseID() {
        return verifySAMLResponseID;
    }

    /**
     * Legt den Wert der verifySAMLResponseID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLResponseID(Boolean value) {
        this.verifySAMLResponseID = value;
    }

    /**
     * Ruft den Wert der verifySAMLResponseIssueInstant-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLResponseIssueInstant() {
        return verifySAMLResponseIssueInstant;
    }

    /**
     * Legt den Wert der verifySAMLResponseIssueInstant-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLResponseIssueInstant(Boolean value) {
        this.verifySAMLResponseIssueInstant = value;
    }

    /**
     * Ruft den Wert der verifiySAMLResponseSignatureTrusted-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLResponseSignatureTrusted() {
        return verifiySAMLResponseSignatureTrusted;
    }

    /**
     * Legt den Wert der verifiySAMLResponseSignatureTrusted-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLResponseSignatureTrusted(Boolean value) {
        this.verifiySAMLResponseSignatureTrusted = value;
    }

    /**
     * Ruft den Wert der verifiySAMLResponseSignature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLResponseSignature() {
        return verifiySAMLResponseSignature;
    }

    /**
     * Legt den Wert der verifiySAMLResponseSignature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLResponseSignature(Boolean value) {
        this.verifiySAMLResponseSignature = value;
    }

    /**
     * Ruft den Wert der verifySAMLResponseInResponseTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLResponseInResponseTo() {
        return verifySAMLResponseInResponseTo;
    }

    /**
     * Legt den Wert der verifySAMLResponseInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLResponseInResponseTo(Boolean value) {
        this.verifySAMLResponseInResponseTo = value;
    }

    /**
     * Ruft den Wert der verifiySAMLAssertionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLAssertionID() {
        return verifiySAMLAssertionID;
    }

    /**
     * Legt den Wert der verifiySAMLAssertionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLAssertionID(Boolean value) {
        this.verifiySAMLAssertionID = value;
    }

    /**
     * Ruft den Wert der verifiySAMLAssertionSignatureTrusted-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLAssertionSignatureTrusted() {
        return verifiySAMLAssertionSignatureTrusted;
    }

    /**
     * Legt den Wert der verifiySAMLAssertionSignatureTrusted-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLAssertionSignatureTrusted(Boolean value) {
        this.verifiySAMLAssertionSignatureTrusted = value;
    }

    /**
     * Ruft den Wert der verifiySAMLAssertionSignature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLAssertionSignature() {
        return verifiySAMLAssertionSignature;
    }

    /**
     * Legt den Wert der verifiySAMLAssertionSignature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLAssertionSignature(Boolean value) {
        this.verifiySAMLAssertionSignature = value;
    }

    /**
     * Ruft den Wert der verifiySAMLAssertionInResponseTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLAssertionInResponseTo() {
        return verifiySAMLAssertionInResponseTo;
    }

    /**
     * Legt den Wert der verifiySAMLAssertionInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLAssertionInResponseTo(Boolean value) {
        this.verifiySAMLAssertionInResponseTo = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionIssueInstant-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLAssertionIssueInstant() {
        return verifySAMLAssertionIssueInstant;
    }

    /**
     * Legt den Wert der verifySAMLAssertionIssueInstant-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLAssertionIssueInstant(Boolean value) {
        this.verifySAMLAssertionIssueInstant = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionSbjConfirmationTimestamps-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLAssertionSbjConfirmationTimestamps() {
        return verifySAMLAssertionSbjConfirmationTimestamps;
    }

    /**
     * Legt den Wert der verifySAMLAssertionSbjConfirmationTimestamps-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLAssertionSbjConfirmationTimestamps(Boolean value) {
        this.verifySAMLAssertionSbjConfirmationTimestamps = value;
    }

    /**
     * Ruft den Wert der verifiySAMLAssertionSbjConfirmationDestination-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiySAMLAssertionSbjConfirmationDestination() {
        return verifiySAMLAssertionSbjConfirmationDestination;
    }

    /**
     * Legt den Wert der verifiySAMLAssertionSbjConfirmationDestination-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiySAMLAssertionSbjConfirmationDestination(Boolean value) {
        this.verifiySAMLAssertionSbjConfirmationDestination = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionSbjInResponseTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLAssertionSbjInResponseTo() {
        return verifySAMLAssertionSbjInResponseTo;
    }

    /**
     * Legt den Wert der verifySAMLAssertionSbjInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLAssertionSbjInResponseTo(Boolean value) {
        this.verifySAMLAssertionSbjInResponseTo = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionConditionsTimestamps-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLAssertionConditionsTimestamps() {
        return verifySAMLAssertionConditionsTimestamps;
    }

    /**
     * Legt den Wert der verifySAMLAssertionConditionsTimestamps-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLAssertionConditionsTimestamps(Boolean value) {
        this.verifySAMLAssertionConditionsTimestamps = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionConditionsAudience-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLAssertionConditionsAudience() {
        return verifySAMLAssertionConditionsAudience;
    }

    /**
     * Legt den Wert der verifySAMLAssertionConditionsAudience-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLAssertionConditionsAudience(Boolean value) {
        this.verifySAMLAssertionConditionsAudience = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionAuthnMethod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifySAMLAssertionAuthnMethod() {
        return verifySAMLAssertionAuthnMethod;
    }

    /**
     * Legt den Wert der verifySAMLAssertionAuthnMethod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifySAMLAssertionAuthnMethod(Boolean value) {
        this.verifySAMLAssertionAuthnMethod = value;
    }

    /**
     * Ruft den Wert der verifiyHolderOfKey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiyHolderOfKey() {
        return verifiyHolderOfKey;
    }

    /**
     * Legt den Wert der verifiyHolderOfKey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiyHolderOfKey(Boolean value) {
        this.verifiyHolderOfKey = value;
    }

}
