package com.personal.elkstack;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class ElkstackApplication {

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("/Users/anmolgupta/Downloads/elkstack/src/main/resources/application.properties");
		BasicConfigurator.configure();
		SpringApplication.run(ElkstackApplication.class, args);
	}

}
