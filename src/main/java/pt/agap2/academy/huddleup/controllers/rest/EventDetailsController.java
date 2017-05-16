package pt.agap2.academy.huddleup.controllers.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.agap2.academy.huddleup.business.interfaces.EventService;
import pt.agap2.academy.huddleup.daos.HuddleEventDAO;
import pt.agap2.academy.huddleup.daos.dtos.EventDetails;

@RestController
@RequestMapping("/eventdetails")
public class EventDetailsController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private HuddleEventDAO eventDao;
	
	@GetMapping("/{eventId}")
	public EventDetails doGet(@PathVariable("eventId") Long eventId, HttpServletResponse response){
		
		EventDetails eventDetails = this.eventService.getEventDetailsByEventId(eventId);
		return eventDetails;
	}
	
	@GetMapping(value="/all" ,params={"page","limit","sort","by"})
	public List<EventDetails> getAllEventDetails(
			@RequestParam("page") Integer page, 
			@RequestParam("limit") Integer limit,
			@RequestParam(value="sort")  String field,
			@RequestParam(value="by") String sortby )
	{
		
		Pageable p = new  PageRequest(
						page,
						limit, 
						new Sort( sortby.equals("desc") ? Direction.DESC : Direction.ASC ,  field ) );
		
		return this.eventDao.findAllEventDetails(p);
	}
	
	
	
	@GetMapping(value="/all" ,params={"page","limit"})
	public List<EventDetails> getAllEventDetails(
			@RequestParam("page") Integer page, 
			@RequestParam("limit") Integer limit)
	{
		
		Pageable p = new  PageRequest(
						page,
						limit);
		return this.eventDao.findAllEventDetails(p);
	}
}
