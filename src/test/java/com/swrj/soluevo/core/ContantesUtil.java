package com.swrj.soluevo.core;

import java.math.BigDecimal;

public class ContantesUtil {

    public static final String CPF_VALIDO = "98765432101";

    public static final String CPF_MENOR_QUE_ONZE_DIGITOS = "0123";
    public static final String CPF_MAIOR_QUE_ONZE_DIGITOS = "9876543210123";
    public static final String NOME_VALIDO = "Pedro de Alcântara Francisco";
    public static final String NOME_VALIDO_ALTERADO = "Pedro de Alcântara Francisco de Paula";
    public static final String NOME_MENOR_QUE_CINCO_CARACTERES = "Joao";
    public static final String NOME_MAIOR_QUE_100_CARACTERES = "Pedro de Alcântara Francisco Antônio João Carlos Xavier" +
            " de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon e Elisabeth Dobrzensky de Dobrzenicz";

    public static final BigDecimal SOMA_10_MAIS_10 = BigDecimal.TEN.add(BigDecimal.TEN);

}
