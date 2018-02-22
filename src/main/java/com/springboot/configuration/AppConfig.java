package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.springboot.configuration.initializer.TestDataInitializer;

@Configuration
@ComponentScan("com.springboot")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean(initMethod = "init")
    public TestDataInitializer initTestData() {
        return new TestDataInitializer();
    }

}  



