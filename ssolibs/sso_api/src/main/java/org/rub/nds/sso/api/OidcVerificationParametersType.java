//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.11.04 um 11:43:03 PM CET 
//


package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für oidcVerificationParametersType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="oidcVerificationParametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x509certificate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="audience" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oidc_metadata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oidc_metadata_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time_limitation" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="pkceParameters" type="{http://www.api.sso.nds.rub.org}pkceParametersType" minOccurs="0"/>
 *         &lt;element name="client_secret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnf" type="{http://www.api.sso.nds.rub.org}proofOfPossessionType" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accessToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subClaims" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oidcVerificationParametersType", propOrder = {
    "x509Certificate",
    "audience",
    "oidcMetadata",
    "oidcMetadataUrl",
    "timeLimitation",
    "pkceParameters",
    "clientSecret",
    "cnf",
    "code",
    "accessToken",
    "subClaims"
})
public class OidcVerificationParametersType {

    @XmlElement(name = "x509certificate")
    protected String x509Certificate;
    protected String audience;
    @XmlElement(name = "oidc_metadata")
    protected String oidcMetadata;
    @XmlElement(name = "oidc_metadata_url")
    protected String oidcMetadataUrl;
    @XmlElement(name = "time_limitation")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeLimitation;
    protected PkceParametersType pkceParameters;
    @XmlElement(name = "client_secret")
    protected String clientSecret;
    protected ProofOfPossessionType cnf;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String accessToken;
    @XmlElement(required = true)
    protected String subClaims;

    /**
     * Ruft den Wert der x509Certificate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX509Certificate() {
        return x509Certificate;
    }

    /**
     * Legt den Wert der x509Certificate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX509Certificate(String value) {
        this.x509Certificate = value;
    }

    /**
     * Ruft den Wert der audience-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudience() {
        return audience;
    }

    /**
     * Legt den Wert der audience-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudience(String value) {
        this.audience = value;
    }

    /**
     * Ruft den Wert der oidcMetadata-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOidcMetadata() {
        return oidcMetadata;
    }

    /**
     * Legt den Wert der oidcMetadata-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOidcMetadata(String value) {
        this.oidcMetadata = value;
    }

    /**
     * Ruft den Wert der oidcMetadataUrl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOidcMetadataUrl() {
        return oidcMetadataUrl;
    }

    /**
     * Legt den Wert der oidcMetadataUrl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOidcMetadataUrl(String value) {
        this.oidcMetadataUrl = value;
    }

    /**
     * Ruft den Wert der timeLimitation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeLimitation() {
        return timeLimitation;
    }

    /**
     * Legt den Wert der timeLimitation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeLimitation(XMLGregorianCalendar value) {
        this.timeLimitation = value;
    }

    /**
     * Ruft den Wert der pkceParameters-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PkceParametersType }
     *     
     */
    public PkceParametersType getPkceParameters() {
        return pkceParameters;
    }

    /**
     * Legt den Wert der pkceParameters-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PkceParametersType }
     *     
     */
    public void setPkceParameters(PkceParametersType value) {
        this.pkceParameters = value;
    }

    /**
     * Ruft den Wert der clientSecret-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Legt den Wert der clientSecret-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSecret(String value) {
        this.clientSecret = value;
    }

    /**
     * Ruft den Wert der cnf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProofOfPossessionType }
     *     
     */
    public ProofOfPossessionType getCnf() {
        return cnf;
    }

    /**
     * Legt den Wert der cnf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProofOfPossessionType }
     *     
     */
    public void setCnf(ProofOfPossessionType value) {
        this.cnf = value;
    }

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Ruft den Wert der accessToken-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Legt den Wert der accessToken-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessToken(String value) {
        this.accessToken = value;
    }

    /**
     * Ruft den Wert der subClaims-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubClaims() {
        return subClaims;
    }

    /**
     * Legt den Wert der subClaims-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubClaims(String value) {
        this.subClaims = value;
    }

}
