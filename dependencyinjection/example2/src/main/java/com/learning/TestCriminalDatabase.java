package com.learning;

import java.util.concurrent.TimeUnit;

public class TestCriminalDatabase implements CriminalDatabase {

    public String fetchInformation(String criminalName) {
            //No timeout because this would be faster with a stub
            return criminalName + " needs to be stopped!";
    }
}
