package com.sienna.postertracker.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@NamedNativeQuery(name = "Poster.findTeammatesPosters", query = "SELECT location FROM poster WHERE hung_by = (SELECT name FROM TEAMMATE where id=?1)")
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
