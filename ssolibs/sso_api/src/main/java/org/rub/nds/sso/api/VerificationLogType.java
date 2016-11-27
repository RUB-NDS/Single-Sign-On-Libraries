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
 * Java-Klasse für verificationLogType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="verificationLogType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="logLevel" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="debug"/>
 *               &lt;enumeration value="info"/>
 *               &lt;enumeration value="warn"/>
 *               &lt;enumeration value="error"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verificationLog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificationLogType", propOrder = { "logLevel", "exception", "verificationLog" })
public class VerificationLogType {

    protected String logLevel;
    @XmlElement(name = "Exception")
    protected String exception;
    protected String verificationLog;

    /**
     * Ruft den Wert der logLevel-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * Legt den Wert der logLevel-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setLogLevel(String value) {
        this.logLevel = value;
    }

    /**
     * Ruft den Wert der exception-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getException() {
        return exception;
    }

    /**
     * Legt den Wert der exception-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setException(String value) {
        this.exception = value;
    }

    /**
     * Ruft den Wert der verificationLog-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getVerificationLog() {
        return verificationLog;
    }

    /**
     * Legt den Wert der verificationLog-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setVerificationLog(String value) {
        this.verificationLog = value;
    }

}
