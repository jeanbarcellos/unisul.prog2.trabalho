package view.old;

import control.LivroControl;
import model.Livro;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe LivroListarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package view
 *
 */
public class LivroListarView {

    private LivroControl livroControl = new LivroControl();;

    public LivroListarView() {        
    }

    /**
     * Exibe os livros cadastrados
     */
    public void show() {
        List<Livro> lista = livroControl.getLivros();

        String texto = "Livros Cadastrados:\n";
        for (int i = 0; i < lista.size(); i++) {
            Livro livroExt = lista.get(i);
            texto += "ID: " + livroExt.getId() + " - ";
            texto += "Título: " + livroExt.getTitulo() + " - ";
            texto += "Autor: " + livroExt.getAutor() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

}
