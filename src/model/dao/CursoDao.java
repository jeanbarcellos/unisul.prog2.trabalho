package model.dao;

import model.Curso;

/**
 * Interface CursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface CursoDao {

    /**
     * Inserir Livroda base de dados
     *
     * @param curso
     * @return Resultado da insersão
     */
    public boolean insert(Curso curso);

    /**
     * Alterar curso da base de dados
     *
     * @param id ID do Curso
     * @param curso Objeto a ser alterado
     * @return
     */
    public boolean update(String id, Curso curso);

    /**
     * Apagar livro da base de dados
     *
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     * Recupera (retorna) um objeto da base de dados
     *
     * @param id ID do objeto
     * @return
     */
    public Curso load(int id);

    public void listar();

}
