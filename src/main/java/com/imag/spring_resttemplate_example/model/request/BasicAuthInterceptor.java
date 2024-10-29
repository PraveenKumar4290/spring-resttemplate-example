package com.imag.spring_resttemplate_example.model.request;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * This is a custom interceptor extending ClientHttpRequestInterceptor that
 * handles sending the Authorization & usernametoken as a header to the Secure
 * services.
 */
@Slf4j
public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    private final String username;
    private final String password;

    /**
     * The username & password are injected from the securePid.
     *
     * @param username
     * @param password
     */
    public BasicAuthInterceptor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        log.info("BasicAuthInterceptor.intercept() is called");
        // Build the auth-header
        final String auth = username + ":" + password;
        final byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
        final String authHeader = "Basic " + new String(encodedAuth);

        // Add the auth-header
        request.getHeaders().add("Authorization", authHeader);
        if(!request.getHeaders().containsKey("usernametoken")) {
            request.getHeaders().add("usernametoken", getLoggedInUser());
        }


        return execution.execute(request, body);
    }

    /**
     * To get the logged in userID.
     *
     * @return userId
     */
    private String getLoggedInUser() {
//        Optional<Authentication> authentication = Optional
//                .ofNullable(SecurityContextHolder.getContext().getAuthentication());
        String userName = null;
//        if (authentication.isPresent()) {
//            userName = authentication.map(Authentication::getPrincipal).map(obj -> (UserDetails) obj)
//                    .map(UserDetails::getUsername).orElse(null);
//        }
        return userName;
    }
}