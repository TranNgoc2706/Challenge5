package com.example.demo.Config;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI openapi() {
        return new OpenAPI()
                .info(new Info().title("API Documentation :OOOO ").description("API Documentation Description :VVVVVV "))
                .servers(List.of(new Server().url("http://localhost:8080")))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))
                )
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .paths(new Paths()
                        .addPathItem("/api/auth/login", new PathItem()
                                .post(new Operation()
                                        .summary("Login")
                                        .responses(new ApiResponses().addApiResponse("200", new ApiResponse().description("Successful login")))
                                        .security(new ArrayList<>())) // Không yêu cầu xác thực cho endpoint này
                        )
                );
    }
    @Bean
    public GroupedOpenApi groupOpenApi() {
        return GroupedOpenApi.builder()
                .group(":))))")
                .packagesToScan("com.example.demo")
                .build();
    }
}