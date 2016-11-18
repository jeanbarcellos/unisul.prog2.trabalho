package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Config;
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
        Config config = Config.getInstance();
        
        String server = config.getValue("server");
        String host = config.getValue("host");
        String port = config.getValue("port");
        String user = config.getValue("user");
        String password = config.getValue("password");
        String database = config.getValue("database");

        try {
            conn = DriverManager.getConnection("jdbc:" + server + "://" + host + ":" + port + "/" + database, user, password);
        } catch (SQLException ex) {
            Log.write("Código: " + ex.getErrorCode() + "" + ex.getMessage());
        }

        return conn;
    }
}
