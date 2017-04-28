package pt.agap2.academy.huddleup.business.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pt.agap2.academy.huddleup.business.validation.annotations.HuddleupStrongPassword;

public class HuddleupStrongPasswordValidator implements  ConstraintValidator<HuddleupStrongPassword, String> {

	
	@Override
	public void initialize(HuddleupStrongPassword constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		System.out.println("password validator");
		
		return value!=null && value.length() >= 8;
	}

	
	
	
}
