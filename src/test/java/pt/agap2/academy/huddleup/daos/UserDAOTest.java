package pt.agap2.academy.huddleup.daos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pt.agap2.academy.huddleup.configs.TestConfiguration;
import pt.agap2.academy.huddleup.model.User;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes= TestConfiguration.class)
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDao;

	public static User getDemoUser(){
		
		User user = new User();
		user.setBirthDate(new Date());
		user.setEmail("joao.pinto@agap2.pt");
		user.setFullName("JoaoPinto");
		user.setIsDeleted(false);
		user.setRate(0.0);
		user.setRateCount(0L);
		user.setUserPassword("youtouchmytralala");
		return user;
	}
	
	@Test
	public void  testInsert(){
		
		User testUser = getDemoUser();
		this.userDao.save( testUser );
		
		User queriedUser = this.userDao.findOne(testUser.getId());
		
		Assert.assertEquals( "joao.pinto@agap2.pt", queriedUser.getEmail());
		
	}
	
	
	
}
