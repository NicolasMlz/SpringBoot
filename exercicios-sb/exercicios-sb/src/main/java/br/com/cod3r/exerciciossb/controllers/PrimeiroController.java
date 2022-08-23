package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring reconhece automaticamente o controlador atraves do main
@RestController
public class PrimeiroController {
	
	//Metodo get usado na requisicao do browser
	@GetMapping(path = {"/ola", "/saudacao"})
	public String ola() {
		return "Olá Spring Boot! "; 
	}
}
