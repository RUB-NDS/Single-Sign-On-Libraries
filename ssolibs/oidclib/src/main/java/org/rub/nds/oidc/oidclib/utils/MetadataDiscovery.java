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
package org.rub.nds.oidc.oidclib.utils;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.oauth2.sdk.ParseException;
import com.nimbusds.openid.connect.sdk.op.OIDCProviderMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.minidev.json.JSONObject;

/**
 *
 * @author vladi
 */
public class MetadataDiscovery {

    public static OIDCProviderMetadata discoverIssuerURL(String issuerURL) throws ParseException, URISyntaxException,
            MalformedURLException, IOException {
        URI issuerURI = new URI(issuerURL);
        URL providerConfigurationURL = issuerURI.resolve("/.well-known/openid-configuration").toURL();
        InputStream stream = providerConfigurationURL.openStream();
        // Read all data from URL
        String providerInfo = null;
        try (java.util.Scanner s = new java.util.Scanner(stream)) {
            providerInfo = s.useDelimiter("\\A").hasNext() ? s.next() : "";
        }
        return OIDCProviderMetadata.parse(providerInfo);
    }

    public static OIDCProviderMetadata parseMetadataFile(String metadataFile) throws ParseException,
            URISyntaxException, MalformedURLException, IOException, java.text.ParseException {
        JSONObject json = JSONObjectUtils.parse(readFile(metadataFile, Charset.defaultCharset()));
        return OIDCProviderMetadata.parse(json);
    }

    public static JWKSet getJWKSKeys(OIDCProviderMetadata metadata) throws ParseException, URISyntaxException,
            MalformedURLException, IOException, java.text.ParseException {
        JWKSet rsaKeys;
        // HTTP connect timeout in milliseconds
        int connectTimeout = 100;

        // HTTP read timeout in milliseconds
        int readTimeout = 100;

        // JWK set size limit, in bytes
        int sizeLimit = 10000;

        rsaKeys = JWKSet.load(metadata.getJWKSetURI().toURL(), connectTimeout, readTimeout, sizeLimit);

        return rsaKeys;
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
