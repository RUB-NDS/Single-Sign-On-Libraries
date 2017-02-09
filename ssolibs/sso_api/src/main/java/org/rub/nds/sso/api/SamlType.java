//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.09 at 01:11:59 PM EET 
//


package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for samlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="samlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.api.sso.nds.rub.org}ssoType">
 *       &lt;sequence>
 *         &lt;element name="samlRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="samlResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="samlVerificationParameters" type="{http://www.api.sso.nds.rub.org}samlVerificationParametersType" minOccurs="0"/>
 *         &lt;element name="samlVerificationProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="samlTokenVerificationChecks" type="{http://www.api.sso.nds.rub.org}samlTokenVerificationChecksType" minOccurs="0"/>
 *         &lt;element name="samlAuthnReqVerificationChecks" type="{http://www.api.sso.nds.rub.org}samlAuthnRequestVerificationChecksType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samlType", propOrder = {
    "samlRequest",
    "samlResponse",
    "samlVerificationParameters",
    "samlVerificationProfile",
    "samlTokenVerificationChecks",
    "samlAuthnReqVerificationChecks"
})
public class SamlType
    extends SsoType
{

    protected String samlRequest;
    protected String samlResponse;
    protected SamlVerificationParametersType samlVerificationParameters;
    protected String samlVerificationProfile;
    protected SamlTokenVerificationChecksType samlTokenVerificationChecks;
    protected SamlAuthnRequestVerificationChecksType samlAuthnReqVerificationChecks;

    /**
     * Gets the value of the samlRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamlRequest() {
        return samlRequest;
    }

    /**
     * Sets the value of the samlRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamlRequest(String value) {
        this.samlRequest = value;
    }

    /**
     * Gets the value of the samlResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamlResponse() {
        return samlResponse;
    }

    /**
     * Sets the value of the samlResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamlResponse(String value) {
        this.samlResponse = value;
    }

    /**
     * Gets the value of the samlVerificationParameters property.
     * 
     * @return
     *     possible object is
     *     {@link SamlVerificationParametersType }
     *     
     */
    public SamlVerificationParametersType getSamlVerificationParameters() {
        return samlVerificationParameters;
    }

    /**
     * Sets the value of the samlVerificationParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link SamlVerificationParametersType }
     *     
     */
    public void setSamlVerificationParameters(SamlVerificationParametersType value) {
        this.samlVerificationParameters = value;
    }

    /**
     * Gets the value of the samlVerificationProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamlVerificationProfile() {
        return samlVerificationProfile;
    }

    /**
     * Sets the value of the samlVerificationProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamlVerificationProfile(String value) {
        this.samlVerificationProfile = value;
    }

    /**
     * Gets the value of the samlTokenVerificationChecks property.
     * 
     * @return
     *     possible object is
     *     {@link SamlTokenVerificationChecksType }
     *     
     */
    public SamlTokenVerificationChecksType getSamlTokenVerificationChecks() {
        return samlTokenVerificationChecks;
    }

    /**
     * Sets the value of the samlTokenVerificationChecks property.
     * 
     * @param value
     *     allowed object is
     *     {@link SamlTokenVerificationChecksType }
     *     
     */
    public void setSamlTokenVerificationChecks(SamlTokenVerificationChecksType value) {
        this.samlTokenVerificationChecks = value;
    }

    /**
     * Gets the value of the samlAuthnReqVerificationChecks property.
     * 
     * @return
     *     possible object is
     *     {@link SamlAuthnRequestVerificationChecksType }
     *     
     */
    public SamlAuthnRequestVerificationChecksType getSamlAuthnReqVerificationChecks() {
        return samlAuthnReqVerificationChecks;
    }

    /**
     * Sets the value of the samlAuthnReqVerificationChecks property.
     * 
     * @param value
     *     allowed object is
     *     {@link SamlAuthnRequestVerificationChecksType }
     *     
     */
    public void setSamlAuthnReqVerificationChecks(SamlAuthnRequestVerificationChecksType value) {
        this.samlAuthnReqVerificationChecks = value;
    }

}
