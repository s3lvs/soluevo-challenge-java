package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.domain.Cliente;

import java.time.LocalDate;

public interface AtualizarDadosCliente {
    Cliente atualizarDados(String cpf, String nome, LocalDate dataNascimento) throws Exception;
}
