package view;

import javax.swing.JOptionPane;

import app.Disciplina;
import cadastros.CadastroDisciplina;

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
                    Disciplina novaDisciplina = dadosNovaDisciplina();
                    cadDisciplina.cadastrarDisciplina(novaDisciplina);
                    break;

                case 2:
                    String codigoDisciplina = lerCodigoDisciplina();
                    Disciplina d = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
                    if (d != null)
                        JOptionPane.showMessageDialog(null, d.toString());
                    break;

                case 3:
                    codigoDisciplina = lerCodigoDisciplina();
                    Disciplina novoCadastro = dadosNovaDisciplina();
                    boolean atualizado = cadDisciplina.atualizarDisciplina(codigoDisciplina, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    codigoDisciplina = lerCodigoDisciplina();
                    Disciplina remover = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
                    boolean removido = cadDisciplina.removerDisciplina(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
                        System.gc();
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
        return;
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
