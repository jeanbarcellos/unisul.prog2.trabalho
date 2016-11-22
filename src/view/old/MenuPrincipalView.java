package view.old;

import javax.swing.JOptionPane;

/**
 * Classe MenuPrincipalView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package view
 *
 */
public class MenuPrincipalView {

    public MenuPrincipalView() {
    }

    public void show() {

        int opcao = 1;

        while (opcao >= 1 && opcao <= 4) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "MENU \n"
                    + "\n"
                    + "1 - Cadastros \n"
                    + "2 - Procedimentos \n"
                    + "3 - Consultas \n"
                    + "4 - Relatorios \n"
                    + "0 - Sair do Sistema\n\n", "BIBLIOTECA UNIVERSITÁRIA", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    // Chama a view de Cadastros
                    new MenuCadastroView().show();
                    break;
                case 2:
                    // Chama a view de Procedimentos
                    new MenuProcedimentoView().show();
                    break;
                case 3:
                    // Chama a view de Consultas
                    new MenuConsultaView().show();
                    break;
                case 4:
                    // Chama a view de Relatórios
                    new MenuRelatorioView().show();
                    break;
            }

        }

    }

}
