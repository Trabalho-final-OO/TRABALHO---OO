package app;

public class Professor extends PessoaFisica {

    private String areaFormacao;
    private String matriculaFUB;

    public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) {
        super(nome, cpf, email);
        this.areaFormacao = areaFormacao;
        this.matriculaFUB = matriculaFUB;
    }


    public String getAreaFormacao() {
        return areaFormacao;
    }

    public String getMatriculaFUB() {
        return matriculaFUB;
    }



    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    public void setMatriculaFUB(String matriculaFUB) {
        this.matriculaFUB = matriculaFUB;
    }
}

