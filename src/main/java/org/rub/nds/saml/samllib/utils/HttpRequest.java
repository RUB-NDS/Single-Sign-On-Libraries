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

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class HttpRequest {
    private transient Map<String, Object> params;

    public HttpRequest() {
        params = new HashMap<>();
    }

    public HttpRequest(HttpServletRequest request) {
        params = new HashMap<>();
        
        params.put(HttpRequestConstants.JAVAXSERVLETREQUEST_X509_CERTIFICATE,request.getAttribute(HttpRequestConstants.JAVAXSERVLETREQUEST_X509_CERTIFICATE));
        params.put(HttpRequestConstants.SAML_REQUEST,request.getSession().getAttribute(HttpRequestConstants.SAML_REQUEST));
        params.put(HttpRequestConstants.TEMPLATE,request.getSession().getAttribute(HttpRequestConstants.TEMPLATE));
        params.put(HttpRequestConstants.BROKER_TEMPLATE,request.getSession().getAttribute(HttpRequestConstants.BROKER_TEMPLATE));
        params.put(HttpRequestConstants.SECURITY_TOKEN,request.getSession().getAttribute(HttpRequestConstants.SECURITY_TOKEN));
        params.put(HttpRequestConstants.RELAY_STATE, request.getSession().getAttribute(HttpRequestConstants.RELAY_STATE));
        params.put(HttpRequestConstants.ERROR_URL, request.getSession().getAttribute(HttpRequestConstants.ERROR_URL));
        params.put(HttpRequestConstants.HttpParamTLSUnique, request.getHeader(HttpRequestConstants.HttpParamTLSUnique));
        
    }
    
    
    

    public Map<String, Object> getParams() {
        return params;
    }
    
    public Object getParam (String key){
        return params.get(key);
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    
    public void addParams (String key, String value)
    {
        params.put(key, value);
    }
}
