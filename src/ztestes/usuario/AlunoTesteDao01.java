/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes.usuario;

import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.dao.DaoFactory;
import model.dao.AlunoDao;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class AlunoTesteDao01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlunoDao alunoDao = DaoFactory.getDaoFactory().getAlunoDao();

//        int proxId = alunoDao.lastId() + 1;


        // INSERIR -------------------------------------------------------------

//        Aluno usuario1 = new Aluno();
//        usuario1.setId(proxId);
//        usuario1.setCursoId(1);
//        usuario1.setMatricula(1001);
//        usuario1.setNome("Victor 2");
//
//        boolean retrono = alunoDao.insert(usuario1);
//
//        if (retrono) {
//            JOptionPane.showMessageDialog(null, "Aluno incluído com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao tentar incluir aluno.");
//        }
        
        
        // EDITAR -------------------------------------------------------------

//        Aluno usuario2 = new Aluno();
//        usuario2.setId(3);
//        usuario2.setCursoId(1);
//        usuario2.setMatricula(99999);
//        usuario2.setNome("Aluno EDITADO 1");
//
//        boolean retrono = alunoDao.update(usuario2);
//
//        if (retrono) {
//            JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar dados do aluno.");
//        }
        
        // EDITAR --------------------------------------------------------------
//        Aluno usuario3 = new Aluno();
//        usuario3.setId(3);
//
//        boolean retrono3 = alunoDao.delete(3);
//
//        if (retrono3) {
//            JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir aluno.");
//        }

        // LISTAR --------------------------------------------------------------
//        List<Aluno> retorno4 = alunoDao.all();
//        
//        for (Aluno aluno : retorno4) {
//            System.out.println(aluno);
//        }
        
        // LOAD ----------------------------------------------------------------
        Aluno retorno5 = alunoDao.load(7);
        
        if (retorno5 != null) {
            System.out.println(retorno5);
        } else {
            System.out.println("NÃO");
        }
        
    }

}
