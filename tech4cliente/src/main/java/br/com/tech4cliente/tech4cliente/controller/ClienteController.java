package br.com.tech4cliente.tech4cliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4cliente.tech4cliente.model.Cliente;
import br.com.tech4cliente.tech4cliente.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repositorio;

    @GetMapping
    public ResponseEntity<List<Cliente>>obterClientes() {
        return new ResponseEntity<>(repositorio.findAll(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente>obterClientePorId(@PathVariable String id){
        Optional<Cliente> cliente = repositorio.findById(id);

        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Cliente>cadastrarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(repositorio.save(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirCliente(@PathVariable String id) {
        repositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return new ResponseEntity<>(repositorio.save(cliente), HttpStatus.ACCEPTED);
    }

}
