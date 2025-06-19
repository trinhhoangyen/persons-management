package com.example.persons_management.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Person Management API")
                        .version("0.0.1")
                        .description("RESTful API for managing personal data, including creation, update, retrieval, and deletion of person records."));
    }
}
