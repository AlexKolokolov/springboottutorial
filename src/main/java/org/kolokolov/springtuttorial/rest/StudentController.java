package org.kolokolov.springtuttorial.rest;

import org.kolokolov.springtuttorial.model.StudGroup;
import org.kolokolov.springtuttorial.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("groups")
    public List<StudGroup> getAllGroups() {
        return studentService.getAllGroups();
    }
}
