package com.ecommerce.pim.common.config;

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
    GroupedOpenApi category() {
        return GroupedOpenApi.builder().group("category").pathsToMatch("/category/**").build();
    }

    @Bean
    GroupedOpenApi product() {
        return GroupedOpenApi.builder().group("product").pathsToMatch("/product/**").build();
    }

    @Bean
    GroupedOpenApi price() {
        return GroupedOpenApi.builder().group("price").pathsToMatch("/price/**").build();
    }

    @Bean
    GroupedOpenApi stock() {
        return GroupedOpenApi.builder().group("stock").pathsToMatch("/stock/**").build();
    }

}
