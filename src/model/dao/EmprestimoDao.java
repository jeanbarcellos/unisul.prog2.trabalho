package model.dao;

import java.util.List;
import model.Emprestimo;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface EmprestimoDao {

    /**
     * Inserir Emprestimo na base de dados
     *
     * @param emprestimo Objeto a ser inserido
     * @return Resultado da inserção
     */
    public boolean insert(Emprestimo emprestimo);
    
    /**
     * Alterar emprestimo na base de dados
     *
     * @param emprestimo Objeto a ser alterado
     * @return
     */
    public boolean update(Emprestimo emprestimo);

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
     * @return Objeto Emprestimo
     */
    public Emprestimo load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Emprestimos
     */
    public List<Emprestimo> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();
    
    public List<Emprestimo> listarAtivos();

}
