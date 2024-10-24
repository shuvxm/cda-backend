package org.jsp.cda.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        Server localhost = new Server();
        localhost.setUrl("http://localhost:8080");
        localhost.setDescription("Development environment");
        Contact contact = new Contact();
        contact.setEmail("kumarshubham5559@gmail.com");
        contact.setName("College Directory Application");
        contact.setUrl("http://localhost:8080");
        License mitLicense = new License().name("MIT License").url("https://localhost:8080");
        Info info = new Info().title("College Directory Application").version("1.0")
                .contact(contact).description("This API exposes endpoints to manage Application.")
                .termsOfService("http://localhost:8080").license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(localhost));
    }

}