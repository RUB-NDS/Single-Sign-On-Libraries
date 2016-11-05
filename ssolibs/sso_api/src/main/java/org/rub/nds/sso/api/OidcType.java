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
 * <p>Java-Klasse für oidcType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="oidcType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oidcResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oidcVerificationProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oidcVerificationParameters" type="{http://www.api.sso.nds.rub.org}oidcVerificationParametersType" minOccurs="0"/>
 *         &lt;element name="oidcVerificiationChecks" type="{http://www.api.sso.nds.rub.org}oidcVerificationChecksType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oidcType", propOrder = {
    "oidcResponse",
    "oidcVerificationProfile",
    "oidcVerificationParameters",
    "oidcVerificiationChecks"
})
public class OidcType {

    protected String oidcResponse;
    protected String oidcVerificationProfile;
    protected OidcVerificationParametersType oidcVerificationParameters;
    protected OidcVerificationChecksType oidcVerificiationChecks;

    /**
     * Ruft den Wert der oidcResponse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOidcResponse() {
        return oidcResponse;
    }

    /**
     * Legt den Wert der oidcResponse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOidcResponse(String value) {
        this.oidcResponse = value;
    }

    /**
     * Ruft den Wert der oidcVerificationProfile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOidcVerificationProfile() {
        return oidcVerificationProfile;
    }

    /**
     * Legt den Wert der oidcVerificationProfile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOidcVerificationProfile(String value) {
        this.oidcVerificationProfile = value;
    }

    /**
     * Ruft den Wert der oidcVerificationParameters-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OidcVerificationParametersType }
     *     
     */
    public OidcVerificationParametersType getOidcVerificationParameters() {
        return oidcVerificationParameters;
    }

    /**
     * Legt den Wert der oidcVerificationParameters-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OidcVerificationParametersType }
     *     
     */
    public void setOidcVerificationParameters(OidcVerificationParametersType value) {
        this.oidcVerificationParameters = value;
    }

    /**
     * Ruft den Wert der oidcVerificiationChecks-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OidcVerificationChecksType }
     *     
     */
    public OidcVerificationChecksType getOidcVerificiationChecks() {
        return oidcVerificiationChecks;
    }

    /**
     * Legt den Wert der oidcVerificiationChecks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OidcVerificationChecksType }
     *     
     */
    public void setOidcVerificiationChecks(OidcVerificationChecksType value) {
        this.oidcVerificiationChecks = value;
    }

}
