package com.imag.spring_resttemplate_example.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
