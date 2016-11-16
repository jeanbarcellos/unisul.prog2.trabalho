package model.dao;

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

    
    

}
