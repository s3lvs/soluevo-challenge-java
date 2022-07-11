package com.swrj.soluevo.core;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientRepositoyMock implements ClienteRepository {

    private final HashMap<String, Cliente> clientRepository = new HashMap<>();

    @Override
    public Cliente get(String cpf) throws Exception {
        return clientRepository.get(cpf);
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> cliente = new ArrayList<Cliente>(0);
        clientRepository.forEach((key, value) -> cliente.add(value));
        return cliente;
    }

    @Override
    public void put(Cliente cliente) throws Exception {
        clientRepository.put(cliente.getCpf(), cliente);
    }

    @Override
    public void remove(Cliente cliente) throws Exception {
        clientRepository.remove(cliente.getCpf());
    }
}
