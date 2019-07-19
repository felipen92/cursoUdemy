package com.udemy.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.curso.domain.Categoria;
import com.udemy.curso.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoUdemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepo;

	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepo.saveAll(Arrays.asList(cat1, cat2));
		
	}
		
}
