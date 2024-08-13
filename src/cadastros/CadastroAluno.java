package cadastros;

import Exceptions.AlunoNaoAtribuidaException;
import Exceptions.CampoEmBrancoException;
import Exceptions.NaoHaAlunoCadastradoException;
import app.Aluno;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroAluno extends Cadastros {

    private int numAlunos;
    private List<Aluno> alunos;

    public CadastroAluno() {
        numAlunos = 0;
        alunos = new ArrayList<Aluno>();
    }

    public int cadastrarAluno(Aluno aluno) throws CampoEmBrancoException {
        String nome = lerNome();
        String matricula = lerMatricula();

        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome do Aluno não pode estar em branco.");
        }
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new CampoEmBrancoException("Matrícula do Aluno não pode estar em branco.");
        }

        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setCpf(lerCPF());
        aluno.setEmail(lerEmail());
        aluno.setCurso(lerCurso());

        this.alunos.add(aluno);
        this.numAlunos = this.alunos.size();
        return this.numAlunos;
    }

    public Aluno pesquisarAluno(String matricula) {
        try {
            Aluno aluno = getAlunoByMatricula(matricula);
            return aluno;
        } catch (AlunoNaoAtribuidaException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean removerAluno(Aluno aluno) {
        boolean removeu = false;
        if (this.alunos.contains(aluno)) {
            removeu = this.alunos.remove(aluno);
        }
        return removeu;
    }

    public boolean atualizarAluno(String matricula) {
        try {
            Aluno aluno = getAlunoByMatricula(matricula);
            aluno.setNome(lerNome());
            aluno.setCpf(lerCPF());
            aluno.setEmail(lerEmail());
            aluno.setMatricula(lerMatricula());
            aluno.setCurso(lerCurso());
        } catch (AlunoNaoAtribuidaException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    // Funções auxiliares

    public Aluno getAlunoByMatricula(String matricula)  throws AlunoNaoAtribuidaException, CampoEmBrancoException {
        if (matricula == null) {
            throw new CampoEmBrancoException("Matricula não informada");
        }
        for (Aluno aluno : this.alunos) {
            String alunoMatricula = aluno.getMatricula();
            System.out.println(alunoMatricula);
            if (alunoMatricula.equals(matricula)) {
                return aluno;
            }
        }
        throw new AlunoNaoAtribuidaException("Não há nenhum aluno com essa matricula");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do aluno: ");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do aluno: ");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do aluno: ");
    }

    public static String lerMatricula() {
        return JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
    }

    private static String lerCurso() {
        return JOptionPane.showInputDialog("Informe o curso do aluno: ");
    }

    // Validação

    public void validaAlunoCadastrado() throws NaoHaAlunoCadastradoException {
        if (this.numAlunos < 1) {
            throw new NaoHaAlunoCadastradoException("Nenhum aluno foi cadastro ainda");
        }
    }

    // Declaração das classes abstratas

    public int cadastrar(Object o) throws CampoEmBrancoException {
        return cadastrarAluno((Aluno) o);
    }

    public Object pesquisar(String s) {
        return pesquisarAluno(s);
    }

    public boolean remover(Object o) {
        return removerAluno((Aluno) o);
    }

    public boolean atualizar(String matricula){
            return atualizarAluno(matricula);
    }
}
