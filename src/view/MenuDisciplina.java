package view;

import javax.swing.JOptionPane;
import app.Disciplina;
import cadastros.CadastroDisciplina;
import Exceptions.CampoEmBrancoException;

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
                        Disciplina novaDisciplina = dadosNovaDisciplina();
                        cadDisciplina.cadastrarDisciplina(novaDisciplina);
                        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    String codigoDisciplina = lerCodigoDisciplina();
                    Disciplina d = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
                    if (d != null) {
                        JOptionPane.showMessageDialog(null, d.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
                    }
                    break;

                case 3:
                    try {
                        codigoDisciplina = lerCodigoDisciplina();
                        Disciplina novoCadastro = dadosNovaDisciplina();
                        boolean atualizado = cadDisciplina.atualizarDisciplina(codigoDisciplina, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
                        }
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    codigoDisciplina = lerCodigoDisciplina();
                    Disciplina remover = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
                    if (remover != null) {
                        boolean removido = cadDisciplina.removerDisciplina(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover a disciplina.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
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

    public static Disciplina dadosNovaDisciplina() {
        String nomeDisciplina = lerNomeDisciplina();
        String codigoDisciplina = lerCodigoDisciplina();
        String cargaHoraria = lerCargaHoraria();
        int turmaDisciplina = lerTurmaDisciplina();
        return new Disciplina(nomeDisciplina, codigoDisciplina, cargaHoraria, turmaDisciplina);
    }

    private static String lerNomeDisciplina() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    private static String lerCodigoDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    private static String lerCargaHoraria() {
        return JOptionPane.showInputDialog("Informe a carga horária da disciplina: ");
    }

    private static int lerTurmaDisciplina() {
        String turma = JOptionPane.showInputDialog("Informe o código da turma: ");
        return Integer.parseInt(turma);
    }
}
