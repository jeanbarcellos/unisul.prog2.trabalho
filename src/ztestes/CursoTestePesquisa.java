package ztestes;

import java.util.List;
import model.Aluno;
import model.dao.AlunoDao;
import model.dao.DaoFactory;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class CursoTestePesquisa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlunoDao alunoDao = DaoFactory.getDaoFactory().getAlunoDao();

        List<Aluno> alunos = null;
        
        alunos = alunoDao.buscarPeloNome("Daniela");
        
        System.out.println(alunos);
        
        
    }

}
