package com.henrique.compras.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException() {
        super("Nenhum dado encontrado para o valor indicado.");
    }
}
