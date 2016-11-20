package ztestes;

import java.util.ArrayList;
import java.util.List;

import model.*;

import util.PersistenciaArquivo;

public class ZerarTudo {

    public static void main(String[] args) {

//        /**
//         * DROP CURSO
//         */
//        PersistenciaArquivo curso = new PersistenciaArquivo("cursos.bin", "curso_seq.txt");
//        List<Curso> cursoLista = new ArrayList<Curso>();
//        curso.serializar(cursoLista);
//        curso.reiniciarSequencia();
//
//        /**
//         * DROP ALUNO
//         */
//        PersistenciaArquivo aluno = new PersistenciaArquivo("alunos.bin", "aluno_seq.txt");
//        List<Aluno> alunoLista = new ArrayList<Aluno>();
//        aluno.serializar(alunoLista);
//        aluno.reiniciarSequencia();
//
//        /**
//         * DROP PROFESSOR
//         */
//        PersistenciaArquivo professor = new PersistenciaArquivo("professores.bin", "professor_seq.txt");
//        List<Aluno> professorLista = new ArrayList<Aluno>();
//        professor.serializar(professorLista);
//        professor.reiniciarSequencia();
//
//        /**
//         * DROP LIVRO
//         */
//        PersistenciaArquivo livro = new PersistenciaArquivo("livros.bin", "livro_seq.txt");
//        List<Livro> livroLista = new ArrayList<Livro>();
//        livro.serializar(livroLista);
//        livro.reiniciarSequencia();
//
//        /**
//         * DROP EXEMPLAR
//         */
//        PersistenciaArquivo exemplar = new PersistenciaArquivo("exemplares.bin", "exemplar_seq.txt");
//        List<Exemplar> exemplarLista = new ArrayList<Exemplar>();
//        exemplar.serializar(exemplarLista);
//        exemplar.reiniciarSequencia();

//        /**
//         * DROP Emprestimo
//         */
        PersistenciaArquivo emprestimo = new PersistenciaArquivo("emprestimos.bin", "emprestimo_seq.txt");
        List<Exemplar> emprestimoLista = new ArrayList<Exemplar>();
        emprestimo.serializar(emprestimoLista);
        emprestimo.reiniciarSequencia();

    }

}
