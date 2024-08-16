package com.imag.spring_resttemplate_example.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostResponse {

    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
