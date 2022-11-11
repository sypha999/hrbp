package com.arinze.hrbp.response;

import com.arinze.hrbp.models.A2;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class A2Response {
    private HttpStatus code;
    private String message;
    private List<A2> content;

}
