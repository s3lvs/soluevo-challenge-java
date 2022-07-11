package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.domain.Cliente;

import java.time.LocalDate;

public interface CadastrarCliente {
    Cliente cadastrarCliente(String cpf, String nome, LocalDate dataNascimento) throws Exception;
}
