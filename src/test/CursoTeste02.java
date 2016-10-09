package test;

import control.CursoControl;
import javax.swing.JOptionPane;
import model.Curso;

public class CursoTeste02 {

    public void CursoCRUD() {

        CursoControl cursoControl = new CursoControl();

        int id;
        String curso;
        int opcao = 1;

        while (opcao > 0 && opcao < 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Gerenciar Curso \n"
                    + "\n"
                    + "O que desejas fazer? \n"
                    + "\n"
                    + "1 - Cadastrar \n"
                    + "2 - Alterar \n"
                    + "3 - Apagar \n"
                    + "4 - Listar \n"
                    + "5 - SAIR\n\n"
            ));

            switch (opcao) {

                case 1:
                    // Inserir curso
                    id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser inserido:"));
                    curso = JOptionPane.showInputDialog("Informe o nome do curso a ser inserido:");

                    // Envia os dados ao Controlador
//                    cursoControl.inserir(curso);

                    break;

                case 2:
                    // Alterar curso
                    id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser alterado:"));
                    curso = JOptionPane.showInputDialog("Informe o novo nome do curso:");

                    // Envia os dados ao Controlador
//                    cursoControl.alterar(id, curso);

                    break;

                case 3:
                    // Apagar curso
                    id = Integer.parseInt(JOptionPane.showInputDialog("Informe o código:"));

                    // Envia os dados ao Controlador
                    cursoControl.excluir(id);

                    break;

                case 4:
                    String texto = "Crusos Cadastrados:\n";
                    for (int i = 0; i < cursoControl.listar().size(); i++) {
                        Curso cursoExt = cursoControl.listar().get(i);
                        texto += "ID: " + cursoExt.getId() + " - ";
                        texto += "Nome: " + cursoExt.getNome() + "\n";
                    }
//                    for(Curso cursoExt : cursoControl.listar()){
//                        texto += cursoExt.getNome() + "\n";
//                    }                                        
                    JOptionPane.showMessageDialog(null, texto);

                    break;

            }
        }
    }

    public static void main(String[] args) {
        new CursoTeste02().CursoCRUD();
    }

}
