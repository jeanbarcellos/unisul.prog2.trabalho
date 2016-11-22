package zview.old;

import control.AlunoControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;

/**
 * Classe AlunoListarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class AlunoListarView {

    private AlunoControl alunoControl = new AlunoControl();

    public AlunoListarView() {
    }

    /**
     * Exibe os livros cadastrados
     */
    public void show() {
        List<Aluno> lista = alunoControl.getAlunos();

        String texto = "Livros Cadastrados:\n";
        for (Aluno aluno : lista) {
            texto += "ID: " + aluno.getId() + " - ";
            texto += "Nome: " + aluno.getNome() + " - ";
            texto += "Matrícula: " + aluno.getMatricula() + " - ";
            texto += "Curso: " + aluno.getCurso().getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

}
