package pt.agap2.academy.huddleup.business.interfaces;

import java.util.List;

import pt.agap2.academy.huddleup.model.HuddleEvent;
import pt.agap2.academy.huddleup.model.Location;

public interface GeographicalService {
	
	/**
	 * 
	 * @param location Latitude and longitude
	 * @param radius Expressed in Kilometers
	 * @return A list of events within the radius
	 */
	public List<HuddleEvent> getEventsNearby(Location location, float radius);
	
}
