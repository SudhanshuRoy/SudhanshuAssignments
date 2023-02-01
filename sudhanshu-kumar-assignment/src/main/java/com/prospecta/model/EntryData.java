package com.prospecta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class EntryData {
	
	@JsonProperty("API")
	 private String api;
	 
	 
	 @JsonProperty("Description")
	 private String description;
	 
	 
	 @JsonProperty("Auth")
	 private String auth;
	 
	 
	 @JsonProperty("HTTPS")
	 private Boolean https ;
	 
	 
	 @JsonProperty("Cors")
	 private String cors;
	 
	 @Id
	 @JsonProperty("Link")
	 private String link;
	 
	 
	 @JsonProperty("Category")
	 private String category;
		

}
