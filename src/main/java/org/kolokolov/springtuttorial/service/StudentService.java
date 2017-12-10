package org.kolokolov.springtuttorial.service;

import org.kolokolov.springtuttorial.model.StudGroup;
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
        StudGroup epa02 = new StudGroup(GroupTitle.EPA, "02",Arrays.asList(
                new Student("Алексей Колоколов"),
                new Student("Сергей Мелецеий")
        ));
        groupRepository.save(epa02);
    }

    public List<StudGroup> getAllGroups() {
        return groupRepository.findAll();
    }
}
