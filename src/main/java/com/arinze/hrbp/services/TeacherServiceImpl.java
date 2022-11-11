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
    private String a1_subjects;
    @Value("${a2_subjects}")
    private String a2_subjects;
    @Value("${b1_subjects}")
    private String b1_subjects;
    @Value("${b2_subjects}")
    private String b2_subjects;

    @Override
    public Response get_student_score(String name, String term, String studentClass, String subject) {
        studentClass = studentClass.toLowerCase();
        Response response = new Response();
        subject=subject.toLowerCase();
        switch (studentClass) {
            case ("a1") -> {
                Optional<A1> data = a1.findByFullnameAndTermAndSubject(name, term, subject);
                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    A1 data2 = data.get();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    response.setContent(studentResponseDto.toString());
                    return response;
                }
            }
            case ("a2") -> {
                Optional<A2> data = a2.findByFullnameAndTermAndSubject(name, term, subject);

                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    A2 data2 = data.get();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    response.setContent(studentResponseDto.toString());
                    return response;
                }

            }
            case ("b1") -> {
                Optional<B1> data = b1.findByFullnameAndTermAndSubject(name, term, subject);

                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    B1 data2 = data.get();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    response.setContent(studentResponseDto.toString());
                    return response;
                }
            }
            case ("b2") -> {
                Optional<B2> data = b2.findByFullnameAndTermAndSubject(name, term, subject);
                if (data.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");

                } else {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    B2 data2 = data.get();
                    studentResponseDto.setName(data2.getFullname());
                    studentResponseDto.setScore(data2.getScore());
                    studentResponseDto.setSubject(data2.getSubject());
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully");
                    response.setContent(studentResponseDto.toString());
                    return response;


                }

            }
            default -> {
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage("Operation not successful");
                response.setContent("Student data does not exist, please crosscheck your input and try again");
            }
        }


        return response;
    }


    @Override
    public Response get_all_student_score(String name, String studentclass, String term) {

        studentclass = studentclass.toLowerCase();
        Response response = new Response();
        switch (studentclass) {
            case ("a1") -> {
                Optional<A1> studentData = a1.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");
                }
                else  {
                    List<A1> data = (List<A1>) studentData.get();
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < data.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += data.get(i).getScore();
                        studentResponseDto.setName(data.get(i).getFullname());
                        studentResponseDto.setScore(data.get(i).getScore());
                        studentResponseDto.setSubject(data.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / data.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2.toString());
                    return response;
                }

            }
            case ("a2") -> {
                Optional<A2> studentData = a2.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");
                }
                else {
                    List<A2> data = (List<A2>) studentData.get();
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < data.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += data.get(i).getScore();
                        studentResponseDto.setName(data.get(i).getFullname());
                        studentResponseDto.setScore(data.get(i).getScore());
                        studentResponseDto.setSubject(data.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / data.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2.toString());
                    return response;
                }


            }
            case ("b1") -> {
                Optional<B1> studentData = b1.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");
                }
                else{
                    List<B1> data = (List<B1>) studentData.get();
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < data.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += data.get(i).getScore();
                        studentResponseDto.setName(data.get(i).getFullname());
                        studentResponseDto.setScore(data.get(i).getScore());
                        studentResponseDto.setSubject(data.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / data.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2.toString());
                    return response;
                }

            }
            case ("b2") -> {
                Optional<B2> studentData = b2.findByFullnameAndTerm(name, term);
                if (studentData.isEmpty()) {
                    response.setCode(HttpStatus.BAD_REQUEST);
                    response.setMessage("Operation not successful");
                    response.setContent("Student data does not exist, please crosscheck your input and try again");

                }
                else{
                    List<B2> data = (List<B2>) studentData.get();
                    List<StudentResponseDto> data2 = new ArrayList<>();
                    Double avg = 0.0;
                    for (int i = 0; i < data.size(); i++) {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        avg += data.get(i).getScore();
                        studentResponseDto.setName(data.get(i).getFullname());
                        studentResponseDto.setScore(data.get(i).getScore());
                        studentResponseDto.setSubject(data.get(i).getSubject());
                        data2.add(studentResponseDto);
                    }
                    avg = avg / data.size();
                    response.setCode(HttpStatus.ACCEPTED);
                    response.setMessage("Operation performed successfully Student has an average score of " + avg);
                    response.setContent(data2.toString());
                    return response;
                }
            }
            default -> {
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage("Operation not successful");
                response.setContent("Student data does not exist, please crosscheck your input and try again");
                return response;

            }
        }
        return response;
    }

    @Override
    public Response add_student_score(String name, String studentClass, Double score, String subject, String term) {

        A1 class_a1 = new A1();
        A2 class_a2 = new A2();
        B1 class_b1 = new B1();
        B2 class_b2 = new B2();
        Response response = new Response();
        studentClass=studentClass.toLowerCase();
        subject=subject.toLowerCase();
        switch (studentClass) {
            case ("a1") -> {
                if (!a1_subjects.toLowerCase().contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Class A1 does not offer this subject");
                    return response;
                }

                if(score<0 && score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because score is invalid");
                    return response;
                }
                Optional<A1> a1scoreExist = a1.findByFullnameAndTermAndSubject(name, term, subject);
                if (a1scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Student score has already been added before now");
                    return response;
                }
                List<A1> all = a1.findBySubjectAndTerm(subject, term);
                if (all.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Students in class A1 has reached it's maximum capacity");
                    return response;
                }
                class_a1.setFullname(name);
                class_a1.setScore(score);
                class_a1.setTerm(term);
                class_a1.setSubject(subject);
                a1.save(class_a1);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Operation performed successfully");
                response.setContent("Student score added successfully");
                return response;
            }
            case ("a2") -> {
                if (!a2_subjects.toLowerCase().contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Class A2 does not offer this subject");
                    return response;
                }

                if(score<0 && score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because score is invalid");
                    return response;
                }

                Optional<A2> a2scoreExist = a2.findByFullnameAndTermAndSubject(name, term, subject);
                if (a2scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Student score has already been added before now");
                    return response;
                }
                List<A2> alla2 = a2.findBySubjectAndTerm(subject, term);
                if (alla2.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Students in class A2 has reached it's maximum capacity");
                    return response;
                }
                class_a2.setFullname(name);
                class_a2.setScore(score);
                class_a2.setTerm(term);
                class_a2.setSubject(subject);
                a2.save(class_a2);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Operation performed successfully");
                response.setContent("Student score added successfully");
                return response;
            }
            case ("b1") -> {
                if (!b1_subjects.toLowerCase().contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Class B1 does not offer this subject");
                    return response;
                }

                if(score<0 && score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because score is invalid");
                    return response;
                }

                Optional<B1> b1scoreExist = b1.findByFullnameAndTermAndSubject(name, term, subject);
                if (b1scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Student score has already been added before now");
                    return response;
                }
                List<B1> allb1 = b1.findBySubjectAndTerm(subject, term);
                if (allb1.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Students in class B1 has reached it's maximum capacity");
                    return response;
                }
                class_b1.setFullname(name);
                class_b1.setScore(score);
                class_b1.setTerm(term);
                class_b1.setSubject(subject);
                b1.save(class_b1);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Operation performed successfully");
                response.setContent("Student score added successfully");
                return response;
            }
            case ("b2") -> {
                if (!b2_subjects.toLowerCase().contains(subject.toLowerCase())) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Class B2 does not offer this subject");
                    return response;
                }

                if(score<0 && score>100){
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because score is invalid");
                    return response;
                }

                Optional<B2> b2scoreExist = b2.findByFullnameAndTermAndSubject(name, term, subject);
                if (b2scoreExist.isPresent()) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Student score has already been added before now");
                    return response;
                }
                List<B2> allb2 = b2.findBySubjectAndTerm(subject, term);
                if (allb2.size() >= 10) {
                    response.setCode(HttpStatus.FORBIDDEN);
                    response.setMessage("Operation could not be performed");
                    response.setContent("Could not add Student score because Students in class B2 has reached it's maximum capacity");
                    return response;
                }
                class_b2.setFullname(name);
                class_b2.setScore(score);
                class_b2.setTerm(term);
                class_b2.setSubject(subject);
                b2.save(class_b2);
                response.setCode(HttpStatus.ACCEPTED);
                response.setMessage("Operation performed successfully");
                response.setContent("Student score added successfully");
                return response;
            }
            default -> {
                response.setCode(HttpStatus.FORBIDDEN);
                response.setMessage("Operation could not be performed");
                response.setContent("Class does not exist");
                return response;
            }
        }


    }
}
