package com.feiraBrasil.IFeiraAPI.service;

import java.util.List;

import com.feiraBrasil.IFeiraAPI.model.Categoria;

public interface CategoriaService {
	
	public List<Categoria> getAll();
	
	public Categoria getById(int id);
	
	public Categoria createOrUpate(Categoria categoria);
	
	public void delete(int id);

}
