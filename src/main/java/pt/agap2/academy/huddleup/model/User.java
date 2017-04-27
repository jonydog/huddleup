package pt.agap2.academy.huddleup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USER")
public class User extends HuddleupHeader{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(value=AccessLevel.PRIVATE)
	private Long id;
	
	private String fullName;
	
	private Date birthDate;
	
	private String email;
	
	private String userPassword;
	
	private double rate;
	
	private long rateCount;

}