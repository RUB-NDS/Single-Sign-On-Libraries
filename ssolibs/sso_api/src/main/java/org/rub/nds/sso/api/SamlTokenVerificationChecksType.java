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
 * <p>
 * Java-Klasse für samlTokenVerificationChecksType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
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
 *         &lt;element name="VerifySAMLResponseSignatureTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifySAMLResponseSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLResponseInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifySAMLAssertionID" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifySAMLAssertionSignatureTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifySAMLAssertionSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifySAMLAssertionInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionIssueInstant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionSbjConfirmationTimestamps" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifySAMLAssertionSbjConfirmationDestination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionSbjInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionConditionsTimestamps" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionConditionsAudience" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="verifySAMLAssertionAuthnMethod" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerifyHolderOfKey" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samlTokenVerificationChecksType", propOrder = { "verifySchema", "verifyXSW", "verifySAMLResponseID",
        "verifySAMLResponseIssueInstant", "VerifySAMLResponseSignatureTrusted", "VerifySAMLResponseSignature",
        "verifySAMLResponseInResponseTo", "VerifySAMLAssertionID", "VerifySAMLAssertionSignatureTrusted",
        "VerifySAMLAssertionSignature", "VerifySAMLAssertionInResponseTo", "verifySAMLAssertionIssueInstant",
        "verifySAMLAssertionSbjConfirmationTimestamps", "VerifySAMLAssertionSbjConfirmationDestination",
        "verifySAMLAssertionSbjInResponseTo", "verifySAMLAssertionConditionsTimestamps",
        "verifySAMLAssertionConditionsAudience", "verifySAMLAssertionAuthnMethod", "VerifyHolderOfKey" })
public class SamlTokenVerificationChecksType {

    protected Boolean verifySchema;
    protected Boolean verifyXSW;
    protected Boolean verifySAMLResponseID;
    protected Boolean verifySAMLResponseIssueInstant;
    protected Boolean VerifySAMLResponseSignatureTrusted;
    protected Boolean VerifySAMLResponseSignature;
    protected Boolean verifySAMLResponseInResponseTo;
    protected Boolean VerifySAMLAssertionID;
    protected Boolean VerifySAMLAssertionSignatureTrusted;
    protected Boolean VerifySAMLAssertionSignature;
    protected Boolean VerifySAMLAssertionInResponseTo;
    protected Boolean verifySAMLAssertionIssueInstant;
    protected Boolean verifySAMLAssertionSbjConfirmationTimestamps;
    protected Boolean VerifySAMLAssertionSbjConfirmationDestination;
    protected Boolean verifySAMLAssertionSbjInResponseTo;
    protected Boolean verifySAMLAssertionConditionsTimestamps;
    protected Boolean verifySAMLAssertionConditionsAudience;
    protected Boolean verifySAMLAssertionAuthnMethod;
    protected Boolean VerifyHolderOfKey;

