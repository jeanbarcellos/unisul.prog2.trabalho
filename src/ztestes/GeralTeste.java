package ztestes;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class GeralTeste {
   
    public static void emprestimoInserir(Emprestimo emprestimo) {
        String sql1 = "";
        String sql2 = "";

        sql1 += "INSERT INTO emprestimo ";
        sql1 += "(id, usuario_id, exemplar_id, data_emprestimo, data_devolucao_previsao, data_devolucao) ";
        sql1 += "VALUES (" + emprestimo.getId() + "," + emprestimo.getUsuario().getId() + ", '2016-11-15', '2016-11-20', null);";

        System.out.println(sql1);

    }

    public static void main(String[] args) {

        // Livros e seus exemplares --------------------------------------------
        Livro livro1 = new Livro(1, "Livro 1", "Autor 2");
        Livro livro2 = new Livro(2, "Livro 2", "Autor 2");
        Livro livro3 = new Livro(3, "Livro 3", "Autor 1");
        Livro livro4 = new Livro(4, "Livro 4", "Autor 1");

        Exemplar ex1 = new Exemplar(1, livro1, "Edicao 1", "Localizacao 1");
        Exemplar ex2 = new Exemplar(2, livro1, "Edicao 2", "Localacao 1");
        Exemplar ex3 = new Exemplar(3, livro2, "Edicao 5", "Localizacao 2");
        Exemplar ex4 = new Exemplar(4, livro2, "Edicao 6", "Localizao 3");
        Exemplar ex5 = new Exemplar(6, livro3, "Edicao 4", "Localizacao 5");
        Exemplar ex6 = new Exemplar(7, livro3, "Edicao 7", "Localizacao 6");
        Exemplar ex7 = new Exemplar(8, livro4, "Edicao 4", "Localizacao 3");
        Exemplar ex8 = new Exemplar(8, livro4, "Edicao 2", "Localizac 34");
        Exemplar ex9 = new Exemplar(9, livro4, "Edicao 40", "Localizacao 3");
        
        // USUARIO -------------------------------------------------------------
        Usuario usuario = new Professor();
        usuario.setId(1);
        usuario.setMatricula(1);
        usuario.setNome("Jean Barcellos");
        

        // EMPRESTIMO ----------------------------------------------------------        
        // 1
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setId(1);        
        emprestimo1.setUsuario(usuario);
        emprestimo1.setExemplar(ex1);
        
        // 2
        Emprestimo emprestimo2 = new Emprestimo();
        emprestimo2.setId(2);        
        emprestimo2.setUsuario(usuario);
        emprestimo2.setExemplar(ex2);
        
                
        emprestimoInserir(emprestimo1);
        emprestimoInserir(emprestimo2);
    }

}
