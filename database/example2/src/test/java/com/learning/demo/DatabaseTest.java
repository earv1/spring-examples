package com.learning.demo;

import com.google.common.collect.ImmutableList;
import com.learning.demo.rest.CriminalsController;
import com.learning.demo.model.Criminal;
import com.learning.demo.repository.CriminalsRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {CriminalsController.class, DemoApplication.class})
@WebAppConfiguration
@ContextConfiguration(classes = DemoApplication.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//TODO
/* Exercises */
/*
    Look at CriminalsJDBCRepository.java


 */
public class DatabaseTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    CriminalsRepository CriminalsRepository;


    @BeforeAll
    void beforeAll(){
    }

    //Ignore this for now. Just know we are loading the database with information
    @BeforeEach
    void beforeEach(){
        List<Criminal> Criminals = ImmutableList.<Criminal>builder()
                .add(new Criminal("the joker", "gotham"))
                .add(new Criminal("the riddler", "gotham"))
                .add(new Criminal("that guy with out 'the' in his name", "somewhere"))
                .add(new Criminal("thanos", "marvel universe"))
                .build();
        CriminalsRepository.saveAll(Criminals);
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void checkJokerExists() throws Exception {
        ResultActions resultActions =  mockMvc.perform(get("/database/api/Criminals/name/joker"));
        resultActions.andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();

        assertTrue(response.contains("\"name\":\"the joker\""));
    }
}
