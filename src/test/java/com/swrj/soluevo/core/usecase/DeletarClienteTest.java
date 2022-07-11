package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.factory.ClienteFactory;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import com.swrj.soluevo.core.usecase.interactor.AtualizarSaldoClienteDefault;
import com.swrj.soluevo.core.usecase.interactor.DeletarClienteDefault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.swrj.soluevo.core.ContantesUtil.CPF_VALIDO;
import static com.swrj.soluevo.core.ContantesUtil.NOME_VALIDO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig
@ContextConfiguration(classes = {DeletarClienteDefault.class, AtualizarSaldoClienteDefault.class})
class DeletarClienteTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private DeletarCliente deletarCliente;

    @Autowired
    private AtualizarSaldoCliente atualizarSaldoCliente;

    @BeforeEach
    public void setUp() throws Exception {
        given(clienteRepository.get(anyString())).willReturn(ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()));
    }

    @Test
    void deletarCliente() {
        assertDoesNotThrow(() -> deletarCliente.deletarCliente(CPF_VALIDO));
    }

    @Test
    void impedirDeletarClienteComSaldo() throws Exception {
        Cliente cliente = atualizarSaldoCliente.atualizarSaldo(CPF_VALIDO, BigDecimal.TEN);
        assertThrows(Exception.class, () -> deletarCliente.deletarCliente(CPF_VALIDO));
    }

}