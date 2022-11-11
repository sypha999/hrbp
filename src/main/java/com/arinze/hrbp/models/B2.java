package com.arinze.hrbp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class B2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private String term;
    @Column(nullable = false)
    private String studentClass="b2";
    @Column(nullable = false)
    private Double score;
    @Column(nullable = false)
    private String subject;
}
