package view;

import model.Exemplar;
import model.Livro;

import control.ExemplarControl;
import control.LivroControl;

import javax.swing.JOptionPane;

/**
 * Classe ExemplarListarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 15/11/2016
 *
 * @package view
 *
 */
class ExemplarListarView {

    private final LivroControl livroControl;
    private final ExemplarControl exemplarControl;

    public ExemplarListarView() {
        this.livroControl = new LivroControl();
        this.exemplarControl = new ExemplarControl();
    }

    public void show() {
        String resultTxt;
        Livro livro;
        resultTxt = "";

        for (Exemplar exe : exemplarControl.getExemplares()) {
            livro = livroControl.getLivro(exe.getLivroId());

            resultTxt += "ID: " + exe.getId() + " | ";
            resultTxt += "Livro {ID " + livro.getId() + ", ";
            resultTxt += "Titulo: " + livro.getTitulo() + "} | ";
            resultTxt += "Edição" + exe.getEdicao() + "\n";

        }
        JOptionPane.showMessageDialog(null, resultTxt);
    }

}
