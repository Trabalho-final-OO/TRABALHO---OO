package app;

public class Aluno extends PessoaFisica {

    private String matricula;
    private String curso;

    public Aluno(String nome, String cpf, String email, String curso, String matricula) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String toString() {
        String resposta = super.toString();
        resposta += "MATRICULA: " + matricula + '\n';
        resposta += "CURSO: " + curso + '\n';
        return resposta;
    }
}

