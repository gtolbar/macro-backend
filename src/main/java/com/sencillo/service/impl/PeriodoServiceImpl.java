package com.sencillo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.model.Periodo;
import com.sencillo.repo.IGenericRepo;
import com.sencillo.repo.IPeriodoRepo;
import com.sencillo.service.IPeriodoService;

@Service
public class PeriodoServiceImpl extends CRUDImpl<Periodo, Integer> implements IPeriodoService{
	
	@Autowired
	private IPeriodoRepo repo;
	
	@Override
	protected IGenericRepo<Periodo, Integer> getRepo() {
		return repo;
	}

}
