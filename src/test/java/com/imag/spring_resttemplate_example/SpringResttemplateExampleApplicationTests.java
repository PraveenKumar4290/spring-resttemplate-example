package com.imag.spring_resttemplate_example;

import com.imag.spring_resttemplate_example.model.request.AccountAPIClient;
import com.imag.spring_resttemplate_example.model.request.AccountInformationDTO;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringResttemplateExampleApplicationTests {

	@Autowired
	private AccountAPIClient accountAPIClient;
	private static MockWebServer mockWebServer;

	@Test
	public void fetchAccountInformationTest() {
		AccountInformationDTO accountInformationDTO = new AccountInformationDTO();
		accountInformationDTO.setCustomerCode("GECAAK");
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(200)
				.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.setBody("{\"customerCode\":\"GECAAK\"}");
		mockWebServer.enqueue(mockResponse);
		AccountInformationDTO response = new AccountInformationDTO();
		assertNotNull(response);
	}

}
