package com.aluraCurso.ForoHubChallenge.infra.error;

public class IntegrityValidation extends RuntimeException {
    public IntegrityValidation(String s) {
        super(s);
    }
}