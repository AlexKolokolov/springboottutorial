package org.kolokolov.springtuttorial.rest;

import org.kolokolov.springtuttorial.model.Group;
import org.kolokolov.springtuttorial.model.GroupTitle;
import org.kolokolov.springtuttorial.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Group> getGroups(@RequestParam(required = false) GroupTitle title) {
        List<Group> groups;
        if (title == null) {
            logger.debug("Trying to fetch all groups");
            groups = studentService.getAllGroups();
            logger.debug("Fetched groups : {}", groups);
        } else {
            logger.debug("Trying to find groups by title: {}",title);
            groups = studentService.findGroupsByTitle(title);
            logger.debug("Fetched groups : {}", groups);
            return groups;
        }
        return groups;
    }

    @RequestMapping("groups/{id}")
    public Group getGroupById(@PathVariable long id) {
        logger.debug("Trying to find group by id: {}",id);
        Group group = studentService.findGroupById(id);
        logger.debug("Fetched group : {}", group);
        return group;
    }
}
