import javax.swing.JOptionPane;
import cadastros.CadastroProfessor;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroTurma;
import view.MenuAluno;
import view.MenuPrincipal;
import view.MenuProfessor;
import view.MenuDisciplina;
import view.MenuTurma;

public class Principal {

    static CadastroAluno cadAluno;
    static CadastroProfessor cadProf;
    static CadastroDisciplina cadDisc;
    static CadastroTurma cadTurma;

    public static void main(String[] args) {
        cadAluno = new CadastroAluno();
        cadProf = new CadastroProfessor();
        cadDisc = new CadastroDisciplina();
        cadTurma = new CadastroTurma();

        int opcao = 0;

        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 1:
                    MenuAluno.menuAluno(cadAluno);
                    break;
                case 2:
                    MenuProfessor.menuProfessor(cadProf);
                    break;
                case 3:
                    MenuDisciplina.menuDisciplina(cadDisc);
                    break;
                case 4:
                    MenuTurma.menuTurma(cadTurma);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
        return;
    }
}
