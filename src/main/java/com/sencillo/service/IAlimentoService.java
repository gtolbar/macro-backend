package com.sencillo.service;

import java.util.List;

import com.sencillo.dto.AlimentoDTO;
import com.sencillo.model.Alimento;

public interface IAlimentoService extends ICRUD<Alimento, Integer>{

	 List<AlimentoDTO> consultaAlimentos();
	
}
