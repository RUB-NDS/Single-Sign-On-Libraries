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
 * <p>Java-Klasse für assertionSubjectDecoratorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="assertionSubjectDecoratorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nameIDValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameIDformat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameIDnameQualifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameIDsPNameQualifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameIDsPProvidedID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sbjConfirmMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sbjConfirmationDataAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sbjConfirmationDataRecipient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestampDuration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assertionSubjectDecoratorType", propOrder = {
    "nameIDValue",
    "nameIDformat",
    "nameIDnameQualifier",
    "nameIDsPNameQualifier",
    "nameIDsPProvidedID",
    "sbjConfirmMethod",
    "sbjConfirmationDataAddress",
    "sbjConfirmationDataRecipient",
    "timestampDuration"
})
public class AssertionSubjectDecoratorType {

    protected String nameIDValue;
    protected String nameIDformat;
    protected String nameIDnameQualifier;
    protected String nameIDsPNameQualifier;
    protected String nameIDsPProvidedID;
    protected String sbjConfirmMethod;
    protected String sbjConfirmationDataAddress;
    protected String sbjConfirmationDataRecipient;
    protected Integer timestampDuration;

    /**
     * Ruft den Wert der nameIDValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameIDValue() {
        return nameIDValue;
    }

    /**
     * Legt den Wert der nameIDValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameIDValue(String value) {
        this.nameIDValue = value;
    }

    /**
     * Ruft den Wert der nameIDformat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameIDformat() {
        return nameIDformat;
    }

    /**
     * Legt den Wert der nameIDformat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameIDformat(String value) {
        this.nameIDformat = value;
    }

    /**
     * Ruft den Wert der nameIDnameQualifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameIDnameQualifier() {
        return nameIDnameQualifier;
    }

    /**
     * Legt den Wert der nameIDnameQualifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameIDnameQualifier(String value) {
        this.nameIDnameQualifier = value;
    }

    /**
     * Ruft den Wert der nameIDsPNameQualifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameIDsPNameQualifier() {
        return nameIDsPNameQualifier;
    }

    /**
     * Legt den Wert der nameIDsPNameQualifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameIDsPNameQualifier(String value) {
        this.nameIDsPNameQualifier = value;
    }

    /**
     * Ruft den Wert der nameIDsPProvidedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameIDsPProvidedID() {
        return nameIDsPProvidedID;
    }

    /**
     * Legt den Wert der nameIDsPProvidedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameIDsPProvidedID(String value) {
        this.nameIDsPProvidedID = value;
    }

    /**
     * Ruft den Wert der sbjConfirmMethod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbjConfirmMethod() {
        return sbjConfirmMethod;
    }

    /**
     * Legt den Wert der sbjConfirmMethod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbjConfirmMethod(String value) {
        this.sbjConfirmMethod = value;
    }

    /**
     * Ruft den Wert der sbjConfirmationDataAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbjConfirmationDataAddress() {
        return sbjConfirmationDataAddress;
    }

    /**
     * Legt den Wert der sbjConfirmationDataAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbjConfirmationDataAddress(String value) {
        this.sbjConfirmationDataAddress = value;
    }

    /**
     * Ruft den Wert der sbjConfirmationDataRecipient-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbjConfirmationDataRecipient() {
        return sbjConfirmationDataRecipient;
    }

    /**
     * Legt den Wert der sbjConfirmationDataRecipient-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbjConfirmationDataRecipient(String value) {
        this.sbjConfirmationDataRecipient = value;
    }

    /**
     * Ruft den Wert der timestampDuration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimestampDuration() {
        return timestampDuration;
    }

    /**
     * Legt den Wert der timestampDuration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimestampDuration(Integer value) {
        this.timestampDuration = value;
    }

}
