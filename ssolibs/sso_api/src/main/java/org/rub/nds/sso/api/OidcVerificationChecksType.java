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
 * <p>Java-Klasse für oidcVerificationChecksType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="oidcVerificationChecksType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verifyIssuer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="verifyAudience" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="verifiyNonce" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="verifyIssuedAt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="verifyExpired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vierfyNotBefore" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="verifySubClaims" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oidcVerificationChecksType", propOrder = {
    "verifyIssuer",
    "verifyAudience",
    "verifiyNonce",
    "verifyIssuedAt",
    "verifyExpired",
    "vierfyNotBefore",
    "verifySubClaims"
})
public class OidcVerificationChecksType {

    protected boolean verifyIssuer;
    protected boolean verifyAudience;
    protected boolean verifiyNonce;
    protected boolean verifyIssuedAt;
    protected boolean verifyExpired;
    protected boolean vierfyNotBefore;
    protected boolean verifySubClaims;

    /**
     * Ruft den Wert der verifyIssuer-Eigenschaft ab.
     * 
     */
    public boolean isVerifyIssuer() {
        return verifyIssuer;
    }

    /**
     * Legt den Wert der verifyIssuer-Eigenschaft fest.
     * 
     */
    public void setVerifyIssuer(boolean value) {
        this.verifyIssuer = value;
    }

    /**
     * Ruft den Wert der verifyAudience-Eigenschaft ab.
     * 
     */
    public boolean isVerifyAudience() {
        return verifyAudience;
    }

    /**
     * Legt den Wert der verifyAudience-Eigenschaft fest.
     * 
     */
    public void setVerifyAudience(boolean value) {
        this.verifyAudience = value;
    }

    /**
     * Ruft den Wert der verifiyNonce-Eigenschaft ab.
     * 
     */
    public boolean isVerifiyNonce() {
        return verifiyNonce;
    }

    /**
     * Legt den Wert der verifiyNonce-Eigenschaft fest.
     * 
     */
    public void setVerifiyNonce(boolean value) {
        this.verifiyNonce = value;
    }

    /**
     * Ruft den Wert der verifyIssuedAt-Eigenschaft ab.
     * 
     */
    public boolean isVerifyIssuedAt() {
        return verifyIssuedAt;
    }

    /**
     * Legt den Wert der verifyIssuedAt-Eigenschaft fest.
     * 
     */
    public void setVerifyIssuedAt(boolean value) {
        this.verifyIssuedAt = value;
    }

    /**
     * Ruft den Wert der verifyExpired-Eigenschaft ab.
     * 
     */
    public boolean isVerifyExpired() {
        return verifyExpired;
    }

    /**
     * Legt den Wert der verifyExpired-Eigenschaft fest.
     * 
     */
    public void setVerifyExpired(boolean value) {
        this.verifyExpired = value;
    }

    /**
     * Ruft den Wert der vierfyNotBefore-Eigenschaft ab.
     * 
     */
    public boolean isVierfyNotBefore() {
        return vierfyNotBefore;
    }

    /**
     * Legt den Wert der vierfyNotBefore-Eigenschaft fest.
     * 
     */
    public void setVierfyNotBefore(boolean value) {
        this.vierfyNotBefore = value;
    }

    /**
     * Ruft den Wert der verifySubClaims-Eigenschaft ab.
     * 
     */
    public boolean isVerifySubClaims() {
        return verifySubClaims;
    }

    /**
     * Legt den Wert der verifySubClaims-Eigenschaft fest.
     * 
     */
    public void setVerifySubClaims(boolean value) {
        this.verifySubClaims = value;
    }

}
