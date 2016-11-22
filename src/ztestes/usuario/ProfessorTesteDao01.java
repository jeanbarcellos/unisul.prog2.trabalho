/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes.usuario;

import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import model.Professor;
import model.dao.CursoDao;
import model.dao.DaoFactory;
import model.dao.ProfessorDao;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class ProfessorTesteDao01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProfessorDao professorDao = DaoFactory.getDaoFactory().getProfessorDao();
        CursoDao cursoDao = DaoFactory.getDaoFactory().getCursoDao();

        int proxId = professorDao.lastId() + 1;

        // INSERIR -------------------------------------------------------------
//        Professor usuario1 = new Professor();
//        usuario1.setId(proxId);
//        usuario1.setMatricula(10003);
//        usuario1.setNome("Flávio Ceci");
//
//        boolean retrono = professorDao.insert(usuario1);
//
//        if (retrono) {
//            JOptionPane.showMessageDialog(null, "Professor incluído com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao tentar incluir professor.");
//        }
        // EDITAR -------------------------------------------------------------
//        Professor usuario2 = new Professor();
//        usuario2.setId(1);
//        usuario2.setMatricula(10101);
//        usuario2.setNome("Jean Barcellos EDITADO 2");
//
//        boolean retrono = professorDao.update(usuario2);
//
//        if (retrono) {
//            JOptionPane.showMessageDialog(null, "Professor alterado com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar dados do professor.");
//        }
        // EDITAR --------------------------------------------------------------
//        Professor usuario3 = new Professor();
//        usuario3.setId(1);
//
//        boolean retrono3 = professorDao.delete(1);
//
//        if (retrono3) {
//            JOptionPane.showMessageDialog(null, "Professor excluido com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir professor.");
//        }
        // LISTAR --------------------------------------------------------------
//        List<Professor> retorno4 = professorDao.all();
//        
//        for (Professor prof : retorno4) {
//            System.out.println(prof);
//        }
        // LOAD ----------------------------------------------------------------
        Professor professor = professorDao.load(2);
        System.out.println(professor + "\n");

        Curso curso = cursoDao.load(1);
//        System.out.println(curso + "\n");

        // LISTAR --------------------------------------------------------------
        List<Curso> retorno6 = professorDao.getCursos(professor.getId());
        for (Curso prof : retorno6) {
            System.out.println(prof);
        }

        // Add Curso ao professor ----------------------------------------------
//        boolean retornoAdd = professorDao.addCurso(professor.getId(), curso);
//        if (retornoAdd) {
//            System.out.println("Adicionado com sucesso");
//        } else {
//            System.out.println("Erro ao adicionar");
//        }
        // Remover -------------------------------------------------------------
        boolean retornoDel = professorDao.delCurso(professor.getId(), 2);

        if (retornoDel) {
            System.out.println("EXCLUIDO com sucesso");
        } else {
            System.out.println("Erro ao excluir");
        }

        List<Curso> retorno7 = professorDao.getCursos(professor.getId());
        for (Curso prof : retorno7) {
            System.out.println(prof);
        }

    }

}
