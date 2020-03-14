package com.feiraBrasil.IFeiraAPI.service;

import java.util.List;

import com.feiraBrasil.IFeiraAPI.model.Feirante;

public interface FeiranteService {
	
	public List<Feirante> getAll();
	
	public Feirante getById(int id);
	
	public Feirante createOrUpdate(Feirante feirante);
	
	public void delete(int id);

}
