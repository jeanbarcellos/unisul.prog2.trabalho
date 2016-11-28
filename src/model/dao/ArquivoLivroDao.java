package model.dao;

import model.Livro;

import java.util.List;
import java.util.ArrayList;

import util.PersistenciaArquivo;

/**
 * Classe ArquivoLivroDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package model.dao
 *
 */
final class ArquivoLivroDao implements LivroDao {

    private List<Livro> livros = new ArrayList<Livro>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoLivroDao() {
        this.persistArquivo = new PersistenciaArquivo("livros.bin", "livro_seq.txt");
        
        this.carregarLista();
    }

    @Override
    public boolean insert(Livro livro) {

        // Adicionar a lista temporária local
        this.livros.add(livro);

        // Serializar arquivo
        this.persistArquivo.serializar(this.livros);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Livro livro) {

        Livro livroRef = this.load(livro.getId());

        if (livroRef != null) {

            // Altera somente o nome
            livroRef.setTitulo(livro.getTitulo());
            livroRef.setAutor(livro.getAutor());

            // Persistir
            this.persistArquivo.serializar(this.livros);

            // Recarregar lista interna
            this.carregarLista();
            
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Livro livroRef = this.load(id);

        if (livroRef != null) {

            // Remover a lista
            this.livros.remove(livroRef);

            // Persistir
            this.persistArquivo.serializar(this.livros);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Livro load(int id) {
        Livro retorno = null;
        for (Livro livroExt : livros) {
            if (livroExt.getId() == id) {
                retorno = livroExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Livro> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {
        return this.persistArquivo.getLastId();
    }

    /**
     * Recarrega lista interna do Dao
     */
    private void carregarLista() {
        this.livros = this.all();
    }
}
