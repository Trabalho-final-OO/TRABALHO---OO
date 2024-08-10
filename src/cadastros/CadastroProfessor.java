package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Professor;

public class CadastroProfessor extends Cadastros {

    private int numProfessores;
    private List<Professor> professores;

    public CadastroProfessor() {
        numProfessores = 0;
        professores = new ArrayList<Professor>();
    }

    public int cadastrarProfessor(Professor p) {
        boolean cadastrou = professores.add(p);
        if (cadastrou) {
            numProfessores = professores.size();
        }
        return numProfessores;
    }

    public Professor pesquisarProfessor(String matriculaFUB) {
        for (Professor p : professores) {
            if (p.getMatricula().equalsIgnoreCase(matriculaFUB)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerProfessor(Professor p) {
        boolean removeu = false;
        if (professores.contains(p)) {
            removeu = professores.remove(p);
        }
        return removeu;
    }

    public boolean atualizarProfessor(String matricula, Professor p) {
        boolean resposta = false;
        Professor remover = pesquisarProfessor(matricula);
        if (remover != null) {
            professores.remove(remover);
            resposta = professores.add(p);
        }
        return resposta;
    }

    public int cadastrar(Object o) {
        return cadastrarProfessor((Professor) o);
    }

    public Object pesquisar(String s) {
        return pesquisarProfessor(s);
    }

    public boolean remover(Object o) {
        return removerProfessor((Professor) o);
    }

    public boolean atualizar(String matricula, Object o) {
        return atualizarProfessor(matricula, (Professor) o);
    }
}
