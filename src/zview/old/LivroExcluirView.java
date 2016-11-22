package zview.old;

import model.Livro;
import control.LivroControl;

import javax.swing.JOptionPane;

/**
 * Classe LivroExcluirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package view
 *
 */
public class LivroExcluirView {

    private final LivroControl livroControl;

    public LivroExcluirView() {
        this.livroControl = new LivroControl();
    }

    public void show() {

        int id_excluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do livro a ser excluído:"));

        // Carrega o objeto a ser alterado
        Livro livroSelecionado2 = livroControl.getLivro(id_excluir);

        if (livroSelecionado2 != null) {

            // Envia os dados ao Controlador                        
            boolean retorno = livroControl.excluir(id_excluir);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Livro excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluír o livro.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }
}
