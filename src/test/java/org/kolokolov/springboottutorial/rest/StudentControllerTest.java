package org.kolokolov.springboottutorial.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kolokolov.springboottuttorial.Application;
import org.kolokolov.springboottuttorial.rest.StudentController;
import org.kolokolov.springboottuttorial.security.SecurityConfig;
import org.kolokolov.springboottuttorial.service.StudentService;
import org.kolokolov.springboottutorial.testutils.TestConstants;
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

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ContextConfiguration(classes={Application.class, SecurityConfig.class})
public class StudentControllerTest implements TestConstants {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testSignIn() throws Exception {
        mvc.perform(formLogin("/login").user("user").password("user"))
                .andExpect(authenticated());
    }

    @Test
    public void testFailedSignIn() throws Exception {
        mvc.perform(formLogin("/login").user("user").password("wrongPassword"))
                .andExpect(unauthenticated());
    }

    @Test
    public void testRoot() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllGroups() throws Exception {
        mvc.perform(get("/rest/groups"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testGetAllGroupsWithCookie() throws Exception {
        BDDMockito.when(studentService.getAllGroups()).thenReturn(groups);
        String resultJSON = new ObjectMapper().writeValueAsString(groups);
        logger.debug("Expected JSON : {}",resultJSON);
        MvcResult res = mvc.perform(formLogin("/login").user("user").password("user")).andReturn();
        MockHttpSession session = (MockHttpSession) res.getRequest().getSession();
        mvc.perform(get("/rest/groups").session(session))
                .andExpect(status().isOk()).andExpect(content().json(resultJSON));
    }
}
