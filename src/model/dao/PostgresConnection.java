package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import utils.Log;

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

    /**
     * Abre conexão com o Banco de Dados
     * 
     * @return Instância de Conexão
     */
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
            Log.write("Código: " + ex.getErrorCode() + "" + ex.getMessage());
        }

        return conn;
    }
}
