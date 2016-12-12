package org.rub.nds.sso.provider;

import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rub.nds.saml.samllib.provider.SamlEidProvider;
import org.rub.nds.sso.api.SamlType;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public class IntegrationTest {

    @Before
    public void init() {
        EidSecurity.addEidProvider(new SamlEidProvider());
    }

    @Test
    public void testProviders() {
        Set<String> types = EidSecurity.getEidTypes();
        Assert.assertEquals(1, types.size());
    }

    @Test(expected = NoSuchEidProviderException.class)
    public void testOidcProvider() throws NoSuchEidProviderException {
        EidSecurity.getEidProviderInstance("oidc");
    }

    @Test
    public void testSamlProvider() throws NoSuchEidProviderException {
        EidProvider p = EidSecurity.getEidProviderInstance("saml");
        SamlType t = new SamlType();
        p.setSecurityObject(t);
        Assert.assertEquals(false, p.verify());
    }

}
