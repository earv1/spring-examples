package com.learning.examples.libraries;

import com.learning.examples.application.ExamplesApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//30 minutes for the following exercises and questions.

//Notice the BeforeEach,  what does it do?

//Notice the MockMvc section. Research what mocking is and why we would use it.
//Don't spend more than 10 minutes on this section, we will come back to it later.
//The point is to get more comfortable with researching things you don't understand.

//Run 'mvn -Dtest=BatmanIntegrationTest test' in the aspectorientatedprogramming/example1 folder.
//You shoiuld see, 'Wow Alfred, good job on the new surveillance system'
//Try to figure out how it was done
//Add something to after the method executes once you have figured out how



//You can continue with the following if you are done. You will have another 30 minutes
//after I explain the above

//Create a class called LockdownAspect
//Make it exit before the method executes using System.exit(1)
//Run this test again and see what happens

//Make your aspect only call system.exit after the test runs. What happened?
//Now make it throw a RuntimeException instead



@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ExamplesApplication.class, TestCriminalDatabase.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class BatmanIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void beforeEach(){
        throws Runtime
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void fightCrime() throws Exception {
        mockMvc.perform(get("/fightcrime"))
                .andExpect(status().isOk());
    }
}

