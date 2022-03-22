package com.sencillo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.model.Dieta;
import com.sencillo.repo.IDietaRepo;
import com.sencillo.repo.IGenericRepo;
import com.sencillo.service.IDietaService;

@Service
public class DietaServiceImpl extends CRUDImpl<Dieta, Integer> implements IDietaService{
	
	@Autowired
	private IDietaRepo repo;
	
	@Override
	protected IGenericRepo<Dieta, Integer> getRepo() {
		return repo;
	}

}
