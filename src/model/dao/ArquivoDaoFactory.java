package model.dao;

import model.dao.arquivo.ArquivoAlunoDao;
import model.dao.arquivo.ArquivoCursoDao;
import model.dao.arquivo.ArquivoLivroDao;
import model.dao.arquivo.ArquivoEmprestimoDao;
import model.dao.arquivo.ArquivoUsuarioDao;
import model.dao.arquivo.ArquivoProfessorDao;
import model.dao.arquivo.ArquivoExemplarDao;

/**
 * Classe ArquivoDaoFactory
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
class ArquivoDaoFactory extends DaoFactory {

    @Override
    public CursoDao getCursoDao() {
        return new ArquivoCursoDao();
    }

    @Override
    public LivroDao getLivroDao() {
        return new ArquivoLivroDao();
    }

    @Override
    public ExemplarDao getExemplarDao() {
        return new ArquivoExemplarDao();
    }

    @Override
    public ProfessorDao getProfessorDao() {
        return new ArquivoProfessorDao();
    }

    @Override
    public AlunoDao getAlunoDao() {
        return new ArquivoAlunoDao();
    }

    @Override
    public UsuarioDao getUsuarioDao() {
        return new ArquivoUsuarioDao();
    }

    @Override
    public EmprestimoDao getEmprestimoDao() {
        return new ArquivoEmprestimoDao();
    }

}
