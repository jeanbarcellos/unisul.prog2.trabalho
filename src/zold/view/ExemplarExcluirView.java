package zold.view;

import control.ExemplarControl;
import control.ExemplarControl;
import control.LivroControl;
import javax.swing.JOptionPane;
import model.Exemplar;

/**
 * Classe ExemplarExcluirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 15/11/2016
 *
 * @package view
 *
 */
public class ExemplarExcluirView {

    private ExemplarControl exemplarControl = new ExemplarControl();

    public ExemplarExcluirView() {
    }

    public void show() {

        int id_excluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do exemplar a ser excluído:"));

        // Carrega o objeto a ser alterado
        Exemplar exemplarSelecionado2 = exemplarControl.getExemplar(id_excluir);

        if (exemplarSelecionado2 != null) {

            // Envia os dados ao Controlador                        
            boolean retorno = exemplarControl.excluir(id_excluir);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Exemplar excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluír o exemplar.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
