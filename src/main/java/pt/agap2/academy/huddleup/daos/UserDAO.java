package pt.agap2.academy.huddleup.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.agap2.academy.huddleup.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{

	
	
	
}
