package pt.agap2.academy.huddleup.controllers;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResult<T> {

	private T 				data;
	private List<String> 	errors;
	
}
