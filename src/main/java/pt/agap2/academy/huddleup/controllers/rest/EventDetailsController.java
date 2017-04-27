package pt.agap2.academy.huddleup.controllers.rest;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.agap2.academy.huddleup.business.interfaces.EventService;
import pt.agap2.academy.huddleup.controllers.RestResult;
import pt.agap2.academy.huddleup.daos.dtos.EventDetails;

@RestController
@RequestMapping("/eventdetails")
public class EventDetailsController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/{eventId}")
	public RestResult<EventDetails> doGet(@PathVariable("eventId") Long eventId, HttpServletResponse response){
		
		//call business
		Errors getErrors = new BeanPropertyBindingResult(eventId,"eventId");
		EventDetails eventDetails = this.eventService.getEventDetailsByEventId(eventId,getErrors);

		RestResult<EventDetails> result = new RestResult<>();
		result.setData(eventDetails);
		result.setErrors( getErrors.getAllErrors()
							.stream()
							.map( (error) -> error.getDefaultMessage() )
							.collect(Collectors.toList())   
						);
		
		//set apropriate response
		if( getErrors.hasErrors() ){
			response.setStatus( HttpServletResponse.SC_NOT_FOUND );
		}else{
			response.setStatus( HttpServletResponse.SC_OK );
		}
		
		
		return result;

	}
	
}
