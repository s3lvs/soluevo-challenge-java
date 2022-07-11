package com.swrj.soluevo.core.usecase.interactor;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class DeletarClienteDefault implements com.swrj.soluevo.core.usecase.DeletarCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void deletarCliente(String cpf) throws Exception {
        Cliente cliente = clienteRepository.get(cpf);
        if (cliente == null) {
            throw new Exception("Cliente possui saldo");
        } else if (!cliente.getSaldo().equals(BigDecimal.ZERO)) {
            throw new Exception("Cliente possui saldo");
        }
    }
}
