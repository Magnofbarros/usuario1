package com.viajante_usuario1.infrastructure.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String menssagem) {
        super(menssagem);
    }
    public ResourceNotFoundException(String menssagem, Throwable throwable){
        super(menssagem, throwable);
    }
}
