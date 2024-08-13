import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import view.*;
import Exceptions.CampoEmBrancoException;
import Exceptions.DisciplinaNaoAtribuidaException;
import Exceptions.ProfessorNaoAtribuidoException;

public class  Principal {

    static CadastroAluno cadAluno;
    static CadastroProfessor cadProf;
    static CadastroDisciplina cadDisc;
    static CadastroTurma cadTurma;

    public static void main(String[] args)throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
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
                    MenuTurma.menuTurma(cadTurma, cadAluno, cadProf, cadDisc);
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
