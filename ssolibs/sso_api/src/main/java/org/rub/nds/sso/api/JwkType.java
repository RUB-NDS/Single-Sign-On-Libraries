//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.22 um 01:58:53 PM CET 
//

package org.rub.nds.sso.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für jwkType complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="jwkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwkType", propOrder = { "kty", "sig", "crv", "x", "y", "alg", "k" })
public class JwkType {

    protected String kty;
    protected String sig;
    protected String crv;
    protected String x;
    protected String y;
    protected String alg;
    protected String k;

    /**
     * Ruft den Wert der kty-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getKty() {
        return kty;
    }

    /**
     * Legt den Wert der kty-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setKty(String value) {
        this.kty = value;
    }

    /**
     * Ruft den Wert der sig-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSig() {
        return sig;
    }

    /**
     * Legt den Wert der sig-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setSig(String value) {
        this.sig = value;
    }

    /**
     * Ruft den Wert der crv-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCrv() {
        return crv;
    }

    /**
     * Legt den Wert der crv-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCrv(String value) {
        this.crv = value;
    }

    /**
     * Ruft den Wert der x-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getX() {
        return x;
    }

    /**
     * Legt den Wert der x-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setX(String value) {
        this.x = value;
    }

    /**
     * Ruft den Wert der y-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getY() {
        return y;
    }

    /**
     * Legt den Wert der y-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setY(String value) {
        this.y = value;
    }

    /**
     * Ruft den Wert der alg-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAlg() {
        return alg;
    }

    /**
     * Legt den Wert der alg-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setAlg(String value) {
        this.alg = value;
    }

    /**
     * Ruft den Wert der k-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getK() {
        return k;
    }

    /**
     * Legt den Wert der k-Eigenschaft fest.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setK(String value) {
        this.k = value;
    }

}
