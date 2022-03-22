package com.sencillo.model;

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
@Table(name="dieta")
public class Dieta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_alimento", nullable=false)
	private Alimento idAlimento;
	
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false)
	private Persona idPersona;

}
