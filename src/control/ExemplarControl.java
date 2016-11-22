package control;

import model.Exemplar;

import model.dao.DaoFactory;
import model.dao.ExemplarDao;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe ExemplarControl
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 02/11/2016
 *
 * @package control
 *
 */
public class ExemplarControl {

    /**
     * Lista com todos os exemplares sincronizados com a base de dados
     */
    private List<Exemplar> exemplares;

    /**
     * Instância do DaoFactory de Cursos
     */
    private ExemplarDao exemplarDao = DaoFactory.getDaoFactory().getExemplarDao();

    /**
     * Contrutor
     */
    public ExemplarControl() {
        this.exemplares = new ArrayList<Exemplar>();
        this.setExemplares(this.carregarLista());
    }

    /**
     * Retorna a lista de Exemplares do controlador
     *
     * @return Lista de Exemplares
     */
    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    /**
     * Seta a Lista de exemplares do controlador. Declaramos setExemplar() como
     * privado pois ninguem, além do próprio controlador, pode gerenciar a
     * lista.
     *
     * @param exemplares Exemplares a serem setados na lista.
     */
    private void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    /**
     * Inserir um exemplar
     *
     * @param exemplar
     * @return Booleano
     */
    public boolean inserir(Exemplar exemplar) {

        exemplar.setId(this.autoId());

        this.exemplares.add(exemplar);

        boolean db = exemplarDao.insert(exemplar);

        if (db) {
            return true;
        } else {
            this.exemplares.remove(exemplar);
            return false;
        }

    }

    /**
     * Alterar um exemplar
     *
     * @param exemplar Objeto Exemplar já modificado
     * @return Booleando
     */
    public boolean alterar(Exemplar exemplar) {

        Exemplar exemplarRef = this.getExemplar(exemplar.getId());

        if (exemplarRef != null) {

            exemplarRef.setEdicao(exemplar.getEdicao());
            exemplarRef.setLocalizacao(exemplar.getLocalizacao());

            boolean retorno = exemplarDao.update(exemplar);

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

        Exemplar exemplarRef = this.getExemplar(id);

        if (exemplarRef != null) {
            this.exemplares.remove(exemplarRef);

            boolean retorno = exemplarDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Retorna a referência de um objeto da lista através de seu ID. Caso não o
     * encontre retorna NULL.
     *
     * @param id ID do Exemplar a ser buscado na lista
     * @return Objeto Exemplar
     */
    public Exemplar getExemplar(int id) {
        Exemplar retorno = null;
        for (Exemplar exemplarExt : this.getExemplares()) {
            if (exemplarExt.getId() == id) {
                retorno = exemplarExt;
            }
        }
        return retorno;
    }

    /**
     * Total de exemplares ativos por livro
     *
     * @param livroId ID do Livro
     * @return numero total de exemplares
     */
    public int total(int livroId) {
        return exemplarDao.total(livroId);
    }

    /**
     * Lista os exemplares de um livro
     *
     * @param livroId
     * @return
     */
    public List<Exemplar> listar(int livroId) {
        return exemplarDao.listar(livroId);
    }

    /**
     * Carrega a lista no controlador
     *
     * @return Lista com todos os Exemplares
     */
    private List<Exemplar> carregarLista() {
        return exemplarDao.all();
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return exemplarDao.lastId();
    }

    /**
     * Gera o próximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }

    public List<Exemplar> buscarPeloTitulo(String titulo) {
        return this.exemplarDao.buscarPeloTitulo(titulo);
    }

    public List<Exemplar> buscarPeloAutor(String autor) {
        return this.exemplarDao.buscarPeloAutor(autor);
    }

    public List<Exemplar> buscarPelaEdicao(String edicao) {
        return this.exemplarDao.buscarPelaEdicao(edicao);
    }

}
