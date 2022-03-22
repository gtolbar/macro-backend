package com.sencillo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="alimento")
public class Alimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="proteina", nullable=false)
	private int proteina;
	
	@Column(name="carbohidrato", nullable=false)
	private int carbohidrato;
	
	@Column(name="grasa", nullable=false)
	private int grasa;

}
