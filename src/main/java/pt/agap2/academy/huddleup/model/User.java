package pt.agap2.academy.huddleup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import pt.agap2.academy.huddleup.business.validation.annotations.HuddleupStrongPassword;
import pt.agap2.academy.huddleup.business.validation.annotations.ValidUser;

@ValidUser
@Getter
@Setter
@Entity
@Table(name="USER")
public class User extends HuddleupHeader{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(value=AccessLevel.PRIVATE)
	private Long id;
	
	@NotNull
	private String fullName;
	
	@NotNull
	private Date birthDate;
	
	@Email @NotNull
	private String email;
	
	@NotNull @HuddleupStrongPassword 
	private String userPassword;
	
	private double rate;
	
	private long rateCount;
}