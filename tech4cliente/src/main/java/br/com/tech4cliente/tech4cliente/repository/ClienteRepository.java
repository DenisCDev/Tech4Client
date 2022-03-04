package br.com.tech4cliente.tech4cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4cliente.tech4cliente.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    
}
