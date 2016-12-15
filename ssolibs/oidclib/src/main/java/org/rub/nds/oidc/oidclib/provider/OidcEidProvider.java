package org.rub.nds.oidc.oidclib.provider;

import org.rub.nds.sso.api.OidcType;
import org.rub.nds.sso.provider.EidProvider;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public class OidcEidProvider extends EidProvider {

    private static final double VERSION = 1.0;

    private static final String INFO = "OIDC eID provider v" + VERSION;

    private static final String NAME = "OIDC eID";

    private static final String TYPE = "OIDC";

    public OidcEidProvider() {
        super(NAME, INFO, VERSION, TYPE);
    }

    @Override
    public boolean verify(Object type) {
        OidcType sType = (OidcType) type;

        // insert code here

        return false;
    }

}