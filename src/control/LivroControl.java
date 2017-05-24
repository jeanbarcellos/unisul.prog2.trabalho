package control;

import model.Livro;

import model.dao.DaoFactory;
import model.dao.LivroDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe LivroControl
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 22/10/2016
 *
 * @package control
 *
 */
public class LivroControl {

    /**
     * Lista com todos os livros sincronizados com a base de dados
     */
    private List<Livro> livros;

    /**
     * Instância do DaoFactory de Livros
     */
    private final LivroDao livroDao = DaoFactory.getDaoFactory().getLivroDao();

    /**
     * Construtor
     *
     * Carrega a lista de livros armazanados na base de dados
     */
    public LivroControl() {
        this.livros = new ArrayList<Livro>();

        // Carrega os livros vindos da base de dados
        this.setLivros(this.carregarLista());
    }

    /**
     * Retorna a lista de Livros do controlador
     *
     * @return Lista de Livros
     */
    public List<Livro> getLivros() {
        return livros;
    }

    /**
     * Seta a Lista de livros do controlador. Declaramos setLivro() como privado
     * pois ninguem, além do próprio controlador, pode gerenciar a lista.
     *
     * @param livros Livros a serem setados na lista.
     */
    private void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    /**
     * Inserir um livro
     *
     * @param livro
     * @return Booleano
     */
    public boolean inserir(Livro livro) {

        livro.setId(this.autoId());

        this.livros.add(livro);

        boolean db = livroDao.insert(livro);

        if (db) {
            return true;
        } else {
            this.livros.remove(livro);
            return false;
        }
    }

    /**
     * Alterar um livro
     *
     * @param livro Objeto Livro já modificado
     * @return Booleando
     */
    public boolean alterar(Livro livro) {

        Livro livroRef = this.getLivro(livro.getId());

        if (livroRef != null) {

            livroRef.setTitulo(livro.getTitulo());

            boolean retorno = livroDao.update(livro);

            return retorno;
        } else {
            return false;
        }

    }

    /**
     * Excluir um objeto da base de dados
     *
     * @param id ID do Objeto a ser excluido
     * @return true ou false
     */
    public boolean excluir(int id) {

        Livro livroRef = this.getLivro(id);

        if (livroRef != null) {
            this.livros.remove(livroRef);

            boolean retorno = livroDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Retorna a referência de um objeto da lista através de seu ID. Caso não o
     * encontre retorna NULL.
     *
     * @param id ID do Livro a ser buscado na lista
     * @return Objeto Livro
     */
    public Livro getLivro(int id) {
        Livro retorno = null;
        for (Livro livroExt : this.getLivros()) {
            if (livroExt.getId() == id) {
                retorno = livroExt;
            }
        }
        return retorno;
    }

    /**
     * Carrega a lista no controlador
     *
     * @return Lista com todos os Livros
     */
    private List<Livro> carregarLista() {
        return livroDao.all();
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return livroDao.lastId();
    }

    /**
     * Gera o próximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }

}
