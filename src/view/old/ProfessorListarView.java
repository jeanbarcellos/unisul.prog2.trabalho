package view.old;

import control.ProfessorControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Professor;

/**
 * Classe ProfessorListarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class ProfessorListarView {

    private ProfessorControl professorControl = new ProfessorControl();

    public ProfessorListarView() {
    }

    /**
     * Exibe os livros cadastrados
     */
    public void show() {
        List<Professor> lista = professorControl.getProfessores();

        String texto = "Livros Cadastrados:\n";
        for (Professor professor : lista) {
            texto += "ID: " + professor.getId() + " - ";
            texto += "Nome: " + professor.getNome() + " - ";
            texto += "Matrícula: " + professor.getMatricula() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

}
