//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.11.04 um 11:43:03 PM CET 
//

package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für verificationProfileType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="verificationProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="samlTokenVerificationChecks" type="{http://www.api.sso.nds.rub.org}samlTokenVerificationChecksType" minOccurs="0"/>
 *         &lt;element name="samlAuthnReqVerificationChecks" type="{http://www.api.sso.nds.rub.org}samlAuthnRequestVerificationChecksType" minOccurs="0"/>
 *         &lt;element name="samlTokenVerificationParameters" type="{http://www.api.sso.nds.rub.org}samlVerificationParametersType" minOccurs="0"/>
 *         &lt;element name="oidcVerificationChecks" type="{http://www.api.sso.nds.rub.org}oidcVerificationChecksType" minOccurs="0"/>
 *         &lt;element name="oidcVerificationParameters" type="{http://www.api.sso.nds.rub.org}oidcVerificationParametersType" minOccurs="0"/>
 *         &lt;element name="log" type="{http://www.api.sso.nds.rub.org}verificationLogType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificationProfileType", propOrder = { "id", "samlTokenVerificationChecks",
        "samlAuthnReqVerificationChecks", "samlTokenVerificationParameters", "oidcVerificationChecks",
        "oidcVerificationParameters", "log" })
public class VerificationProfileType {

    @XmlElement(name = "ID", required = true)
    protected String id;
    protected SamlTokenVerificationChecksType samlTokenVerificationChecks;
    protected SamlAuthnRequestVerificationChecksType samlAuthnReqVerificationChecks;
    protected SamlVerificationParametersType samlTokenVerificationParameters;
    protected OidcVerificationChecksType oidcVerificationChecks;
    protected OidcVerificationParametersType oidcVerificationParameters;
    protected VerificationLogType log;

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

    /**
     * Ruft den Wert der samlTokenVerificationParameters-Eigenschaft ab.
     * 
     * @return possible object is {@link SamlVerificationParametersType }
     * 
     */
    public SamlVerificationParametersType getSamlTokenVerificationParameters() {
        return samlTokenVerificationParameters;
    }

    /**
     * Legt den Wert der samlTokenVerificationParameters-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link SamlVerificationParametersType }
     * 
     */
    public void setSamlTokenVerificationParameters(SamlVerificationParametersType value) {
        this.samlTokenVerificationParameters = value;
    }

    /**
     * Ruft den Wert der oidcVerificationChecks-Eigenschaft ab.
     * 
     * @return possible object is {@link OidcVerificationChecksType }
     * 
     */
    public OidcVerificationChecksType getOidcVerificationChecks() {
        return oidcVerificationChecks;
    }

    /**
     * Legt den Wert der oidcVerificationChecks-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link OidcVerificationChecksType }
     * 
     */
    public void setOidcVerificationChecks(OidcVerificationChecksType value) {
        this.oidcVerificationChecks = value;
    }

    /**
     * Ruft den Wert der oidcVerificationParameters-Eigenschaft ab.
     * 
     * @return possible object is {@link OidcVerificationParametersType }
     * 
     */
    public OidcVerificationParametersType getOidcVerificationParameters() {
        return oidcVerificationParameters;
    }

    /**
     * Legt den Wert der oidcVerificationParameters-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link OidcVerificationParametersType }
     * 
     */
    public void setOidcVerificationParameters(OidcVerificationParametersType value) {
        this.oidcVerificationParameters = value;
    }

    /**
     * Ruft den Wert der log-Eigenschaft ab.
     * 
     * @return possible object is {@link VerificationLogType }
     * 
     */
    public VerificationLogType getLog() {
        return log;
    }

    /**
     * Legt den Wert der log-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link VerificationLogType }
     * 
     */
    public void setLog(VerificationLogType value) {
        this.log = value;
    }

}
