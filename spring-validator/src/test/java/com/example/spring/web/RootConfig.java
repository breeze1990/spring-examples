package com.example.spring.web;

import com.example.spring.web.validator.PersonValidator;
import com.example.spring.web.validator.PersonValidatorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
    @Bean
    public PersonValidator personValidator() {
        return new PersonValidator();
    }

    @Bean
    public PersonValidatorController personValidatorController(PersonValidator personValidator) {
        assert personValidator != null;
        return new PersonValidatorController(personValidator);
    }
}
