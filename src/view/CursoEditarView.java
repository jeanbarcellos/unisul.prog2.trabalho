package view;

import control.CursoControl;
import javax.swing.JOptionPane;
import model.Curso;

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

    private final CursoControl cursoControl;

    public CursoEditarView() {
        this.cursoControl = new CursoControl();
    }

    public void show() {

        int id_alterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser alterado:"));

        // Carrega o objeto a ser alterado
        Curso cursoSelecionado = cursoControl.getCurso(id_alterar);

        if (cursoSelecionado != null) {

            String nome_novo = JOptionPane.showInputDialog("Informe o novo nome do curso:");

            // Altera o objeto selecionado                        
            cursoSelecionado.setNome(nome_novo);

            // Executa a alteração no controlador
            boolean retorno = cursoControl.alterar(cursoSelecionado.getId(), cursoSelecionado);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Curso alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o curso.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
