package com.swrj.soluevo.core.usecase.interactor;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.factory.ClienteFactory;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CadastrarClienteDefault implements com.swrj.soluevo.core.usecase.CadastrarCliente {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrarCliente(String cpf, String nome, LocalDate dataNascimento) throws Exception {
        Cliente cliente = ClienteFactory.create(cpf, nome, dataNascimento);
        clienteRepository.put(cliente);
        return cliente;
    }
}
