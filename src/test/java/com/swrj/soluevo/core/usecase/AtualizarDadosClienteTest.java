package com.swrj.soluevo.core.usecase;

import com.swrj.soluevo.core.ClientRepositoyMock;
import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.repository.ClienteRepository;
import com.swrj.soluevo.core.usecase.interactor.AtualizarDadosClienteDefault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static com.swrj.soluevo.core.ContantesUtil.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig
@ContextConfiguration(classes = {AtualizarDadosClienteDefault.class, ClientRepositoyMock.class})
class AtualizarDadosClienteTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AtualizarDadosCliente atualizarDadosCliente;

    @BeforeEach
    public void setUp() throws Exception {
        //given(clienteRepository.get(anyString())).willReturn(ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()));
    }

    @Test
    void alterarNomeEDataNascimento() throws Exception {
        Cliente cliente = clienteRepository.get(CPF_VALIDO);

        String nomeClienteOriginal = cliente.getNome();
        LocalDate dataNascimentoClienteOriginal = cliente.getDataNascimento();

        Cliente clienteAtualizado = atualizarDadosCliente.atualizarDados(CPF_VALIDO, NOME_VALIDO_ALTERADO, LocalDate.now().plusDays(1));

        assertNotEquals(clienteAtualizado.getNome(), nomeClienteOriginal);
        assertNotEquals(clienteAtualizado.getDataNascimento(), dataNascimentoClienteOriginal);
    }

    @Test
    void impedirNomeMaiorQue150Caracteres() throws Exception {
        assertThrows(Exception.class, () -> atualizarDadosCliente.atualizarDados(CPF_VALIDO, NOME_MAIOR_QUE_100_CARACTERES, LocalDate.now().plusDays(1)));
    }

}