package com.arinze.hrbp.controller;

import com.arinze.hrbp.response.*;
import com.arinze.hrbp.services.TeacherServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class ResultController {

    final TeacherServiceImpl teacherService;
    public ResultController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/getOne")
    public Response getScore(@RequestBody GetOneScoreDto getOneScoreDto){
        return teacherService.get_student_score(getOneScoreDto.getFullName(), getOneScoreDto.getTerm(), getOneScoreDto.getStudentClass(), getOneScoreDto.getSubject());
    }

    @RequestMapping(path = "/add")
    public Response addScore(@RequestBody AddScoreDto addScoreDto)
    {
        return teacherService.add_student_score(addScoreDto.getFullName(), addScoreDto.getStudentClass(), addScoreDto.getScore(), addScoreDto.getSubject(), addScoreDto.getTerm());
    }

    @RequestMapping(path = "/getAll")
    public  Response getAll(@RequestBody GetAllScoreDto getAllScoreDto){
        return teacherService.get_all_student_score(getAllScoreDto.getFullName(),getAllScoreDto.getStudentClass(),getAllScoreDto.getTerm());
    }
}
