package ztestes;

import control.CursoControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;

public class CursoTeste02 {

    public void CursoCRUD() {

        CursoControl cursoControl = new CursoControl();

        String nome;
        int opcao = 1;
        boolean retorno;

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
                    + "0 - SAIR\n\n"
            ));

            switch (opcao) {

                case 1: // Inserir curso

                    nome = JOptionPane.showInputDialog("Informe o nome do curso a ser inserido:");

                    // Envia o objeto criado para o controlador               
                    retorno = cursoControl.inserir(new Curso(nome));

                    if (retorno) {
                        JOptionPane.showMessageDialog(null, "Curso Cadastrado com Sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Curso.");
                    }

                    break;

                case 2: // Alterar curso

                    int id_alterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser alterado:"));

                    // Carrega o objeto a ser alterado
                    Curso cursoSelecionado = cursoControl.getCurso(id_alterar);

                    if (cursoSelecionado != null) {

                        String nome_novo = JOptionPane.showInputDialog("Informe o novo nome do curso:");

                        // Altera o objeto selecionado                        
                        cursoSelecionado.setNome(nome_novo);

                        // Executa a alteração no controlador
                        retorno = cursoControl.alterar(cursoSelecionado.getId(), cursoSelecionado);

                        if (retorno) {
                            JOptionPane.showMessageDialog(null, "Curso alterado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o curso.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "O código informado não existe");
                    }

                    break;

                case 3: // Apagar curso

                    int id_excluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do curso a ser excluído:"));

                    // Carrega o objeto a ser alterado
                    Curso cursoSelecionado2 = cursoControl.getCurso(id_excluir);

                    if (cursoSelecionado2 != null) {

                        // Envia os dados ao Controlador                        
                        retorno = cursoControl.excluir(id_excluir);

                        if (retorno) {
                            JOptionPane.showMessageDialog(null, "Curso excluído com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao excluír o curso.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O código informado não existe");
                    }

                    break;

                case 4: // Listar

                    List<Curso> lista = cursoControl.getCursos();

                    String texto = "Cursos Cadastrados:\n";
                    for (int i = 0; i < lista.size(); i++) {
                        Curso cursoExt = lista.get(i);
                        texto += "ID: " + cursoExt.getId() + " - ";
                        texto += "Nome: " + cursoExt.getNome() + "  \n";
                    }
                    JOptionPane.showMessageDialog(null, texto);

                    break;

            }
        }
    }

    public static void main(String[] args) {
        new CursoTeste02().CursoCRUD();
    }

}
