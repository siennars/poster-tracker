package com.sienna.postertracker.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sienna.postertracker.model.Teammate;
import com.sienna.postertracker.repository.TeammateRepository;

@RestController
@RequestMapping("api/v1/")
public class TeammateController {

	@Autowired
	TeammateRepository repository;
	
	@GetMapping("teammates/get")
    public List<Teammate> all() {
        return repository.findAll();
    }
	
	@GetMapping("teammate/get/{id}")
	public Teammate getOneById(@PathVariable Long id) {
		return repository.getOneById(id);	
	}
	
	@PostMapping("teammate/create")
    public Teammate create(@RequestParam Teammate teammate) {
        return repository.saveAndFlush(teammate);
    }
	
	@PutMapping("teammate/update/{id}")
    public Teammate update(@PathVariable Long id, @RequestBody Teammate teammate) {
        Teammate existingTeammate = repository.getOneById(id);
        BeanUtils.copyProperties(teammate, existingTeammate);
        return repository.saveAndFlush(teammate);
    }

    @DeleteMapping("teammate/remove/{id}")
    public Teammate delete(@PathVariable Long id) {
        Teammate existingTeammate= repository.getOneById(id);
        repository.delete(existingTeammate);
        return existingTeammate;
    }	
	
}
