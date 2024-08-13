package cadastros;

import java.util.ArrayList;
import java.util.List;

import Exceptions.NaoHaProfessorCadastradoException;
import Exceptions.ProfessorNaoEncontradoException;
import app.Professor;
import Exceptions.CampoEmBrancoException;

import javax.swing.*;

public class CadastroProfessor extends Cadastros {

    private int numProfessores;
    private List<Professor> professores;

    public CadastroProfessor() {
        numProfessores = 0;
        professores = new ArrayList<Professor>();
    }

    public int cadastrarProfessor(Professor professor) throws CampoEmBrancoException {
        String nome = lerNome();
        String matriculaFUB = lerMatriculaFUB();

        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome do professor não pode estar em branco.");
        }
        if (matriculaFUB == null || matriculaFUB.trim().isEmpty()) {
            throw new CampoEmBrancoException("Matrícula FUB do professor não pode estar em branco.");
        }

        professor.setNome(nome);
        professor.setMatriculaFUB(matriculaFUB);
        professor.setCpf(lerCPF());
        professor.setEmail(lerEmail());
        professor.setAreaFormacao(lerAreaFormacao());

        this.professores.add(professor);
        this.numProfessores = this.professores.size();
        return this.numProfessores;
    }

    public Professor pesquisarProfessor(String matriculaFUB) {
        try {
            Professor professor = getProfessorByMatricula(matriculaFUB);
            return professor;
        } catch (ProfessorNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean removerProfessor(Professor p) {
        boolean removeu = false;
        if (this.professores.contains(p)) {
            removeu = this.professores.remove(p);
        }
        return removeu;
    }

    public boolean atualizarProfessor(String matricula) {
        try {
            Professor professor = getProfessorByMatricula(matricula);
            professor.setNome(lerNome());
            professor.setCpf(lerCPF());
            professor.setEmail(lerEmail());
            professor.setMatriculaFUB(lerMatriculaFUB());
            professor.setAreaFormacao(lerAreaFormacao());
        } catch (ProfessorNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    // Funções auxiliares

    public Professor getProfessorByMatricula(String matricula)  throws ProfessorNaoEncontradoException, CampoEmBrancoException {
        if (matricula == null) {
            throw new CampoEmBrancoException("Matricula não informada");
        }
        for (Professor professor : this.professores) {
            String professorMatricula = professor.getMatriculaFUB();
            System.out.println(professorMatricula);
            if (professorMatricula.equals(matricula)) {
                return professor;
            }
        }
        throw new ProfessorNaoEncontradoException("Não há nenhum professor com essa matricula");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor: ");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor: ");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor: ");
    }

    public static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    }

    private static String lerAreaFormacao() {
        return JOptionPane.showInputDialog("Informe a área de formação do professor: ");
    }

    // Validação

    public void validaProfessorCadastrado() throws NaoHaProfessorCadastradoException {
        if (this.numProfessores < 1) {
            throw new NaoHaProfessorCadastradoException("Nenhum professor foi cadastro ainda");
        }
    }

    // Declaração das classes abstratas

    public int cadastrar(Object o) throws CampoEmBrancoException {
        return cadastrarProfessor((Professor) o);
    }

    public Object pesquisar(String s) {
        return pesquisarProfessor(s);
    }

    public boolean remover(Object o) {
        return removerProfessor((Professor) o);
    }

    public boolean atualizar(String matricula){
            return atualizarProfessor(matricula);
    }
}
