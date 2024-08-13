package cadastros;

import Exceptions.CampoEmBrancoException;
import Exceptions.NaoHaDisciplinaCadastradoException;
import Exceptions.DisciplinaNaoEncontradoException;
import app.Disciplina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroDisciplina extends Cadastros {

    private int numDisciplinas;
    private List<Disciplina> disciplinas;

    public CadastroDisciplina() {
        numDisciplinas = 0;
        disciplinas = new ArrayList<Disciplina>();
    }

    public int cadastrarDisciplina(Disciplina disciplina) throws CampoEmBrancoException {
        String nome = lerNomeDisciplina();
        String codigoDisciplina = lerCodigoDisciplina();

        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome da disciplina não pode estar em branco.");
        }
        if (codigoDisciplina == null || codigoDisciplina.trim().isEmpty()) {
            throw new CampoEmBrancoException("Código da disciplina não pode estar em branco.");
        }

        disciplina.setNomeDisciplina(nome);
        disciplina.setCodigoDisciplina(codigoDisciplina);
        disciplina.setCargaHoraria(lerCargaHoraria());

        this.disciplinas.add(disciplina);
        this.numDisciplinas = this.disciplinas.size();
        return this.numDisciplinas;
    }

    public Disciplina pesquisarDisciplina(String codigo) {
        try {
            Disciplina disciplina = getDisciplinaByCodigo(codigo);
            return disciplina;
        } catch (DisciplinaNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean removerDisciplina(Disciplina disciplina) {
        boolean removeu = false;
        if (this.disciplinas.contains(disciplina)) {
            removeu = this.disciplinas.remove(disciplina);
        }
        return removeu;
    }

    public boolean atualizarDisciplina(String codigo) {
        try {
            Disciplina disciplina = getDisciplinaByCodigo(codigo);
            disciplina.setNomeDisciplina(lerNomeDisciplina());
            disciplina.setCodigoDisciplina(lerCodigoDisciplina());
            disciplina.setCargaHoraria(lerCargaHoraria());
        } catch (DisciplinaNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    // Funções auxiliares

    public Disciplina getDisciplinaByCodigo(String codigo)  throws DisciplinaNaoEncontradoException, CampoEmBrancoException {
        if (codigo.equals("0")) {
            throw new CampoEmBrancoException("Codigo não informada");
        }
        for (Disciplina disciplina : this.disciplinas) {
            String disciplinaCodigo = disciplina.getCodigoDisciplina();
            if (disciplinaCodigo.equals(codigo)) {
                return disciplina;
            }
        }
        throw new DisciplinaNaoEncontradoException("Não há nenhum disciplina com essa codigo");
    }

    private static String lerNomeDisciplina() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    public static String lerCodigoDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    private static String lerCargaHoraria() {
        return JOptionPane.showInputDialog("Informe a carga horária da disciplina: ");
    }

    // Validação

    public void validaDisciplinaCadastrado() throws NaoHaDisciplinaCadastradoException {
        if (this.numDisciplinas < 1) {
            throw new NaoHaDisciplinaCadastradoException("Nenhum disciplina foi cadastro ainda");
        }
    }

    // Declaração das classes abstratas

    public int cadastrar(Object o) throws CampoEmBrancoException {
        return cadastrarDisciplina((Disciplina) o);
    }

    public Object pesquisar(String s) {
        return pesquisarDisciplina(s);
    }

    public boolean remover(Object o) {
        return removerDisciplina((Disciplina) o);
    }

    public boolean atualizar(String codigo){
            return atualizarDisciplina(codigo);
    }
}
