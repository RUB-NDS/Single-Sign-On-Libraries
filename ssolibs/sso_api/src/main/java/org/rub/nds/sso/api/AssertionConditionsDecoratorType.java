//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.22 um 01:58:53 PM CET 
//

package org.rub.nds.sso.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für assertionConditionsDecoratorType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="assertionConditionsDecoratorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setNotBefore" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="setNotAfter" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="timestampDuration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="audienceRestriction" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assertionConditionsDecoratorType", propOrder = { "setNotBefore", "setNotAfter", "timestampDuration",
        "audienceRestriction" })
public class AssertionConditionsDecoratorType {

    protected Boolean setNotBefore;
    protected Boolean setNotAfter;
    protected Integer timestampDuration;
    protected List<String> audienceRestriction;

    /**
     * Ruft den Wert der setNotBefore-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isSetNotBefore() {
        return setNotBefore;
    }

    /**
     * Legt den Wert der setNotBefore-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setSetNotBefore(Boolean value) {
        this.setNotBefore = value;
    }

    /**
     * Ruft den Wert der setNotAfter-Eigenschaft ab.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isSetNotAfter() {
        return setNotAfter;
    }

    /**
     * Legt den Wert der setNotAfter-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setSetNotAfter(Boolean value) {
        this.setNotAfter = value;
    }

    /**
     * Ruft den Wert der timestampDuration-Eigenschaft ab.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getTimestampDuration() {
        return timestampDuration;
    }

    /**
     * Legt den Wert der timestampDuration-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setTimestampDuration(Integer value) {
        this.timestampDuration = value;
    }

    /**
     * Gets the value of the audienceRestriction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the audienceRestriction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAudienceRestriction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getAudienceRestriction() {
        if (audienceRestriction == null) {
            audienceRestriction = new ArrayList<String>();
        }
        return this.audienceRestriction;
    }

}
