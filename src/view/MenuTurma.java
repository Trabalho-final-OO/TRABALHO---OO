package view;

import javax.swing.JOptionPane;

import app.Turma;
import cadastros.CadastroTurma;

public class MenuTurma {

    public static void menuTurma(CadastroTurma cadTurma) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma();
                    cadTurma.cadastrarTurma(novaTurma);
                    break;

                case 2:
                    int codigoTurma = lerCodigoTurma();
                    Turma t = cadTurma.pesquisarTurma(codigoTurma);
                    if (t != null)
                        JOptionPane.showMessageDialog(null, t.toString());
                    break;

                case 3:
                    codigoTurma = lerCodigoTurma();
                    Turma novoCadastro = dadosNovaTurma();
                    boolean atualizado = cadTurma.atualizarTurma(codigoTurma, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    codigoTurma = lerCodigoTurma();
                    Turma remover = cadTurma.pesquisarTurma(codigoTurma);
                    boolean removido = cadTurma.removerTurma(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        System.gc();
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }

    public static Turma dadosNovaTurma() {
        String disciplinaMinistrada = lerNomeDisciplinaMinistrada();
        int codigoTurma = lerCodigoTurma();
        String alunoTurma = lerAlunoTurma(); // Supondo que o menu turma precisaria ler isso.
        String professorTurma = lerProfessorTurma();
        String horaTurma = lerHoraTurma();
        String salaTurma = lerSalaTurma();
        return new Turma(disciplinaMinistrada, codigoTurma, alunoTurma, professorTurma, horaTurma, salaTurma);
    }

    private static String lerNomeDisciplinaMinistrada() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina ministrada: ");
    }

    private static int lerCodigoTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        return Integer.parseInt(codigo);
    }

    private static String lerAlunoTurma() {
        return JOptionPane.showInputDialog("Informe o nome do aluno na turma: ");
    }

    private static String lerProfessorTurma() {
        return JOptionPane.showInputDialog("Informe o nome do professor da turma: ");
    }

    private static String lerHoraTurma() {
        return JOptionPane.showInputDialog("Informe o horário da turma: ");
    }

    private static String lerSalaTurma() {
        return JOptionPane.showInputDialog("Informe a sala da turma: ");
    }
}
