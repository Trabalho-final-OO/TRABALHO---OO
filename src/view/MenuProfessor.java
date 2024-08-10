package view;

import javax.swing.JOptionPane;

import app.Professor;
import cadastros.CadastroProfessor;

public class MenuProfessor {

    public static void menuProfessor(CadastroProfessor cadProf) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar professor\n"
                + "2 - Pesquisar professor\n"
                + "3 - Atualizar professor\n"
                + "4 - Remover professor\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfessor();
                    cadProf.cadastrarProfessor(novoProfessor);
                    break;

                case 2:
                    String matriculaFUB = lerMatriculaFUB();
                    Professor p = cadProf.pesquisarProfessor(matriculaFUB);
                    if (p != null)
                        JOptionPane.showMessageDialog(null, p.toString());
                    break;

                case 3:
                    matriculaFUB = lerMatriculaFUB();
                    Professor novoCadastro = dadosNovoProfessor();
                    boolean atualizado = cadProf.atualizarProfessor(matriculaFUB, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    matriculaFUB = lerMatriculaFUB();
                    Professor remover = cadProf.pesquisarProfessor(matriculaFUB);
                    boolean removido = cadProf.removerProfessor(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
                        System.gc();
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }

    public static Professor dadosNovoProfessor() {
        String nome = lerNome();
        String cpf = lerCPF();
        String email = lerEmail();
        String matriculaFUB = lerMatriculaFUB();
        String areaFormacao = lerAreaFormacao();
        return new Professor(nome, cpf, email, matriculaFUB, areaFormacao);
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor: ");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor: ");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor: ");
    }

    private static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    }

    private static String lerAreaFormacao() {
        return JOptionPane.showInputDialog("Informe a área de formação do professor: ");
    }
}
