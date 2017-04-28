package pt.agap2.academy.huddleup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import pt.agap2.academy.huddleup.lixo.ForbbidenTerms;

@Getter
@Setter
@Entity
@Table(name="EVENT")
public class HuddleEvent extends HuddleupHeader{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(value=AccessLevel.PRIVATE)
	private Long id;
	
	private String requirements;
	
	@ForbbidenTerms(forbiddenTerms={"drogas","heroina","snuff"})
	private String eventName;
	
	private String eventType;
	
	private String photo;
	
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade={} )
	@JoinColumn(name="host_id")
	private User host;
	
	private Date eventDate;
	
	private String address;
	
	private String city;
	
	private int maxAtt;
		
	private Location location;
	
}