package com.arinze.hrbp.services;

import com.arinze.hrbp.response.Response;


public interface TeacherServices {

    Response get_student_score(String name, String term, String studentClass, String subject);

    Response get_all_student_score(String name, String studentClass, String term);

    Response add_student_score(String name, String studentClass,Double score, String subject, String term);

}
