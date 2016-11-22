package zview.old;

import control.EmprestimoControl;
import javax.swing.JOptionPane;
import model.Emprestimo;

/**
 * Classe ProcedimentoEmprestimoLitarAtivosView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 19/11/2016
 *
 * @package view
 *
 */
public class ProcedimentoEmprestimoLitarAtivosView {

    private EmprestimoControl emprestimoControl = new EmprestimoControl();
    
    public ProcedimentoEmprestimoLitarAtivosView() {
    }

    public void show() {
        String resultTxt;
        resultTxt = "";

        for (Emprestimo emprestimo : emprestimoControl.getEmprestimos()) {
            resultTxt += "ID: " + emprestimo.getId() + " | ";
            resultTxt += "Usuário: " + emprestimo.getUsuario().getMatricula()+ " - ";
            resultTxt += "" + emprestimo.getUsuario().getNome() + "\n";
            resultTxt += "LIVRO: " + emprestimo.getExemplar().getLivro().getTitulo() + " | ";
            resultTxt += "Edição" + emprestimo.getExemplar().getEdicao() + "\n";
            resultTxt += "DATAS: \n";
            resultTxt += "Empréstimo: " + emprestimo.getDataEmprestimo()+ " | ";
            resultTxt += "Devolução previsão: " + emprestimo.getDataDevolucaoPrevista()+ "\n\n";
        }
        JOptionPane.showMessageDialog(null, resultTxt);
    }

}
