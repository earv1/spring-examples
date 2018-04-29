package com.learning.examples.libraries;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestCriminalDatabase implements CriminalDatabase{

    boolean informationFetched = false;

    public String fetchInformation(String criminalName) {
        informationFetched = true;
        return "test information";
    }
}
