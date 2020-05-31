package com.k0ft3.atman.web.apis.authenticate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AuthenticationFilterTests {

    @MockBean
    private AuthenticationManager authenticationManagerMock;

    @Test(expected = InsufficientAuthenticationException.class)
    public void attemptAuthentication_emptyRequestBody_shouldFail() throws IOException {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/api/authentications");
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerMock);
        filter.attemptAuthentication(request, new MockHttpServletResponse());
    }

 

}