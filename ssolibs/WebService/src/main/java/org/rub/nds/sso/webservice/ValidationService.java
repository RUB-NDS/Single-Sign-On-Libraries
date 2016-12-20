/*
 * Copyright (C) 2016 Juraj Somorovsky - juraj.somorovsky@rub.de.
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
package org.rub.nds.sso.webservice;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import org.rub.nds.sso.api.VerificationResponseType;

/**
 * REST Web Service
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
@Path("validation")
public class ValidationService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ValidationService
     */
    public ValidationService() {
    }

    /**
     * Retrieves representation of an instance of
     * org.rub.nds.sso.rest.application.config.ValidationService
     *
     * @return an instance of org.rub.nds.sso.api.VerificationResponseType
     */
    @GET
    @Produces("application/json")
    @Path("/list")
    public String getJson() {
        return "{methods : verifyrequest}";
    }

    /**
     * POST method for updating or creating an instance of ValidationService
     *
     * @param content
     *            representation for the resource
     * @return
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("verifyrequest")
    public VerificationResponseType postJson(String content) {
        // System.out.println(content.getAuthenticatedUser().getUserID());
        System.out.println(content);
        return new VerificationResponseType();
    }

}
