package com.swrj.soluevo.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Cliente {

    enum Situacao { ATIVO, INATIVO };

    String getCpf();

    String getNome();
    void setNome(String nome);
    LocalDate getDataNascimento();
    void setDataNascimento(LocalDate dataNascimento);

    Situacao getSituacao();
    BigDecimal getSaldo();

    BigDecimal addSaldo(BigDecimal valor);


}
