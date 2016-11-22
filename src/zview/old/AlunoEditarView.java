package zview.old;

import control.AlunoControl;
import control.CursoControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Curso;

/**
 * Classe AlunoEditarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class AlunoEditarView {

    private AlunoControl alunoControl = new AlunoControl();
    private CursoControl cursoControl = new CursoControl();

    public AlunoEditarView() {
    }

    public void show() {

        int id_alterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do aluno a ser alterado:"));

        // Carrega o objeto a ser alterado
        Aluno aluno = alunoControl.getAluno(id_alterar);

        if (aluno != null) {

            List<Curso> cursos = this.cursoControl.getCursos();

            String texto = "Cursos Cadastrados:\n";
            for (Curso curso : cursos) {
                texto += "ID: " + curso.getId() + " - ";
                texto += "Nome: " + curso.getNome() + "  \n";
            }

            // Colher informação do usuário
            String nome = JOptionPane.showInputDialog("Informe a NOME do Aluno:", aluno.getNome());
            int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a MATRÍCULA do Aluno:", aluno.getMatricula()));
            int cursoId = Integer.parseInt(JOptionPane.showInputDialog(texto + "\nInforme o ID do Curso no qual o aluno pertence:", aluno.getCurso().getId()));

            // Altera o objeto selecionado                        
            aluno.setCurso(this.cursoControl.getCurso(cursoId));
            aluno.setNome(nome);
            aluno.setMatricula(matricula);

            // Executa a alteração no controlador
            boolean retorno = alunoControl.alterar(aluno);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o aluno.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
