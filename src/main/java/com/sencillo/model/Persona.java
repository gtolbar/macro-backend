package com.sencillo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name="edad", nullable = false)
	private int edad;
	
	@Column(name="altura", nullable = false)
	private int altura;
	
	@Column(name="peso", nullable = false )
	private int peso;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario idUsuario;
	
	@ManyToOne
	@JoinColumn(name="id_periodo", nullable = false)
	private Usuario idPeriodo;

}
