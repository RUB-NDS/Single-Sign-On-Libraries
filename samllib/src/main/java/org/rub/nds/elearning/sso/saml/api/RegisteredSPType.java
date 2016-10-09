//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.17 at 11:12:08 PM CEST 
//


package org.rub.nds.elearning.sso.saml.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registeredSPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registeredSPType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="issuer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="acsURL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="certificateX509" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="metadataFilePath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="preferredTokenPprofile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registeredSPType", propOrder = {
    "issuer",
    "acsURL",
    "certificateX509",
    "metadataFilePath",
    "preferredTokenPprofile"
})
public class RegisteredSPType {

    @XmlElement(required = true)
    protected String issuer;
    @XmlElement(required = true)
    protected List<String> acsURL;
    protected List<String> certificateX509;
    protected List<String> metadataFilePath;
    protected String preferredTokenPprofile;

    /**
     * Gets the value of the issuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the acsURL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acsURL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcsURL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAcsURL() {
        if (acsURL == null) {
            acsURL = new ArrayList<String>();
        }
        return this.acsURL;
    }

    /**
     * Gets the value of the certificateX509 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificateX509 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificateX509().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCertificateX509() {
        if (certificateX509 == null) {
            certificateX509 = new ArrayList<String>();
        }
        return this.certificateX509;
    }

    /**
     * Gets the value of the metadataFilePath property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadataFilePath property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadataFilePath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMetadataFilePath() {
        if (metadataFilePath == null) {
            metadataFilePath = new ArrayList<String>();
        }
        return this.metadataFilePath;
    }

    /**
     * Gets the value of the preferredTokenPprofile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredTokenPprofile() {
        return preferredTokenPprofile;
    }

    /**
     * Sets the value of the preferredTokenPprofile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredTokenPprofile(String value) {
        this.preferredTokenPprofile = value;
    }

}
