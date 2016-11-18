package model.dao;

import model.Aluno;
import java.util.List;

/**
 * Interface AlunoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface AlunoDao {

    /**
     * Inserir aluno na base de dados
     *
     * @param aluno
     * @return Resultado da inserção
     */
    public boolean insert(Aluno aluno);

    /**
     * Alterar aluno na base de dados
     *
     * @param aluno Objeto a ser alterado
     * @return
     */
    public boolean update(Aluno aluno);

    /**
     * Apagar aluno da base de dados
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
     * @return Objeto Aluno
     */
    public Aluno load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Alunos
     */
    public List<Aluno> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();

}
