package org.kolokolov.springboottutorial.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kolokolov.springtuttorial.Application;
import org.kolokolov.springtuttorial.model.Group;
import org.kolokolov.springtuttorial.model.GroupTitle;
import org.kolokolov.springtuttorial.rest.StudentController;
import org.kolokolov.springtuttorial.security.SecurityConfig;
import org.kolokolov.springtuttorial.service.StudentService;
import org.mockito.BDDMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ContextConfiguration(classes={Application.class, SecurityConfig.class})
public class StudentControllerTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<Group> groups = Arrays.asList(
            new Group(1L, GroupTitle.EPA, "01", null)
    );

    private final String resultJSON = "[{\"id\":1,\"title\":\"EPA\",\"year\":\"01\",\"students\":null}]";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testSignIn() throws Exception {
        mvc.perform(formLogin("/login").user("user").password("user")).andExpect(authenticated());
    }

    @Test
    public void testFailedSignIn() throws Exception {
        mvc.perform(formLogin("/login").user("user").password("wrongPassword")).andExpect(unauthenticated());
    }

    @Test
    public void testRoot() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void testGetAllGroups() throws Exception {
        mvc.perform(get("/rest/groups")).andExpect(status().is3xxRedirection());
    }

    @Test
    public void testGetAllGroupsWithCookie() throws Exception {
        BDDMockito.given(studentService.getAllGroups()).willReturn(groups);
        MvcResult res = mvc.perform(formLogin("/login").user("user").password("user")).andReturn();
        MockHttpSession session = (MockHttpSession) res.getRequest().getSession();
        mvc.perform(get("/rest/groups").session(session))
                .andExpect(status().isOk()).andExpect(content().json(resultJSON));
    }
}
