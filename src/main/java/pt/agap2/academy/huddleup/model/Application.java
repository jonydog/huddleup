package pt.agap2.academy.huddleup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="APPLICATION")
public class Application {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long id;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private User candidate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private HuddleEvent event; 
	
	private Boolean accepted;
}
