package br.com.dh.exercicioempresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.exercicioempresa.model.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	
}
