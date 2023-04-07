package br.edu.web.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.web.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
