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
package org.rub.nds.saml.samllib.decorators;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.*;
import org.rub.nds.elearning.sso.saml.api.AssertionSubjectDecoratorType;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLDefaultConstants;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */

public class SubjectDecorator extends SAMLDecorator {

    private static Logger _log = LoggerFactory.getLogger(SubjectDecorator.class);
    
    private String nameIDValue = SAMLDefaultConstants.NameIDValue;
    private String nameIDformat = NameIDType.TRANSIENT;
    private String nameIDnameQualifier;
    private String nameIDsPNameQualifier;
    private String nameIDsPProvidedID;
    private String sbjConfirmMethod = SAMLDefaultConstants.SbjConfirmationMethod;
    private String sbjConfirmationDataAddress;
    private String sbjConfirmationDataRecipient;
    private int timestampDuration = 30; //Minutes

    public SubjectDecorator(AssertionSubjectDecoratorType decorator) {
        init(decorator);
        sbjConfirmationDataRecipient = decorator.getSbjConfirmationDataRecipient();
    }
    
    public SubjectDecorator(AssertionSubjectDecoratorType decorator, AuthnRequest samlRequest) {
        init(decorator);
        sbjConfirmationDataRecipient = samlRequest.getAssertionConsumerServiceURL();
    }

    private void init(AssertionSubjectDecoratorType decorator) {
        nameIDValue = decorator.getNameIDValue();
        nameIDformat = decorator.getNameIDformat();
        nameIDnameQualifier = decorator.getNameIDnameQualifier();
        nameIDsPNameQualifier = decorator.getNameIDsPNameQualifier();
        nameIDsPProvidedID = decorator.getNameIDsPProvidedID();
        
        if (!decorator.getSbjConfirmMethod().isEmpty()){
            sbjConfirmMethod = decorator.getSbjConfirmMethod();
        }
        sbjConfirmationDataAddress = decorator.getSbjConfirmationDataAddress();
    }
    
    
    
    /*
     * Build the Subject and add it to the Assertion
     *
     * @throws SAMLBuildException
     */
    @Override
    public SAMLObject build(final SAMLObject samlToken) throws SAMLBuildException 
    {
        try
        {
            _log.debug(this.toString() + ": start building the Subject");

            Subject subject;
            NameID nameID;
            SubjectConfirmation sbjConfirmation;
            SubjectConfirmationData sbjConfrimationData;

            nameID = (NameID) SAMLUtils.getSAMLBuilder(NameID.DEFAULT_ELEMENT_NAME).buildObject();
            nameID.setValue(nameIDValue);

            if (getSubject(samlToken) == null) {
                _log.debug(this.toString() + ": No Subject found. Generate new one");
                NameID tempNameID;

                tempNameID = (NameID) SAMLUtils.getSAMLBuilder(NameID.DEFAULT_ELEMENT_NAME).buildObject();
                tempNameID.setFormat(nameIDformat);
                tempNameID.setValue(nameIDValue);
                tempNameID.setNameQualifier(nameIDnameQualifier);
                tempNameID.setSPNameQualifier(nameIDsPNameQualifier);
                tempNameID.setSPProvidedID(nameIDsPProvidedID);

                subject = (Subject) SAMLUtils.getSAMLBuilder(Subject.DEFAULT_ELEMENT_NAME).buildObject();
                subject.setNameID(tempNameID);
                
                setSubject(samlToken, subject);
            } else {
                _log.debug(this.toString() + ": Subject element found. Start extending it.");
                subject = getSubject(samlToken);
            }

            _log.debug(this.toString() + ": add SubjectConfirmation");
            sbjConfrimationData = (SubjectConfirmationData) SAMLUtils.getSAMLBuilder(SubjectConfirmationData.DEFAULT_ELEMENT_NAME).buildObject();
            sbjConfrimationData.setNotOnOrAfter(SAMLUtils.getDateTime().plusMinutes(timestampDuration));
            sbjConfrimationData.setAddress(sbjConfirmationDataAddress);
            sbjConfrimationData.setRecipient(sbjConfirmationDataRecipient);

            sbjConfirmation = (SubjectConfirmation) SAMLUtils.getSAMLBuilder(SubjectConfirmation.DEFAULT_ELEMENT_NAME).buildObject();
            sbjConfirmation.setMethod(sbjConfirmMethod);
            sbjConfirmation.setSubjectConfirmationData(sbjConfrimationData);

            subject.getSubjectConfirmations().add(sbjConfirmation);
            
            return samlToken;
        }
        catch(NullPointerException | ClassCastException ex)
        {
            throw new SAMLBuildException(this.toString(), ex);
        }
    }
    
    private void setSubject(SAMLObject samlToken, Subject subject) throws SAMLBuildException {
        if (samlToken instanceof Assertion) {
            ((Assertion) samlToken).setSubject(subject);
        } else if (samlToken instanceof AuthnRequest) {
            ((AuthnRequest) samlToken).setSubject(subject);
        } else {
            throw new SAMLBuildException("Cannot insert conditions elemenent! SAMLToken instance is not known!");
        }
    }

    private Subject getSubject(SAMLObject samlToken) throws SAMLBuildException {
        if (samlToken instanceof Assertion) {
            return ((Assertion) samlToken).getSubject();
        } else if (samlToken instanceof AuthnRequest) {
            return ((AuthnRequest) samlToken).getSubject();
        } else {
            throw new SAMLBuildException("Cannot insert conditions elemenent! SAMLToken instance is not known!");
        }
    }
}
