package com.sienna.postertracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

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
