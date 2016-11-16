package ztestes;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class GeralTeste02 {

    public static void livroInserir(Livro livro) {

        int id = livro.getId();
        String titulo = livro.getTitulo();
        String autor = livro.getAutor();
        List<Exemplar> exemplares = livro.getExemplares();
        String sql1 = "";
        String sql2 = "";

        sql1 += "INSERT INTO livro ";
        sql1 += "(id, titulo, autor, data_cadastro, data_exclusao) ";
        sql1 += "VALUES (" + id + ", '" + titulo + "', '" + autor + "', '2016-11-14', null);";

        System.out.println(sql1);

        for (Exemplar exe : exemplares) {
            sql2 = "INSERT INTO exemplar (id, livro_id, localizacao, edicao, data_cadastro, data_exclusao) ";
            sql2 += "VALUES (" + exe.getId() + ", " + livro.getId() + ", '" + exe.getEdicao() + "', '" + exe.getLocalizacao() + "', '2016-11-14', null);";
            System.out.println(sql2);
        }
    }

    public static void emprestimoInserir(Emprestimo emprestimo) {
        String sql1 = "";
        String sql2 = "";

        sql1 += "INSERT INTO emprestimo ";
        sql1 += "(id, usuario_id, data_emprestimo, data_devolucao_previsao, data_devolucao) ";
        sql1 += "VALUES (" + emprestimo.getId() + "," + emprestimo.getUsuario().getMatricula() + ", '2016-11-15', '2016-11-20', null);";

        System.out.println(sql1);

        for (Exemplar exemplar : emprestimo.getExemplares()) {
            sql2 = "INSERT INTO emprestimo_exemplar (emprestimo_id, exemplar_id) ";
            sql2 += "VALUES (" + emprestimo.getId() + ", " + exemplar.getId() + ");";
            System.out.println(sql2);
        }
    }

    private static void exemplarInserir(Exemplar exemplar) {
        String sql1 = "";

        sql1 = "INSERT INTO exemplar (id, livro_id, localizacao, edicao, data_cadastro, data_exclusao) ";
//        sql1 += "VALUES (" + exemplar.getId() + ", " + exemplar.getLivro().getId() + ", '" + exemplar.getEdicao() + "', '" + exemplar.getLocalizacao() + "', '2016-11-14', null);";

        System.out.println(sql1);
    }

    public static void main(String[] args) {

        // Livros e seus exemplares --------------------------------------------
        Livro livro1 = new Livro(1, "Livro 1", "Autor 2");
        Livro livro2 = new Livro(2, "Livro 2", "Autor 2");
        Livro livro3 = new Livro(3, "Livro 3", "Autor 1");

//        Exemplar ex1 = new Exemplar(1, livro1, "Edicao 1", "Localizacao 1");
//        Exemplar ex2 = new Exemplar(2, livro1, "Edicao 2", "Localacao 1");
//        Exemplar ex3 = new Exemplar(3, livro1, "Edicao 5", "Localizacao 2");
//        Exemplar ex4 = new Exemplar(4, livro1, "Edicao 6", "Localizao 3");
//        Exemplar ex5 = new Exemplar(6, livro2, "Edicao 4", "Localizacao 5");
//        Exemplar ex6 = new Exemplar(7, livro2, "Edicao 7", "Localizacao 6");
//        Exemplar ex7 = new Exemplar(8, livro3, "Edicao 4", "Localizacao 3");
//        Exemplar ex8 = new Exemplar(8, livro3, "Edicao 2", "Localizac 34");
//        Exemplar ex9 = new Exemplar(9, livro3, "Edicao 40", "Localizacao 3");

//        exemplarInserir(ex1);
//        exemplarInserir(ex9);
       

    }

}
