package br.com.nexuscloud.exception;

/**
 * Exceção CHECKED (Exception).
 * O compilador OBRIGA try-catch ou cláusula throws.
 */
public class CapacidadeExcedidaException extends Exception {

    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}