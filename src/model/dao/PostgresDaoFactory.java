package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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

}
