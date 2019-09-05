package com.example.dbservice.validator;

import com.example.dbservice.model.Thing;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ThingRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Thing.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Thing thing = (Thing) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.thingName.empty");

        }
    }
