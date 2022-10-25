package com.ecommerce.pim.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Satış Garanti Spring API Portal")
                        .description("Emrullah Durumlu & Tolga Güldütuna - Spring Project")
                        .version("1.0.0")
                );
    }

    @Bean
    GroupedOpenApi all() {
        return GroupedOpenApi.builder().group("all").pathsToMatch("/**/**").build();
    }

    @Bean
    GroupedOpenApi category() {
        return GroupedOpenApi.builder().group("category").pathsToMatch("/category/**").build();
    }

}
