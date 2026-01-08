package br.com.nerds.patrimonio.exception;

public class EquipamentoNaoEncontradoException extends RuntimeException {

    public EquipamentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}