
package model.dao;

/**
 * Classe ArquivoDaoFactory
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
class ArquivoDaoFactory extends DaoFactory {

    public ArquivoDaoFactory() {
    }

    @Override
    public CursoDao getCursoDao() {
        return new ArquivoCursoDao();
    }

}