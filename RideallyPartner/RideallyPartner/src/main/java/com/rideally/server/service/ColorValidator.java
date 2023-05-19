package com.rideally.server.service;

import java.util.Arrays;
import java.util.List;

import com.rideally.server.repository.ColorValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ColorValidator implements ConstraintValidator<ColorValidation, String> {

	@Override
	public boolean isValid(String colorName, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList(new String[]{"RED","GREEN","BLUE"});
        return list.contains(colorName);
	}

}
