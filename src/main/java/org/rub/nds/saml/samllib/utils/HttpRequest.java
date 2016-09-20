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
        
        params.put(HttpRequestConstants.PROFILE, request.getParameter((HttpRequestConstants.PROFILE)));
        params.put(HttpRequestConstants.SAML_REQUEST,request.getParameter((HttpRequestConstants.SAML_REQUEST)));
        params.put(HttpRequestConstants.RELAY_STATE, request.getParameter(HttpRequestConstants.RELAY_STATE));
        
        if (request.getParameter(HttpRequestConstants.SECURITY_BINDING) != null && !request.getParameter(HttpRequestConstants.SECURITY_BINDING).isEmpty())
        {
            String binding = request.getParameter(HttpRequestConstants.SECURITY_BINDING);
            switch (binding){
                case HttpRequestConstants.hok : params.put(HttpRequestConstants.JAVAXSERVLETREQUEST_X509_CERTIFICATE,request.getAttribute(HttpRequestConstants.JAVAXSERVLETREQUEST_X509_CERTIFICATE)); break;
                case HttpRequestConstants.TokenBinding : break; // not implemented yet
                case HttpRequestConstants.tlsUnique : break; //not implemented yet
            }
            
        }        
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
