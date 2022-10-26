package com.ecommerce.om;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@SpringBootApplication
public class OmApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
