package pt.agap2.academy.huddleup.configs;

import javax.sql.DataSource;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan( basePackages={"pt.agap2.academy.huddleup.business","pt.agap2.academy.huddleup.configs"})
@EntityScan(basePackages="pt.agap2.academy.huddleup.model")
@EnableJpaRepositories(basePackages="pt.agap2.academy.huddleup.daos")
@Configuration
@PropertySource("classpath:application.properties")
public class TestConfiguration {

		@ConfigurationProperties(prefix = "spring.datasource")
		@Bean
		@Primary
		public DataSource dataSource() {
		    return DataSourceBuilder.create().build();
		}
		
		
		@Bean
		public Validator entityValidator(){
			
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			return validatorFactory.getValidator();
		}
	
}
