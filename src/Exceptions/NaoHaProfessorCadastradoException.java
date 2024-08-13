package Exceptions;

public class NaoHaProfessorCadastradoException extends Exception{
    private static final long serialVersionUID = 1L;

    public NaoHaProfessorCadastradoException(String msg) {
        super(msg);
    }
}