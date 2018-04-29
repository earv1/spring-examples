package com.learning;

import java.util.concurrent.TimeUnit;

public class BatmanCriminalDatabase implements CriminalDatabase {

    public String fetchInformation(String criminalName) {
        //Yes, in real life batman would use a real database
        try {
            TimeUnit.SECONDS.sleep(10);
            return criminalName + " needs to be stopped!";
        } catch (InterruptedException e) {
            throw new RuntimeException("The Joker has Struck Again!");
        }
    }
}
