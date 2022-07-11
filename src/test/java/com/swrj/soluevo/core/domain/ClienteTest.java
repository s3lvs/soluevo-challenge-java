package com.swrj.soluevo.core.domain;

import com.swrj.soluevo.core.domain.factory.ClienteFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.swrj.soluevo.core.ContantesUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void cpfSomenteCom11Digitos() {
        assertDoesNotThrow(() -> ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()));
        assertThrows(Exception.class, () -> ClienteFactory.create(CPF_MENOR_QUE_ONZE_DIGITOS, NOME_VALIDO, LocalDate.now()));
    }

    @Test
    void nomeSomenteMaiorQue5AndMenorQue150() {
        assertDoesNotThrow(() -> ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()));
        assertThrows(Exception.class, () -> ClienteFactory.create(CPF_VALIDO, NOME_MENOR_QUE_CINCO_CARACTERES, LocalDate.now()));
        assertThrows(Exception.class, () -> ClienteFactory.create(CPF_VALIDO, NOME_MAIOR_QUE_100_CARACTERES, LocalDate.now()));
    }

    @Test
    void situacaoAtivoPorPadrao() {
        assertEquals(ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()).getSituacao(), Cliente.Situacao.ATIVO);
    }

    @Test
    void saldoZeradoPorPadrao() {
        assertEquals(ClienteFactory.create(CPF_VALIDO, NOME_VALIDO, LocalDate.now()).getSaldo(), BigDecimal.ZERO);
    }

}