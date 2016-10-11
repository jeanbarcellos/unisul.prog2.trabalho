package view;

import control.CursoControl;
import javax.swing.JOptionPane;
import model.Curso;

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

    CursoControl cursoControl;

    public CursoExcluirView() {
        this.cursoControl = new CursoControl();
    }
    
    public void show() {

        int id_excluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser excluído:"));

        // Carrega o objeto a ser alterado
        Curso cursoSelecionado2 = cursoControl.getCurso(id_excluir);

        if (cursoSelecionado2 != null) {

            // Envia os dados ao Controlador                        
            boolean retorno = cursoControl.excluir(id_excluir);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Curso excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluír o curso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }
}
