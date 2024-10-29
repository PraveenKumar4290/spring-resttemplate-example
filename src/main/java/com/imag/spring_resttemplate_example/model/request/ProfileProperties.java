package com.imag.spring_resttemplate_example.model.request;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("profile")
public class ProfileProperties {

    private String masterdatacrossreferenceURL;
    private String profilePartyServiceHostName;
    private String profileContactServiceHostName;
    private int profileClientConnectionMaxTotal;
    private int profileClientConnectionMaxTotalPerRoute;
    private int profileClientConnectionDefaultMaxTotalPerRoute;

}