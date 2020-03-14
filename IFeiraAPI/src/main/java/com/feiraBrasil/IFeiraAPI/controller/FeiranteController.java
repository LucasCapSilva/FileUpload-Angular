package com.feiraBrasil.IFeiraAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feiraBrasil.IFeiraAPI.model.Feirante;
import com.feiraBrasil.IFeiraAPI.service.FeiranteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/feirante")
public class FeiranteController {
	
	@Autowired
	private FeiranteService feiranteService;
	
	@GetMapping
	public ResponseEntity<List<Feirante>> getAll() {
		return ResponseEntity.ok(feiranteService.getAll());
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Feirante> getByID(@PathVariable int id) {
		return ResponseEntity.ok(feiranteService.getById(id));		
	}
	@PostMapping
	public ResponseEntity<Feirante> post(@RequestBody Feirante feirante) {
		return ResponseEntity.ok(feiranteService.createOrUpdate(feirante));
	}
	@PutMapping
	public ResponseEntity<Feirante> put(@RequestBody Feirante feirante) {
		return ResponseEntity.ok(feiranteService.createOrUpdate(feirante));
	}
	public void delete(int id) {
		feiranteService.delete(id);
	}

}
