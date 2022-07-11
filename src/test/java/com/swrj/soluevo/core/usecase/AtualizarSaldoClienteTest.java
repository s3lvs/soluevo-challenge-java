package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.factory.ClienteFactory;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import com.swrj.soluevo.core.usecase.interactor.AtualizarSaldoClienteDefault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.swrj.soluevo.core.ContantesUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig
@ContextConfiguration(classes = {AtualizarSaldoClienteDefault.class})
class AtualizarSaldoClienteTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private AtualizarSaldoCliente atualizarSaldoCliente;

    @BeforeEach
    public void setUp() throws Exception {
        given(clienteRepository.get(anyString())).willReturn(ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()));
    }

    @Test
    void alterarSaldo() throws Exception {
        Cliente cliente = clienteRepository.get(CPF_VALIDO);
        BigDecimal saldoClienteOriginal = cliente.getSaldo();
        Cliente clienteAtualizado = atualizarSaldoCliente.atualizarSaldo(CPF_VALIDO, BigDecimal.TEN);
        assertNotEquals(clienteAtualizado.getSaldo(), saldoClienteOriginal);
    }

    @Test
    void incrementarSaldo() throws Exception {
        Cliente cliente = clienteRepository.get(CPF_VALIDO);
        BigDecimal saldoClienteOriginal = cliente.getSaldo();
        Cliente clienteAtualizado = atualizarSaldoCliente.atualizarSaldo(CPF_VALIDO, BigDecimal.TEN);
        clienteAtualizado = atualizarSaldoCliente.atualizarSaldo(CPF_VALIDO, BigDecimal.TEN);
        assertEquals(clienteAtualizado.getSaldo(), SOMA_10_MAIS_10);
    }
}