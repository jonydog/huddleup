package pt.agap2.academy.huddleup.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.agap2.academy.huddleup.business.interfaces.GeographicalService;
import pt.agap2.academy.huddleup.model.HuddleEvent;
import pt.agap2.academy.huddleup.model.Location;

@RestController
@RequestMapping("/events")
public class EventServiceController {
	
	@Autowired
	private GeographicalService geographicalService;
	
	@GetMapping("/nearby")
	public List<HuddleEvent> getNearbyEvents(@RequestParam("lat") Float latitude, @RequestParam("long") Float longitude){
		
		
		return this.geographicalService.getEventsNearby(new Location(latitude, longitude), 100 );
	}

}
