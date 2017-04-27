package pt.agap2.academy.huddleup.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class HuddleupHeader {

	private Date 		createdDate;
	private Date 		lastModifiedDate;
	private Boolean 	isDeleted;
	
}
