package br.com.dh.exercicioempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.exercicioempresa.model.entities.Cliente;
import br.com.dh.exercicioempresa.model.repositories.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping()
	public Iterable<Cliente> getClientes() {
		return clienteRepository.findAll();
		
	}
	
	@PostMapping()
	public Cliente addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}

}
