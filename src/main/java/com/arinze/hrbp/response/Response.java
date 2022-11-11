package com.arinze.hrbp.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;

@Data
public class Response {
    private HttpStatus code;
    private String message;
    private String content;

}
