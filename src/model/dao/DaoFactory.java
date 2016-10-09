package model.dao;

import java.util.Properties;

/**
 * Classe DaoFactory
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
public abstract class DaoFactory {

    public abstract CursoDao getCursoDao();

    public static DaoFactory getDaoFactory() {
        
        Properties config = Config.getConfig();
        
        int server = Integer.parseInt(config.getProperty("tipo"));
                        
        if (server == 1) {            
            return new PostgresDaoFactory();
        } else {
            return new ArquivoDaoFactory();
        }

    }

}
