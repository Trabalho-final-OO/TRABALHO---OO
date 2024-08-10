package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Disciplina;
import Exceptions.CampoEmBrancoException;

public class CadastroDisciplina extends Cadastros {

    private int numDisciplinas;
    private List<Disciplina> disciplinas;

    public CadastroDisciplina() {
        numDisciplinas = 0;
        disciplinas = new ArrayList<Disciplina>();
    }

    public int cadastrarDisciplina(Disciplina d) throws CampoEmBrancoException {
        if (d.getNomeDisciplina() == null || d.getNomeDisciplina().trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome da disciplina não pode estar em branco.");
        }
        if (d.getCodigoDisciplina() == null || d.getCodigoDisciplina().trim().isEmpty()) {
            throw new CampoEmBrancoException("Código da disciplina não pode estar em branco.");
        }
        boolean cadastrou = disciplinas.add(d);
        if (cadastrou) {
            numDisciplinas = disciplinas.size();
        }
        return numDisciplinas;
    }

    public Disciplina pesquisarDisciplina(String codigoDisciplina) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina)) {
                return d;
            }
        }
        return null;
    }

    public boolean removerDisciplina(Disciplina d) {
        boolean removeu = false;
        if (disciplinas.contains(d)) {
            removeu = disciplinas.remove(d);
        }
        return removeu;
    }

    public boolean atualizarDisciplina(String codigoDisciplina, Disciplina d) throws CampoEmBrancoException {
        if (d.getNomeDisciplina() == null || d.getNomeDisciplina().trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome da disciplina não pode estar em branco.");
        }
        if (d.getCodigoDisciplina() == null || d.getCodigoDisciplina().trim().isEmpty()) {
            throw new CampoEmBrancoException("Código da disciplina não pode estar em branco.");
        }
        boolean resposta = false;
        Disciplina remover = pesquisarDisciplina(codigoDisciplina);
        if (remover != null) {
            disciplinas.remove(remover);
            resposta = disciplinas.add(d);
        }
        return resposta;
    }

    public int cadastrar(Object o) throws CampoEmBrancoException {
        return cadastrarDisciplina((Disciplina) o);
    }

    public Object pesquisar(String s) {
        return pesquisarDisciplina(s);
    }

    public boolean remover(Object o) {
        return removerDisciplina((Disciplina) o);
    }

    public boolean atualizar(String codigo, Object o) throws CampoEmBrancoException {
        return atualizarDisciplina(codigo, (Disciplina) o);
    }
}


