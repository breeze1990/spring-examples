package com.example.spring.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person/validate")
public class PersonValidatorController {
    private final Validator personValidator;

    @Autowired
    public PersonValidatorController(@Qualifier("personValidator") Validator personValidator) {
        this.personValidator = personValidator;
    }

    @PostMapping
    public Person validate(@Valid @RequestBody Person person) {
        return person;
    }

    @InitBinder
    private void dataBinding(WebDataBinder binder) {
        binder.addValidators(personValidator);
    }
}
