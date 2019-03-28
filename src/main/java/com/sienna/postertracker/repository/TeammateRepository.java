package com.sienna.postertracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sienna.postertracker.model.Teammate;

public interface TeammateRepository extends JpaRepository <Teammate, Long> {
	Teammate getByName(String name);
	Teammate getOneById(Long id);
}
