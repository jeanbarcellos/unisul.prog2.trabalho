package zold.view;

import javax.swing.JOptionPane;

/**
 * Classe MenuConsultaView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/10/2016
 *
 * @package view
 *
 */
public class MenuConsultaView {

    public MenuConsultaView() {
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
                    + "0 - Voltar ao Menu Principal\n\n", "CONSULTAS", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    // Chama View de Consulta de Curso
                    JOptionPane.showMessageDialog(null, "Consulta Curso");
                    break;
                case 2:
                    // Chama View de Consulta de Aluno
                    JOptionPane.showMessageDialog(null, "Consulta Aluno");
                    break;
                case 3:
                    // Chama View de Consulta de Professor
                    JOptionPane.showMessageDialog(null, "Consulta Professor");
                    break;
                case 4:
                    // Chama View de Consulta de Livro
                    JOptionPane.showMessageDialog(null, "Consulta Livro");
                    break;
                case 5:
                    // Chama View de Consulta de Exemplar
                    JOptionPane.showMessageDialog(null, "Consulta Exemplar");
                    break;
            }

        }

    }

}
