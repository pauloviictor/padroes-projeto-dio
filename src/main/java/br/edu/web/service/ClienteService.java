package br.edu.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.web.model.Cliente;
import br.edu.web.model.Endereco;
import br.edu.web.repository.ClienteRepository;
import br.edu.web.repository.EnderecoRepository;
import br.edu.web.repository.ViaCepRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepRepository viaCepRepository;

    public Cliente buscaPorId(Long id){
            Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.get();
    }

    public List<Cliente> listarClientes(){
        Iterable<Cliente> clientesIterable = clienteRepository.findAll();

        List<Cliente> clienteList = new ArrayList<>();

        clientesIterable.forEach(clienteList::add);

        return clienteList;
    }

    public void inserirCliente(Cliente cliente){
        this.salvarClienteComCep(cliente);
    }

    public void alteraCliente(Cliente cliente){
        this.salvarClienteComCep(cliente);
    }

    public void excluiCliente(Long id){
        Cliente cliente = this.buscaPorId(id);
        clienteRepository.delete(cliente);
    }

    public void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
           Endereco novoEndereco =  viaCepRepository.consultarCep(cep);
           enderecoRepository.save(novoEndereco);
           return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
