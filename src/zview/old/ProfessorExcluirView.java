package zview.old;

import control.ProfessorControl;
import javax.swing.JOptionPane;
import model.Professor;

/**
 * Classe ProfessorExcluirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class ProfessorExcluirView {

    private ProfessorControl professorControl = new ProfessorControl();

    public ProfessorExcluirView() {
    }

    public void show() {

        int id_excluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do professor a ser excluído:"));

        // Carrega o objeto a ser alterado
        Professor professorSelecionado2 = professorControl.getProfessor(id_excluir);

        if (professorSelecionado2 != null) {

            // Envia os dados ao Controlador                        
            boolean retorno = professorControl.excluir(id_excluir);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Professor excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluír o professor.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
