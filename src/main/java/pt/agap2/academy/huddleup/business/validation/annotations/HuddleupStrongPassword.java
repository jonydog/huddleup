package pt.agap2.academy.huddleup.business.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pt.agap2.academy.huddleup.business.validation.validators.HuddleupStrongPasswordValidator;

@Constraint(validatedBy = HuddleupStrongPasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface HuddleupStrongPassword {

	String message() default "Palavra passe fraquinha";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
