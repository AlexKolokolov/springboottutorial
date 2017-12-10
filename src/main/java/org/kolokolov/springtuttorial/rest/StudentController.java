package org.kolokolov.springtuttorial.rest;

import org.kolokolov.springtuttorial.model.Group;
import org.kolokolov.springtuttorial.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("groups")
    public List<Group> getAllGroups() {
        logger.debug("Trying to fetch all groups");
        List<Group> groups = studentService.getAllGroups();
        logger.debug("Fetched groups : {}", groups);
        return groups;
    }
}
