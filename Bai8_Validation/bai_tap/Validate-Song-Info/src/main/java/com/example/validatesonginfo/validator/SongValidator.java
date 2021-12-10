package com.example.validatesonginfo.validator;

import com.example.validatesonginfo.model.SongInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class SongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SongInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
