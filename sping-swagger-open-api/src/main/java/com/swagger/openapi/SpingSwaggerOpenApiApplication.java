package com.swagger.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;

//import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class SpingSwaggerOpenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingSwaggerOpenApiApplication.class, args);
	}

//	 @Bean
//	    public OpenAPI customOpenAPI() {
//	        return new OpenAPI()
//	                .info(getInfo());
//	    }
//	 
//	  private Info getInfo() {
//	        return new Info()
//	                .title("spring-swagger-open-api-test")
//	                .description("Test example")
//	                .version("8082")
//	                .license(getLicense());
//	    }
//	  
//	  private License getLicense() {
//	        return new License()
//	                .name("testLicence")
//	                .url("https://testLicence.org/");
//	    }
}
