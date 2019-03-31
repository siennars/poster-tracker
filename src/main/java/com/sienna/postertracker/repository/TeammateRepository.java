package com.sienna.postertracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sienna.postertracker.model.Teammate;

public interface TeammateRepository extends JpaRepository <Teammate, Long> {
	Teammate getByName(String name);
	Teammate getOneById(Long id);
	
	@Query(value = "SELECT * FROM Teammate t WHERE t.poster_count > 4", nativeQuery=true)
	public List<Teammate> getRoster();
	
}
