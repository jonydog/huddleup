package pt.agap2.academy.huddleup.daos.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventDetails {

	private Long eventId; 
	private String eventName;
	private String eventDescription;
	private String city;
	private double rate;
	private Date  eventDate;	

}