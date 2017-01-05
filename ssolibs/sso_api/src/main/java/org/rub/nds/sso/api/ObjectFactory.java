//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.12.22 um 01:58:53 PM CET 
//


package org.rub.nds.sso.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.rub.nds.sso.api package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SamlTokenProfiles_QNAME = new QName("http://www.api.sso.nds.rub.org", "samlTokenProfiles");
    private final static QName _Oidc_QNAME = new QName("http://www.api.sso.nds.rub.org", "oidc");
    private final static QName _SamlRequestProfiles_QNAME = new QName("http://www.api.sso.nds.rub.org", "samlRequestProfiles");
    private final static QName _Saml_QNAME = new QName("http://www.api.sso.nds.rub.org", "saml");
    private final static QName _AuthenticatedUser_QNAME = new QName("http://www.api.sso.nds.rub.org", "authenticatedUser");
    private final static QName _VerificationResponse_QNAME = new QName("http://www.api.sso.nds.rub.org", "verificationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.rub.nds.sso.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerificationResponseType }
     * 
     */
    public VerificationResponseType createVerificationResponseType() {
        return new VerificationResponseType();
    }

    /**
     * Create an instance of {@link SamlRequestProfilesType }
     * 
     */
    public SamlRequestProfilesType createSamlRequestProfilesType() {
        return new SamlRequestProfilesType();
    }

    /**
     * Create an instance of {@link SamlType }
     * 
     */
    public SamlType createSamlType() {
        return new SamlType();
    }

    /**
     * Create an instance of {@link AuthenticatedUserType }
     * 
     */
    public AuthenticatedUserType createAuthenticatedUserType() {
        return new AuthenticatedUserType();
    }

    /**
     * Create an instance of {@link SamlTokenProfilesType }
     * 
     */
    public SamlTokenProfilesType createSamlTokenProfilesType() {
        return new SamlTokenProfilesType();
    }

    /**
     * Create an instance of {@link OidcType }
     * 
     */
    public OidcType createOidcType() {
        return new OidcType();
    }

    /**
     * Create an instance of {@link AssertionConditionsDecoratorType }
     * 
     */
    public AssertionConditionsDecoratorType createAssertionConditionsDecoratorType() {
        return new AssertionConditionsDecoratorType();
    }

    /**
     * Create an instance of {@link SamlAuthnRequestVerificationChecksType }
     * 
     */
    public SamlAuthnRequestVerificationChecksType createSamlAuthnRequestVerificationChecksType() {
        return new SamlAuthnRequestVerificationChecksType();
    }

    /**
     * Create an instance of {@link AssertionSubjectDecoratorType }
     * 
     */
    public AssertionSubjectDecoratorType createAssertionSubjectDecoratorType() {
        return new AssertionSubjectDecoratorType();
    }

    /**
     * Create an instance of {@link ResponseHeaderDecoratorType }
     * 
     */
    public ResponseHeaderDecoratorType createResponseHeaderDecoratorType() {
        return new ResponseHeaderDecoratorType();
    }

    /**
     * Create an instance of {@link AssertionAuthnStatementDecoratorType }
     * 
     */
    public AssertionAuthnStatementDecoratorType createAssertionAuthnStatementDecoratorType() {
        return new AssertionAuthnStatementDecoratorType();
    }

    /**
     * Create an instance of {@link AudienceRestrictionsType }
     * 
     */
    public AudienceRestrictionsType createAudienceRestrictionsType() {
        return new AudienceRestrictionsType();
    }

    /**
     * Create an instance of {@link SamlTokenProfileType }
     * 
     */
    public SamlTokenProfileType createSamlTokenProfileType() {
        return new SamlTokenProfileType();
    }

    /**
     * Create an instance of {@link TokenSignatureDecoratorType }
     * 
     */
    public TokenSignatureDecoratorType createTokenSignatureDecoratorType() {
        return new TokenSignatureDecoratorType();
    }

    /**
     * Create an instance of {@link SamlRequestProfileType }
     * 
     */
    public SamlRequestProfileType createSamlRequestProfileType() {
        return new SamlRequestProfileType();
    }

    /**
     * Create an instance of {@link SamlTokenVerificationChecksType }
     * 
     */
    public SamlTokenVerificationChecksType createSamlTokenVerificationChecksType() {
        return new SamlTokenVerificationChecksType();
    }

    /**
     * Create an instance of {@link AssertionHeaderDecoratorType }
     * 
     */
    public AssertionHeaderDecoratorType createAssertionHeaderDecoratorType() {
        return new AssertionHeaderDecoratorType();
    }

    /**
     * Create an instance of {@link OidcVerificationChecksType }
     * 
     */
    public OidcVerificationChecksType createOidcVerificationChecksType() {
        return new OidcVerificationChecksType();
    }

    /**
     * Create an instance of {@link UserInfoType }
     * 
     */
    public UserInfoType createUserInfoType() {
        return new UserInfoType();
    }

    /**
     * Create an instance of {@link ProofOfPossessionType }
     * 
     */
    public ProofOfPossessionType createProofOfPossessionType() {
        return new ProofOfPossessionType();
    }

    /**
     * Create an instance of {@link JwkType }
     * 
     */
    public JwkType createJwkType() {
        return new JwkType();
    }

    /**
     * Create an instance of {@link SamlVerificationProfilesType }
     * 
     */
    public SamlVerificationProfilesType createSamlVerificationProfilesType() {
        return new SamlVerificationProfilesType();
    }

    /**
     * Create an instance of {@link PkceParametersType }
     * 
     */
    public PkceParametersType createPkceParametersType() {
        return new PkceParametersType();
    }

    /**
     * Create an instance of {@link OidcVerificationParametersType }
     * 
     */
    public OidcVerificationParametersType createOidcVerificationParametersType() {
        return new OidcVerificationParametersType();
    }

    /**
     * Create an instance of {@link VerificationProfilesType }
     * 
     */
    public VerificationProfilesType createVerificationProfilesType() {
        return new VerificationProfilesType();
    }

    /**
     * Create an instance of {@link UserAdditionalInformationType }
     * 
     */
    public UserAdditionalInformationType createUserAdditionalInformationType() {
        return new UserAdditionalInformationType();
    }

    /**
     * Create an instance of {@link SamlVerificationParametersType }
     * 
     */
    public SamlVerificationParametersType createSamlVerificationParametersType() {
        return new SamlVerificationParametersType();
    }

    /**
     * Create an instance of {@link VerificationLogType }
     * 
     */
    public VerificationLogType createVerificationLogType() {
        return new VerificationLogType();
    }

    /**
     * Create an instance of {@link VerificationProfileType }
     * 
     */
    public VerificationProfileType createVerificationProfileType() {
        return new VerificationProfileType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SamlTokenProfilesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.api.sso.nds.rub.org", name = "samlTokenProfiles")
    public JAXBElement<SamlTokenProfilesType> createSamlTokenProfiles(SamlTokenProfilesType value) {
        return new JAXBElement<SamlTokenProfilesType>(_SamlTokenProfiles_QNAME, SamlTokenProfilesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OidcType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.api.sso.nds.rub.org", name = "oidc")
    public JAXBElement<OidcType> createOidc(OidcType value) {
        return new JAXBElement<OidcType>(_Oidc_QNAME, OidcType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SamlRequestProfilesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.api.sso.nds.rub.org", name = "samlRequestProfiles")
    public JAXBElement<SamlRequestProfilesType> createSamlRequestProfiles(SamlRequestProfilesType value) {
        return new JAXBElement<SamlRequestProfilesType>(_SamlRequestProfiles_QNAME, SamlRequestProfilesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SamlType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.api.sso.nds.rub.org", name = "saml")
    public JAXBElement<SamlType> createSaml(SamlType value) {
        return new JAXBElement<SamlType>(_Saml_QNAME, SamlType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticatedUserType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.api.sso.nds.rub.org", name = "authenticatedUser")
    public JAXBElement<AuthenticatedUserType> createAuthenticatedUser(AuthenticatedUserType value) {
        return new JAXBElement<AuthenticatedUserType>(_AuthenticatedUser_QNAME, AuthenticatedUserType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerificationResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.api.sso.nds.rub.org", name = "verificationResponse")
    public JAXBElement<VerificationResponseType> createVerificationResponse(VerificationResponseType value) {
        return new JAXBElement<VerificationResponseType>(_VerificationResponse_QNAME, VerificationResponseType.class, null, value);
    }

}
