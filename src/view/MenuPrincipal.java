package view;
import javax.swing.JOptionPane;
public class MenuPrincipal {
    public static int menuOpcoes() {
        String opcoes = "1 - Abrir menu de alunos \n"
                + "2 - Abrir menu de professores \n"
                + "3 - Abrir menu de disciplinas \n"
                + "4 - Abrir menu de turma \n"
                + "0 - Sair";

        String strOpcao = JOptionPane.showInputDialog(opcoes);
        int opcao = Integer.parseInt(strOpcao);

        return opcao;
    }

}
