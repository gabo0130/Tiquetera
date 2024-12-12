package com.group.tiquetera.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.group.tiquetera" } )
@EnableJpaRepositories(basePackages = "com.group.tiquetera.infrastructure.repository")
@OpenAPIDefinition(info = @Info(title = "Report API", version = "1.0", description = "Report API Process"))
public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

}
