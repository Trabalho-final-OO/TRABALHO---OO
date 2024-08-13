package Exceptions;

public class NaoHaTurmaCadastradaException extends Exception{
    private static final long serialVersionUID = 1L;

    public NaoHaTurmaCadastradaException(String msg) {
        super(msg);
    }
}