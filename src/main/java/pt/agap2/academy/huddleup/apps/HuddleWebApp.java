package pt.agap2.academy.huddleup.apps;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pt.agap2.academy.huddleup.daos.HuddleEventDAO;

@SpringBootApplication
@EnableAutoConfiguration 
@ComponentScan(basePackages={"pt.agap2.academy.huddleup.business","pt.agap2.academy.huddleup.controllers"})
@EntityScan("pt.agap2.academy.huddleup.model")
@EnableJpaRepositories(basePackages={"pt.agap2.academy.huddleup.daos"})
public class HuddleWebApp {


	public static void main(String[] args){
		
		ApplicationContext ctx = SpringApplication.run(HuddleWebApp.class, args);
		
		Arrays.asList( ctx.getBeanDefinitionNames() ).stream().forEach(System.out::println);

		
		System.out.println( "HuddleEventDAO :" + ctx.getBean(HuddleEventDAO.class) + " Class:" + ctx.getBean(HuddleEventDAO.class).getClass().toString()  );
	}
	
}