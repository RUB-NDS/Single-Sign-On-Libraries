//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.22 um 01:58:53 PM CET 
//

package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für assertionAuthnStatementDecoratorType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="assertionAuthnStatementDecoratorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timestamps" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sbjLocalityAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sbjLocalityDNS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authnContextDeclStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authnContextClassRefStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authnContextDeclRefStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assertionAuthnStatementDecoratorType", propOrder = { "timestamps", "sbjLocalityAddress",
        "sbjLocalityDNS", "authnContextDeclStr", "authnContextClassRefStr", "authnContextDeclRefStr" })
public class AssertionAuthnStatementDecoratorType {

    protected Integer timestamps;
    protected String sbjLocalityAddress;
    protected String sbjLocalityDNS;
    protected String authnContextDeclStr;
    protected String authnContextClassRefStr;
    protected String authnContextDeclRefStr;

    /**
     * Ruft den Wert der timestamps-Eigenschaft ab.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getTimestamps() {
        return timestamps;
    }

    /**
     * Legt den Wert der timestamps-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setTimestamps(Integer value) {
        this.timestamps = value;
    }

    /**
     * Ruft den Wert der sbjLocalityAddress-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSbjLocalityAddress() {
        return sbjLocalityAddress;
    }

    /**
     * Legt den Wert der sbjLocalityAddress-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSbjLocalityAddress(String value) {
        this.sbjLocalityAddress = value;
    }

    /**
     * Ruft den Wert der sbjLocalityDNS-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSbjLocalityDNS() {
        return sbjLocalityDNS;
    }

    /**
     * Legt den Wert der sbjLocalityDNS-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSbjLocalityDNS(String value) {
        this.sbjLocalityDNS = value;
    }

    /**
     * Ruft den Wert der authnContextDeclStr-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAuthnContextDeclStr() {
        return authnContextDeclStr;
    }

    /**
     * Legt den Wert der authnContextDeclStr-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setAuthnContextDeclStr(String value) {
        this.authnContextDeclStr = value;
    }

    /**
     * Ruft den Wert der authnContextClassRefStr-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAuthnContextClassRefStr() {
        return authnContextClassRefStr;
    }

    /**
     * Legt den Wert der authnContextClassRefStr-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setAuthnContextClassRefStr(String value) {
        this.authnContextClassRefStr = value;
    }

    /**
     * Ruft den Wert der authnContextDeclRefStr-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAuthnContextDeclRefStr() {
        return authnContextDeclRefStr;
    }

    /**
     * Legt den Wert der authnContextDeclRefStr-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setAuthnContextDeclRefStr(String value) {
        this.authnContextDeclRefStr = value;
    }

}
