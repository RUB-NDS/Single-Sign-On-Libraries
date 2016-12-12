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
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rub.nds.oidc.oidclib.exceptions.OIDCVerifyException;
import org.rub.nds.sso.api.VerificationProfileType;

/**
 *
 * @author vladi
 */
public class OidcVerifierImpl implements OIDCVerifierInterface {

    @Override
    public void verify(SignedJWT oidcObject, VerificationProfileType profile) throws OIDCVerifyException {
        new OidcIntegrityVerifier().verify(oidcObject, profile);

    }

}
