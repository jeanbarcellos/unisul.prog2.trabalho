/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class Config {

    private static final Config INSTANCE = new Config();
    
    private final Properties configs;

    private Config() {
        this.configs = loagProperties();
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    private Properties loagProperties() {

        InputStream leitorByte = null;
        Properties props = new Properties();

        try {
            leitorByte = new FileInputStream("config/db-default.properties");
            props.load(leitorByte);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (leitorByte != null) {
                    leitorByte.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return props;

    }

    public String getValue(String propriedade) {
        return configs.getProperty(propriedade);
    }

}
