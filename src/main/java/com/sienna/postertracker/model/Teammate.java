package com.sienna.postertracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Teammate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private int posterCount;

    public Teammate () {
    	
    }
    
	public Teammate(Long id, String name, String posterLocation, int posterCount) {
		this.id = id;
		this.name = name;
		this.posterCount = posterCount;
	}
       
}
