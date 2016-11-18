package zold;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe ConfigOld
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
public class ConfigOld {

    private ConfigOld() {
        
    }

    
    
    /**
     * Retorna as configurações do sistema
     * 
     * @return Properties
     */
    public static Properties getConfig() {

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

}
