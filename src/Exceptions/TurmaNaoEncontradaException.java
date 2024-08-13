package Exceptions;

public class TurmaNaoEncontradaException extends Exception{
    private static final long serialVersionUID = 1L;

    public TurmaNaoEncontradaException(String msg) {
        super(msg);
    }
}