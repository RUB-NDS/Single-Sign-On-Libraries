//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.01.06 um 12:38:40 PM CET 
//

package oasis.names.tc.saml._1_0.assertion;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;

/**
 * <p>
 * Java-Klasse für AdviceType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AdviceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{urn:oasis:names:tc:SAML:1.0:assertion}AssertionIDReference"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:1.0:assertion}Assertion"/>
 *         &lt;any processContents='lax' namespace='##other'/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceType", propOrder = { "assertionIDReferenceOrAssertionOrAny" })
public class AdviceType {

    @XmlElementRefs({
            @XmlElementRef(name = "AssertionIDReference", namespace = "urn:oasis:names:tc:SAML:1.0:assertion", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "Assertion", namespace = "urn:oasis:names:tc:SAML:1.0:assertion", type = JAXBElement.class, required = false) })
    @XmlAnyElement(lax = true)
    protected List<Object> assertionIDReferenceOrAssertionOrAny;

    /**
     * Gets the value of the assertionIDReferenceOrAssertionOrAny property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the assertionIDReferenceOrAssertionOrAny
     * property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAssertionIDReferenceOrAssertionOrAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >} {@link JAXBElement }
     * {@code <}{@link AssertionType }{@code >} {@link Element } {@link Object }
     * 
     * 
     */
    public List<Object> getAssertionIDReferenceOrAssertionOrAny() {
        if (assertionIDReferenceOrAssertionOrAny == null) {
            assertionIDReferenceOrAssertionOrAny = new ArrayList<Object>();
        }
        return this.assertionIDReferenceOrAssertionOrAny;
    }

}
