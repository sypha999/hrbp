package com.arinze.hrbp.services;

import com.arinze.hrbp.models.A1;
import com.arinze.hrbp.models.A2;
import com.arinze.hrbp.models.B1;
import com.arinze.hrbp.models.B2;
import com.arinze.hrbp.repositories.a1repository;
import com.arinze.hrbp.repositories.a2repository;
import com.arinze.hrbp.repositories.b1repository;
import com.arinze.hrbp.repositories.b2repository;
import com.arinze.hrbp.response.Response;
import com.arinze.hrbp.response.StudentResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TeacherServiceImpl implements TeacherServices{

    final a1repository a1;
    final a2repository a2;
    final b1repository b1;
    final b2repository b2;

    public TeacherServiceImpl(a1repository a1, a2repository a2, b1repository b1, b2repository b2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;

    }
    @Value("${a1_subjects}")
    private String a1_sub;
    @Value("${a2_subjects}")
    private String a2_sub;
    @Value("${b1_subjects}")
    private String b1_sub;
    @Value("${b2_subjects}")
    private String b2_sub;


    @Override
    public Response get_student_score(String name, String term, String studentClass, String subject) {
        studentClass = studentClass.toLowerCase();
        term = term.toLowerCase();
        name = name.toLowerCase();
        Response response = new Response();
        subject=subject.toLowerCase();
        switch (studentClass) {
            case ("a1") -> {
                Optional<A1> data = a1.findByFullnameAndTermAndSubject(name, term, subject);
                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    A1 data2 = data.get();
                    List<StudentResponseDto>data3 = new ArrayList<>();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    data3.add(studentResponseDto);
                    response.setContent(data3);
                    return response;
                }
            }
            case ("a2") -> {
                Optional<A2> data = a2.findByFullnameAndTermAndSubject(name, term, subject);

                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    A2 data2 = data.get();
                    List<StudentResponseDto>data3 = new ArrayList<>();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    data3.add(studentResponseDto);
                    response.setContent(data3);
                    return response;
                }

            }
            case ("b1") -> {
                Optional<B1> data = b1.findByFullnameAndTermAndSubject(name, term, subject);

                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    B1 data2 = data.get();
                    List<StudentResponseDto>data3 = new ArrayList<>();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    data3.add(studentResponseDto);
                    response.setContent(data3);
                    return response;
                }
            }
            case ("b2") -> {
                Optional<B2> data = b2.findByFullnameAndTermAndSubject(name, term, subject);
                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    B2 data2 = data.get();
                    List<StudentResponseDto>data3 = new ArrayList<>();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    data3.add(studentResponseDto);
                    response.setContent(data3);
                    return response;


                }

            }
            default -> {
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage("Student data does not exist, please crosscheck your input and try again");
                response.setContent(null);
            }
        }


        return response;
    }


    @Override
    public Response get_all_student_score(String name, String studentclass, String term) {
        studentclass = studentclass.toLowerCase();
        term = term.toLowerCase();
        name = name.toLowerCase();
        Response response = new Response();
        switch (studentclass) {
            case ("a1") -> {
                List<A1> studentData = a1.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);
                }
                else  {

                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < studentData.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += studentData.get(i).getScore();
                        studentResponseDto.setName(studentData.get(i).getFullname());
                        studentResponseDto.setScore(studentData.get(i).getScore());
                        studentResponseDto.setSubject(studentData.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / studentData.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2);
                    return response;
                }

            }
            case ("a2") -> {
                List<A2> studentData = a2.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);
                }
                else {
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < studentData.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += studentData.get(i).getScore();
                        studentResponseDto.setName(studentData.get(i).getFullname());
                        studentResponseDto.setScore(studentData.get(i).getScore());
                        studentResponseDto.setSubject(studentData.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / studentData.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2);
                    return response;
                }


            }
            case ("b1") -> {
                List <B1> studentData = b1.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);
                }
                else{
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < studentData.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += studentData.get(i).getScore();
                        studentResponseDto.setName(studentData.get(i).getFullname());
                        studentResponseDto.setScore(studentData.get(i).getScore());
                        studentResponseDto.setSubject(studentData.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / studentData.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2);
                    return response;
                }

            }
            case ("b2") -> {
                List <B2> studentData = b2.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Student data does not exist, please crosscheck your input and try again");
                    response.setContent(null);

                }
                else{
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < studentData.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += studentData.get(i).getScore();
                        studentResponseDto.setName(studentData.get(i).getFullname());
                        studentResponseDto.setScore(studentData.get(i).getScore());
                        studentResponseDto.setSubject(studentData.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / studentData.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2);
                    return response;
                }
            }
            default -> {
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage("Student data does not exist, please crosscheck your input and try again");
                response.setContent(null);
                return response;

            }
        }
        return response;
    }

    @Override
    public Response add_student_score(String name, String studentClass, Double score, String subject, String term) {

        Response response = new Response();
        studentClass=studentClass.toLowerCase();
        term = term.toLowerCase();
        name = name.toLowerCase();
        subject=subject.toLowerCase();
        switch (studentClass) {
            case ("a1") -> {
                List<String> a1_subjects = new ArrayList<>(Arrays.asList(a1_sub.split(",")));
                A1 class_a1 = new A1();
                if (!a1_subjects.contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Class A1 does not offer this subject");
                    response.setContent(null);
                    return response;
                }

                if(score<0 || score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because score is invalid");
                    response.setContent(null);
                    return response;
                }
                Optional<A1> a1scoreExist = a1.findByFullnameAndTermAndSubject(name, term, subject);
                if (a1scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Student score has already been added before now");
                    response.setContent(null);
                    return response;
                }
                List<A1> all = a1.findBySubjectAndTerm(subject, term);
                if (all.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Students in class A1 has reached it's maximum capacity");
                    response.setContent(null);
                    return response;
                }
                class_a1.setFullname(name);
                class_a1.setScore(score);
                class_a1.setTerm(term);
                class_a1.setSubject(subject);
                a1.save(class_a1);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Student score added successfully");
                response.setContent(null);
                return response;
            }
            case ("a2") -> {
                List<String> a2_subjects = new ArrayList<>(Arrays.asList(a2_sub.split(",")));
                A2 class_a2 = new A2();
                if (!a2_subjects.contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Class A2 does not offer this subject");
                    response.setContent(null);
                    return response;
                }
                if(score<0 || score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because score is invalid");
                    response.setContent(null);
                    return response;
                }

                Optional<A2> a2scoreExist = a2.findByFullnameAndTermAndSubject(name, term, subject);
                if (a2scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Student score has already been added before now");
                    response.setContent(null);
                    return response;
                }
                List<A2> alla2 = a2.findBySubjectAndTerm(subject, term);
                if (alla2.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Students in class A2 has reached it's maximum capacity");
                    response.setContent(null);
                    return response;
                }
                class_a2.setFullname(name);
                class_a2.setScore(score);
                class_a2.setTerm(term);
                class_a2.setSubject(subject);
                a2.save(class_a2);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Student score added successfully");
                response.setContent(null);
                return response;
            }
            case ("b1") -> {
                List<String> b1_subjects = new ArrayList<>(Arrays.asList(b1_sub.split(",")));
                B1 class_b1 = new B1();
                if (!b1_subjects.contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Class B1 does not offer this subject");
                    response.setContent(null);
                    return response;
                }

                if(score<0 || score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because score is invalid");
                    response.setContent(null);
                    return response;
                }

                Optional<B1> b1scoreExist = b1.findByFullnameAndTermAndSubject(name, term, subject);
                if (b1scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Student score has already been added before now");
                    response.setContent(null);
                    return response;
                }
                List<B1> allb1 = b1.findBySubjectAndTerm(subject, term);
                if (allb1.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Students in class B1 has reached it's maximum capacity");
                    response.setContent(null);
                    return response;
                }
                class_b1.setFullname(name);
                class_b1.setScore(score);
                class_b1.setTerm(term);
                class_b1.setSubject(subject);
                b1.save(class_b1);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Student score added successfully");
                response.setContent(null);
                return response;
            }
            case ("b2") -> {
                List<String> b2_subjects = new ArrayList<>(Arrays.asList(b2_sub.split(",")));
                B2 class_b2 = new B2();
                if (!b2_subjects.contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Class B2 does not offer this subject");
                    response.setContent(null);
                    return response;
                }

                if(score<0 || score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because score is invalid");
                    response.setContent(null);
                    return response;
                }

                Optional<B2> b2scoreExist = b2.findByFullnameAndTermAndSubject(name, term, subject);
                if (b2scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Student score has already been added before now");
                    response.setContent(null);
                    return response;
                }
                List<B2> allb2 = b2.findBySubjectAndTerm(subject, term);
                if (allb2.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Could not add Student score because Students in class B2 has reached it's maximum capacity");
                    response.setContent(null);
                    return response;
                }
                class_b2.setFullname(name);
                class_b2.setScore(score);
                class_b2.setTerm(term);
                class_b2.setSubject(subject);
                b2.save(class_b2);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Student score added successfully");
                response.setContent(null);
                return response;
            }
            default -> {
                response.setCode(HttpStatus.FORBIDDEN);
                response.setMessage("Class does not exist");
                response.setContent(null);
                return response;
            }
        }


    }
}
