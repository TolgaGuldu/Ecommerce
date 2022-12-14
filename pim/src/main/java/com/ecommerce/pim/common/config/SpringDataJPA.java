package com.ecommerce.pim.common.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class SpringDataJPA {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJPA.class, args);
    }
}
