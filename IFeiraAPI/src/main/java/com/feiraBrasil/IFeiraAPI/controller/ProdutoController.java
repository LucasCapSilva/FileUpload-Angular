package com.feiraBrasil.IFeiraAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feiraBrasil.IFeiraAPI.model.Produto;
import com.feiraBrasil.IFeiraAPI.service.ProdutoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable int id){
		return ResponseEntity.ok(produtoService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.createOrUpdate(produto));
	}
	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.createOrUpdate(produto));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		produtoService.delete(id);
	}

}
