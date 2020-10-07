package br.com.dh.exercicioempresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.exercicioempresa.model.entities.Funcionario;
import br.com.dh.exercicioempresa.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
		
	@GetMapping()
	public Iterable<Funcionario> getFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	@PostMapping()
	public Funcionario addNovoFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	@DeleteMapping("/{id}")
	public void demitirFuncionario(@PathVariable int id) {
		funcionarioRepository.deleteById(id);
	}
	
	
	@PutMapping("/{idFuncionario}")
	public Funcionario reajusteSalario(@PathVariable int idFuncionario, @RequestBody Funcionario dadosFuncionario) throws Exception {
		Funcionario funcionarioDB = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new IllegalAccessException());
		
		funcionarioDB.setSalario(dadosFuncionario.getSalario());
		
		funcionarioRepository.save(funcionarioDB);
		return funcionarioDB;
	}
}
