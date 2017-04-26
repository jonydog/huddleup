package pt.agap2.academy.huddleup.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pt.agap2.academy.huddleup.business.impl.GeographicalServiceImpl;
import pt.agap2.academy.huddleup.business.interfaces.GeographicalService;

@Configuration
public class BusinessConfiguration {

	
	@Bean
	public GeographicalService geographicalService(){
		
		return new GeographicalServiceImpl();
	}
	
}
