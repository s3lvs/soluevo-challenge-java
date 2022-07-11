package com.swrj.soluevo.core.domain.repository;

import com.swrj.soluevo.core.domain.Cliente;

import java.util.List;

public interface ClienteRepository {

    Cliente get(String cpf) throws Exception;

    List<Cliente> getAll() throws Exception;
    void put(Cliente cliente) throws Exception;
    void remove(Cliente cliente) throws Exception;



}
