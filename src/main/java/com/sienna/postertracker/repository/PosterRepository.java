package com.sienna.postertracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sienna.postertracker.model.Poster;

public interface PosterRepository extends JpaRepository <Poster, Long>{
	Poster getOneById(Long id);
}
