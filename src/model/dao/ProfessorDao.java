package model.dao;

import model.Professor;

import java.util.List;

/**
 * Interface ProfessorDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface ProfessorDao {

    /**
     * Inserir professor na base de dados
     *
     * @param professor
     * @return Resultado da inserção
     */
    public boolean insert(Professor professor);

    /**
     * Alterar professor na base de dados
     *
     * @param professor Objeto a ser alterado
     * @return
     */
    public boolean update(Professor professor);

    /**
     * Apagar professor da base de dados
     *
     * @param id ID do Objeto
     * @return
     */
    public boolean delete(int id);

    /**
     * Recupera um objeto da base de dados através de seu ID informado e
     * instancia-o na memória
     *
     * @param id ID do objeto
     * @return Objeto Professor
     */
    public Professor load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Professors
     */
    public List<Professor> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();

}
