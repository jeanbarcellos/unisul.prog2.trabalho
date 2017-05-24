package zold.view;
import model.Professor;

import control.ProfessorControl;

import javax.swing.JOptionPane;

/**
 * Classe ProfessorInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class ProfessorInserirView {

    private ProfessorControl professorControl = new ProfessorControl();

    public ProfessorInserirView() {
    }

    public void show() {

        // Colher informação do usuário
        String nome = JOptionPane.showInputDialog("Informe a NOME do Professor:");
        int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a MATRÍCULA do Professor:"));

        // Cria o objeto de transição
        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setMatricula(matricula);

        // Envia o objeto criado para o controlador               
        boolean retorno = this.professorControl.inserir(professor);

        if (retorno) {
            JOptionPane.showMessageDialog(null, "Professor cadastrado com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Professor.");
        }
    }

}
