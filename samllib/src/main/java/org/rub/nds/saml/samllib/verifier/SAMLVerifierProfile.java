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

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@XStreamAlias("samlVerifierProfile")
public class SAMLVerifierProfile {
    @XStreamAsAttribute
    protected String name;
    
    private boolean schemaValidation;
    
    private boolean responseID;
    private boolean responseTimestamp;
    private boolean responseInResponseTo;
    
    
    private boolean assertionID;
    private boolean assertionTimestamp;
    
    private boolean signatureStructure;
    private boolean responseSignature;
    private boolean responseTrustVerification;
    private boolean assertionSignature;
    private boolean assertionTrustVerification;
    
    
    private String conditionAudienceStr;
    private boolean conditionNotBefore;
    private boolean conditionsNotOnOrAfter;
    private int conditionsMaxDuration;
    
    private String subjectRecipient;
    private boolean subjectNotBefore;
    private boolean subjectNotOnOrAfter;
    private boolean subjectInResponseTo;
    private int subjectMaxDuration;
    
    private boolean authnStatementTimestamp;
    
    private boolean hokverification;

    public boolean isSchemaValidation() {
        return schemaValidation;
    }
    
    public boolean isResponseID() {
        return responseID;
    }

    public boolean isResponseInResponseTo() {
        return responseInResponseTo;
    }

    public boolean isResponseTimestamp() {
        return responseTimestamp;
    }

    public boolean isResponseSignature() {
        return responseSignature;
    }

    public boolean isResponseTrustVerification() {
        return responseTrustVerification;
    }
    
    
    public boolean isAssertionID() {
        return assertionID;
    }

    public boolean isAssertionTimestamp() {
        return assertionTimestamp;
    }

    public boolean isAssertionSignature() {
        return assertionSignature;
    }

    public boolean isAssertionTrustVerification() {
        return assertionTrustVerification;
    }

    
    
    public boolean isConditionNotBefore() {
        return conditionNotBefore;
    }

    public boolean isConditionsNotOnOrAfter() {
        return conditionsNotOnOrAfter;
    }

    public String getConditionAudienceStr() {
        return conditionAudienceStr;
    }

    public int getConditionsMaxDuration() {
        return conditionsMaxDuration;
    }
    
    

    public boolean isSubjectNotBefore() {
        return subjectNotBefore;
    }

    public boolean isSubjectNotOnOrAfter() {
        return subjectNotOnOrAfter;
    }

    public String getSubjectRecipient() {
        return subjectRecipient;
    }

    public int getSubjectMaxDuration() {
        return subjectMaxDuration;
    }
    
    

    public boolean isAuthnStatementTimestamp() {
        return authnStatementTimestamp;
    }

    public boolean isSignatureStructure() {
        return signatureStructure;
    }

    public boolean isSubjectInResponseTo() {
        return subjectInResponseTo;
    }

    public boolean isHokverification() {
        return hokverification;
    }

    public void setSchemaValidation(boolean schemaValidation) {
        this.schemaValidation = schemaValidation;
    }

    public void setResponseID(boolean responseID) {
        this.responseID = responseID;
    }

    public void setResponseTimestamp(boolean responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public void setResponseInResponseTo(boolean responseInResponseTo) {
        this.responseInResponseTo = responseInResponseTo;
    }

    public void setAssertionID(boolean assertionID) {
        this.assertionID = assertionID;
    }

    public void setAssertionTimestamp(boolean assertionTimestamp) {
        this.assertionTimestamp = assertionTimestamp;
    }

    public void setSignatureStructure(boolean signatureStructure) {
        this.signatureStructure = signatureStructure;
    }

    public void setResponseSignature(boolean responseSignature) {
        this.responseSignature = responseSignature;
    }

    public void setResponseTrustVerification(boolean responseTrustVerification) {
        this.responseTrustVerification = responseTrustVerification;
    }

    public void setAssertionSignature(boolean assertionSignature) {
        this.assertionSignature = assertionSignature;
    }

    public void setAssertionTrustVerification(boolean assertionTrustVerification) {
        this.assertionTrustVerification = assertionTrustVerification;
    }

    public void setConditionAudienceStr(String conditionAudienceStr) {
        this.conditionAudienceStr = conditionAudienceStr;
    }

    public void setConditionNotBefore(boolean conditionNotBefore) {
        this.conditionNotBefore = conditionNotBefore;
    }

    public void setConditionsNotOnOrAfter(boolean conditionsNotOnOrAfter) {
        this.conditionsNotOnOrAfter = conditionsNotOnOrAfter;
    }

    public void setConditionsMaxDuration(int conditionsMaxDuration) {
        this.conditionsMaxDuration = conditionsMaxDuration;
    }
    
    

    public void setSubjectRecipient(String subjectRecipient) {
        this.subjectRecipient = subjectRecipient;
    }

    public void setSubjectNotBefore(boolean subjectNotBefore) {
        this.subjectNotBefore = subjectNotBefore;
    }

    public void setSubjectNotOnOrAfter(boolean subjectNotOnOrAfter) {
        this.subjectNotOnOrAfter = subjectNotOnOrAfter;
    }

    public void setSubjectInResponseTo(boolean subjectInResponseTo) {
        this.subjectInResponseTo = subjectInResponseTo;
    }

    public void setSubjectMaxDuration(int subjectMaxDuration) {
        this.subjectMaxDuration = subjectMaxDuration;
    }
    
    

    public void setAuthnStatementTimestamp(boolean authnStatementTimestamp) {
        this.authnStatementTimestamp = authnStatementTimestamp;
    }

    public void setHokverification(boolean hokverification) {
        this.hokverification = hokverification;
    }   

    public String getName() {
        return name;
    }
    
    
}
