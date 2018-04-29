package com.learning.examples.libraries;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BatmanTest {

    private TestCriminalDatabase testCriminalDatabase;

    @BeforeEach
    void beforeEach(){
        testCriminalDatabase = new TestCriminalDatabase();
    }

    @Test
    void fightCrimeTest() {
        Batman batman = new Batman(testCriminalDatabase);
        assertEquals(batman.getCrimesSolved(), 0, "crimesSolved must be 0");
        batman.fightCrime(Batman.BroodLevel.Low);
        assertEquals(batman.getCrimesSolved(), 1, "crimesSolved must be 1");
        assertTrue(testCriminalDatabase.informationFetched, "the information must be fetched");
    }
}

