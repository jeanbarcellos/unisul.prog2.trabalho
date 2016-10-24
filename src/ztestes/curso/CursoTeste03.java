package ztestes.curso;

import model.Curso;
import control.CursoControl;

import java.util.List;
import javax.swing.JOptionPane;

public class CursoTeste03 {

    public static void main(String[] args) {

        CursoControl cursoControl = new CursoControl();

//        String nome = JOptionPane.showInputDialog("Informe o nome do curso.");
//        // Envia o objeto para o controlador
//        cursoControl.inserir(new Curso(nome));

        /**
         * Pega a lista de cursos do controlador -------------------------------
         */
        List<Curso> lista = cursoControl.getCursos();
        

        // LISTA ---------------------------------------------------------------
        String texto = "Cursos Cadastrados:\n";
        for (int i = 0; i < lista.size(); i++) {
            Curso cursoExt = lista.get(i);
            texto += "ID: " + cursoExt.getId() + " - ";
            texto += "Nome: " + cursoExt.getNome() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);
        // ---------------------------------------------------------------------

        /**
         * ALTERAR OBJETO ------------------------------------------------------
         */
        
        // Seleciona um objeto;
        int id_alterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o CÓDIGO."));
        
        // Carrega o objeto a ser alterado
        Curso cursoSelecionado = cursoControl.getCurso(id_alterar);

        // Altera o objeto selecionado
        String nome_novo = JOptionPane.showInputDialog("Informe o novo nome do curso:");
        cursoSelecionado.setNome(nome_novo);

        // Executa a alteração no controlador
        cursoControl.alterar(cursoSelecionado.getId(), cursoSelecionado);
                

        // LISTA ---------------------------------------------------------------
        texto = "Cursos Cadastrados:\n";
        for (int i = 0; i < lista.size(); i++) {
            Curso cursoExt = lista.get(i);
            texto += "ID: " + cursoExt.getId() + " - ";
            texto += "Nome: " + cursoExt.getNome() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);
        // ---------------------------------------------------------------------

        }
        
//        // Alterar Curso
//        Curso cursoAlterado = new Curso();
//        cursoAlterado.setNome("Curso com o nome alterado");
//
//        cursoControl.alterar(2, cursoAlterado);




//        List<Curso> cursos = new ArrayList<>();
//        cursos.add(new Curso(1, "Ciência da Computação"));
//        cursos.add(new Curso(2, "Arquitetura"));
//        cursos.add(new Curso(3, "Sistemas de Informação"));
//        int ultioId = cursos.get(cursos.size() - 1).getId();
//        int proximoId = ultioId + 1;
//        System.out.println(proximoId);   

}
