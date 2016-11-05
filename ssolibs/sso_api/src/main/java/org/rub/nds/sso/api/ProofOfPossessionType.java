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
 * <p>Java-Klasse für proofOfPossessionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="proofOfPossessionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jwk" type="{http://www.api.sso.nds.rub.org}jwkType" minOccurs="0"/>
 *         &lt;element name="jwe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jku" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proofOfPossessionType", propOrder = {
    "kid",
    "jwk",
    "jwe",
    "jku"
})
public class ProofOfPossessionType {

    protected String kid;
    protected JwkType jwk;
    protected String jwe;
    protected String jku;

    /**
     * Ruft den Wert der kid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKid() {
        return kid;
    }

    /**
     * Legt den Wert der kid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKid(String value) {
        this.kid = value;
    }

    /**
     * Ruft den Wert der jwk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JwkType }
     *     
     */
    public JwkType getJwk() {
        return jwk;
    }

    /**
     * Legt den Wert der jwk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JwkType }
     *     
     */
    public void setJwk(JwkType value) {
        this.jwk = value;
    }

    /**
     * Ruft den Wert der jwe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJwe() {
        return jwe;
    }

    /**
     * Legt den Wert der jwe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJwe(String value) {
        this.jwe = value;
    }

    /**
     * Ruft den Wert der jku-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJku() {
        return jku;
    }

    /**
     * Legt den Wert der jku-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJku(String value) {
        this.jku = value;
    }

}
