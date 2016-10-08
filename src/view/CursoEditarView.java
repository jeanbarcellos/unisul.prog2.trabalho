package view;

import javax.swing.JOptionPane;

/**
 * Classe CursoEditarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class CursoEditarView {

    public void show() {

        int id;
        String curso;

        id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser alterado:"));
        curso = JOptionPane.showInputDialog("Informe o novo nome do curso:");

    }

}
