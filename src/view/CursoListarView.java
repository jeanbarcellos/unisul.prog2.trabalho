package view;

import control.CursoControl;
import java.util.List;
import model.Curso;

import javax.swing.JOptionPane;

/**
 * Classe CursoListarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class CursoListarView {

    CursoControl cursoControl;

    public CursoListarView() {
        this.cursoControl = new CursoControl();
    }

    /**
     * Exibe os cursos cadastrados
     */
    public void show() {

        List<Curso> lista = cursoControl.getCursos();

        String texto = "Cursos Cadastrados:\n";
        for (int i = 0; i < lista.size(); i++) {
            Curso cursoExt = lista.get(i);
            texto += "ID: " + cursoExt.getId() + " - ";
            texto += "Nome: " + cursoExt.getNome() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);

    }

}
