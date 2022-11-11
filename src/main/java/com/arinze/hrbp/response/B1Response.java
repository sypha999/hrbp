package com.arinze.hrbp.response;

import com.arinze.hrbp.models.B1;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class B1Response {
    private HttpStatus code;
    private String message;
    private List<B1> content;

}