package view;

import javax.swing.JOptionPane;
import app.Professor;
import cadastros.CadastroProfessor;
import Exceptions.CampoEmBrancoException;

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
                    try {
                        Professor novoProfessor = dadosNovoProfessor();
                        cadProf.cadastrarProfessor(novoProfessor);
                        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    String matriculaFUB = lerMatriculaFUB();
                    Professor p = cadProf.pesquisarProfessor(matriculaFUB);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                    }
                    break;

                case 3:
                    try {
                        matriculaFUB = lerMatriculaFUB();
                        Professor novoCadastro = dadosNovoProfessor();
                        boolean atualizado = cadProf.atualizarProfessor(matriculaFUB, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                        }
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    matriculaFUB = lerMatriculaFUB();
                    Professor remover = cadProf.pesquisarProfessor(matriculaFUB);
                    if (remover != null) {
                        boolean removido = cadProf.removerProfessor(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover o professor.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado.");
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
