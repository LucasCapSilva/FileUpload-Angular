package com.feiraBrasil.IFeiraAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feiraBrasil.IFeiraAPI.model.Categoria;
import com.feiraBrasil.IFeiraAPI.repository.CategoriaRepository;
import com.feiraBrasil.IFeiraAPI.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> getAll() {
		List<Categoria> categorias= (List<Categoria>)categoriaRepository.findAll();
		return categorias;
	}

	@Override
	public Categoria getById(int id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	public Categoria createOrUpate(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void delete(int id) {
		categoriaRepository.deleteById(id);
		
	}
	
	

}
