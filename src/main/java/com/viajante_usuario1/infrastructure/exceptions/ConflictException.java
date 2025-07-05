package com.viajante_usuario1.infrastructure.exceptions;

public class ConflictException extends RuntimeException{

    public ConflictException(String mensagem){
        super(mensagem);
    }
    public ConflictException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }

}
