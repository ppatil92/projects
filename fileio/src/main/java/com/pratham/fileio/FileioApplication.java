package com.pratham.fileio;

import com.pratham.fileio.service.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FileioApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FileioApplication.class, args);
		context.getBean(FileService.class).processFile();
	}

}
