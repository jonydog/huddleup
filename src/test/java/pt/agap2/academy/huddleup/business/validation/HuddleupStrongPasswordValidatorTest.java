package pt.agap2.academy.huddleup.business.validation;

import java.util.Date;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;

import pt.agap2.academy.huddleup.model.User;


public class HuddleupStrongPasswordValidatorTest {
	

	
	@Test
	public void testStrongPasswordValidator(){
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator entityValidator = validatorFactory.getValidator();
		
		User user = new User();
		user.setFullName("Joao");
		user.setEmail("jf.m.pt");
		user.setUserPassword("aaa");
		user.setBirthDate(new Date());
		user.setIsDeleted(false);
		user.setLastModifiedDate(new Date());
		user.setRate(0);
		user.setRateCount(0L);
		
		Assert.assertEquals( 2,  entityValidator.validate(user).size()  );
	}
	
	@Test
	public void testSInsertValidUser(){
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator entityValidator = validatorFactory.getValidator();

		User user = new User();
		user.setFullName("Joao");
		user.setEmail("jf.ribeiro@live.com.pt");
		user.setUserPassword("aaaaaaaaaa");
		user.setBirthDate(new Date());
		user.setIsDeleted(false);
		user.setLastModifiedDate(new Date());
		user.setRate(0);
		user.setRateCount(0L);
		
		
		Assert.assertEquals( 0, entityValidator.validate(user).size() );
		
	}
	
	

}