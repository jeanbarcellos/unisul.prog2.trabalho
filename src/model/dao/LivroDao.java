package model.dao;

import model.Livro;
import java.util.List;

/**
 * Interface LivroDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface LivroDao {

    /**
     * Inserir livro na base de dados
     *
     * @param livro
     * @return Resultado da inserção
     */
    public boolean insert(Livro livro);

    /**
     * Alterar livro na base de dados
     *
     * @param id ID do Livro
     * @param livro Objeto a ser alterado
     * @return
     */
    public boolean update(int id, Livro livro);

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
     * @return Objeto Livro
     */
    public Livro load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Livros
     */
    public List<Livro> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();

}
