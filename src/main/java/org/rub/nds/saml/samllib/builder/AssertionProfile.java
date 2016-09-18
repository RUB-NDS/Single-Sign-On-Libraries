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
package org.rub.nds.saml.samllib.builder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.rub.nds.saml.samllib.decorators.AssertionAttributeStatementDecorator;
import org.rub.nds.saml.samllib.decorators.AssertionAuthnStatementDecorator;
import org.rub.nds.saml.samllib.decorators.AssertionHeaderDecorator;
import org.rub.nds.saml.samllib.decorators.ConditionsDecorator;
import org.rub.nds.saml.samllib.decorators.SubjectDecorator;

/**
 * This Decorator-class contains the decorators of the assertion initialized
 * by the configuration file
 * 
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
@XStreamAlias("assertionProfile")
public class AssertionProfile {

    //Decorators of the assertion
    private transient AssertionHeaderDecorator assertionHeaderDecorator;
    private transient ConditionsDecorator assertionConditionsDecorator;
    private transient SubjectDecorator assertionSubjectDecorator;
    private transient AssertionAuthnStatementDecorator assertionAuthnStatementDecorator;
    private transient AssertionAttributeStatementDecorator assertionAttributeStatementDecorator;
    
    /*
     * The References in the SAMLProfile to the decorators
     */
    private String assertionHeaderDec;
    private String assertionConditionsDec;
    private String assertionSubjectDec;
    private String assertionAuthnStatementDec;
    private String assertionAttributeStatementDec;

    /**
     * @return
     */
    public AssertionHeaderDecorator getAssertionHeaderDecorator() {
        return assertionHeaderDecorator;
    }

    /**
     * @param assertionHeaderDecorator
     */
    public void setAssertionHeaderDecorator(AssertionHeaderDecorator assertionHeaderDecorator) {
        this.assertionHeaderDecorator = assertionHeaderDecorator;
    }

    /**
     *
     * @return
     */
    public String getAssertionHeaderDec() {
        return assertionHeaderDec;
    }

    /**
     *
     * @param assertionConditionsDecorator
     */
    public void setAssertionConditionsDecorator(ConditionsDecorator assertionConditionsDecorator) {
        this.assertionConditionsDecorator = assertionConditionsDecorator;
    }

    /**
     *
     * @return
     */
    public String getAssertionConditionsDec() {
        return assertionConditionsDec;
    }

    /**
     *
     * @return
     */
    public ConditionsDecorator getAssertionConditionsDecorator() {
        return assertionConditionsDecorator;
    }

    /**
     *
     * @param assertionSubjectDecorator
     */
    public void setAssertionSubjectDecorator(SubjectDecorator assertionSubjectDecorator) {
        this.assertionSubjectDecorator = assertionSubjectDecorator;
    }

    /**
     *
     * @return
     */
    public SubjectDecorator getAssertionSubjectDecorator() {
        return assertionSubjectDecorator;
    }

    /**
     *
     * @return
     */
    public String getAssertionSubjectDec() {
        return assertionSubjectDec;
    }

    /**
     *
     * @return
     */
    public AssertionAuthnStatementDecorator getAssertionAuthnStatementDecorator() {
        return assertionAuthnStatementDecorator;
    }

    /**
     *
     * @param assertionAuthnStatementDecorator
     */
    public void setAssertionAuthnStatementDecorator(AssertionAuthnStatementDecorator assertionAuthnStatementDecorator) {
        this.assertionAuthnStatementDecorator = assertionAuthnStatementDecorator;
    }

    /**
     *
     * @return
     */
    public String getAssertionAuthnStatementDec() {
        return assertionAuthnStatementDec;
    }

    /**
     *
     * @return
     */
    public AssertionAttributeStatementDecorator getAssertionAttributeStatementDecorator() {
        return assertionAttributeStatementDecorator;
    }

    /**
     *
     * @param assertionAttributeStatementDecorator
     */
    public void setAssertionAttributeStatementDecorator(AssertionAttributeStatementDecorator assertionAttributeStatementDecorator) {
        this.assertionAttributeStatementDecorator = assertionAttributeStatementDecorator;
    }

    /**
     *
     * @return
     */
    public String getAssertionAttributeStatementDec() {
        return assertionAttributeStatementDec;
    }
    
    
}
