package model.dao;

import java.util.Date;
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
     * Realiza o emprestimo do livro
     *
     * @param emprestimo Obejto de emprestimo
     * @return True/False
     */
    public boolean emprestar(Emprestimo emprestimo);

    /**
     * Realiza a devolução do emprestimo
     *
     * @param emprestimoId
     * @param dataDevolucao
     * @return
     */
    public boolean devolver(int emprestimoId, Date dataDevolucao);

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

    /**
     * Mostra a lista de Exemplares pegos por um usuario
     *
     * @param usuarioId ID do usuário
     * @return Lista de Exeplares
     */
    public List<Emprestimo> getEmprestimosPorUsuario(int usuarioId);

}
