package com.k0ft3.atman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = { "com.k0ft3.atman.infrastructure.file.local" })

@SpringBootApplication
public class ATManApplication {

	public static void main(String[] args) {
		SpringApplication.run(ATManApplication.class, args);

	}

}
