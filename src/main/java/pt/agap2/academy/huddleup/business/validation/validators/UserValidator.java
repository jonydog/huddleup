package pt.agap2.academy.huddleup.business.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pt.agap2.academy.huddleup.business.validation.annotations.ValidUser;
import pt.agap2.academy.huddleup.model.User;

public class UserValidator implements ConstraintValidator<ValidUser, User> {

	@Override
	public void initialize(ValidUser constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		
		System.out.println("user validator");
		
		// password nao pode conter o nome
		boolean nameInsidePass = value.getUserPassword()!= null && value.getFullName() != null  &&value.getUserPassword().contains(  value.getFullName() );
		
		// nome nao pode conter numeros
		boolean nameContainsNumbers = value.getFullName() != null && value.getFullName().contains("1");
				
		return (!nameInsidePass) && (!nameContainsNumbers);
	}

}
