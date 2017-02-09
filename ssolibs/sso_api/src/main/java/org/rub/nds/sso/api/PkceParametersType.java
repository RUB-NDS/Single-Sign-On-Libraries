//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.09 at 01:11:59 PM EET 
//

package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for pkceParametersType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="pkceParametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code_challenge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code_verifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code_challenge_method">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="S256"/>
 *               &lt;enumeration value="plain"/>
 *               &lt;enumeration value="S512"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pkceParametersType", propOrder = { "codeChallenge", "codeVerifier", "codeChallengeMethod" })
public class PkceParametersType {

    @XmlElement(name = "code_challenge", required = true)
    protected String codeChallenge;
    @XmlElement(name = "code_verifier", required = true)
    protected String codeVerifier;
    @XmlElement(name = "code_challenge_method", required = true)
    protected String codeChallengeMethod;

    /**
     * Gets the value of the codeChallenge property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCodeChallenge() {
        return codeChallenge;
    }

    /**
     * Sets the value of the codeChallenge property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCodeChallenge(String value) {
        this.codeChallenge = value;
    }

    /**
     * Gets the value of the codeVerifier property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCodeVerifier() {
        return codeVerifier;
    }

    /**
     * Sets the value of the codeVerifier property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCodeVerifier(String value) {
        this.codeVerifier = value;
    }

    /**
     * Gets the value of the codeChallengeMethod property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }

    /**
     * Sets the value of the codeChallengeMethod property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCodeChallengeMethod(String value) {
        this.codeChallengeMethod = value;
    }

}
