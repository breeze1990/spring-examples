package com.example.spring.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (StringUtils.isEmpty(person.getFirstName()) || StringUtils.isEmpty(person.getLastName())) {
            errors.reject("empty_name", "Name should not be empty");
        }
    }
}
