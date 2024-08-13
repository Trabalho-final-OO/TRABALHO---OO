package Exceptions;

public class NaoHaDisciplinaCadastradoException extends Exception{
    private static final long serialVersionUID = 1L;

    public NaoHaDisciplinaCadastradoException(String msg) {
        super(msg);
    }
}