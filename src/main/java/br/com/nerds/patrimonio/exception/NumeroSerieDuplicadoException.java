package br.com.nerds.patrimonio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumeroSerieDuplicadoException extends RuntimeException {
    public NumeroSerieDuplicadoException(String numeroSerie) {
        super("Já existe equipamento com número de série: " + numeroSerie);
    }
}
