package com.imag.spring_resttemplate_example;

import com.imag.spring_resttemplate_example.model.request.BasicAuthInterceptor;
import com.imag.spring_resttemplate_example.model.request.ProfileProperties;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringResttemplateExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringResttemplateExampleApplication.class, args);
    }
    private ProfileProperties profileProperties;

    public SpringResttemplateExampleApplication(ProfileProperties profileProperties){
        this.profileProperties=profileProperties;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate profileRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingMessageconverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(mappingMessageconverter);
        Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
        restTemplate.getMessageConverters().add(jaxbMessageConverter);

        final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(profileProperties.getProfileClientConnectionMaxTotal());
        connManager.setDefaultMaxPerRoute(profileProperties.getProfileClientConnectionDefaultMaxTotalPerRoute());
        connManager.setMaxPerRoute(new HttpRoute(new HttpHost(profileProperties.getProfilePartyServiceHostName())),
                profileProperties.getProfileClientConnectionMaxTotalPerRoute());
        connManager.setMaxPerRoute(new HttpRoute(new HttpHost(profileProperties.getProfileContactServiceHostName())),
                profileProperties.getProfileClientConnectionMaxTotalPerRoute());

        BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor("username","password");
        restTemplate.getInterceptors().add(basicAuthInterceptor);

        final HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connManager).build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }
}
