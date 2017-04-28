package pt.agap2.academy.huddleup.lixo;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.junit.Test;

public class ForbbidenTermTest {
	
	class JustAPerson{
		
		public static final String a = "maminha";
		
		@NotNull
		public String terms = "Diversão sads";
	
		public int age = 18;
		
		public String salute = "Hello";
	}
	
	
	@Test
	public void simpleTest() throws IllegalArgumentException, IllegalAccessException{
		
		
		{
			JustAPerson person = new JustAPerson();
			Field[] objectFields = person.getClass().getDeclaredFields();
			Arrays.asList( objectFields ).stream().forEach( System.out::println );
			
			for(Field field : objectFields){
				
				if(  field.isAnnotationPresent(ForbbidenTerms.class) ){
					
					field.setAccessible(true);
					String checkedTerms = (String) field.get(person);					
					for(String forbbidenTerm : field.getAnnotation(ForbbidenTerms.class).forbiddenTerms() ){
						
						if ( checkedTerms.contains( forbbidenTerm ) ){
							field.set(person, "FORBBIDEN");
						}
					}
				}
			}
			System.out.println("PERSON: " + person.terms);
		}		
		
		
	}
	
}