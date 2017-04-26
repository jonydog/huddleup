package pt.agap2.academy.huddleup.business.interfaces;

import java.util.List;

import pt.agap2.academy.huddleup.model.HuddleEvent;

public interface GeographicalService {

	public List<HuddleEvent> getEventsNearby(float latitude, float longitude, float radius);
	
}
