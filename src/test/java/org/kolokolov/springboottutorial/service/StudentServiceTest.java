package org.kolokolov.springboottutorial.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kolokolov.springboottuttorial.Application;
import org.kolokolov.springboottuttorial.model.Group;
import org.kolokolov.springboottuttorial.model.GroupTitle;
import org.kolokolov.springboottutorial.testutils.TestUtils;
import org.kolokolov.springboottuttorial.repository.GroupRepository;
import org.kolokolov.springboottuttorial.service.StudentServiceImpl;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StudentServiceTest extends TestUtils {

    @MockBean
    private GroupRepository groupRepository;

    @Autowired
    private StudentServiceImpl studentService;

    private void initMockRepo() {
        BDDMockito.when(groupRepository.findGroupsByTitle(GroupTitle.EPA)).thenReturn(groups);
        BDDMockito.when(groupRepository.findAll()).thenReturn(groups);
        BDDMockito.when(groupRepository.findGroupsByTitle(GroupTitle.TGPV)).thenReturn(Collections.emptyList());
        BDDMockito.when(groupRepository.findOne(1L)).thenReturn(group);
    }

    @Before
    public void initGroupRepository() {
        initMockRepo();
    }

    @Test
    public void testGetGroupsByTitle() {
        List<Group> result = studentService.getGroupsByTitle(GroupTitle.EPA);
        assertEquals(groups,result);
    }

    @Test
    public void testGetNonexistentGroupsByTitle() {
        List<Group> result = studentService.getGroupsByTitle(GroupTitle.TGPV);
        assertEquals(Collections.emptyList(),result);
    }

    @Test
    public void testGetGroupById() {
        Group result = studentService.getGroupById(1L);
        assertEquals(group, result);
    }

    @Test
    public void testGetAllGroups() {
        List<Group> result = studentService.getAllGroups();
        assertEquals(groups, result);
    }
}