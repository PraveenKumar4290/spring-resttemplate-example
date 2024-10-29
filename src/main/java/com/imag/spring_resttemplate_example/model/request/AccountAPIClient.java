package com.imag.spring_resttemplate_example.model.request;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AccountAPIClient {

    private final RestTemplate accountAPIWebClient;

    public AccountAPIClient(RestTemplate accountAPIWebClient) {
        this.accountAPIWebClient = accountAPIWebClient;
    }


    public AccountInformationDTO fetchAccountInformation(Integer partyID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.ALL);
        headers.setAccept(List.of(MediaType.ALL));
       return accountAPIWebClient.exchange("account/accounts/" + partyID + "/accountinformations", HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<AccountInformationDTO>() {
        }).getBody();
    }
}
