
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

    @Override
    public CursoDao getCursoDao() {
        return new ArquivoCursoDao();
    }
    
    @Override
    public LivroDao getLivroDao() {
        return new ArquivoLivroDao();
    }

    @Override
    public ExemplarDao getExemplarDao() {
        return new ArquivoExemplarDao();
    }

}