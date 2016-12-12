/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author Ole Lemke <ole.lemke@rub.de>
 */
public class DecoderUtils {

    public static String decodeBase64Mime(String encoded) throws UnsupportedEncodingException {
        byte[] decoded_bytes = Base64.getMimeDecoder().decode(encoded);
        return new String(decoded_bytes, "UTF-8");
    }

}
