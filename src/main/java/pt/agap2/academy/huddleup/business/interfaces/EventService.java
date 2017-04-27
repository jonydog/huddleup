package pt.agap2.academy.huddleup.business.interfaces;

import org.springframework.validation.Errors;

import pt.agap2.academy.huddleup.daos.dtos.EventDetails;

public interface EventService {
	
	public EventDetails getEventDetailsByEventId(Long eventId, Errors errors);
	
}
