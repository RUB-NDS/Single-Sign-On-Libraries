/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.futuretrust.controller;

import oasis.names.tc.dss._1_0.core.schema.VerifyRequest;
import org.rub.nds.futuretrust.cvs.sso.api.VerificationRequestType;
import org.rub.nds.saml.samllib.provider.SamlEidProvider;
import org.rub.nds.sso.api.VerificationLogType;
import org.rub.nds.sso.api.VerificationResponseType;
import org.rub.nds.sso.provider.EidProvider;

/**
 *
 * @author vmladenov
 */
public class Controller {
    VerifyRequest request;

    public Controller(VerifyRequest request) {
        this.request = request;
    }

    public VerificationResponseType verify() {
        VerificationResponseType result = new VerificationResponseType();
        try {
            VerificationRequestType rq = (VerificationRequestType) request.getOptionalInputs().getAny().get(0);
            EidProvider provider = new SamlEidProvider();
            result = provider.verify(rq.getSaml());

            return result;
        } catch (Exception ex) { // TODO: Only exceptions which are throws by
                                 // our lib
            VerificationLogType log = new VerificationLogType();
            log.setException(ex.getMessage());
            result.setVerificationLog(log);
            return result;
        }
    }
}
