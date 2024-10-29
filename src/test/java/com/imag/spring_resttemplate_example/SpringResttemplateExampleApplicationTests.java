package com.imag.spring_resttemplate_example;

import com.imag.spring_resttemplate_example.model.request.AccountAPIClient;
import com.imag.spring_resttemplate_example.model.request.AccountInformationDTO;
import com.imag.spring_resttemplate_example.model.request.ProfileAPIClient;
import com.imag.spring_resttemplate_example.model.request.ProfileProperties;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
class SpringResttemplateExampleApplicationTests {

    @Autowired
    private AccountAPIClient accountAPIClient;
    private static MockWebServer mockWebServer;

    private RestTemplate restTemplate;
    private MockRestServiceServer mockServer;
    private ProfileProperties profileProperties;
    private ProfileAPIClient profileClient;
    private String masterdatacrossreferenceURL;


    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
        masterdatacrossreferenceURL = "https://masterdatacrossreferenceservices-tst.nonprod.jbhunt.com";
        profileProperties = new ProfileProperties();
        profileProperties.setMasterdatacrossreferenceURL(masterdatacrossreferenceURL);
        profileClient = new ProfileAPIClient(restTemplate, profileProperties);
        accountAPIClient = new AccountAPIClient(restTemplate);
    }

    @Test
    public void fetchAccountInformationTest() {
        AccountInformationDTO accountInformationDTO = new AccountInformationDTO();
        accountInformationDTO.setCustomerCode("GECAAK");
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody("{\"customerCode\":\"GECAAK\"}");
        mockWebServer.enqueue(mockResponse);
        AccountInformationDTO response = accountAPIClient.fetchAccountInformation(123);
        assertNotNull(response);
    }

    @Test
    public void findBusinessSiteIdsByCustomerIdTest() throws Exception {
        String url = profileProperties.getMasterdatacrossreferenceURL() + "/masterdatacrossreferenceservices/crossreference/fetchcrossreferences/Organization/OrganizationID/1";
        String response = "[{\"cciEntityFirstColumnName\": \"JBH\"}]";
        mockServer.expect(requestTo(url)).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));
        List<?> actual = profileClient.findBusinessSiteIdsByCustomerId(1);
        assertNotNull(actual.stream().findFirst().get());
        mockServer.verify();
    }


}
