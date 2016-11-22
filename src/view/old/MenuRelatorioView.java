package view.old;

import javax.swing.JOptionPane;

/**
 * Classe MenuRelatorioView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/10/2016
 *
 * @package view
 *
 */
public class MenuRelatorioView {

    public MenuRelatorioView() {
    }

    public void show() {

        int opcao = 1;

        while (opcao >= 1 && opcao <= 2) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Selecione uma das opção abaixo: \n"
                    + "\n"
                    + "1 - Livros Emprestados em um período \n"
                    + "2 - Top 100 dos livros\n"
                    + "0 - Voltar ao Menu Principal\n\n", "RELATÓRIOS", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    // 
                    JOptionPane.showMessageDialog(null, "Livros Emprestados por período");
                    break;
                case 2:
                    // 
                    JOptionPane.showMessageDialog(null, "Top 100 dos livros");
                    break;
            }

        }

    }

}
