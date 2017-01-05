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
 * <p>Java-Klasse für authenticatedUserType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="authenticatedUserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userAdditionalInformation" type="{http://www.api.sso.nds.rub.org}userAdditionalInformationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authenticatedUserType", propOrder = {
    "userID",
    "userAdditionalInformation"
})
public class AuthenticatedUserType {

    @XmlElement(required = true)
    protected String userID;
    protected UserAdditionalInformationType userAdditionalInformation;

    /**
     * Ruft den Wert der userID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Legt den Wert der userID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Ruft den Wert der userAdditionalInformation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UserAdditionalInformationType }
     *     
     */
    public UserAdditionalInformationType getUserAdditionalInformation() {
        return userAdditionalInformation;
    }

    /**
     * Legt den Wert der userAdditionalInformation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAdditionalInformationType }
     *     
     */
    public void setUserAdditionalInformation(UserAdditionalInformationType value) {
        this.userAdditionalInformation = value;
    }

}
