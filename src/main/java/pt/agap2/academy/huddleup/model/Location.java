package pt.agap2.academy.huddleup.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Location {

	@NotNull
	private Float latitude;
	
	@NotNull
	private Float longitude;


	
}
