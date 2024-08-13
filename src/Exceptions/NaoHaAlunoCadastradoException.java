package Exceptions;

public class NaoHaAlunoCadastradoException extends Exception{
    private static final long serialVersionUID = 1L;

    public NaoHaAlunoCadastradoException(String msg) {
        super(msg);
    }
}