package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.factory.ClienteFactory;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import com.swrj.soluevo.core.usecase.interactor.CadastrarClienteDefault;
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
@ContextConfiguration(classes = {CadastrarClienteDefault.class})
class CadastrarClienteTest {

    @Autowired
    private CadastrarCliente cadastrarCliente;

    @MockBean
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() throws Exception {
        given(clienteRepository.get(anyString())).willReturn(ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()));
    }

    @Test
    void cadastrarCliente() throws Exception {
        ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now());

        assertDoesNotThrow(() -> {
            Cliente cliente = cadastrarCliente.cadastrarCliente(CPF_VALIDO, NOME_VALIDO, LocalDate.now());
        });

        Cliente cliente = cadastrarCliente.cadastrarCliente(CPF_VALIDO, NOME_VALIDO, LocalDate.now());
        assertNotNull(cliente);

        assertEquals(cliente.getNome(), NOME_VALIDO);
        assertEquals(cliente.getCpf(), CPF_VALIDO);
        assertEquals(cliente.getSituacao(), Cliente.Situacao.ATIVO);
        assertEquals(cliente.getSaldo(), BigDecimal.ZERO);
    }

}