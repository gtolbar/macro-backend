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

import com.sencillo.exception.ModeloNotFoundException;
import com.sencillo.model.Periodo;
import com.sencillo.service.IPeriodoService;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {
	
	@Autowired
	private IPeriodoService service;
	
	@GetMapping
	public ResponseEntity<List<Periodo>> listar() throws Exception{
		List<Periodo> lista= service.listar();
		return new ResponseEntity<List<Periodo>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Periodo> listarPorId(@PathVariable("id")Integer id) throws Exception{
		Periodo obj= service.listarPorId(id);
		return new ResponseEntity<Periodo>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Periodo> registrar(@RequestBody Periodo p) throws Exception{
		Periodo obj= service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
	@PutMapping
	public ResponseEntity<Periodo> actualizar(@RequestBody Periodo p) throws Exception{
		Periodo obj= service.registrar(p);
		return new ResponseEntity<Periodo>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		Periodo obj= service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	} 
}
