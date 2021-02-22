package com.ailtonluiz.sgs.service.exception;

public class CompanyNameAlreadyRegisteredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CompanyNameAlreadyRegisteredException(String message) {
        super(message);
    }
}
