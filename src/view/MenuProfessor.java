package view;

import javax.swing.JOptionPane;

import Exceptions.NaoHaProfessorCadastradoException;
import Exceptions.ProfessorNaoEncontradoException;
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
                        Professor novoProfessor = new Professor(null, null, null, null, null);
                        int numProfessores = cadProf.cadastrarProfessor(novoProfessor);
                        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
                        JOptionPane.showMessageDialog(null, novoProfessor.toString());
                        JOptionPane.showMessageDialog(null, "Agora você possui " + numProfessores + " cadastrados");
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        cadProf.validaProfessorCadastrado();
                    } catch (NaoHaProfessorCadastradoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        break;
                    }
                    String matriculaFUB = cadProf.lerMatriculaFUB();
                    Professor p = cadProf.pesquisarProfessor(matriculaFUB);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                    }
                    break;

                case 3:
                    matriculaFUB = cadProf.lerMatriculaFUB();
                    boolean atualizado = cadProf.atualizarProfessor(matriculaFUB);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Professor atualizado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não atualizado.");
                    }
                    break;

                case 4:
                    matriculaFUB = cadProf.lerMatriculaFUB();
                    try {
                        Professor professorARemover = cadProf.getProfessorByMatricula(matriculaFUB);
                        boolean removido = cadProf.removerProfessor(professorARemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover o professor.");
                        }
                    } catch (ProfessorNaoEncontradoException e) {
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
