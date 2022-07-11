package com.swrj.soluevo.core.domain.factory;

import com.swrj.soluevo.core.domain.Cliente;
import com.swrj.soluevo.core.domain.entity.ClienteDefault;

import java.time.LocalDate;

public interface ClienteFactory {

    static Cliente create(String cpf, String nome, LocalDate dataNascimento) {
        return new ClienteDefault(cpf, nome, dataNascimento);
    }

}
