package model.dao;

import model.dao.postgre.PostgresProfessorDao;
import model.dao.postgre.PostgresLivroDao;
import model.dao.postgre.PostgresCursoDao;
import model.dao.postgre.PostgresUsuarioDao;
import model.dao.postgre.PostgresExemplarDao;
import model.dao.postgre.PostgresAlunoDao;
import model.dao.postgre.PostgresConnection;
import model.dao.postgre.PostgresEmprestimoDao;
import java.sql.Connection;

/**
 * Classe PostgresDaoFactory
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
public class PostgresDaoFactory extends DaoFactory {

    public static Connection openConnection() {
        return PostgresConnection.open();
    }

    @Override
    public CursoDao getCursoDao() {
        return new PostgresCursoDao();
    }

    @Override
    public LivroDao getLivroDao() {
        return new PostgresLivroDao();
    }

    @Override
    public ExemplarDao getExemplarDao() {
        return new PostgresExemplarDao();
    }

    @Override
    public ProfessorDao getProfessorDao() {
        return new PostgresProfessorDao();
    }

    @Override
    public AlunoDao getAlunoDao() {
        return new PostgresAlunoDao();
    }

    @Override
    public UsuarioDao getUsuarioDao() {
        return new PostgresUsuarioDao();
    }

    @Override
    public EmprestimoDao getEmprestimoDao() {
        return new PostgresEmprestimoDao();
    }

}
