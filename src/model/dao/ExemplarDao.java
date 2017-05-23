package model.dao;

import java.util.List;
import model.Exemplar;

/**
 * Interface ExemplarDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface ExemplarDao {

    /**
     * Inserir exemplar na base de dados
     *
     * @param exemplar
     * @return Resultado da inserção
     */
    public boolean insert(Exemplar exemplar);

    /**
     * Alterar exemplar na base de dados
     *
     * @param exemplar Objeto a ser alterado
     * @return
     */
    public boolean update(Exemplar exemplar);

    /**
     * Apagar exemplar da base de dados
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
     * @return Objeto Exemplar
     */
    public Exemplar load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Exemplars
     */
    public List<Exemplar> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();

    /**
     * Pega o valor total de exemplares de um livro
     *
     * @param livroId ID do livro a ser pesquisdo
     * @return Valor total de exemplares do livro
     */
    public int total(int livroId);

    /**
     * Lista todos os exemplares ativos de um livro
     *
     * @param livroId ID O Livro
     * @return Lista de Exemplares
     */
    public List<Exemplar> listar(int livroId);

    /**
     * Buscar Exemplares através de um Título informado
     *
     * @param titulo Título a ser pesquisado
     * @return Lista de Exemplares
     */
    public List<Exemplar> buscarPeloTitulo(String titulo);

    /**
     * Buscar Exemplares através de um auto informado
     *
     * @param autor Autor a ser pesquisado
     * @return Lista de Exemplares
     */
    public List<Exemplar> buscarPeloAutor(String autor);

    /**
     * Buscar Exemplares através de uma edição informada
     *
     * @param edicao Edição a ser pesquisada
     * @return Lista de Exemplares
     */
    public List<Exemplar> buscarPelaEdicao(String edicao);

    /**
     * Exemplares disponíveis (ou seja, que não estão emprestados)
     *
     * @return Lista de Exemplares disponíveis
     */
    public List<Exemplar> disponiveis();
}
