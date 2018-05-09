package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

//TODO 30 minutes
//Create a new more efficient criminal Database(note that in BatmanCriminalDatabase there is a timeout

//Dependency inject solvecrime in Batman.java

//Create a Nemesis class, inject the Nemesis class into the Batman class
//and follow the instructions in the speakToChiefOfPolice method in the Batman Class
//Bonus points of Nemesis is an interface or abstract class and you inject something
//that inherets from it. HINT, the CriminalDatabase works like this

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

