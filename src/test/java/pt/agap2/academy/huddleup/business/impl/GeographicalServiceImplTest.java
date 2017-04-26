package pt.agap2.academy.huddleup.business.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pt.agap2.academy.huddleup.business.interfaces.GeographicalService;
import pt.agap2.academy.huddleup.configs.BusinessConfiguration;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes=BusinessConfiguration.class )
public class GeographicalServiceImplTest {
	
	@Autowired
	private GeographicalService geoService;
	
	
	@Test
	public void getGeographicalEvent(){
		
		
		Assert.assertNotNull( this.geoService.getEventsNearby(0.0F, 0.0F, 100) );	
	}
}
