package com.sencillo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.model.Usuario;
import com.sencillo.repo.IGenericRepo;
import com.sencillo.repo.IUsuarioRepo;
import com.sencillo.service.IUsuarioService;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, Integer> getRepo() {
		return repo;
	}
	
	

}
