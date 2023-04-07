package br.edu.web.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.web.model.Endereco;

@FeignClient(name = "viacep", url = "viacep.com.br/ws/")
public interface ViaCepRepository {

    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
