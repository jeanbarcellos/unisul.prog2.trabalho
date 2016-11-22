package view.old;

import javax.swing.JOptionPane;

/**
 * Classe ProfessorView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class ProfessorView {

    public ProfessorView() {
    }

    public void show() {

        int opcao = 1;

        while (opcao > 0 && opcao < 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "O que desejas fazer? \n"
                    + "\n"
                    + "1 - Cadastrar professor \n"
                    + "2 - Alterar dados de professor \n"
                    + "3 - Apagar professor \n"
                    + "4 - Listar todos professors \n"
                    + "0 - Voltar ao menu de cadastros \n\n",
                    "GERENCIAR ALUNOS", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    new ProfessorInserirView().show();
                    break;
                case 2:
                    new ProfessorEditarView().show();
                    break;
                case 3:
                    new ProfessorExcluirView().show();
                    break;
                case 4:
                    new ProfessorListarView().show();
                    break;
            }
        }
    }

}
