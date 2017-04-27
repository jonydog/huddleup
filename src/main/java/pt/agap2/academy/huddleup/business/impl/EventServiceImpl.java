package pt.agap2.academy.huddleup.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import pt.agap2.academy.huddleup.business.interfaces.EventService;
import pt.agap2.academy.huddleup.daos.HuddleEventDAO;
import pt.agap2.academy.huddleup.daos.dtos.EventDetails;

@Component
public class EventServiceImpl implements  EventService{
	
	@Autowired
	private HuddleEventDAO huddleEventDao;
	

	@Override
	public EventDetails getEventDetailsByEventId(Long eventId,Errors errors) {
		
		return this.huddleEventDao.findEventDetailsById(eventId);
	}

	
}
