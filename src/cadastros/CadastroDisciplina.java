package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Disciplina;

public class CadastroDisciplina extends Cadastros {

    private int numDisciplinas;
    private List<Disciplina> disciplinas;

    public CadastroDisciplina() {
        numDisciplinas = 0;
        disciplinas = new ArrayList<Disciplina>();
    }

    public int cadastrarDisciplina(Disciplina d) {
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

    public boolean atualizarDisciplina(String codigoDisciplina, Disciplina d) {
        boolean resposta = false;
        Disciplina remover = pesquisarDisciplina(codigoDisciplina);
        if (remover != null) {
            disciplinas.remove(remover);
            resposta = disciplinas.add(d);
        }
        return resposta;
    }

    public int cadastrar(Object o) {
        return cadastrarDisciplina((Disciplina) o);
    }

    public Object pesquisar(String s) {
        return pesquisarDisciplina(s);
    }

    public boolean remover(Object o) {
        return removerDisciplina((Disciplina) o);
    }

    public boolean atualizar(String codigo, Object o) {
        return atualizarDisciplina(codigo, (Disciplina) o);
    }
}
