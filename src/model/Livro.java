package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo Livro
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public class Livro implements Serializable {

    private static final long serialVersionUID = -1436215841880774188L;

    private String titulo;
    private String autor;
    private List<Exemplar> exemplares;

    public Livro() {
        this.exemplares = new ArrayList<Exemplar>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

}
