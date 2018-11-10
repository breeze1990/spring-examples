package com.example.spring.web.validator;

import com.example.spring.web.RootConfig;
import com.example.spring.web.WebConfig;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
public class PersonValidatorControllerTest {
    private static final Logger LOG = LoggerFactory.getLogger(PersonValidatorControllerTest.class);

    private MockMvc mockMvc;

    private Gson gson = new Gson();

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private PersonValidator personValidator;

    @Autowired
    private PersonValidatorController controller;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void passFullName() throws Exception {
        Person person = Person.builder()
            .firstName("first")
            .lastName("last")
            .build();
        String personJson = gson.toJson(person);
        mockMvc
            .perform(post("/person/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
            .andExpect(status().isOk());
    }

    @Test
    public void failEmptyFirstName() throws Exception {
        Person p = Person.builder()
            .lastName("last")
            .build();
        String personJson = gson.toJson(p);
        mockMvc
            .perform(post("/person/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    public void failEmptylastName() throws Exception {
        Person p = Person.builder()
            .firstName("first")
            .build();
        String personJson = gson.toJson(p);
        mockMvc
            .perform(post("/person/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }
}
