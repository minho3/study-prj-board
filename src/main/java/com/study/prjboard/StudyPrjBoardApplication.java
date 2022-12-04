package com.study.prjboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class StudyPrjBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyPrjBoardApplication.class, args);
	}

}
