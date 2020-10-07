package br.com.dh.exercicioempresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.exercicioempresa.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
