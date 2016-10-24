package view;

import javax.swing.JOptionPane;

/**
 * Classe LivroView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package view
 *
 */
public class LivroView {

    /**
     * Exibir conteudo view
     */
    public void show() {

        int opcao = 1;

        while (opcao > 0 && opcao < 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "O que desejas fazer? \n"
                    + "\n"
                    + "1 - Cadastrar \n"
                    + "2 - Alterar \n"
                    + "3 - Apagar \n"
                    + "4 - Listar \n"
                    + "0 - Voltar ao menu de cadastros \n\n",
                    "GERENCIAR LIVRO", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    new LivroInserirView().show();
                    break;
                case 2:
                    new LivroEditarView().show();
                    break;
                case 3:
                    new LivroExcluirView().show();
                    break;
                case 4:
                    new LivroListarView().show();
                    break;
            }
        }
    }

}
