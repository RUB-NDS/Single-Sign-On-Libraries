//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.11.04 um 11:43:03 PM CET 
//

package org.rub.nds.sso.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java-Klasse für samlVerificationParametersType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="samlVerificationParametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x509certificate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="samlSchema" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="samlSchema_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="audience" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time_limitation" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="hok_x509certificate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saml_metadata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saml_metadata_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samlVerificationParametersType", propOrder = { "x509Certificate", "samlSchema", "samlSchemaUrl",
        "audience", "destination", "timeLimitation", "hokX509Certificate", "samlMetadata", "samlMetadataUrl" })
public class SamlVerificationParametersType {

    @XmlElement(name = "x509certificate")
    protected List<String> x509Certificate;
    protected List<String> samlSchema;
    @XmlElement(name = "samlSchema_url")
    protected String samlSchemaUrl;
    protected List<String> audience;
    protected String destination;
    @XmlElement(name = "time_limitation")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeLimitation;
    @XmlElement(name = "hok_x509certificate")
    protected String hokX509Certificate;
    @XmlElement(name = "saml_metadata")
    protected String samlMetadata;
    @XmlElement(name = "saml_metadata_url")
    protected String samlMetadataUrl;

    /**
     * Gets the value of the x509Certificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the x509Certificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getX509Certificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getX509Certificate() {
        if (x509Certificate == null) {
            x509Certificate = new ArrayList<String>();
        }
        return this.x509Certificate;
    }

    /**
     * Gets the value of the samlSchema property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the samlSchema property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getSamlSchema().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getSamlSchema() {
        if (samlSchema == null) {
            samlSchema = new ArrayList<String>();
        }
        return this.samlSchema;
    }

    /**
     * Ruft den Wert der samlSchemaUrl-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSamlSchemaUrl() {
        return samlSchemaUrl;
    }

    /**
     * Legt den Wert der samlSchemaUrl-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSamlSchemaUrl(String value) {
        this.samlSchemaUrl = value;
    }

    /**
     * Gets the value of the audience property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the audience property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAudience().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getAudience() {
        if (audience == null) {
            audience = new ArrayList<String>();
        }
        return this.audience;
    }

    /**
     * Ruft den Wert der destination-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Legt den Wert der destination-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Ruft den Wert der timeLimitation-Eigenschaft ab.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getTimeLimitation() {
        return timeLimitation;
    }

    /**
     * Legt den Wert der timeLimitation-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setTimeLimitation(XMLGregorianCalendar value) {
        this.timeLimitation = value;
    }

    /**
     * Ruft den Wert der hokX509Certificate-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getHokX509Certificate() {
        return hokX509Certificate;
    }

    /**
     * Legt den Wert der hokX509Certificate-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setHokX509Certificate(String value) {
        this.hokX509Certificate = value;
    }

    /**
     * Ruft den Wert der samlMetadata-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSamlMetadata() {
        return samlMetadata;
    }

    /**
     * Legt den Wert der samlMetadata-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSamlMetadata(String value) {
        this.samlMetadata = value;
    }

    /**
     * Ruft den Wert der samlMetadataUrl-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSamlMetadataUrl() {
        return samlMetadataUrl;
    }

    /**
     * Legt den Wert der samlMetadataUrl-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSamlMetadataUrl(String value) {
        this.samlMetadataUrl = value;
    }

}
