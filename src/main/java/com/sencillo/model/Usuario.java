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
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable=false)
	private String username;
	
	@Column(name="clave", nullable=false)
	private  String password;
	
	@Column(name="estado", nullable=false)
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
	private Rol idRol;
	
}
