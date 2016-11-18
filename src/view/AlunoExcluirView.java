package view;

import control.AlunoControl;
import javax.swing.JOptionPane;
import model.Aluno;

/**
 * Classe AlunoExcluirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class AlunoExcluirView {

    private AlunoControl alunoControl = new AlunoControl();

    public AlunoExcluirView() {
    }

    public void show() {

        int id_excluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do aluno a ser excluído:"));

        // Carrega o objeto a ser alterado
        Aluno alunoSelecionado2 = alunoControl.getAluno(id_excluir);

        if (alunoSelecionado2 != null) {

            // Envia os dados ao Controlador                        
            boolean retorno = alunoControl.excluir(id_excluir);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluír o aluno.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
