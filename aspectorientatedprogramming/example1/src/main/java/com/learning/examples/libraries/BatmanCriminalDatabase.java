package com.learning.examples.libraries;

import java.util.concurrent.TimeUnit;

public class BatmanCriminalDatabase implements CriminalDatabase {

    public String fetchInformation(String criminalName) {
        //Yes, in real life batman would use a real database
        try {
            //Put in some optimisations and now it only takes 2 seconds !!!!
            TimeUnit.SECONDS.sleep(5);
            return criminalName + " needs to be stopped!";
        } catch (InterruptedException e) {
            throw new RuntimeException("The Joker has Struck Again!");
        }
    }
}
