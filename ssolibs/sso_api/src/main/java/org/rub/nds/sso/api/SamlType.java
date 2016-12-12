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
 * Java-Klasse für samlType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
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
@XmlType(name = "samlType", propOrder = { "samlRequest", "samlResponse", "samlVerificationParameters",
        "samlVerificationProfile", "samlTokenVerificationChecks", "samlAuthnReqVerificationChecks" })
public class SamlType extends SsoType {

    protected String samlRequest;
    protected String samlResponse;
    protected SamlVerificationParametersType samlVerificationParameters;
    protected String samlVerificationProfile;
    protected SamlTokenVerificationChecksType samlTokenVerificationChecks;
    protected SamlAuthnRequestVerificationChecksType samlAuthnReqVerificationChecks;

    /**
     * Ruft den Wert der samlRequest-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSamlRequest() {
        return samlRequest;
    }

    /**
     * Legt den Wert der samlRequest-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSamlRequest(String value) {
        this.samlRequest = value;
    }

    /**
     * Ruft den Wert der samlResponse-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSamlResponse() {
        return samlResponse;
    }

    /**
     * Legt den Wert der samlResponse-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSamlResponse(String value) {
        this.samlResponse = value;
    }

    /**
     * Ruft den Wert der samlVerificationParameters-Eigenschaft ab.
     * 
     * @return possible object is {@link SamlVerificationParametersType }
     * 
     */
    public SamlVerificationParametersType getSamlVerificationParameters() {
        return samlVerificationParameters;
    }

    /**
     * Legt den Wert der samlVerificationParameters-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link SamlVerificationParametersType }
     * 
     */
    public void setSamlVerificationParameters(SamlVerificationParametersType value) {
        this.samlVerificationParameters = value;
    }

    /**
     * Ruft den Wert der samlVerificationProfile-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSamlVerificationProfile() {
        return samlVerificationProfile;
    }

    /**
     * Legt den Wert der samlVerificationProfile-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSamlVerificationProfile(String value) {
        this.samlVerificationProfile = value;
    }

    /**
     * Ruft den Wert der samlTokenVerificationChecks-Eigenschaft ab.
     * 
     * @return possible object is {@link SamlTokenVerificationChecksType }
     * 
     */
    public SamlTokenVerificationChecksType getSamlTokenVerificationChecks() {
        return samlTokenVerificationChecks;
    }

    /**
     * Legt den Wert der samlTokenVerificationChecks-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link SamlTokenVerificationChecksType }
     * 
     */
    public void setSamlTokenVerificationChecks(SamlTokenVerificationChecksType value) {
        this.samlTokenVerificationChecks = value;
    }

    /**
     * Ruft den Wert der samlAuthnReqVerificationChecks-Eigenschaft ab.
     * 
     * @return possible object is {@link SamlAuthnRequestVerificationChecksType }
     * 
     */
    public SamlAuthnRequestVerificationChecksType getSamlAuthnReqVerificationChecks() {
        return samlAuthnReqVerificationChecks;
    }

    /**
     * Legt den Wert der samlAuthnReqVerificationChecks-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is
     *            {@link SamlAuthnRequestVerificationChecksType }
     * 
     */
    public void setSamlAuthnReqVerificationChecks(SamlAuthnRequestVerificationChecksType value) {
        this.samlAuthnReqVerificationChecks = value;
    }

}
