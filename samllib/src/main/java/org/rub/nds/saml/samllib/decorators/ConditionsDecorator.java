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
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;
import org.opensaml.common.SAMLObject;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Audience;
import org.opensaml.saml2.core.AudienceRestriction;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Conditions;
import org.rub.nds.elearning.sso.saml.api.AssertionConditionsDecoratorType;
import org.rub.nds.saml.samllib.exceptions.SAMLBuildException;
import org.rub.nds.saml.samllib.utils.SAMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov <vladislav.mladenov@rub.de>
 */

public class ConditionsDecorator extends SAMLDecorator {

    private static Logger _log = LoggerFactory.getLogger(ConditionsDecorator.class);
    //Timestamps values
    private boolean setNotBefore = true;
    private boolean setNotAfter = true;
    private int timestampDuration = 30; //Minutes
    private List<String> audienceRestrictions;

    public ConditionsDecorator(AssertionConditionsDecoratorType profile) {
        setNotBefore = profile.isSetNotBefore();
        setNotAfter = profile.isSetNotAfter();
        timestampDuration = profile.getTimestampDuration();
        audienceRestrictions = profile.getAudienceRestriction();
    }
    
    

    @Override
    public SAMLObject build(final SAMLObject samlToken) throws SAMLBuildException {
        try {
            _log.debug(this.toString() + ": start building the Conditions");

            Conditions conditions;
            AudienceRestriction audienceRestriction;
            Audience audience;

            _log.debug(ConditionsDecorator.class.toString() + ": add timestamps");

            //Check if any Conditions are already included
            //if NOT - generates new one and include them
            if (getConditions(samlToken) == null) {
                conditions = (Conditions) SAMLUtils.getSAMLBuilder(Conditions.DEFAULT_ELEMENT_NAME).buildObject();
                if (setNotBefore) {
                    conditions.setNotBefore(SAMLUtils.getDateTime());
                }
                if (setNotAfter) {
                    conditions.setNotOnOrAfter(SAMLUtils.getDateTime().plusMinutes(timestampDuration));
                }

                setConditions(samlToken, conditions);
            } else {
                conditions = getConditions(samlToken);
            }

            if (this.audienceRestrictions != null && !this.audienceRestrictions.isEmpty()) {
                //include AudienceRestrictions if needed/configured
                _log.debug(ConditionsDecorator.class.toString() + ": add audience restrictions");
                audienceRestriction = (AudienceRestriction) SAMLUtils.getSAMLBuilder(AudienceRestriction.DEFAULT_ELEMENT_NAME).buildObject();

                for (String s : this.audienceRestrictions) {
                    audience = (Audience) SAMLUtils.getSAMLBuilder(Audience.DEFAULT_ELEMENT_NAME).buildObject();
                    audience.setAudienceURI(s);
                    audienceRestriction.getAudiences().add(audience);
                }

                conditions.getAudienceRestrictions().add(audienceRestriction);
            }

            return samlToken;
        } catch (ClassCastException | NullPointerException ex) {
            throw new SAMLBuildException(this.toString(), ex);
        }
    }

    private void setConditions(SAMLObject samlToken, Conditions conditions) throws SAMLBuildException {
        if (samlToken instanceof Assertion) {
            ((Assertion) samlToken).setConditions(conditions);
        } else if (samlToken instanceof AuthnRequest) {
            ((AuthnRequest) samlToken).setConditions(conditions);
        } else {
            throw new SAMLBuildException("Cannot insert conditions elemenent! SAMLToken instance is not known!");
        }
    }

    private Conditions getConditions(SAMLObject samlToken) throws SAMLBuildException {
        if (samlToken instanceof Assertion) {
            return ((Assertion) samlToken).getConditions();
        } else if (samlToken instanceof AuthnRequest) {
            return ((AuthnRequest) samlToken).getConditions();
        } else {
            throw new SAMLBuildException("Cannot insert conditions elemenent! SAMLToken instance is not known!");
        }
    }
}
