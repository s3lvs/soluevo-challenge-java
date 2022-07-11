package com.swrj.soluevo.core.usecase.interactor;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtualizarDadosClienteDefault implements com.swrj.soluevo.core.usecase.AtualizarDadosCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente atualizarDados(String cpf, String nome, LocalDate dataNascimento) throws Exception {
        Cliente cliente = clienteRepository.get(cpf);
        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimento);
        clienteRepository.put(cliente);
        return cliente;
    }

}
