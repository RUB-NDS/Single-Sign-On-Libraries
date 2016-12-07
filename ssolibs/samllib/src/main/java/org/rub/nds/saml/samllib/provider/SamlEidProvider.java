package org.rub.nds.saml.samllib.provider;

import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.provider.EidProvider;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public class SamlEidProvider extends EidProvider {

    private static final double VERSION = 1.0;

    private static final String INFO = "SAML eID provider v" + VERSION;

    private static final String NAME = "SAML eID";

    private static final String TYPE = "SAML";

    public SamlEidProvider() {
        super(NAME, INFO, VERSION, TYPE);
    }

    @Override
    public boolean verify(Object type) {
        SamlType sType = (SamlType) type;

        // insert code here

        return false;
    }

}
