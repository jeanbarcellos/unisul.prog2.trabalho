package ztestes;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class GeralTeste {

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

    public static void main(String[] args) {

        // Livros e seus exemplares --------------------------------------------
        Livro livro1 = new Livro(1, "Livro 1", "Autor 2");
        Livro livro2 = new Livro(2, "Livro 2", "Autor 2");
        Livro livro3 = new Livro(3, "Livro 3", "Autor 1");
        Livro livro4 = new Livro(4, "Livro 4", "Autor 1");

        Exemplar ex1 = new Exemplar(1, "Edicao 1", "Localizacao 1");
        Exemplar ex2 = new Exemplar(2, "Edicao 2", "Localacao 1");
        Exemplar ex3 = new Exemplar(3, "Edicao 5", "Localizacao 2");
        Exemplar ex4 = new Exemplar(4, "Edicao 6", "Localizao 3");
        Exemplar ex5 = new Exemplar(6, "Edicao 4", "Localizacao 5");
        Exemplar ex6 = new Exemplar(7, "Edicao 7", "Localizacao 6");
        Exemplar ex7 = new Exemplar(8, "Edicao 4", "Localizacao 3");
        Exemplar ex8 = new Exemplar(8, "Edicao 2", "Localizac 34");
        Exemplar ex9 = new Exemplar(9, "Edicao 40", "Localizacao 3");

        List<Exemplar> exemplares1 = new ArrayList<Exemplar>();
        exemplares1.add(ex1);
        exemplares1.add(ex2);
        exemplares1.add(ex3);
        exemplares1.add(ex4);

        List<Exemplar> exemplares2 = new ArrayList<Exemplar>();
        exemplares2.add(ex5);
        exemplares2.add(ex6);
        exemplares2.add(ex8);
        exemplares2.add(ex7);
        exemplares2.add(ex9);

        livro1.setExemplares(exemplares1);

        livro2.setExemplares(exemplares2);

        livro3.addExemplar(11, "Exemplar2", "Titulo");
        Exemplar ex11 = livro3.getExemplar(11);

        // Persistir Livro
        livroInserir(livro1);
        livroInserir(livro2);



        // Emprestimo ----------------------------------------------------------
        Usuario usuario = new Professor();
        usuario.setMatricula(1);
        usuario.setNome("Jean Barcellos");

        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setId(1);
        emprestimo1.setUsuario(usuario);

        List<Exemplar> emprestimo1Exempls = new ArrayList<Exemplar>();
        emprestimo1Exempls.add(ex2);
        emprestimo1Exempls.add(ex8);
        emprestimo1Exempls.add(ex11);
        emprestimo1Exempls.add(ex4);
        emprestimo1.setExemplares(emprestimo1Exempls);

        // Persistindo Emprestimo
//        emprestimoInserir(emprestimo1);

    }

}
