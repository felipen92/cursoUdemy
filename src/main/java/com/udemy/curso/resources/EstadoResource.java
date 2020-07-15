package com.udemy.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.curso.domain.Estado;
import com.udemy.curso.services.EstadoService;


@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Integer id) {
		
		Estado obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
