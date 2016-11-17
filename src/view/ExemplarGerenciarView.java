package view;

import model.Livro;
import model.Exemplar;

import control.ExemplarControl;
import control.LivroControl;

import javax.swing.JOptionPane;

/**
 * Classe ExemplarGerenciarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 15/11/2016
 *
 * @package view
 *
 */
class ExemplarGerenciarView {

    private LivroControl livroControl;
    private ExemplarControl exemplarControl;

    public ExemplarGerenciarView() {
        this.livroControl = new LivroControl();
        this.exemplarControl = new ExemplarControl();
    }

    public void show() {
        int livroId;

        String texto = "";
        texto += "Informe o ID do Livro:\n";
        livroId = Integer.parseInt(JOptionPane.showInputDialog(texto));

        // Carrega o objeto a --------------------------------------------------
        Livro livro = livroControl.getLivro(livroId);

        if (livro == null) {
            JOptionPane.showMessageDialog(null, "O livro informado não existe.");
        } else {
            int opcao = 1;

            int totalExemplares = exemplarControl.total(livro.getId());

            while (opcao >= 1 && opcao <= 3) {

                String exemplaresTxt = "ID | Edição | Localização:\n";
                for (Exemplar exemp : exemplarControl.listar(livroId)) {
                    exemplaresTxt += "" + exemp.getId() + " | " + exemp.getEdicao() + " | " + exemp.getLocalizacao() + " \n";
                }

                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "LIVRO: \n"
                        + "Titulo: " + livro.getTitulo() + " | "
                        + "Autor: " + livro.getAutor() + " | "
                        + "Total Exemplares: " + totalExemplares + "\n"
                        + "\n"
                        + "EXEMPLARES: \n"
                        + exemplaresTxt
                        + "\n"
                        + "O que desejas fazer? \n"
                        + "1 - Cadastrar\n"
                        + "2 - Alterar \n"
                        + "3 - Apagar \n"
                        + "0 - Voltar ao menu de cadastros \n\n",
                        "GERENCIAR EXEMPLARES", JOptionPane.QUESTION_MESSAGE
                ));

                switch (opcao) {
                    case 1:
                        new ExemplarInserirView(livro).show();
                        break;
                    case 2:
                        new ExemplarEditarView(livro).show();
                        break;
                    case 3:
                        new ExemplarExcluirView().show();
                        break;
                }

            }

        }
    }

}
