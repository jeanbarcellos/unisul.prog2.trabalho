package view;

import javax.swing.JOptionPane;

/**
 * Classe CursoExcluirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class CursoExcluirView {

    public void show() {

        int id;

        id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código:"));
    }
}
