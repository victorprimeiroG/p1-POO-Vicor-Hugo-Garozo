package br.com.nexuscloud.exception;

/**
 * Exceção UNCHECKED (RuntimeException).
 * O compilador não obriga tratamento — a falha estoura em tempo de execução.
 */
public class ServidorOfflineException extends RuntimeException {

    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}