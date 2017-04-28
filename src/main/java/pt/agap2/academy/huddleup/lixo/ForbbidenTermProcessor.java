package pt.agap2.academy.huddleup.lixo;

import java.lang.reflect.Field;

public class ForbbidenTermProcessor {

	
	public static void process(Object o){
	
		Field[] objectFields = o.getClass().getFields();
		for(Field field : objectFields){
			
			if(  field.isAnnotationPresent(ForbbidenTerms.class) ){
				
				
			}
		}
		
		
	}
	
}