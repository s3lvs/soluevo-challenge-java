package com.swrj.soluevo.core.usecase.interactor;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class AtualizarSaldoClienteDefault implements com.swrj.soluevo.core.usecase.AtualizarSaldoCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente atualizarSaldo(String cpf, BigDecimal valor) throws Exception {
        Cliente cliente = clienteRepository.get(cpf);
        cliente.addSaldo(valor);
        clienteRepository.put(cliente);
        return cliente;
    }

}
