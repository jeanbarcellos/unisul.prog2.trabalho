package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe Conexao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/09/2016
 *
 * @package api
 *
 */
public class PostgresConnection {

    public static Connection open() {

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
}
