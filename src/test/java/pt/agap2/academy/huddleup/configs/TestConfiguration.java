package pt.agap2.academy.huddleup.configs;

import javax.sql.DataSource;

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
@ComponentScan( basePackages="pt.agap2.academy.huddleup.business")
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
		
	
}
