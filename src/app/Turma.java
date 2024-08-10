package app;

public class Turma {
    private String disciplinaMinistrada;
    private int codigoTurma;
    private String alunoTurma;
    private String professorTurma;
    private String horaTurma;
    private String salaTurma;

    // Construtor
    public Turma(String disciplinaMinistrada, int codigoTurma, String alunoTurma,
                 String professorTurma, String horaTurma, String salaTurma) {
        this.disciplinaMinistrada = disciplinaMinistrada;
        this.codigoTurma = codigoTurma;
        this.alunoTurma = alunoTurma;
        this.professorTurma = professorTurma;
        this.horaTurma = horaTurma;
        this.salaTurma = salaTurma;
    }


    public String getDisciplinaMinistrada() {
        return disciplinaMinistrada;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public String getAlunoTurma() {
        return alunoTurma;
    }

    public String getProfessorTurma() {
        return professorTurma;
    }

    public String getHoraTurma() {
        return horaTurma;
    }

    public String getSalaTurma() {
        return salaTurma;
    }



    public String toString() {
        return "Turma [Disciplina: " + disciplinaMinistrada +
                ", Código: " + codigoTurma +
                ", Aluno: " + alunoTurma +
                ", Professor: " + professorTurma +
                ", Hora: " + horaTurma +
                ", Sala: " + salaTurma + "]";
    }


    protected void finalize() throws Throwable {
        try {
            // Código para limpar recursos, se necessário
        } finally {
            super.finalize();
        }
    }

}
