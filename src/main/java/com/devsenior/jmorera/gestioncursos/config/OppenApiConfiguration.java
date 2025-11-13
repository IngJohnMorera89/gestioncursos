package com.devsenior.jmorera.gestioncursos.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OppenApiConfiguration {

    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestion de Cursos Académicos")
                        .description("Sistema Completo de Gestión de cursos para una universidad")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Ing John Morera")
                                .email("johnmorera.89@gmail.com")
                                .url("http://johnmorera.com"))
                        .license(new License()
                                .name("MIT Licence")
                                .url("http:// opensource.org/licence/MIT"))

                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Entorno de Desarrollo"),
                        new Server().url("http://api.cursos.devsenior.com").description("Entorno de Producción")));

    }

}
