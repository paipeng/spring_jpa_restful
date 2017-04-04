package com.paipeng.spring_jpa_restful.controller;

import com.paipeng.spring_jpa_restful.dao.entity.Teacher;
import com.paipeng.spring_jpa_restful.dao.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paipeng on 27/03/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/teachers")
public class TeacherController extends BaseController {
    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public Teacher getById(@PathVariable("id") Long id) {
        Teacher teacher = teacherRepository.findOne(id);
        if (teacher == null) {
            log.info("此id:" + id + "没有批次记录");
            setHttpResponseStatus(404);
            return null;
        } else {
            return teacher;
        }
    }

    @RequestMapping(produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<Teacher> getById() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }


    @RequestMapping(produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Teacher post(@RequestBody Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }


    @RequestMapping(produces = {"application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public Teacher put(@RequestBody Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findOne(teacher.getId());
        if (oldTeacher != null) {
            return teacherRepository.saveAndFlush(teacher);
        } else {
            log.info("此id:"  + "没有批次记录");
            setHttpResponseStatus(404);
            return null;
        }
    }

    @RequestMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        try {
            teacherRepository.delete(id);
            return;
        } catch (Exception e) {
            setHttpResponseStatus(404);
            return;
        }
    }
}
