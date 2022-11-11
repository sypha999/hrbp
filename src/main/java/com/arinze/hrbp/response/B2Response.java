package com.arinze.hrbp.response;

import com.arinze.hrbp.models.B2;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class B2Response {
    private HttpStatus code;
    private String message;
    private List<B2> content;

}
