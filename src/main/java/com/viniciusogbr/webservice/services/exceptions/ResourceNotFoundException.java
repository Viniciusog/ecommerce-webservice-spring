package com.viniciusogbr.webservice.services.exceptions;

//RuntimeException: Não obriga o computador a tratar a exceção
public class ResourceNotFoundException extends RuntimeException {

    //throw new ResourceNotFoundException

    private static final Long serialVersionUID = 1L;

    //Recebe o id que não foi encontrado
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id: " + id);
    }
}
