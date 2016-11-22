/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes.usuario;

import control.EmprestimoControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Emprestimo;
import zview.old.ProcedimentoEmprestimoEmprestarView;
import zview.old.ProcedimentoEmprestimoView;

/**
 *
 * @author Jean Barcellos
 */
public class EmprestimoTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new ProcedimentoEmprestimoView().show();

        EmprestimoControl emprestimoControl = new EmprestimoControl();

        List<Emprestimo> lista = emprestimoControl.getEmprestimos();
//        List<Emprestimo> lista = emprestimoControl.getExemplaresPegos(1);
//
        for (Emprestimo emprestimo : lista) {
            String resultTxt;
            resultTxt = "";
            resultTxt += "ID: " + emprestimo.getId() + " | ";
            resultTxt += "Usuário: " + emprestimo.getUsuario().getMatricula() + " - ";
            resultTxt += "" + emprestimo.getUsuario().getNome() + "\n";
            resultTxt += "LIVRO: " + emprestimo.getExemplar().getLivro().getTitulo() + " | ";
            resultTxt += "Edição" + emprestimo.getExemplar().getEdicao() + "\n";
            resultTxt += "DATAS: \n";
            resultTxt += "Empréstimo: " + emprestimo.getDataEmprestimo() + " | ";
            resultTxt += "Devolução previsão: " + emprestimo.getDataDevolucaoPrevista() + "\n\n";
//
            System.out.println(emprestimo);
        }
//        JOptionPane.showMessageDialog(null, resultTxt);

        System.out.println(emprestimoControl.getDisponibilidade(1));

    }

}
