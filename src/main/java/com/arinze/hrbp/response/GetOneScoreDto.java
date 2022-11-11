package com.arinze.hrbp.response;

import lombok.Data;

@Data
public class GetOneScoreDto {
    private String fullName;
    private String term;
    private String studentClass;
    private String subject;
}
