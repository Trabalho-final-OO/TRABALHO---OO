package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Aluno;
import Exceptions.CampoEmBrancoException;

public class CadastroAluno extends Cadastros {

    private int numAlunos;
    private List<Aluno> alunos;

    public CadastroAluno() {
        numAlunos = 0;
        alunos = new ArrayList<Aluno>();
    }

    public int cadastrarAluno(Aluno a) throws CampoEmBrancoException {
        if (a.getNome() == null || a.getNome().trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome do aluno não pode estar em branco.");
        }
        if (a.getMatricula() == null || a.getMatricula().trim().isEmpty()) {
            throw new CampoEmBrancoException("Matrícula do aluno não pode estar em branco.");
        }
        boolean cadastrou = alunos.add(a);
        if (cadastrou) {
            numAlunos = alunos.size();
        }
        return numAlunos;
    }

    public Aluno pesquisarAluno(String matriculaAluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
                return a;
            }
        }
        return null;
    }

    public boolean removerAluno(Aluno a) {
        boolean removeu = false;
        if (alunos.contains(a)) {
            removeu = alunos.remove(a);
        }
        return removeu;
    }

    public boolean atualizarAluno(String matricula, Aluno a) throws CampoEmBrancoException {
        if (a.getNome() == null || a.getNome().trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome do aluno não pode estar em branco.");
        }
        if (a.getMatricula() == null || a.getMatricula().trim().isEmpty()) {
            throw new CampoEmBrancoException("Matrícula do aluno não pode estar em branco.");
        }
        boolean resposta = false;
        Aluno remover = pesquisarAluno(matricula);
        if (remover != null) {
            alunos.remove(remover);
            resposta = alunos.add(a);
        }
        return resposta;
    }

    public int cadastrar(Object o) throws CampoEmBrancoException {
        return cadastrarAluno((Aluno) o);
    }

    public Object pesquisar(String s) {
        return pesquisarAluno(s);
    }

    public boolean remover(Object o) {
        return removerAluno((Aluno) o);
    }

    public boolean atualizar(String matricula, Object o) throws CampoEmBrancoException {
        return atualizarAluno(matricula, (Aluno) o);
    }
}
