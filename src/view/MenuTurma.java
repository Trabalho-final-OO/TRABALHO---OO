package view;

import javax.swing.JOptionPane;
import app.Turma;
import cadastros.CadastroTurma;
import Exceptions.CampoEmBrancoException;
import Exceptions.DisciplinaNaoAtribuidaException;
import Exceptions.ProfessorNaoAtribuidoException;

public class MenuTurma {

    public static void menuTurma(CadastroTurma cadTurma) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Imprimir lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    try {
                        Turma novaTurma = dadosNovaTurma();
                        cadTurma.cadastrarTurma(novaTurma);
                        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
                    } catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    int codigoTurma = lerCodigoTurma();
                    Turma t = cadTurma.pesquisarTurma(codigoTurma);
                    if (t != null) {
                        JOptionPane.showMessageDialog(null, t.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    try {
                        codigoTurma = lerCodigoTurma();
                        Turma novoCadastro = dadosNovaTurma();
                        boolean atualizado = cadTurma.atualizarTurma(codigoTurma, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                        }
                    } catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    codigoTurma = lerCodigoTurma();
                    Turma remover = cadTurma.pesquisarTurma(codigoTurma);
                    if (remover != null) {
                        boolean removido = cadTurma.removerTurma(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                            System.gc();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao remover a turma.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 5:
                    codigoTurma = lerCodigoTurma();
                    Turma turma = cadTurma.pesquisarTurma(codigoTurma);
                    if (turma != null) {
                        imprimirListaPresenca(turma);
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

    public static Turma dadosNovaTurma() {
        String disciplinaMinistrada = lerNomeDisciplinaMinistrada();
        int codigoTurma = lerCodigoTurma();
        String alunoTurma = lerAlunoTurma();
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

    private static void imprimirListaPresenca(Turma turma) {
        StringBuilder listaPresenca = new StringBuilder();
        listaPresenca.append("Disciplina: ").append(turma.getDisciplinaMinistrada()).append("\n");
        listaPresenca.append("Código da Turma: ").append(turma.getCodigoTurma()).append("\n");
        listaPresenca.append("Professor: ").append(turma.getProfessorTurma()).append("\n");
        listaPresenca.append("Horário: ").append(turma.getHoraTurma()).append("\n");
        listaPresenca.append("Sala: ").append(turma.getSalaTurma()).append("\n");
        listaPresenca.append("Aluno(s): ").append(turma.getAlunoTurma()).append("\n");

        JOptionPane.showMessageDialog(null, listaPresenca.toString());
    }
}
