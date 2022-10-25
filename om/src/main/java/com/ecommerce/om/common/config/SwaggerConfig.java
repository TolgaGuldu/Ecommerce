package com.ecommerce.om.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Ecommerce Spring API Portal")
                        .description("Tolga Güldütuna - Spring Project")
                        .version("1.0.0")
                );
    }

    @Bean
    GroupedOpenApi all() {
        return GroupedOpenApi.builder().group("all").pathsToMatch("/**/**").build();
    }

    @Bean
    GroupedOpenApi order() {
        return GroupedOpenApi.builder().group("order").pathsToMatch("/order/**").build();
    }

    @Bean
    GroupedOpenApi address() {
        return GroupedOpenApi.builder().group("address").pathsToMatch("/address/**").build();
    }

}
