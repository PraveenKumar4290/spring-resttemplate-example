package com.imag.spring_resttemplate_example.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {

    private Integer userId;
    private String title;
    private String body;
}
