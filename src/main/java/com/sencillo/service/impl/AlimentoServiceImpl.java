package com.sencillo.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sencillo.dto.AlimentoDTO;
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
	
	public List<AlimentoDTO> consultaAlimentos(){
		List<Alimento> obj=getRepo().findAll();
		List<AlimentoDTO> objDTO = new ArrayList<>();
		for (Alimento alimento : obj) {
			AlimentoDTO alimentoDTO= new AlimentoDTO();
			int caloriasAlimento=(alimento.getGrasa()*9)+(alimento.getCarbohidrato()*4)+(alimento.getProteina()*4);
			alimentoDTO.setId(alimento.getId());
			alimentoDTO.setNombre(alimento.getNombre());
			alimentoDTO.setGrasa(alimento.getGrasa());
			alimentoDTO.setCarbohidrato(alimento.getCarbohidrato());
			alimentoDTO.setProteina(alimento.getProteina());
			alimentoDTO.setCaloria(caloriasAlimento);
			objDTO.add(alimentoDTO);
		}
		System.out.println(objDTO);
		return objDTO;
	}

}
