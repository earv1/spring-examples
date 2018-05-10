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

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ExamplesApplication.class, TestCriminalDatabase.class})
@WebAppConfiguration
@ActiveProfiles("test")



//Again, 30 minutes to complete the following.
//Look at BatmanTest.java in example3. This is similar to the old way of testing.
//Think about why we would want to startup spring in this example wheras BatmanTest.java seems to work just fine.
//Also familiarise yourself between the difference between a unit test and an Integration test.
//BatmanTest.java is an example of a unit test whereas BatmanIntegrationTest.java is also a unit test but
// might be considered an integration test because of its reliance on spring.

//Move the BatmanCriminalDatabase to the com.learning.examples.application. Did it work?
//Why or why not?

//Change the active profile to newtest and run the test, what happens?
//Now change the TestCriminalDatabse to newtest and run it again. These are how profiles work. It's that easy
//Finally copy this test and make it run with a new profile called test2
//Copy TestCriminalDatabase to TestCriminalDatabase2 and run the profile
public class BatmanIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void beforeEach(){
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void fightCrime() throws Exception {
        mockMvc.perform(get("/fightcrime"))
                .andExpect(status().isOk());
    }
}

