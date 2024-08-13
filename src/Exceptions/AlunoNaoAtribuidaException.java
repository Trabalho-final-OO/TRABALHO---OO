package Exceptions;

public class AlunoNaoAtribuidaException extends Exception {
    private static final long serialVersionUID = 1L;

    public AlunoNaoAtribuidaException(String msg) {
        super(msg);
    }
}