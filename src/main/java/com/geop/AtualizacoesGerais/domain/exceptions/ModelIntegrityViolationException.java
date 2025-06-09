package com.geop.AtualizacoesGerais.domain.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class ModelIntegrityViolationException extends DataIntegrityViolationException {
public ModelIntegrityViolationException(String message){
    super(message);
}
public ModelIntegrityViolationException(String message,Throwable cause){
super(message,cause);
}
}
