/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import control.AlunoControl;
import control.EmprestimoControl;
import control.ExemplarControl;
import control.ProfessorControl;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Exemplar;
import model.dao.DaoFactory;
import model.dao.EmprestimoDao;

/**
 *
 * @author Jean Barcellos
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EmprestimoControl emprestimoControl = new EmprestimoControl();
        AlunoControl alunoControl = new AlunoControl();
        ExemplarControl exemplarControl = new ExemplarControl();

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(alunoControl.getAluno(3));
        emprestimo.setExemplar(exemplarControl.getExemplar(13));

        boolean retorno = emprestimoControl.inserir(emprestimo);

        if (retorno) {
            JOptionPane.showMessageDialog(null, "Emprestidmo realizado com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao realizado Emprestimo.");
        }
    }

}
