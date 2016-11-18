package model.dao;

import model.Exemplar;

import java.util.ArrayList;
import java.util.List;

import utils.PersistenciaArquivo;

/**
 * Classe ArquivoExemplarDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 15/11/2016
 *
 * @package model.dao
 *
 */
final class ArquivoExemplarDao implements ExemplarDao {

    private List<Exemplar> exemplares = new ArrayList<Exemplar>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoExemplarDao() {
        this.persistArquivo = new PersistenciaArquivo("exemplares.bin", "exemplar_seq.txt");
        this.exemplares = this.all();
    }

    @Override
    public boolean insert(Exemplar exemplar) {

        // Adicionar a lista temporária local
        this.exemplares.add(exemplar);

        // Serializar arquivo
        this.persistArquivo.serializar(this.exemplares);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Exemplar exemplar) {

        Exemplar exemplarRef = this.load(exemplar.getId());

        if (exemplarRef != null) {

            // Altera somente o nome
            exemplarRef.setEdicao(exemplar.getEdicao());
            exemplarRef.setLocalizacao(exemplar.getLocalizacao());

            // Persistir
            this.persistArquivo.serializar(this.exemplares);

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Exemplar exemplarRef = this.load(id);

        if (exemplarRef != null) {

            // Remover a lista
            this.exemplares.remove(exemplarRef);

            // Persistir
            this.persistArquivo.serializar(this.exemplares);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Exemplar load(int id) {
        Exemplar retorno = null;
        for (Exemplar exemplarExt : this.exemplares) {
            if (exemplarExt.getId() == id) {
                retorno = exemplarExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Exemplar> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {        
        return this.persistArquivo.getLastId();
    }

    @Override
    public int total(int livroId) {
        this.recarregarLista();

        int total = 0;
        for (Exemplar exemplarExt : exemplares) {
            if (exemplarExt.getLivro().getId() == livroId) {
                total++;
            }
        }
        return total;
    }

    @Override
    public List<Exemplar> listar(int livroId) {
        this.recarregarLista();

        List<Exemplar> lista = new ArrayList<Exemplar>();

        for (Exemplar exemplarExt : this.exemplares) {
            if (exemplarExt.getLivro().getId() == livroId) {
                lista.add(exemplarExt);
            }
        }
        return lista;
    }

    /**
     * Recarrega lista interna do Dao
     */
    private void recarregarLista() {
        this.exemplares = this.all();
    }

}
