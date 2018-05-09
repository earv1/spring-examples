package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BatmanTest {

    @Test
    void fightCrime() {
        TestCriminalDatabase testCriminalDatabase = new TestCriminalDatabase();
        Batman batman = new Batman(testCriminalDatabase);
        assertEquals(batman.getCrimesSolved(), 0, "crimesSolved must be 0");
        batman.fightCrime();
        assertEquals(batman.getCrimesSolved(), 1, "crimesSolved must be 1");
    }
}

