package com.employee.management.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

    @Profile("dev")
    @Bean
    public void devDatabaseConfiguration() {
        System.out.println("Dev Database Connection");
    }
    
    @Profile("prod")
    @Bean
    public void prodDatabaseConfiguration() {
        System.out.println("Prod Database Connection");
    }

}
