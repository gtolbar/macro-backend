package com.sencillo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sencillo.dto.AlimentoDTO;
import com.sencillo.exception.ModeloNotFoundException;
import com.sencillo.model.Alimento;
import com.sencillo.service.IAlimentoService;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {
	
	@Autowired
	private IAlimentoService service;
	
	@GetMapping
	public ResponseEntity<List<Alimento>> listar() throws Exception{
		List<Alimento> lista= service.listar();
		return new ResponseEntity<List<Alimento>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alimento> listarPorId(@PathVariable("id")Integer id) throws Exception{
		Alimento obj= service.listarPorId(id);
		return new ResponseEntity<Alimento>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Alimento> registrar(@RequestBody Alimento p) throws Exception{
		Alimento obj= service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
	@PutMapping
	public ResponseEntity<Alimento> actualizar(@RequestBody Alimento p) throws Exception{
		Alimento obj= service.registrar(p);
		return new ResponseEntity<Alimento>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping("/consulta-alimentos")
	public ResponseEntity<List<AlimentoDTO>> consultaAlimentos() throws Exception{
		List<AlimentoDTO> lista= service.consultaAlimentos();
		return new ResponseEntity<List<AlimentoDTO>>(lista,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		Alimento obj= service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	} 
}
