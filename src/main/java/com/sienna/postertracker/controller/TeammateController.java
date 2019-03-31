package com.sienna.postertracker.controller;

import java.util.List;
import java.util.logging.Logger;

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

	Logger log = Logger.getLogger(TeammateController.class.getName());
	
	TeammateRepository repository;
	
	TeammateController(TeammateRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("teammates/get")
    public List<Teammate> all() {
		log.info("all()");
        return repository.findAll();
    }
	
	@GetMapping("teammates/get/roster")
	public List<Teammate> allRoster() {
		log.info("allRoster()");
		System.out.println("allRoster");
		return repository.getRoster();
	}
	
	@GetMapping("teammate/get/{id}")
	public Teammate getOneById(@PathVariable Long id) {
		return repository.getOneById(id);	
	}
	
	@PostMapping("teammates/create")
    public Teammate create(@RequestBody Teammate teammate) {
        return repository.save(teammate);
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
