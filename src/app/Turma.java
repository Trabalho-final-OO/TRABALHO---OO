package app;

import java.util.List;

public class Turma {
    private Disciplina disciplinaMinistrada;
    private int codigoTurma;
    private List<Aluno> alunosTurma;
    private Professor professorTurma;
    private String horaTurma;
    private String salaTurma;

    // Construtor
    public Turma(Disciplina disciplinaMinistrada, int codigoTurma, List<Aluno> alunosTurma,
                 Professor professorTurma, String horaTurma, String salaTurma) {
        this.disciplinaMinistrada = disciplinaMinistrada;
        this.codigoTurma = codigoTurma;
        this.alunosTurma = alunosTurma;
        this.professorTurma = professorTurma;
        this.horaTurma = horaTurma;
        this.salaTurma = salaTurma;
    }

    public Disciplina getDisciplinaMinistrada() {
        return disciplinaMinistrada;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public List<Aluno> getAlunosTurma() {
        return alunosTurma;
    }

    public Professor getProfessorTurma() {
        return professorTurma;
    }

    public String getHoraTurma() {
        return horaTurma;
    }

    public String getSalaTurma() {
        return salaTurma;
    }

    public void setDisciplinaMinistrada(Disciplina disciplinaMinistrada) {
        this.disciplinaMinistrada =  disciplinaMinistrada;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma =  codigoTurma;
    }

    public void setAlunosTurma(List<Aluno> alunosTurma) {
        this.alunosTurma =  alunosTurma;
    }

    public void setProfessorTurma(Professor professorTurma) {
        this.professorTurma =  professorTurma;
    }

    public void setHoraTurma(String horaTurma) {
        this.horaTurma =  horaTurma;
    }

    public void setSalaTurma(String salaTurma) {
        this.salaTurma =  salaTurma;
    }

    public String toString() {
        return "Turma: \nDisciplina: " + disciplinaMinistrada.getNomeDisciplina() + "\n" +
                "Código: " + codigoTurma + "\n" +
                "Professor: " + professorTurma.getNome() + "\n" +
                "Hora: " + horaTurma + "\n" +
                "Sala: " + salaTurma;
    }

}
