package pt.agap2.academy.huddleup.lixo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ForbbidenTerms {

	String[] forbiddenTerms() default {"drogas","heroina"};
	String	 warningMessage() default "bad";
	
}
