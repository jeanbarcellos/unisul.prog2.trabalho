package model.dao;

import java.util.List;
import model.Curso;

/**
 * Interface CursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface CursoDao {

    /**
     * Inserir Livro na base de dados
     *
     * @param curso
     * @return Resultado da insersão
     */
    public boolean insert(Curso curso);

    /**
     * Alterar curso na base de dados
     *
     * @param id ID do Curso
     * @param curso Objeto a ser alterado
     * @return
     */
    public boolean update(int id, Curso curso);

    /**
     * Apagar livro da base de dados
     *
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     * Recupera um objeto da base de dados através de seu ID informado e
     * instancia-o na memória
     *
     * @param id ID do objeto
     * @return Objeto Curso
     */
    public Curso load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Cursos
     */
    public List<Curso> all();

}
