package model.dao.arquivo;

import java.util.List;
import model.Usuario;
import model.dao.UsuarioDao;

/**
 * Classe ArquivoUsuarioDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 04/12/2016
 *
 * @package model.dao
 *
 */
final public class ArquivoUsuarioDao implements UsuarioDao {

    public ArquivoUsuarioDao() {
    }

    @Override
    public Usuario load(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
