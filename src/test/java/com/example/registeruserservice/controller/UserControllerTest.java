package com.example.registeruserservice.controller;

import com.example.registeruserservice.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test_addUser() throws Exception {
        {
            User user1 = new User("userTest",
                    new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime(),
                    "england");

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(user1))).andReturn();

            assertEquals(400, result.getResponse().getStatus());
            assertEquals("Not a france residence", result.getResponse().getContentAsString());
        }

        {
            User user1 = new User("userTest",
                    new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime(),
                    "france");

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(user1))).andReturn();

            assertEquals(400, result.getResponse().getStatus());
            assertEquals("Not an adult", result.getResponse().getContentAsString());
        }
    }

    @Test
    public void test_findUserById() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/employees/{id}", 10)
                .contentType("application/json"))
                .andReturn();

        assertEquals(404, result.getResponse().getStatus());
    }
}
