package com.arinze.hrbp.response;

import com.arinze.hrbp.models.A1;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class A1Response {
    private HttpStatus code;
    private String message;
    private List<A1> content;

}
