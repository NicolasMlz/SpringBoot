package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Cliente;

//Tornar a classe possivel de receber requisicoes
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	//Retornar atraves da requisicao http GET, um objeto
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.456.789-00");
	}
	
	//Retornar um usuario especifico atraves de uma variavel passada
	//na requisicao, por isso deve-se usar o @pathVAriable e {} no path
	
	//Nesse metodo de parametro, o mesmo é passado de forma direta na url
	//O que nao eh muito recomendavel
	@GetMapping(path = "/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new Cliente(id, "Maria", "111.222.333-00");
	}
	
	/*
	 * Nesse metodo, o parametro eh passado apos a interrogacao,
	 * e dessa forma eh possivel passar varios parametros de uma so vez
	 * Esse eh o modelo mais utilizado na web
	 */
	@GetMapping
	public Cliente obterClientePorId2(
			@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Cliente(id, "Nick", "999.999.999-99");
	}
	
}
