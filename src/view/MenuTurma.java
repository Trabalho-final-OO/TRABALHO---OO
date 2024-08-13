package view;

import Exceptions.*;
import app.Aluno;
import app.Professor;
import app.Turma;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;

import javax.swing.*;

public class MenuTurma {

    public static void menuTurma(CadastroTurma cadTurma, CadastroAluno cadAluno, CadastroProfessor cadProf, CadastroDisciplina cadDic) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Imprimir lista de presenca\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    try {
                        Turma novaTurma = new Turma(null, 0, null, null, null, null);
                        int numTurmas = cadTurma.cadastrarTurma(novaTurma, cadAluno, cadProf, cadDic);
                        if (numTurmas == 0) {
                            JOptionPane.showMessageDialog(null, "Não é possível cadastrar uma turma sem professor e/ou disciplina.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
                            JOptionPane.showMessageDialog(null, novaTurma.toString());
                            JOptionPane.showMessageDialog(null, "Agora você possui " + numTurmas + " cadastrados");
                        }
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        cadTurma.validaTurmaCadastrada();
                    } catch (NaoHaTurmaCadastradaException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        break;
                    }
                    String codigoTurma = cadTurma.lerCodigo();
                    Turma p = cadTurma.pesquisarTurma(codigoTurma);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    codigoTurma = cadTurma.lerCodigo();
                    boolean atualizado = cadTurma.atualizarTurma(codigoTurma);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Turma atualizada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não atualizada.");
                    }
                    break;

                case 4:
                    codigoTurma = cadTurma.lerCodigo();
                    try {
                        Turma turmaARemover = cadTurma.getTurmaByCodigo(codigoTurma);
                        boolean removido = cadTurma.removerTurma(turmaARemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover a turma.");
                        }
                    } catch (TurmaNaoEncontradaException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        cadTurma.validaTurmaCadastrada();
                    } catch (NaoHaTurmaCadastradaException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        break;
                    }
                    codigoTurma = cadTurma.lerCodigo();
                    p = cadTurma.pesquisarTurma(codigoTurma);
                    if (p != null) {
                        String listadepresenca = p.toString();
                        listadepresenca = listadepresenca + '\n' + "Aluno(s): \n";
                        for (Aluno aluno : p.getAlunosTurma()) {
                            listadepresenca = listadepresenca + "- " + aluno.getNome() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listadepresenca);
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
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
