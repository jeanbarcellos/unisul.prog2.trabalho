package model.dao;

import util.Config;

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

    /**
     * Retorna uma instância DaoFactory
     *
     * @return
     */
    public static DaoFactory getDaoFactory() {

        Config config = Config.getInstance();

        int tipo = Integer.parseInt(config.getValue("tipo"));

        if (tipo == 1) {
            return new PostgresDaoFactory();
        } else {
            return new ArquivoDaoFactory();
        }

    }

    public abstract CursoDao getCursoDao();

    public abstract LivroDao getLivroDao();

    public abstract UsuarioDao getUsuarioDao();

    public abstract ExemplarDao getExemplarDao();

    public abstract ProfessorDao getProfessorDao();

    public abstract AlunoDao getAlunoDao();

    public abstract EmprestimoDao getEmprestimoDao();

}
