package view;

import control.CursoControl;
import control.AlunoControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Curso;

/**
 * Classe AlunoInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package view
 *
 */
public class AlunoInserirView {

    private AlunoControl alunoControl = new AlunoControl();
    private CursoControl cursoControl = new CursoControl();

    public AlunoInserirView() {
    }

    public void show() {

        List<Curso> cursos = cursoControl.getCursos();

        if (cursos == null) {
            JOptionPane.showMessageDialog(null, "Não há cadastro de Cursos");
        } else {

            String texto = "Cursos Cadastrados:\n";
            for (Curso curso : cursos) {
                texto += "ID: " + curso.getId() + " - ";
                texto += "Nome: " + curso.getNome() + "  \n";
            }

            // Colher informação do usuário
            String nome = JOptionPane.showInputDialog("Informe a NOME do Aluno:");
            int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a MATRÍCULA do Aluno:"));
            int cursoId = Integer.parseInt(JOptionPane.showInputDialog(texto + "\nInforme o ID do Curso no qual o aluno pertence:"));

            // Cria o objeto de transição
            Aluno aluno = new Aluno();
            aluno.setCurso(this.cursoControl.getCurso(cursoId));
            aluno.setNome(nome);
            aluno.setMatricula(matricula);

            // Envia o objeto criado para o controlador               
            boolean retorno = this.alunoControl.inserir(aluno);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com Sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Aluno.");
            }

        }
    }

}
