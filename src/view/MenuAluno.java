package view;

import Exceptions.CampoEmBrancoException;
import Exceptions.NaoHaAlunoCadastradoException;
import Exceptions.AlunoNaoAtribuidaException;
import app.Aluno;
import cadastros.CadastroAluno;

import javax.swing.*;

public class MenuAluno {

    public static void menuAluno(CadastroAluno cadAluno) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar aluno\n"
                + "2 - Pesquisar aluno\n"
                + "3 - Atualizar aluno\n"
                + "4 - Remover aluno\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    try {
                        Aluno novoAluno = new Aluno(null, null, null, null, null);
                        int numAlunos = cadAluno.cadastrarAluno(novoAluno);
                        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                        JOptionPane.showMessageDialog(null, novoAluno.toString());
                        JOptionPane.showMessageDialog(null, "Agora você possui " + numAlunos + " cadastrados");
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        cadAluno.validaAlunoCadastrado();
                    } catch (NaoHaAlunoCadastradoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        break;
                    }
                    String matricula = cadAluno.lerMatricula();
                    Aluno p = cadAluno.pesquisarAluno(matricula);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                    }
                    break;

                case 3:
                    matricula = cadAluno.lerMatricula();
                    boolean atualizado = cadAluno.atualizarAluno(matricula);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Aluno atualizado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aluno não atualizado.");
                    }
                    break;

                case 4:
                    matricula = cadAluno.lerMatricula();
                    try {
                        Aluno alunoARemover = cadAluno.getAlunoByMatricula(matricula);
                        boolean removido = cadAluno.removerAluno(alunoARemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Aluno removido do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover o aluno.");
                        }
                    } catch (AlunoNaoAtribuidaException e) {
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
