package com.sencillo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.model.Persona;
import com.sencillo.repo.IGenericRepo;
import com.sencillo.repo.IPersonaRepo;
import com.sencillo.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService	{
	
	@Autowired
	private IPersonaRepo repo;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		return repo;
	}

}
