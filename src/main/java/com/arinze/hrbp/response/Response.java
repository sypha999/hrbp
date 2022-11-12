package com.arinze.hrbp.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class Response<T> {
    private HttpStatus code;
    private String message;
    private List<T> content;

}
