package com.feiraBrasil.IFeiraAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feiraBrasil.IFeiraAPI.model.Produto;
import com.feiraBrasil.IFeiraAPI.repository.ProdutoRepository;
import com.feiraBrasil.IFeiraAPI.service.ProdutoService;

@Service
public class ProdutoServiceImpl  implements ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> getAll() {
		List<Produto> produtos= (List<Produto>)produtoRepository.findAll();
		return produtos;
	}

	@Override
	public Produto getById(int id) {
		return produtoRepository.findById(id).orElse(null);
	}

	@Override
	public Produto createOrUpdate(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public void delete(int id) {
		produtoRepository.deleteById(id);
		
	}
	
	

}
