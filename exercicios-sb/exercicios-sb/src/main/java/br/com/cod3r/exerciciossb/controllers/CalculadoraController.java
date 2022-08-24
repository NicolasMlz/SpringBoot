package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {
	
	//Somar duas variaveis passando os parametros diretamente na url
	//de forma fixa
	@GetMapping(path = "/somar/{a}/{b}")
	public int somar(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}
	
	//Passar os parametros de forma dinamica, nomeando-os
	@GetMapping(path = "/subtrair")
	public int subtrair(
			@RequestParam(name = "a") int a,
			@RequestParam(name = "b") int b) {
		return a - b;
	}

}
