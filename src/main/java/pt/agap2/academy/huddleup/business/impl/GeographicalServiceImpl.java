package pt.agap2.academy.huddleup.business.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pt.agap2.academy.huddleup.business.interfaces.GeographicalService;
import pt.agap2.academy.huddleup.daos.HuddleEventDAO;
import pt.agap2.academy.huddleup.model.HuddleEvent;
import pt.agap2.academy.huddleup.model.Location;

@Component
public class GeographicalServiceImpl implements GeographicalService {

	@Autowired
	private HuddleEventDAO huddleEventDao;

	private static double distanceBetweenCoordinates(double lat1, double lat2, double lon1, double lon2, double el1,
			double el2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}

	private static double calcDistance(Location locationA, Location locationB) {
		return distanceBetweenCoordinates(locationA.getLatitude(), locationB.getLatitude(), locationA.getLongitude(),
				locationB.getLongitude(), 0, 0) / 1000.0d;
	}

	public List<HuddleEvent> getEventsNearby(Location location, float radius) {
		List<HuddleEvent> allEvents = this.huddleEventDao.findAll();
		List<HuddleEvent> nearbyEvents = new LinkedList<HuddleEvent>();
		
		for (HuddleEvent huddleEvent : allEvents) {
			if (calcDistance(location, huddleEvent.getLocation()) <= radius) {
				nearbyEvents.add(huddleEvent);
			}
		}

		return nearbyEvents;
	}

}
