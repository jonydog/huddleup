package pt.agap2.academy.huddleup.business;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
public class HorusErrors {
	
	@Getter
	private List<String> errors = new LinkedList<>();

	@JsonIgnore
	ResourceBundle resources;
	
	public HorusErrors(Locale locale){	
		this.resources = ResourceBundle.getBundle("errormessages/socialactions-errors", locale );
	}
	
	public Boolean hasErrors(){
		return this.errors.size()!=0;
	}
	
	
	public void addError(String errorKey, Object... parameters){
		this.errors.add( MessageFormat.format( this.resources.getString(errorKey) , parameters ) );
	}
	
}
