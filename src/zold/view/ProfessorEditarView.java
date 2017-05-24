package zold.view;

import control.ProfessorControl;
import javax.swing.JOptionPane;
import model.Professor;

/**
 * Classe ProfessorEditarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class ProfessorEditarView {

    private ProfessorControl professorControl = new ProfessorControl();

    public ProfessorEditarView() {
    }

    public void show() {

        int id_alterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do professor a ser alterado:"));

        // Carrega o objeto a ser alterado
        Professor professor = professorControl.getProfessor(id_alterar);

        if (professor != null) {

            // Colher informação do usuário
            String nome = JOptionPane.showInputDialog("Informe a NOME do Professor:", professor.getNome());
            int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a MATRÍCULA do Professor:", professor.getMatricula()));

            // Altera o objeto selecionado                        
            professor.setNome(nome);
            professor.setMatricula(matricula);

            // Executa a alteração no controlador
            boolean retorno = professorControl.alterar(professor);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Professor alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o professor.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
