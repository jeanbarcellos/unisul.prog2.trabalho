package view;

import javax.swing.JOptionPane;

/**
 * Classe MenuProcedimentoView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/10/2016
 *
 * @package view
 *
 */
class MenuProcedimentoView {

    public MenuProcedimentoView() {
    }

    public void show() {

        int opcao = 1;

        while (opcao >= 1 && opcao <= 1) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Selecione uma das opção abaixo: \n"
                    + "\n"
                    + "1 - Emprestar exemplar \n"
                    + "0 - Voltar ao Menu Principal\n\n", "CONSULTAS", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    // Chama View de Emprestimo de Exemplar de um Livro
                    JOptionPane.showMessageDialog(null, "Empréstimo de exemplar de um livro");
                    break;
            }

        }

    }

}
