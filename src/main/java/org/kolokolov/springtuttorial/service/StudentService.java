package org.kolokolov.springtuttorial.service;

import org.kolokolov.springtuttorial.model.Group;
import org.kolokolov.springtuttorial.model.GroupTitle;
import org.kolokolov.springtuttorial.model.Student;
import org.kolokolov.springtuttorial.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final GroupRepository groupRepository;

    public StudentService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        createGroups();
    }

    public void createGroups() {
        Group epa02 = new Group(GroupTitle.EPA, "02",Arrays.asList(
                new Student("Алексей Колоколов"),
                new Student("Сергей Мелецкий")
        ));
        groupRepository.save(epa02);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
