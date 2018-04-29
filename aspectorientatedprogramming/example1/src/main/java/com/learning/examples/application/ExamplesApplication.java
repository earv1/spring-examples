package com.learning.examples.application;

import com.learning.examples.libraries.CriminalDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {
		"com.learning.examples.libraries",
		"com.learning.examples.rest",
		"com.learning.examples.aspects"
})
//Configures spring based on the jars added
@EnableAutoConfiguration
//@Profile("live")
public class ExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplesApplication.class, args);
	}
}
