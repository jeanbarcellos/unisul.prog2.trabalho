
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

    @Override
    public ProfessorDao getProfessorDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoDao getAlunoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDao getUsuarioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}