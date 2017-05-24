package zold.view;

import javax.swing.JOptionPane;

/**
 * Classe ProcedimentoEmprestimoView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 19/11/2016
 *
 * @package view
 *
 */
public class ProcedimentoEmprestimoView {

    public void show() {
        int opcao = 1;

        while (opcao > 0 && opcao < 3) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Qual procedimento de Emprestimo desejas realizar? \n"
                    + "\n"
                    + "1 - Realiza Emprestimo\n"
                    + "2 - Listar emprestimos ativos\n"
                    + "3 - Realizar revolução \n"
                    + "0 - Voltar ao menu de cadastros \n\n",
                    "GERENCIAR EMPRÉSTIMO", JOptionPane.QUESTION_MESSAGE
            ));

            switch (opcao) {

                case 1:
                    new ProcedimentoEmprestimoEmprestarView().show();
                    break;
                case 2:
                    new ProcedimentoEmprestimoLitarAtivosView().show();
                    break;
                case 3:
//                    new ProcedimentoEmprestimoDevolverView().show();
                    break;
            }
        }

    }

}
