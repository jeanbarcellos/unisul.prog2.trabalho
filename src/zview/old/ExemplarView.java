package zview.old;

import javax.swing.JOptionPane;

/**
 * Classe ExemplarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package view
 *
 */
public class ExemplarView {

    /**
     * Exibir conteudo view
     */
    public void show() {

        int opcao = 1;

        while (opcao > 0 && opcao < 3) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "O que desejas fazer? \n"
                    + "\n"
                    + "1 - Gerenciar exemplares de um livro\n"
                    + "2 - Listar todosex emplares\n"
                    + "0 - Voltar ao menu de cadastros \n\n",
                    "GERENCIAR EXEMPLAR", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    new ExemplarGerenciarView().show();
                    break;
                case 2:
                    new ExemplarListarView().show();
                    break;
            }
        }
    }

}
