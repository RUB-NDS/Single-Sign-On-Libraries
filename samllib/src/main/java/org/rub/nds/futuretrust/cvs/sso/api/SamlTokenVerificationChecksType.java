//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.17 at 11:12:08 PM CEST 
//


package org.rub.nds.futuretrust.cvs.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for samlTokenVerificationChecksType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the verifySchema property.
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
     * Sets the value of the verifySchema property.
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
     * Gets the value of the verifyXSW property.
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
     * Sets the value of the verifyXSW property.
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
     * Gets the value of the verifySAMLResponseID property.
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
     * Sets the value of the verifySAMLResponseID property.
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
     * Gets the value of the verifySAMLResponseIssueInstant property.
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
     * Sets the value of the verifySAMLResponseIssueInstant property.
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
     * Gets the value of the verifiySAMLResponseSignatureTrusted property.
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
     * Sets the value of the verifiySAMLResponseSignatureTrusted property.
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
     * Gets the value of the verifiySAMLResponseSignature property.
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
     * Sets the value of the verifiySAMLResponseSignature property.
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
     * Gets the value of the verifySAMLResponseInResponseTo property.
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
     * Sets the value of the verifySAMLResponseInResponseTo property.
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
     * Gets the value of the verifiySAMLAssertionID property.
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
     * Sets the value of the verifiySAMLAssertionID property.
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
     * Gets the value of the verifiySAMLAssertionSignatureTrusted property.
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
     * Sets the value of the verifiySAMLAssertionSignatureTrusted property.
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
     * Gets the value of the verifiySAMLAssertionSignature property.
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
     * Sets the value of the verifiySAMLAssertionSignature property.
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
     * Gets the value of the verifiySAMLAssertionInResponseTo property.
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
     * Sets the value of the verifiySAMLAssertionInResponseTo property.
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
     * Gets the value of the verifySAMLAssertionIssueInstant property.
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
     * Sets the value of the verifySAMLAssertionIssueInstant property.
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
     * Gets the value of the verifySAMLAssertionSbjConfirmationTimestamps property.
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
     * Sets the value of the verifySAMLAssertionSbjConfirmationTimestamps property.
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
     * Gets the value of the verifiySAMLAssertionSbjConfirmationDestination property.
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
     * Sets the value of the verifiySAMLAssertionSbjConfirmationDestination property.
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
     * Gets the value of the verifySAMLAssertionSbjInResponseTo property.
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
     * Sets the value of the verifySAMLAssertionSbjInResponseTo property.
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
     * Gets the value of the verifySAMLAssertionConditionsTimestamps property.
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
     * Sets the value of the verifySAMLAssertionConditionsTimestamps property.
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
     * Gets the value of the verifySAMLAssertionConditionsAudience property.
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
     * Sets the value of the verifySAMLAssertionConditionsAudience property.
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
     * Gets the value of the verifySAMLAssertionAuthnMethod property.
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
     * Sets the value of the verifySAMLAssertionAuthnMethod property.
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
     * Gets the value of the verifiyHolderOfKey property.
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
     * Sets the value of the verifiyHolderOfKey property.
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
