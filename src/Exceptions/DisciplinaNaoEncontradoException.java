package Exceptions;

public class DisciplinaNaoEncontradoException extends Exception{
    private static final long serialVersionUID = 1L;

    public DisciplinaNaoEncontradoException(String msg) {
        super(msg);
    }
}