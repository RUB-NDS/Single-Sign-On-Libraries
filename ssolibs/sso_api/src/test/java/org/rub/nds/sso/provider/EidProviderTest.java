/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;
import org.rub.nds.saml.samllib.exceptions.SAMLVerifyException;
import org.rub.nds.sso.api.SamlAuthnRequestVerificationChecksType;
import org.rub.nds.sso.api.SamlTokenVerificationChecksType;
import org.rub.nds.sso.api.SamlType;
import org.rub.nds.sso.api.SamlVerificationParametersType;
import org.rub.nds.sso.api.VerificationProfileType;

/**
 *
 * @author vmladenov
 */
public class EidProviderTest {

    public EidProviderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ConfigurationException {
        DefaultBootstrap.bootstrap();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of verify method, of class EidProvider.
     */
    @Test(expected = SAMLVerifyException.class)
    public void testVerify() throws Exception {
        SamlType samlType = new SamlType();
        VerificationProfileType verificationProfile = new VerificationProfileType();
        SamlTokenVerificationChecksType checks = new SamlTokenVerificationChecksType();

        checks.setVerifiySAMLAssertionSignature(Boolean.TRUE);
        samlType.setSamlTokenVerificationChecks(checks);
        samlType.setSamlResponse("PHNhbWxwOlJlc3BvbnNlIHhtbG5zOnNhbWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6cHJvdG9jb2wiIHhtbG5zOnNhbWw9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iIElEPSJfOGU4ZGM1ZjY5YTk4Y2M0YzFmZjM0MjdlNWNlMzQ2MDZmZDY3MmY5MWU2IiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNC0wNy0xN1QwMTowMTo0OFoiIERlc3RpbmF0aW9uPSJodHRwOi8vc3AuZXhhbXBsZS5jb20vZGVtbzEvaW5kZXgucGhwP2FjcyIgSW5SZXNwb25zZVRvPSJPTkVMT0dJTl80ZmVlM2IwNDYzOTVjNGU3NTEwMTFlOTdmODkwMGI1MjczZDU2Njg1Ij4NCiAgPHNhbWw6SXNzdWVyPmh0dHA6Ly9pZHAuZXhhbXBsZS5jb20vbWV0YWRhdGEucGhwPC9zYW1sOklzc3Vlcj4NCiAgPHNhbWxwOlN0YXR1cz4NCiAgICA8c2FtbHA6U3RhdHVzQ29kZSBWYWx1ZT0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnN0YXR1czpTdWNjZXNzIi8+DQogIDwvc2FtbHA6U3RhdHVzPg0KICA8c2FtbDpBc3NlcnRpb24geG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeG1sbnM6eHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hIiBJRD0icGZ4ZWYyMWU1MDItYmM1NC0wZjFmLTg5NzgtMjVhNDJjMTM0NWRlIiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNC0wNy0xN1QwMTowMTo0OFoiPg0KICAgIDxzYW1sOklzc3Vlcj5odHRwOi8vaWRwLmV4YW1wbGUuY29tL21ldGFkYXRhLnBocDwvc2FtbDpJc3N1ZXI+PGRzOlNpZ25hdHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+DQogIDxkczpTaWduZWRJbmZvPjxkczpDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIi8+DQogICAgPGRzOlNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPg0KICA8ZHM6UmVmZXJlbmNlIFVSST0iI3BmeGVmMjFlNTAyLWJjNTQtMGYxZi04OTc4LTI1YTQyYzEzNDVkZSI+PGRzOlRyYW5zZm9ybXM+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIi8+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIvPjwvZHM6VHJhbnNmb3Jtcz48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiLz48ZHM6RGlnZXN0VmFsdWU+bFpXZXNzWEFtRkwwRWZXMzI5S1NqS2V4RDFNPTwvZHM6RGlnZXN0VmFsdWU+PC9kczpSZWZlcmVuY2U+PC9kczpTaWduZWRJbmZvPjxkczpTaWduYXR1cmVWYWx1ZT5Oek9OWHZFZHEwcmQyTGt5ak8zVzhCYzJieTZPMEUyTnlQQ0lrMUVjUlF3MjN1S3dhSGVyZ3VMT25PRFhiWTNyb1Rkdm5OMjJxQTlvN29FNGpHcVJ6L0hoR3VrNVNDeTk2Z0NVUERkV0hhYllKMXozTU52aUhJeXlaMDllSHRnRFBFUU1BL0JYNVpMNmExVlBhNSt6aTFIemVUSmg3aHdaZE56MXhYQ3N3RGM9PC9kczpTaWduYXR1cmVWYWx1ZT4NCjxkczpLZXlJbmZvPjxkczpYNTA5RGF0YT48ZHM6WDUwOUNlcnRpZmljYXRlPk1JSUNhakNDQWRPZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRMEZBREJTTVFzd0NRWURWUVFHRXdKMWN6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVWTUJNR0ExVUVDZ3dNVDI1bGJHOW5hVzRnU1c1ak1SY3dGUVlEVlFRRERBNXpjQzVsZUdGdGNHeGxMbU52YlRBZUZ3MHhOREEzTVRjeE5ERXlOVFphRncweE5UQTNNVGN4TkRFeU5UWmFNRkl4Q3pBSkJnTlZCQVlUQW5Wek1STXdFUVlEVlFRSURBcERZV3hwWm05eWJtbGhNUlV3RXdZRFZRUUtEQXhQYm1Wc2IyZHBiaUJKYm1NeEZ6QVZCZ05WQkFNTURuTndMbVY0WVcxd2JHVXVZMjl0TUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FEWngrT040SVVvSVd4Z3VrVGIxdE9pWDNiTVl6WVFpd1dQVU5NcCtGcTgyeG9Ob2dzbzJieWtaRzB5aUptNW84enYvc2Q2cEdvdWF5TWdreC8yRlNPZGMzNlQwakdiQ0h1UlNidGlhMFBFek5JUnRtVmlNcnQzQWVvV0JpZFJYbVpzeENOTHdnSVY2ZG4yV3B1RTVBejBiSGdwWm5ReFRLRmVrMEJNS1UvZDh3SURBUUFCbzFBd1RqQWRCZ05WSFE0RUZnUVVHSHhZcVpZeVg3Y1R4S1ZPRFZnWndTVGRDbnd3SHdZRFZSMGpCQmd3Rm9BVUdIeFlxWll5WDdjVHhLVk9EVmdad1NUZENud3dEQVlEVlIwVEJBVXdBd0VCL3pBTkJna3Foa2lHOXcwQkFRMEZBQU9CZ1FCeUZPbCtoTUZJQ2JkM0RKZm5wMlJnZC9kcXR0c1pHL3R5aElMV3ZFcmJpby9ERWU5OG1YcG93aFRrQzA0RU5wck95WGk3WmJVcWlpY0Y4OXVBR3l0MW9xZ1RVQ0QxVnNMYWhxSWNtcnpndW1OeVR3TEdXbzE3V0RBYTEvdXNEaGV0V0FNaGd6Ri9DbmY1ZWswbkswMG0wWVpHeWM0THpnRDBDUk9NQVNUV05nPT08L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvZHM6S2V5SW5mbz48L2RzOlNpZ25hdHVyZT4NCiAgICA8c2FtbDpTdWJqZWN0Pg0KICAgICAgPHNhbWw6TmFtZUlEIFNQTmFtZVF1YWxpZmllcj0iaHR0cDovL3NwLmV4YW1wbGUuY29tL2RlbW8xL21ldGFkYXRhLnBocCIgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDp0cmFuc2llbnQiPl9jZTNkMjk0OGI0Y2YyMDE0NmRlZTBhMGIzZGQ2ZjY5YjZjZjg2ZjYyZDc8L3NhbWw6TmFtZUlEPg0KICAgICAgPHNhbWw6U3ViamVjdENvbmZpcm1hdGlvbiBNZXRob2Q9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpjbTpiZWFyZXIiPg0KICAgICAgICA8c2FtbDpTdWJqZWN0Q29uZmlybWF0aW9uRGF0YSBOb3RPbk9yQWZ0ZXI9IjIwMjQtMDEtMThUMDY6MjE6NDhaIiBSZWNpcGllbnQ9Imh0dHA6Ly9zcC5leGFtcGxlLmNvbS9kZW1vMS9pbmRleC5waHA/YWNzIiBJblJlc3BvbnNlVG89Ik9ORUxPR0lOXzRmZWUzYjA0NjM5NWM0ZTc1MTAxMWU5N2Y4OTAwYjUyNzNkNTY2ODUiLz4NCiAgICAgIDwvc2FtbDpTdWJqZWN0Q29uZmlybWF0aW9uPg0KICAgIDwvc2FtbDpTdWJqZWN0Pg0KICAgIDxzYW1sOkNvbmRpdGlvbnMgTm90QmVmb3JlPSIyMDE0LTA3LTE3VDAxOjAxOjE4WiIgTm90T25PckFmdGVyPSIyMDI0LTAxLTE4VDA2OjIxOjQ4WiI+DQogICAgICA8c2FtbDpBdWRpZW5jZVJlc3RyaWN0aW9uPg0KICAgICAgICA8c2FtbDpBdWRpZW5jZT5odHRwOi8vc3AuZXhhbXBsZS5jb20vZGVtbzEvbWV0YWRhdGEucGhwPC9zYW1sOkF1ZGllbmNlPg0KICAgICAgPC9zYW1sOkF1ZGllbmNlUmVzdHJpY3Rpb24+DQogICAgPC9zYW1sOkNvbmRpdGlvbnM+DQogICAgPHNhbWw6QXV0aG5TdGF0ZW1lbnQgQXV0aG5JbnN0YW50PSIyMDE0LTA3LTE3VDAxOjAxOjQ4WiIgU2Vzc2lvbk5vdE9uT3JBZnRlcj0iMjAyNC0wNy0xN1QwOTowMTo0OFoiIFNlc3Npb25JbmRleD0iX2JlOTk2N2FiZDkwNGRkY2FlM2MwZWI0MTg5YWRiZTNmNzFlMzI3Y2Y5MyI+DQogICAgICA8c2FtbDpBdXRobkNvbnRleHQ+DQogICAgICAgIDxzYW1sOkF1dGhuQ29udGV4dENsYXNzUmVmPnVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphYzpjbGFzc2VzOlBhc3N3b3JkPC9zYW1sOkF1dGhuQ29udGV4dENsYXNzUmVmPg0KICAgICAgPC9zYW1sOkF1dGhuQ29udGV4dD4NCiAgICA8L3NhbWw6QXV0aG5TdGF0ZW1lbnQ+DQogICAgPHNhbWw6QXR0cmlidXRlU3RhdGVtZW50Pg0KICAgICAgPHNhbWw6QXR0cmlidXRlIE5hbWU9InVpZCIgTmFtZUZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmF0dHJuYW1lLWZvcm1hdDpiYXNpYyI+DQogICAgICAgIDxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4czpzdHJpbmciPnRlc3Q8L3NhbWw6QXR0cmlidXRlVmFsdWU+DQogICAgICA8L3NhbWw6QXR0cmlidXRlPg0KICAgICAgPHNhbWw6QXR0cmlidXRlIE5hbWU9Im1haWwiIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphdHRybmFtZS1mb3JtYXQ6YmFzaWMiPg0KICAgICAgICA8c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4c2k6dHlwZT0ieHM6c3RyaW5nIj50ZXN0QGV4YW1wbGUuY29tPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPg0KICAgICAgPC9zYW1sOkF0dHJpYnV0ZT4NCiAgICAgIDxzYW1sOkF0dHJpYnV0ZSBOYW1lPSJlZHVQZXJzb25BZmZpbGlhdGlvbiIgTmFtZUZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmF0dHJuYW1lLWZvcm1hdDpiYXNpYyI+DQogICAgICAgIDxzYW1sOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4czpzdHJpbmciPnVzZXJzPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPg0KICAgICAgICA8c2FtbDpBdHRyaWJ1dGVWYWx1ZSB4c2k6dHlwZT0ieHM6c3RyaW5nIj5leGFtcGxlcm9sZTE8L3NhbWw6QXR0cmlidXRlVmFsdWU+DQogICAgICA8L3NhbWw6QXR0cmlidXRlPg0KICAgIDwvc2FtbDpBdHRyaWJ1dGVTdGF0ZW1lbnQ+DQogIDwvc2FtbDpBc3NlcnRpb24+DQo8L3NhbWxwOlJlc3BvbnNlPg==");

        SamlVerificationParametersType verificationParameters;
        String samlVerificationProfile;
        SamlTokenVerificationChecksType samlTokenVerificationChecks;
        SamlAuthnRequestVerificationChecksType samlAuthnRequestVerificationChecks;
        verificationParameters = samlType.getSamlVerificationParameters();
        samlVerificationProfile = samlType.getSamlVerificationProfile();
        samlAuthnRequestVerificationChecks = samlType.getSamlAuthnReqVerificationChecks();

        verificationProfile.setID(UUID.randomUUID().toString());
        verificationProfile.setSamlAuthnReqVerificationChecks(samlAuthnRequestVerificationChecks);
        verificationProfile.setSamlTokenVerificationChecks(checks);
        verificationProfile.setSamlTokenVerificationParameters(verificationParameters);

        EidProvider instance = new EidProvider(samlType);
        instance.verify();
    }

}
