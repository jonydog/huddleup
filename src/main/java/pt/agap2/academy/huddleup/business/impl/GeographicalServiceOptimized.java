package pt.agap2.academy.huddleup.business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import pt.agap2.academy.huddleup.business.interfaces.GeographicalService;
import pt.agap2.academy.huddleup.model.HuddleEvent;
import pt.agap2.academy.huddleup.model.Location;

@Component
public class GeographicalServiceOptimized implements GeographicalService{

	@Override
	public List<HuddleEvent> getEventsNearby(Location location, float radius) {
		// TODO Auto-generated method stub
		return null;
	}

}
