package view;

import javax.swing.JOptionPane;

/**
 * Classe MenuCadastroView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class MenuCadastroView {

    public MenuCadastroView() {
    }

    public void show() {

        int opcao = 1;

        while (opcao >= 1 && opcao <= 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Selecione uma das opção abaixo: \n"
                    + "\n"
                    + "1 - Curso \n"
                    + "2 - Aluno \n"
                    + "3 - Professor \n"
                    + "4 - Livro \n"
                    + "5 - Exemplar \n"
                    + "0 - Voltar ao Menu Principal\n\n", "CADASTROS", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    // Chama View de Cadastro de Curso
                    new CursoView().show();
                    break;
                case 2:
                    // Chama View de Cadastro de Aluno
                    new AlunoView().show();
                    break;
                case 3:
                    // Chama View de Cadastro de Professor
                    new ProfessorView().show();
                    break;
                case 4:
                    // Chama View de Cadastro de Livro
                    new LivroView().show();
                    break;
                case 5:
                    // Chama View de Cadastro de Exemplar
                    new ExemplarView().show();
                    break;
            }

        }

    }

}
