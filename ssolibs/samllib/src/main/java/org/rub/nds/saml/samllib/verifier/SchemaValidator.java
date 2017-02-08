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
package org.rub.nds.saml.samllib.verifier;

import java.util.logging.Level;
import org.opensaml.common.SAMLObject;
import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.ValidatorSuite;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.api.VerificationProfileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class SchemaValidator implements SAMLVerifierInterface {

    private static Logger _log = LoggerFactory.getLogger(SchemaValidator.class);

    @Override
    public void verify(SAMLObject samlObject, VerificationProfileType profile) throws SAMLVerifyException {
        try {
            _log.debug("Verify the XML-Schema ...");

            if (profile.getSamlTokenVerificationChecks().isVerifySchema()) {
                if (profile.getSamlTokenVerificationParameters().getSamlSchema().isEmpty()
                        && profile.getSamlTokenVerificationParameters().getSamlSchemaUrl() == null) {
                    ValidatorSuite schemaValidators = org.opensaml.Configuration
                            .getValidatorSuite("saml2-core-schema-validator");
                    schemaValidators.validate(samlObject);
                    schemaValidators = org.opensaml.Configuration.getValidatorSuite("saml2-core-spec-validator");
                    schemaValidators.validate(samlObject);
                }
                if (profile.getSamlTokenVerificationParameters().getSamlSchemaUrl() != null) {
                    System.out.println(profile.getSamlTokenVerificationParameters().getSamlSchemaUrl());
                }
            }
        } catch (ValidationException ex) {
            _log.error("Schema validation failed! ");
            throw new SAMLVerifyException("Schema validation failed! ", ex);
        }
    }
}