package test;

import control.CursoControl;
import javax.swing.JOptionPane;

public class CursoTeste01 {

    public void CursoCRUD() {

        CursoControl cursoControl = new CursoControl();

        int id;
        String curso;
        int opcao = 1;

        while (opcao > 0 && opcao < 4) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Gerenciar Curso \n"
                    + "\n"
                    + "O que desejas fazer? \n"
                    + "\n"
                    + "1 - Cadastrar \n"
                    + "2 - Alterar \n"
                    + "3 - Apagar \n"
                    + "4 - SAIR\n"
            ));

            switch (opcao) {

                case 1:
                    // Inserir curso
                    curso = JOptionPane.showInputDialog("Informe o nome do curso a ser inserido:");
                    
                    cursoControl.inserirCurso(curso);
                    
                    break;

                case 2:
                    // Alterar curso
                    id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser alterado:"));
                    curso = JOptionPane.showInputDialog("Informe o novo nome do curso:");
                    
                    cursoControl.alterarCurso(id, curso);
                    
                    break;

                case 3:
                    // Apagar curso
                    id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código:"));
                    
                    cursoControl.excluirCurso(id);
                    
                    break;

            }
        }
    }

    public static void main(String[] args) {
        new CursoTeste01().CursoCRUD();
    }

}
