/* 
 * Copyright (C) 2014 Vladislav Mladenov<vladislav.mladenov@rub.de>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.rub.nds.saml.samllib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import org.opensaml.Configuration;
import org.opensaml.xml.security.SecurityConfiguration;
import org.opensaml.xml.security.SecurityException;
import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.UsageType;
import org.opensaml.xml.security.keyinfo.KeyInfoHelper;
import org.opensaml.xml.security.x509.BasicX509Credential;
import org.opensaml.xml.signature.KeyInfo;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureConstants;
import org.rub.nds.saml.samllib.exceptions.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.KeyException;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Julian Krautwald <julian.krautwald@rub.de>
 */
public final class SecurityUtils {

    private static final SecurityUtils INSTANCE = new SecurityUtils();
    private static Logger _log = LoggerFactory.getLogger(SecurityUtils.class);

    private SecurityUtils() {
    }

    /**
     *
     * @return
     */
    public static SecurityUtils getInstance() {
        if (INSTANCE == null) {
            throw new RuntimeException("No singleton instance available");
        }
        return INSTANCE;
    }

    /**
     * Creating a SAML signature for a given certificate and privateKey object
     *
     * @param cert
     * @param privKey
     * @return
     * @throws KeyException failing to create the SAML signature
     * @throws SAMLBuildException
     */
    public static Signature createSignature(final X509Certificate cert, final PrivateKey privKey) throws KeyException, SAMLBuildException {
        _log.info(SecurityUtils.class.toString() + ": Create SAML-Signature element for given certificate and privateKey object");

        BasicX509Credential credential;
        KeyInfo keyInfo;
        Signature signature;
        SecurityConfiguration secConfig;
        String keyInfoGeneratorProfile;
        try {
            keyInfoGeneratorProfile = "XMLSignature";

            credential = new BasicX509Credential();
            credential.setEntityCertificate(cert);
            credential.setPrivateKey(privKey);
            credential.setUsageType(UsageType.SIGNING);

            SAMLUtils.getSAMLBuilder();
            keyInfo = (KeyInfo) Configuration.getBuilderFactory().getBuilder(KeyInfo.DEFAULT_ELEMENT_NAME).buildObject(KeyInfo.DEFAULT_ELEMENT_NAME);

            KeyInfoHelper.addCertificate(keyInfo, cert);

            signature = (Signature) Configuration.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME).buildObject(Signature.DEFAULT_ELEMENT_NAME);
            signature.setSigningCredential(credential);
            signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA1);
            signature.setCanonicalizationAlgorithm(SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);

            signature.setKeyInfo(keyInfo);

            secConfig = Configuration.getGlobalSecurityConfiguration();

            SecurityHelper.prepareSignatureParams(signature, credential, secConfig, keyInfoGeneratorProfile);

