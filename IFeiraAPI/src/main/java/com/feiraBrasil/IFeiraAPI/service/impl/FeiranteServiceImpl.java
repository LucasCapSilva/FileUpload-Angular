package com.feiraBrasil.IFeiraAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feiraBrasil.IFeiraAPI.model.Feirante;
import com.feiraBrasil.IFeiraAPI.repository.FeiranteRepository;
import com.feiraBrasil.IFeiraAPI.service.FeiranteService;

@Service
public class FeiranteServiceImpl  implements FeiranteService{

	@Autowired
	private FeiranteRepository feiranteRepository;
	
	@Override
	public List<Feirante> getAll() {
		List<Feirante> feirantes= (List<Feirante>)feiranteRepository.findAll();
		return feirantes;
	}

	@Override
	public Feirante getById(int id) {
		return feiranteRepository.findById(id).orElse(null);
	}

	@Override
	public Feirante createOrUpdate(Feirante feirante) {
		return feiranteRepository.save(feirante);
	}

	@Override
	public void delete(int id) {
		feiranteRepository.deleteById(id);	
	}
	

}
