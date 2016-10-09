package view;

import javax.swing.JOptionPane;

/**
 * Classe View
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package view
 *
 */
public class View {

    public void menu() {

        int opcao = 1;

        while (opcao > 0 && opcao < 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
                     "MENU \n"
                    + "\n"
                    + "1 - Cadastros \n"
                    + "2 - Consultas \n"
                    + "3 - Relatorios \n"
                    + "4 - Procedimentos \n\n"
                    + "0 - Sair do Sistema\n"
                    , "BIBLIOTECA UNIVERSITÁRIA", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    // Chama a view de Cadastros
                    new CadastroView().show();
                    break;
                case 2:
                    // Chama a view de Consultas
                    break;
                case 3:
                    // Chama a view de Relatórios
                    break;
                case 4:
                    // Chama a view de Procedimentos
                    break;
            }

        }

    }

}
