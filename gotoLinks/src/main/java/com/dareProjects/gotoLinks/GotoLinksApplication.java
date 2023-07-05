package com.dareProjects.gotoLinks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GotoLinksApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotoLinksApplication.class, args);
		
		System.out.println("Application has successfully started.");
	}

}
