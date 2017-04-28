package pt.agap2.academy.huddleup.daos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pt.agap2.academy.huddleup.daos.dtos.EventDetails;
import pt.agap2.academy.huddleup.model.HuddleEvent;

@Repository
public interface HuddleEventDAO extends JpaRepository<HuddleEvent, Long> {

	@Query("select new pt.agap2.academy.huddleup.daos.dtos.EventDetails"
			+ " (event.id,event.eventName,event.description,event.city,host.rate,event.eventDate)"
			+ " from HuddleEvent event join event.host host" 
			+ " where event.id=:eventId")
	public EventDetails findEventDetailsById(@Param("eventId") Long eventId);
	
	@Query("select new pt.agap2.academy.huddleup.daos.dtos.EventDetails"
			+ " (event.id,event.eventName,event.description,event.city,host.rate,event.eventDate)"
			+ " from HuddleEvent event join event.host host")
	public List<EventDetails> findAllEventDetails(Pageable p); 
	
}