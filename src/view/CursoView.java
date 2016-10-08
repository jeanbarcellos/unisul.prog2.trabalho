package view;

import javax.swing.JOptionPane;


/**
 * Classe CursoView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 27/09/2016
 *
 * @package view
 *
 */
public class CursoView {

    public void show() {

        int opcao = 1;

        while (opcao > 0 && opcao < 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Gerenciar Curso \n"
                    + "\n"
                    + "O que desejas fazer? \n"
                    + "\n"
                    + "1 - Cadastrar \n"
                    + "2 - Alterar \n"
                    + "3 - Apagar \n"
                    + "4 - Listar \n"
                    + "5 - SAIR\n\n"
            ));

            switch (opcao) {

                case 1:
                    new CursoInserirView().show();
                    break;
                case 2:                    
                    new CursoEditarView().show();
                    break;                    
                case 3:
                    new CursoExcluirView().show();
                    break;
                case 4:
                    new CursoListarView().show();
                    break;
            }
        }
    }

}
