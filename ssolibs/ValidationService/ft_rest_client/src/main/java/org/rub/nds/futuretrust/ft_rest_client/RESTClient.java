/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.futuretrust.ft_rest_client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import oasis.names.tc.dss._1_0.core.schema.AnyType;
import oasis.names.tc.dss._1_0.core.schema.VerifyRequest;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationRequestType;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.VerificationProfileType;
import org.rub.nds.sso.api.VerificationResponseType;

/**
 *
 * @author vmladenov
 */
public class RESTClient {
    public static void main(String[] args) {
        VerifyRequest ft_request = new VerifyRequest();
        VerificationRequestType ssoRequest = new VerificationRequestType();
        SamlType samlType = new SamlType();
        samlType.setSamlResponse("samlResponseBase64encoded");

        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();
        checks.setVerifySAMLAssertionSignature(Boolean.TRUE);
        samlType.setSamlTokenVerificationChecks(checks);

        ssoRequest.setSaml(samlType);
        AnyType any = new AnyType();
        any.getAny().add(ssoRequest);
        ft_request.setOptionalInputs(any);

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget target = client.target("http://carbon.cloud.nds.rub.de:9999/WebService/webresources/validation")
                .path("verifyrequest");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response ft_Response_raw = invocationBuilder.post(Entity.entity(ft_request, MediaType.APPLICATION_JSON));

        VerificationResponseType ft_response = ft_Response_raw.readEntity(VerificationResponseType.class);

        VerificationProfileType vProfile = new VerificationProfileType();
        vProfile.setSamlTokenVerificationChecks(ft_response.getSamlTokenVerifiedChecks());
    }
}
