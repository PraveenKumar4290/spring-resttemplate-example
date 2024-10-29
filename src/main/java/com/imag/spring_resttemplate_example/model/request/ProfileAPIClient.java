package com.imag.spring_resttemplate_example.model.request;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfileAPIClient {

    private final RestTemplate profileRestTemplate;
    private final ProfileProperties profileProperties;

    public List<?> findBusinessSiteIdsByCustomerId(final Integer customerId) {
        Map<String, Integer> parameter = new HashMap<>();
        parameter.put("organizationID", customerId);
        ResponseEntity<List<?>> response = profileRestTemplate.exchange(
                profileProperties.getMasterdatacrossreferenceURL()
                        + "/masterdatacrossreferenceservices/crossreference/fetchcrossreferences/Organization/OrganizationID/{organizationID}",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
                }, parameter);
        return getResponseBody(response);
    }

    public static <T> T getResponseBody(ResponseEntity<T> object) {
        T responseBody = null;
        if (object != null) {
            responseBody = object.getBody();
        }
        return responseBody;
    }

}
