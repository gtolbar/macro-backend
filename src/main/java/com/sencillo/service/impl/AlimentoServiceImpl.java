package com.sencillo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.model.Alimento;
import com.sencillo.repo.IAlimentoRepo;
import com.sencillo.repo.IGenericRepo;
import com.sencillo.service.IAlimentoService;

@Service
public class AlimentoServiceImpl extends CRUDImpl<Alimento, Integer> implements IAlimentoService{
	
	@Autowired
	private IAlimentoRepo repo;
	
	@Override
	protected IGenericRepo<Alimento, Integer> getRepo() {
		return repo;
	}

}
