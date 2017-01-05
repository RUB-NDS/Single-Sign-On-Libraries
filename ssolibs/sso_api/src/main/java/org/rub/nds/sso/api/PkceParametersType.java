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
 * <p>
 * Java-Klasse für pkceParametersType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
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
     * Ruft den Wert der codeChallenge-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCodeChallenge() {
        return codeChallenge;
    }

    /**
     * Legt den Wert der codeChallenge-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCodeChallenge(String value) {
        this.codeChallenge = value;
    }

    /**
     * Ruft den Wert der codeVerifier-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCodeVerifier() {
        return codeVerifier;
    }

    /**
     * Legt den Wert der codeVerifier-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCodeVerifier(String value) {
        this.codeVerifier = value;
    }

    /**
     * Ruft den Wert der codeChallengeMethod-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }

    /**
     * Legt den Wert der codeChallengeMethod-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCodeChallengeMethod(String value) {
        this.codeChallengeMethod = value;
    }

}
