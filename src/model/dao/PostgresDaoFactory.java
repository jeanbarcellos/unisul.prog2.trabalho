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

        Connection conn = null;
        Properties config = Config.getConfig();
        
        String server = config.getProperty("server");
        String host = config.getProperty("host");
        String port = config.getProperty("port");
        String user = config.getProperty("user");
        String password = config.getProperty("password");
        String database = config.getProperty("database");

        try {
            conn = DriverManager.getConnection("jdbc:" + server + "://" + host + ":" + port + "/" + database, user, password);
        } catch (SQLException ex) {
            System.err.println("Mensagem: " + ex.getMessage());
            System.err.println("Status: " + ex.getSQLState());
            System.err.println("Código: " + ex.getErrorCode());
        }

        return conn;
    }

    @Override
    public CursoDao getCursoDao() {
        return new PostgresCursoDao();
    }

}
