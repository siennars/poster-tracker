package com.sienna.postertracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sienna.postertracker.model.Poster;

public interface PosterRepository extends JpaRepository <Poster, Long>{
	Poster getOneById(Long id);
	
    public List<Poster> findTeammatesPosters(Long id);
    
}

