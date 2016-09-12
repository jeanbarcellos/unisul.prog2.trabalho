package test;

import java.util.Properties;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesTeste01 {

    public static Properties getProp(String arquivo) {

        Properties props = new Properties();
        InputStream file = null;

        try {
            file = new FileInputStream("config/db-" + arquivo + ".properties");
            props.load(file);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return props;

    }

    public static void main(String[] args) {

        // Declarando
        String server;
        String host;
        String port;
        String user;
        String useSsl;
        String password;
        String database;

        // Chamando método estático
        Properties prop = PropertiesTeste01.getProp("postgresql");

        // Pega os valores
        server = prop.getProperty("server");
        host = prop.getProperty("host");
        port = prop.getProperty("port");
        user = prop.getProperty("user");
        useSsl = prop.getProperty("useSsl");
        password = prop.getProperty("password");
        database = prop.getProperty("database");

        // Imprime na tela
        System.out.println("server : " + server);
        System.out.println("host : " + host);
        System.out.println("port : " + port);
        System.out.println("server : " + useSsl);
        System.out.println("user : " + user);
        System.out.println("password : " + password);
        System.out.println("database : " + database);

    }

}
