package com.adeesha.loans_microservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "EazyBank Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Adeesha Gunawardana",
						email = "adeesha.ag@gmail.com",
						url = "https://adeegithub.github.io/my-portfolio/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://adeegithub.github.io/my-portfolio/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Loans microservice REST API Documentation",
				url = "http://localhost:8090/swagger-ui/index.html#/accounts-controller/"
		)
)
public class LoansMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansMicroserviceApplication.class, args);
	}

}
