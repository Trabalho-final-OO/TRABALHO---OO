package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Turma;

public class CadastroTurma extends Cadastros {

    private int numTurmas;
    private List<Turma> turmas;

    public CadastroTurma() {
        numTurmas = 0;
        turmas = new ArrayList<Turma>();
    }

    public int cadastrarTurma(Turma t) {
        boolean cadastrou = turmas.add(t);
        if (cadastrou) {
            numTurmas = turmas.size();
        }
        return numTurmas;
    }

    public Turma pesquisarTurma(String codigoTurma) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma t) {
        boolean removeu = false;
        if (turmas.contains(t)) {
            removeu = turmas.remove(t);
        }
        return removeu;
    }

    public boolean atualizarTurma(String codigoTurma, Turma t) {
        boolean resposta = false;
        Turma remover = pesquisarTurma(codigoTurma);
        if (remover != null) {
            turmas.remove(remover);
            resposta = turmas.add(t);
        }
        return resposta;
    }

    public int cadastrar(Object o) {
        return cadastrarTurma((Turma) o);
    }

    public Object pesquisar(String s) {
        return pesquisarTurma(s);
    }

    public boolean remover(Object o) {
        return removerTurma((Turma) o);
    }

    public boolean atualizar(String codigo, Object o) {
        return atualizarTurma(codigo, (Turma) o);
    }
}
