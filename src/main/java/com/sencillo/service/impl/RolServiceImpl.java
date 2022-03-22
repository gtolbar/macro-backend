package com.sencillo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.model.Rol;
import com.sencillo.repo.IGenericRepo;
import com.sencillo.repo.IRolRepo;
import com.sencillo.service.IRolService;

@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer> implements IRolService{
	
	@Autowired
	private IRolRepo repo;
	
	@Override
	protected IGenericRepo<Rol, Integer> getRepo() {
		return repo;
	}

}
