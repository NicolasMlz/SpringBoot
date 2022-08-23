package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Tornar a classe possivel de receber requisicoes
@RestController
@RequestMapping("/metodos")
public class MetodosHttpCOntroller {
	
	
	//TESTES DAS REQUISICOES
	
	@GetMapping
	public String get() {
		return "Requisicao GET";
	}
	
	@PostMapping
	public String post() {
		return "Requisicao POST";
	}
	
	@PutMapping
	public String put() {
		return "Requisicao PUT";
	}
	
	@PatchMapping
	public String patch() {
		return "Requisicao PATCH";
	}
	
	@DeleteMapping
	public String delete() {
		return "Requisicao DELETE";
	}
}