            return signature;
        } catch (SAMLBuildException | CertificateEncodingException | SecurityException ex) {
            throw new KeyException(ex.getMessage(), ex);
        }
    }

    /**
     *
     * @param filePath
     * @return
     * @throws CertificateException
     * @throws IOException
     */
    public static X509Certificate readCertificatefromPEM(final String filePath) throws CertificateException, IOException {
        InputStream is = null;
        X509Certificate crt = null;
        try {
            is = new FileInputStream(filePath); //filePath.getClass().getResourceAsStream("/" + filePath);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            crt = (X509Certificate) cf.generateCertificate(is);
        } finally {
            is.close();
        }
        return crt;
    }

    /**
     * Creating a SAML Signature from a given certificate + privatekey container
     * (.jks File)
     *
     * @param keystore_path 
     * @param key_keystore_pass 
     * @param key_truststore_pass 
     * @param alias 
     * @return 
     * @throws KeyException extracting the keys from the specified Keystorage
     * @throws SAMLBuildException  
     */
    public static Signature getSignatureFromFileJKS(final File keystore_path, final char[] key_keystore_pass, final char[] key_truststore_pass, String alias) throws KeyException, SAMLBuildException {
        KeyStore.PrivateKeyEntry pkEntry;
        PrivateKey privatekey;
        KeyStore keystore;
        BasicX509Credential credential;
        X509Certificate certificatex509;
        Signature signature;

        try {
            keystore = getKeyStore(keystore_path, key_keystore_pass, key_truststore_pass, alias);

            //Retrieve private Key from KeyStorage:
            pkEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry(alias, new KeyStore.PasswordProtection(key_keystore_pass));
            privatekey = pkEntry.getPrivateKey();

            //Retrieve certificate from KeyStorage:
            certificatex509 = getCertificateFromJKS(keystore, alias);
            //Create SAML signature with the help of the SAMLSignatureFactory class:
            signature = createSignature(certificatex509, privatekey);

            credential = new BasicX509Credential();
            credential.setEntityCertificate(certificatex509);
            credential.setPrivateKey(privatekey);
            credential.setUsageType(UsageType.SIGNING);

            return signature;
        } catch (KeyException | KeyStoreException | UnrecoverableEntryException | NoSuchAlgorithmException ex) {
            throw new KeyException("Cannot create Signature element!", ex);
        }
    }

    /**
     * Get Signature used for signing the SAML token
     *
     * @param signSignature 
     * @return Signature
     * @throws ConfigurationException
     */
    public static Signature copySignature(final Signature signSignature) throws ConfigurationException {
        KeyInfo keyInfo;
        keyInfo = (KeyInfo) Configuration.getBuilderFactory().getBuilder(KeyInfo.DEFAULT_ELEMENT_NAME).buildObject(KeyInfo.DEFAULT_ELEMENT_NAME);


        try {
            final String keyInfoGeneratorProfile = "XMLSignature";

            Signature signature = (Signature) SAMLUtils.getSAMLBuilder().getBuilder(Signature.DEFAULT_ELEMENT_NAME).buildObject(Signature.DEFAULT_ELEMENT_NAME);
            signature.setSigningCredential(signSignature.getSigningCredential());
            signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA1);
            signature.setCanonicalizationAlgorithm(SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
            KeyInfoHelper.addCertificate(keyInfo, ((BasicX509Credential)signature.getSigningCredential()).getEntityCertificate());

            signature.setKeyInfo(keyInfo);

            SecurityHelper.prepareSignatureParams(signature, signSignature.getSigningCredential(), Configuration.getGlobalSecurityConfiguration(), keyInfoGeneratorProfile);

            return signature;
        } catch (SAMLBuildException | org.opensaml.xml.security.SecurityException | CertificateEncodingException ex) {
            _log.error("Could not create a copy of Signature");
            throw new ConfigurationException("Could not create a copy of Signature", ex);
        }
    }

    /**
     *
     * @param keystore
     * @param alias
     * @return
     * @throws KeyStoreException
     */
    public static X509Certificate getCertificateFromJKS(KeyStore keystore, String alias) throws KeyStoreException {
        return (X509Certificate) keystore.getCertificate(alias);
    }
    
    /**
     *
     * @param keystore_path
     * @param key_keystore_pass
     * @param key_truststore_pass
     * @param alias
     * @return
     * @throws KeyStoreException
     * @throws KeyException
     */
    public static X509Certificate getCertificateFromJKS(final File keystore_path, final char[] key_keystore_pass, final char[] key_truststore_pass, String alias) throws KeyStoreException, KeyException {
        KeyStore keystore;
        
        keystore = getKeyStore(keystore_path, key_keystore_pass, key_truststore_pass, alias);
        return (X509Certificate) keystore.getCertificate(alias);
    }

    /**
     *
     * @param keystore_path
     * @param key_keystore_pass
     * @param key_truststore_pass
     * @param alias
     * @return
     * @throws KeyException
     */
    public static KeyStore getKeyStore(final File keystore_path, final char[] key_keystore_pass, final char[] key_truststore_pass, String alias) throws KeyException {
        KeyStore keystore;
        Enumeration enumer;

        try {
            keystore = KeyStore.getInstance("JKS", "SUN");
            try (FileInputStream fileStream = new FileInputStream(keystore_path)) {
                keystore.load(fileStream, key_truststore_pass);
                fileStream.close();
            }
            //Check if a valid key entry alias is present:
            for (enumer = keystore.aliases(); enumer.hasMoreElements();) {
                alias = (String) enumer.nextElement();
                if (keystore.isKeyEntry(alias)) {
                    break;
                }
            }
            return keystore;
        } catch (KeyStoreException | NoSuchProviderException | NoSuchAlgorithmException | CertificateException | IOException ex) {
            throw new KeyException("Cannot read JKS file!", ex);
        }
    }
}
