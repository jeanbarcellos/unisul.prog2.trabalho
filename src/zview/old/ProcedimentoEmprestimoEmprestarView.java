package zview.old;

import control.EmprestimoControl;
import control.AlunoControl;
import control.ExemplarControl;
import control.ProfessorControl;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Exemplar;
import model.Usuario;

/**
 * Classe ProcedimentoEmprestimoEmprestarView
 *
 * @author Jean Barcellos
 * @date 19/11/2016
 *
 * @package view
 *
 */
public class ProcedimentoEmprestimoEmprestarView {

    private EmprestimoControl emprestimoControl = new EmprestimoControl();
    private AlunoControl alunoControl = new AlunoControl();
    private ProfessorControl professorControl = new ProfessorControl();
    private ExemplarControl exemplarControl = new ExemplarControl();

    public void show() {

        // Informar o Usuário
        int usuarioTipo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de usuário:\n\n(1 Aluno ou 2 para professor):"));

        Usuario usuario = null;
        Exemplar exemplar;        
        int matricula;

        while (usuario == null) {

            matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula do usuário:"));

            if (usuarioTipo == 1) {
                usuario = alunoControl.getAluno(matricula);
            } else if (usuarioTipo == 2) {
                usuario = professorControl.getProfessor(matricula);
            }
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "O usuário informado não existe");
            }
        }

        String resultTxt = "";
        for (Exemplar exe : exemplarControl.getExemplares()) {
            resultTxt += "ID: " + exe.getId() + " | ";
            resultTxt += "Livro {ID " + exe.getLivro().getId() + ", ";
            resultTxt += "Titulo: " + exe.getLivro().getTitulo() + "} ";
            resultTxt += "Edição" + exe.getEdicao() + "\n";

        }

        int exemplarId = Integer.parseInt(JOptionPane.showInputDialog(resultTxt + "\nInforme o ID do exemplar:"));

        exemplar = exemplarControl.getExemplar(exemplarId);
                
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setExemplar(exemplar);
        
        
        boolean retorno = this.emprestimoControl.inserir(emprestimo);

        if (retorno) {
            JOptionPane.showMessageDialog(null, "Emprestidmo realizado com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao realizado Emprestimo.");
        }
        

    }

}
