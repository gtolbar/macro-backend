package com.sencillo.dto;

import lombok.Data;

@Data
public class AlimentoDTO {
	
	private int id;
	private String nombre;	
	private int proteina;
	private int carbohidrato;
	private int grasa;
	private int caloria;

}
