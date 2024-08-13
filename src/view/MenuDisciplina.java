package view;

import Exceptions.CampoEmBrancoException;
import Exceptions.NaoHaDisciplinaCadastradoException;
import Exceptions.DisciplinaNaoEncontradoException;
import app.Disciplina;
import cadastros.CadastroDisciplina;

import javax.swing.*;

public class MenuDisciplina {

    public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Atualizar disciplina\n"
                + "4 - Remover disciplina\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    try {
                        Disciplina novoDisciplina = new Disciplina(null, null, null);
                        int numDisciplinaes = cadDisciplina.cadastrarDisciplina(novoDisciplina);
                        JOptionPane.showMessageDialog(null, "Disciplina cadastrado com sucesso!");
                        JOptionPane.showMessageDialog(null, novoDisciplina.toString());
                        JOptionPane.showMessageDialog(null, "Agora você possui " + numDisciplinaes + " cadastrados");
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        cadDisciplina.validaDisciplinaCadastrado();
                    } catch (NaoHaDisciplinaCadastradoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        break;
                    }
                    String codigo = cadDisciplina.lerCodigoDisciplina();
                    Disciplina p = cadDisciplina.pesquisarDisciplina(codigo);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Disciplina não encontrado.");
                    }
                    break;

                case 3:
                    codigo = cadDisciplina.lerCodigoDisciplina();
                    boolean atualizado = cadDisciplina.atualizarDisciplina(codigo);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Disciplina atualizado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Disciplina não atualizado.");
                    }
                    break;

                case 4:
                    codigo = cadDisciplina.lerCodigoDisciplina();
                    try {
                        Disciplina disciplinaARemover = cadDisciplina.getDisciplinaByCodigo(codigo);
                        boolean removido = cadDisciplina.removerDisciplina(disciplinaARemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Disciplina removido do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover o disciplina.");
                        }
                    } catch (DisciplinaNaoEncontradoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                default:
                    if (opcao != 0) {
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                    }
                    break;
            }
        } while (opcao != 0);
    }
}
