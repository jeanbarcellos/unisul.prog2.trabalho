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

    public static DaoFactory getDaoFactory() {

        Properties config = Config.getConfig();

        int tipo = Integer.parseInt(config.getProperty("tipo"));

        if (tipo == 1) {
            return new PostgresDaoFactory();
        } else {
            return new ArquivoDaoFactory();
        }

    }

    public abstract CursoDao getCursoDao();
    
    public abstract LivroDao getLivroDao();

//    public abstract ProfessorDao getProfessorDao();

//    public abstract AlunoDao getAlunoDao();

}
