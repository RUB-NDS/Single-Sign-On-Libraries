/*
 * Copyright (C) 2016 vladi.
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
package org.rub.nds.oidc.oidclib.verifier;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jwt.SignedJWT;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import org.rub.nds.oidc.oidclib.exceptions.OIDCVerifyException;
import org.rub.nds.sso.api.VerificationProfileType;

/**
 *
 * @author vladi
 */
public class OidcIntegrityVerifier implements OIDCVerifierInterface {

    @Override
    public void verify(SignedJWT oidcObject, VerificationProfileType profile) throws OIDCVerifyException {
        String algorithm = oidcObject.getHeader().getAlgorithm().getName();
        try {
            if (algorithm.equalsIgnoreCase("HS256") || algorithm.equalsIgnoreCase("HS384")
                    || algorithm.equalsIgnoreCase("HS512")) {
                verifyHMAC(oidcObject, profile);
            } else if (algorithm.equalsIgnoreCase("RS256") || algorithm.equalsIgnoreCase("RS384")
                    || algorithm.equalsIgnoreCase("RS512") || algorithm.equalsIgnoreCase("PS256")
                    || algorithm.equalsIgnoreCase("PS384") || algorithm.equalsIgnoreCase("PS512")) {
                verifyAsymRSA(oidcObject, profile);
            } else if (algorithm.equalsIgnoreCase("ES256") || algorithm.equalsIgnoreCase("ES384")
                    || algorithm.equalsIgnoreCase("ES512")) {
                verifyAsymEC(oidcObject, profile);
            } else {
                throw new OIDCVerifyException("Algorithm not supported");
            }
        } catch (JOSEException | IOException | ParseException ex) {
            throw new OIDCVerifyException(algorithm, ex);
        }
    }

    private void verifyHMAC(SignedJWT oidcObject, VerificationProfileType profile) throws JOSEException {
        JWSVerifier verifier = new MACVerifier(profile.getOidcVerificationParameters().getClientSecret());
        oidcObject.verify(verifier);
    }

    private void verifyAsymRSA(SignedJWT oidcObject, VerificationProfileType profile) throws IOException,
            ParseException, OIDCVerifyException, JOSEException {
        JWKSet rsaKeys;
        // HTTP connect timeout in milliseconds
        int connectTimeout = 100;

        // HTTP read timeout in milliseconds
        int readTimeout = 100;

        // JWK set size limit, in bytes
        int sizeLimit = 10000;

        if (profile.getOidcVerificationParameters().getOidcMetadata() != null
                || !profile.getOidcVerificationParameters().getOidcMetadata().isEmpty()) {
            rsaKeys = JWKSet.load(new File(profile.getOidcVerificationParameters().getOidcMetadata()));
        } else {
            rsaKeys = JWKSet.load(new URL(profile.getOidcVerificationParameters().getOidcMetadataUrl()),
                    connectTimeout, readTimeout, sizeLimit);
        }

        if (rsaKeys == null) {
            throw new OIDCVerifyException("Cannot find asymmetric key");
        }

        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) rsaKeys);
        oidcObject.verify(verifier);
    }

    private void verifyAsymEC(SignedJWT oidcObject, VerificationProfileType profile) throws IOException,
            ParseException, OIDCVerifyException, JOSEException {
        JWKSet ecKeys;
        // HTTP connect timeout in milliseconds
        int connectTimeout = 100;

        // HTTP read timeout in milliseconds
        int readTimeout = 100;

        // JWK set size limit, in bytes
        int sizeLimit = 10000;

        if (profile.getOidcVerificationParameters().getOidcMetadata() != null
                || !profile.getOidcVerificationParameters().getOidcMetadata().isEmpty()) {
            ecKeys = JWKSet.load(new File(profile.getOidcVerificationParameters().getOidcMetadata()));
        } else {
            ecKeys = JWKSet.load(new URL(profile.getOidcVerificationParameters().getOidcMetadataUrl()), connectTimeout,
                    readTimeout, sizeLimit);
        }

        if (ecKeys == null) {
            throw new OIDCVerifyException("Cannot find asymmetric key");
        }

        JWSVerifier verifier = new ECDSAVerifier((ECPublicKey) ecKeys);
        oidcObject.verify(verifier);
    }
}
