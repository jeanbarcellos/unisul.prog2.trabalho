package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Conexao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/09/2016
 *
 * @package api
 *
 */
public class Conexao {

    public static Connection open() {

        Connection conn = null;

        String server = "mysql";
        String host = "localhost";
        String port = "";
        String user = "teste";
        String useSsl = "false";
        String password = "teste";
        String database = "biblioteca";

        try {

            switch (server) {
                case "postgresql":
                    port = port != "" ? port : "5432";
                    conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + database, user, password);
                    break;
                case "mysql":
                    port = port != "" ? port : "3306";
                    conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?" + "user=" + user + "&password=" + password + "&useSSL=" + useSsl);
                    break;
            }

        } catch (SQLException ex) {
            System.err.println("Mensagem: " + ex.getMessage()); // SQLException
            System.err.println("Status: " + ex.getSQLState()); // SQLState
            System.err.println("Código: " + ex.getErrorCode()); // VendorError            
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println("Mensagem: " + ex.getMessage()); // SQLException
                    System.err.println("Status: " + ex.getSQLState()); // SQLState
                    System.err.println("Código: " + ex.getErrorCode()); // VendorError  
                }
            }
        }

        return conn;
    }
}
