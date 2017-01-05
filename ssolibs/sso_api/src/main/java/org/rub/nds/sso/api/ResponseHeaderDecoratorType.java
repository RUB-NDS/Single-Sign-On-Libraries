//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.22 um 01:58:53 PM CET 
//


package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für responseHeaderDecoratorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="responseHeaderDecoratorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="issuerStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusCodeURI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addInResponseTo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="addDestination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseHeaderDecoratorType", propOrder = {
    "issuerStr",
    "statusCodeURI",
    "addInResponseTo",
    "addDestination"
})
public class ResponseHeaderDecoratorType {

    @XmlElement(required = true)
    protected String issuerStr;
    protected String statusCodeURI;
    protected Boolean addInResponseTo;
    protected Boolean addDestination;

    /**
     * Ruft den Wert der issuerStr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerStr() {
        return issuerStr;
    }

    /**
     * Legt den Wert der issuerStr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerStr(String value) {
        this.issuerStr = value;
    }

    /**
     * Ruft den Wert der statusCodeURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCodeURI() {
        return statusCodeURI;
    }

    /**
     * Legt den Wert der statusCodeURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCodeURI(String value) {
        this.statusCodeURI = value;
    }

    /**
     * Ruft den Wert der addInResponseTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddInResponseTo() {
        return addInResponseTo;
    }

    /**
     * Legt den Wert der addInResponseTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddInResponseTo(Boolean value) {
        this.addInResponseTo = value;
    }

    /**
     * Ruft den Wert der addDestination-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddDestination() {
        return addDestination;
    }

    /**
     * Legt den Wert der addDestination-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddDestination(Boolean value) {
        this.addDestination = value;
    }

}
