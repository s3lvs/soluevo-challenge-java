package com.swrj.soluevo.core.domain.entity;

import com.swrj.soluevo.core.domain.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClienteDefault implements Cliente {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Situacao situacao = Situacao.ATIVO;
    private BigDecimal saldo = BigDecimal.ZERO;

    public ClienteDefault(String cpf, String nome, LocalDate dataNascimento) {
        System.out.println(cpf);
        System.out.println(nome);
        checkCpfValid(cpf);
        checkNomeValid(nome);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    private void checkNomeValid(String nome) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        } else if (nome.length() < 20) {
            throw new IllegalArgumentException("Nome deve conter pelo menos 20 caracteres: " + nome);
        } else if (nome.length() > 150) {
            throw new IllegalArgumentException("Nome deve conter no máximo 150 caracteres");
        };
    }

    private void checkCpfValid(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        } else {
            if (cpf.length() != 11) {
                throw new IllegalArgumentException("CPF deve ter 11 dígitos");
            }
        }
    }

    private void checkPodeDeletar() {
        if (!getSaldo().equals(BigDecimal.ZERO)) {
            throw new IllegalStateException("Cliente não pode ser deletado pois tem saldo diferente de Zero");
        }
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        checkCpfValid(cpf);
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        checkNomeValid(nome);
        this.nome = nome;
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public Situacao getSituacao() {
        return situacao;
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public BigDecimal addSaldo(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
        return this.saldo;
    }

}
