package br.com.dh.exercicioempresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.exercicioempresa.model.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
