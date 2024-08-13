package cadastros;

import Exceptions.*;
import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroTurma {

    private int numTurmas;
    private List<Turma> turmas;


    public CadastroTurma() {
        numTurmas = 0;
        turmas = new ArrayList<Turma>();
    }

    public int cadastrarTurma(Turma turma, CadastroAluno cadAluno, CadastroProfessor cadProf, CadastroDisciplina cadDic) throws CampoEmBrancoException {

        String codigo = lerCodigo();

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new CampoEmBrancoException("Código da Turma não informado.");
        }

        turma.setHoraTurma(lerHora());
        turma.setSalaTurma(lerSala());
        turma.setCodigoTurma(Integer.parseInt(codigo));

        String codigoDisciplina = lerCodigoDisciplina();
        try {
            Disciplina disciplina = cadDic.getDisciplinaByCodigo(codigoDisciplina);
            turma.setDisciplinaMinistrada(disciplina);
        } catch (DisciplinaNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return 0;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return 0;
        }

        String matriculaFUB = lerMatriculaFUB();
        try {
            Professor prof = cadProf.getProfessorByMatricula(matriculaFUB);
            turma.setProfessorTurma(prof);
        } catch (ProfessorNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return 0;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return 0;
        }

        List<Aluno> alunos = new ArrayList<Aluno>();
        String matriculaAluno = "";
        do {
            matriculaAluno = lerAlunos();
            if(alunos.size() == 0 && matriculaAluno.equals("0")) {
                JOptionPane.showMessageDialog(null, "Erro: É preciso cadastrar pelo menos 1 aluno");
                continue;
            } else if (matriculaAluno.equals("0")) {
                break;
            }
            try {
                Aluno aluno = cadAluno.getAlunoByMatricula(matriculaAluno);
                alunos.add(aluno);
            } catch (AlunoNaoAtribuidaException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (!matriculaAluno.equals("0"));
        turma.setAlunosTurma(alunos);

        this.turmas.add(turma);
        this.numTurmas = this.turmas.size();
        return this.numTurmas;
    }

    public Turma pesquisarTurma(String codigoTurma) {
        try {
            Turma turma = getTurmaByCodigo(codigoTurma);
            return turma;
        } catch (TurmaNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean atualizarTurma(String codigo) {
        try {
            Turma turma = getTurmaByCodigo(codigo);
            turma.setCodigoTurma(Integer.parseInt(lerCodigo()));
            turma.setHoraTurma(lerHora());
            turma.setSalaTurma(lerSala());
        } catch (TurmaNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean removerTurma(Turma p) {
        boolean removeu = false;
        if (this.turmas.contains(p)) {
            removeu = this.turmas.remove(p);
        }
        return removeu;
    }

    // Funções auxiliares

     public Turma getTurmaByCodigo(String codigo)  throws TurmaNaoEncontradaException, CampoEmBrancoException {
         if (codigo == null) {
             throw new CampoEmBrancoException("Código não informado");
         }
         for (Turma turma : this.turmas) {
             String turmaCodigo = Integer.toString(turma.getCodigoTurma());
             if (turmaCodigo.equals(codigo)) {
                 return turma;
             }
         }
         throw new TurmaNaoEncontradaException("Não há nenhuma turma com esse código");
     }

    public static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor desta turma: ");
    }

    public static String lerAlunos() {
        return JOptionPane.showInputDialog("Informe a matrícula do aluno para adicionar a turma ou digite 0 prosseguir: ");
    }

    public static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
    }

    private static String lerHora() {
        return JOptionPane.showInputDialog("Informe o horário da turma: ");
    }

    private static String lerSala() {
        return JOptionPane.showInputDialog("Informe a sala da turma: ");
    }

    private  static String lerCodigoDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    // Validação

    public void validaTurmaCadastrada() throws NaoHaTurmaCadastradaException {
        if (this.numTurmas < 1) {
            throw new NaoHaTurmaCadastradaException("Nenhuma turma foi cadastra ainda");
        }
    }

}