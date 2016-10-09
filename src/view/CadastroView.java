package view;

import javax.swing.JOptionPane;

/**
 * Classe CadastroView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class CadastroView {

    public void show() {

        int opcao = 1;

        while (opcao > 0 && opcao < 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Selecione uma das opção abaixo: \n"
                    + "\n"
                    + "1 - Curso \n"
                    + "2 - Aluno \n"
                    + "3 - Professor \n"
                    + "4 - Livro \n"
                    + "5 - Exemplar \n"
                    + "0 - Voltar ao Menu Principal\n\n"
                    , "CADASTROS", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    new CursoView().show();
                    break;
                case 2:
                    // Chama Aluno
                    break;
                case 3:
                    // Chama Professor
                    break;
                case 4:
                    // Chama Livro
                    break;
                case 5:
                    // Chama Exemplar
                    break;
            }

        }

    }

}
