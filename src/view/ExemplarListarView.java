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
public class ExemplarListarView {

    private ExemplarControl exemplarControl;

    public ExemplarListarView() {
        this.exemplarControl = new ExemplarControl();
    }

    public void show() {
        String resultTxt;
        resultTxt = "";

        for (Exemplar exe : exemplarControl.getExemplares()) {            
            resultTxt += "ID: " + exe.getId() + " | ";
            resultTxt += "Livro {ID " + exe.getLivro().getId() + ", ";
            resultTxt += "Titulo: " + exe.getLivro().getTitulo() + "} ";
            resultTxt += "Edição" + exe.getEdicao() + "\n";

        }
        JOptionPane.showMessageDialog(null, resultTxt);
    }

}
