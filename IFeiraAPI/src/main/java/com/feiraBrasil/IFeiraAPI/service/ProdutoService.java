package com.feiraBrasil.IFeiraAPI.service;

import java.util.List;

import com.feiraBrasil.IFeiraAPI.model.Produto;

public interface ProdutoService {
	
	public List<Produto> getAll();
	
	public Produto getById(int id);
	
	public Produto createOrUpdate(Produto produto);
	
	public void delete(int id);
	

}
