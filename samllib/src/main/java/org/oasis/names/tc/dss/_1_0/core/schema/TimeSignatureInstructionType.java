//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.17 at 04:57:05 PM CEST 
//


package oasis.names.tc.dss._1_0.core.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeSignatureInstructionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeSignatureInstructionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:dss:1.0:core:schema}UpdateSignatureInstructionType">
 *       &lt;attribute name="TimeStampTheGivenSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeSignatureInstructionType")
public class TimeSignatureInstructionType
    extends UpdateSignatureInstructionType
{

    @XmlAttribute(name = "TimeStampTheGivenSignature")
    protected Boolean timeStampTheGivenSignature;

    /**
     * Gets the value of the timeStampTheGivenSignature property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTimeStampTheGivenSignature() {
        if (timeStampTheGivenSignature == null) {
            return false;
        } else {
            return timeStampTheGivenSignature;
        }
    }

    /**
     * Sets the value of the timeStampTheGivenSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimeStampTheGivenSignature(Boolean value) {
        this.timeStampTheGivenSignature = value;
    }

}
