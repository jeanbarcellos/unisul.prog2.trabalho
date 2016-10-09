package model.dao;

import model.Curso;

/**
 * Classe ArquivoCursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
class ArquivoCursoDao implements CursoDao {

    @Override
    public boolean insert(Curso curso) {
        return true;
    }

    @Override
    public boolean update(String id, Curso curso) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Curso load(int id) {
        return null;
    }

    @Override
    public void listar() {
    }

}
