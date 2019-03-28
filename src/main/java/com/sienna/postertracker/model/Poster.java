package com.sienna.postertracker.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String city;
    
    private String location;
    
    private String hungBy;
    
    public Poster () {
    	
    }

	public Poster(Long id, String city, String location, String hungBy) {
		this.id = id;
		this.city = city;
		this.location = location;
		this.hungBy = hungBy;
	}
}
