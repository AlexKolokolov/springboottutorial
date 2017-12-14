package org.kolokolov.springboottuttorial.service;

import org.kolokolov.springboottuttorial.model.Group;
import org.kolokolov.springboottuttorial.model.GroupTitle;
import org.kolokolov.springboottuttorial.model.Student;
import org.kolokolov.springboottuttorial.repository.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private GroupRepository groupRepository;

    public StudentServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        createGroups();
    }

    private void createGroups() {
        Group epa02 = new Group(GroupTitle.EPA, "02",Arrays.asList(
                new Student("Алексей Колоколов"),
                new Student("Сергей Мелецкий")
        ));
        groupRepository.save(epa02);
        Group epa03 = new Group(GroupTitle.EPA, "03",null);
        groupRepository.save(epa03);
        Group epa06 = new Group(GroupTitle.EPA, "06",Arrays.asList(
                new Student("Алексей Кравченко"),
                new Student("Николай Чалый")
        ));
        groupRepository.save(epa06);
        Group tgpv03 = new Group(GroupTitle.TGPV, "03",Arrays.asList(
                new Student("Марина Пыжик"),
                new Student("Анна Кацило")
        ));
        groupRepository.save(tgpv03);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(long id) {
        Group group = groupRepository.findOne(id);
        logger.debug("Group found : {}",group);
        return group;
    }

    @Override
    public List<Group> getGroupsByTitle(GroupTitle title) {
        logger.debug("Trying to find groups by title : {}", title);
        List<Group> groups = groupRepository.findGroupsByTitle(title);
        logger.debug("Groups found : {}",groups);
        return groups;
    }
}