    /**
     * Ruft den Wert der verifySchema-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySchema() {
        return verifySchema;
    }

    /**
     * Legt den Wert der verifySchema-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySchema(Boolean value) {
        this.verifySchema = value;
    }

    /**
     * Ruft den Wert der verifyXSW-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifyXSW() {
        return verifyXSW;
    }

    /**
     * Legt den Wert der verifyXSW-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifyXSW(Boolean value) {
        this.verifyXSW = value;
    }

    /**
     * Ruft den Wert der verifySAMLResponseID-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLResponseID() {
        return verifySAMLResponseID;
    }

    /**
     * Legt den Wert der verifySAMLResponseID-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLResponseID(Boolean value) {
        this.verifySAMLResponseID = value;
    }

    /**
     * Ruft den Wert der verifySAMLResponseIssueInstant-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLResponseIssueInstant() {
        return verifySAMLResponseIssueInstant;
    }

    /**
     * Legt den Wert der verifySAMLResponseIssueInstant-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLResponseIssueInstant(Boolean value) {
        this.verifySAMLResponseIssueInstant = value;
    }

    /**
     * Ruft den Wert der VerifySAMLResponseSignatureTrusted-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLResponseSignatureTrusted() {
        return VerifySAMLResponseSignatureTrusted;
    }

    /**
     * Legt den Wert der VerifySAMLResponseSignatureTrusted-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLResponseSignatureTrusted(Boolean value) {
        this.VerifySAMLResponseSignatureTrusted = value;
    }

    /**
     * Ruft den Wert der VerifySAMLResponseSignature-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLResponseSignature() {
        return VerifySAMLResponseSignature;
    }

    /**
     * Legt den Wert der VerifySAMLResponseSignature-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLResponseSignature(Boolean value) {
        this.VerifySAMLResponseSignature = value;
    }

    /**
     * Ruft den Wert der verifySAMLResponseInResponseTo-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLResponseInResponseTo() {
        return verifySAMLResponseInResponseTo;
    }

    /**
     * Legt den Wert der verifySAMLResponseInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLResponseInResponseTo(Boolean value) {
        this.verifySAMLResponseInResponseTo = value;
    }

    /**
     * Ruft den Wert der VerifySAMLAssertionID-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionID() {
        return VerifySAMLAssertionID;
    }

    /**
     * Legt den Wert der VerifySAMLAssertionID-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionID(Boolean value) {
        this.VerifySAMLAssertionID = value;
    }

    /**
     * Ruft den Wert der VerifySAMLAssertionSignatureTrusted-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionSignatureTrusted() {
        return VerifySAMLAssertionSignatureTrusted;
    }

    /**
     * Legt den Wert der VerifySAMLAssertionSignatureTrusted-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionSignatureTrusted(Boolean value) {
        this.VerifySAMLAssertionSignatureTrusted = value;
    }

    /**
     * Ruft den Wert der VerifySAMLAssertionSignature-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionSignature() {
        return VerifySAMLAssertionSignature;
    }

    /**
     * Legt den Wert der VerifySAMLAssertionSignature-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionSignature(Boolean value) {
        this.VerifySAMLAssertionSignature = value;
    }

    /**
     * Ruft den Wert der VerifySAMLAssertionInResponseTo-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionInResponseTo() {
        return VerifySAMLAssertionInResponseTo;
    }

    /**
     * Legt den Wert der VerifySAMLAssertionInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionInResponseTo(Boolean value) {
        this.VerifySAMLAssertionInResponseTo = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionIssueInstant-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionIssueInstant() {
        return verifySAMLAssertionIssueInstant;
    }

    /**
     * Legt den Wert der verifySAMLAssertionIssueInstant-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionIssueInstant(Boolean value) {
        this.verifySAMLAssertionIssueInstant = value;
    }

    /**
     * Ruft den Wert der
     * verifySAMLAssertionSbjConfirmationTimestamps-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionSbjConfirmationTimestamps() {
        return verifySAMLAssertionSbjConfirmationTimestamps;
    }

    /**
     * Legt den Wert der
     * verifySAMLAssertionSbjConfirmationTimestamps-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionSbjConfirmationTimestamps(Boolean value) {
        this.verifySAMLAssertionSbjConfirmationTimestamps = value;
    }

    /**
     * Ruft den Wert der
     * VerifySAMLAssertionSbjConfirmationDestination-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionSbjConfirmationDestination() {
        return VerifySAMLAssertionSbjConfirmationDestination;
    }

    /**
     * Legt den Wert der
     * VerifySAMLAssertionSbjConfirmationDestination-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionSbjConfirmationDestination(Boolean value) {
        this.VerifySAMLAssertionSbjConfirmationDestination = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionSbjInResponseTo-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionSbjInResponseTo() {
        return verifySAMLAssertionSbjInResponseTo;
    }

    /**
     * Legt den Wert der verifySAMLAssertionSbjInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionSbjInResponseTo(Boolean value) {
        this.verifySAMLAssertionSbjInResponseTo = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionConditionsTimestamps-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionConditionsTimestamps() {
        return verifySAMLAssertionConditionsTimestamps;
    }

    /**
     * Legt den Wert der verifySAMLAssertionConditionsTimestamps-Eigenschaft
     * fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionConditionsTimestamps(Boolean value) {
        this.verifySAMLAssertionConditionsTimestamps = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionConditionsAudience-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionConditionsAudience() {
        return verifySAMLAssertionConditionsAudience;
    }

    /**
     * Legt den Wert der verifySAMLAssertionConditionsAudience-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionConditionsAudience(Boolean value) {
        this.verifySAMLAssertionConditionsAudience = value;
    }

    /**
     * Ruft den Wert der verifySAMLAssertionAuthnMethod-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifySAMLAssertionAuthnMethod() {
        return verifySAMLAssertionAuthnMethod;
    }

    /**
     * Legt den Wert der verifySAMLAssertionAuthnMethod-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifySAMLAssertionAuthnMethod(Boolean value) {
        this.verifySAMLAssertionAuthnMethod = value;
    }

    /**
     * Ruft den Wert der VerifyHolderOfKey-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isVerifyHolderOfKey() {
        return VerifyHolderOfKey;
    }

    /**
     * Legt den Wert der VerifyHolderOfKey-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setVerifyHolderOfKey(Boolean value) {
        this.VerifyHolderOfKey = value;
    }

}
