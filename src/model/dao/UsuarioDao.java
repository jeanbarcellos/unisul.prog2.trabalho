package model.dao;

import model.Usuario;
import java.util.List;

/**
 * Interface Usuario
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface UsuarioDao {

    /**
     * Recupera um objeto da base de dados através de seu ID informado e
     * instancia-o na memória
     *
     * @param id ID do objeto
     * @return Objeto Usuario
     */
    public Usuario load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Usuarios
     */
    public List<Usuario> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();
}
