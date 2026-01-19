package com.gayathri.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DocumentHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentHubApplication.class, args);
	}

}
