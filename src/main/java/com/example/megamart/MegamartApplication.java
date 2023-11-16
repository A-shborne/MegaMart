package com.example.megamart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.Controller","com.example.DTO","com.example.Entity","com.example.Repository","com.example.Service","com.example.Utility"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example.Repository")
@EntityScan(basePackages = "com.example.Entity")
public class MegamartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegamartApplication.class, args);
	}

}
