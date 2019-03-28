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

import com.sienna.postertracker.model.Poster;
import com.sienna.postertracker.repository.PosterRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class PosterController {
	
	@Autowired
	PosterRepository repository;
	
	@GetMapping("posters/get")
    public List<Poster> all() {
        return repository.findAll();
    }
	
	@GetMapping("poster/get/{id}")
	public Poster getOneById(@PathVariable Long id) {
		return repository.getOneById(id);	
	}
	
	@PostMapping("poster/create")
    public Poster create(@RequestBody Poster poster) {
        return repository.saveAndFlush(poster);
    }
	
	@PutMapping("poster/update/{id}")
    public Poster update(@PathVariable Long id, @RequestBody Poster poster) {
        Poster existingposter = repository.getOneById(id);
        BeanUtils.copyProperties(poster, existingposter);
        return repository.saveAndFlush(poster);
    }

    @DeleteMapping("poster/remove/{id}")
    public Poster delete(@PathVariable Long id) {
        Poster existingposter= repository.getOneById(id);
        repository.delete(existingposter);
        return existingposter;
    }	
}
