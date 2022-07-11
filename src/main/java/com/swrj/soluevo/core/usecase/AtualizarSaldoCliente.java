package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.domain.Cliente;

import java.math.BigDecimal;

public interface AtualizarSaldoCliente {
    Cliente atualizarSaldo(String cpf, BigDecimal valor) throws Exception;
}
