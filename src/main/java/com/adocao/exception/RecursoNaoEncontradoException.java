package com.adocao.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
    
    //serialVersionUID é uma versão do ID da classe, para evitar problemas de serialização e deserialização
    private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
} 