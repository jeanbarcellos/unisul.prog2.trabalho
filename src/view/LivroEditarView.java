package view;

import model.Livro;
import control.LivroControl;

import javax.swing.JOptionPane;

/**
 * Classe LivroEditarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package view
 *
 */
class LivroEditarView {

    private final LivroControl livroControl;

    public LivroEditarView() {
        this.livroControl = new LivroControl();
    }

    public void show() {

        int id_alterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do livro a ser alterado:"));

        // Carrega o objeto a ser alterado
        Livro livroSelecionado = livroControl.getLivro(id_alterar);

        if (livroSelecionado != null) {

            String titulo_novo = JOptionPane.showInputDialog("Informe o novo TITULO do livro:");
            String autor_novo = JOptionPane.showInputDialog("Informe o novo AUTOR do livro:");

            livroSelecionado.setTitulo(titulo_novo);
            livroSelecionado.setAutor(autor_novo);

            // Executa a alteração no controlador
            boolean retorno = livroControl.alterar(livroSelecionado.getId(), livroSelecionado);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Livro alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o livro.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
