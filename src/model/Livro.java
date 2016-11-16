package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private int id;
    private String titulo;
    private String autor;
    private List<Exemplar> exemplares = new ArrayList<Exemplar>();

    public Livro() {
    }

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addExemplar(int id, String edicao, String localizacao) {
        this.exemplares.add(new Exemplar(id, edicao, localizacao));
    }

    public boolean removeExemplar(Exemplar exemplar) {
        return this.exemplares.remove(exemplar);
    }

    public Exemplar getExemplar(int exemplarId) {
        Exemplar retorno = null;
        for (Exemplar exemplarExt : this.getExemplares()) {
            if (exemplarExt.getId() == exemplarId) {
                retorno = exemplarExt;
            }
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.titulo.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livro {" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + "}";
    }

}
