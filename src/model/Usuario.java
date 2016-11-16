package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo Usuario
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public abstract class Usuario implements Serializable {

    private static final long serialVersionUID = -6636364308558449883L;

    private int id;
    private int matricula;
    private String nome;

    private List<Exemplar> exemplares;

    public Usuario() {
        this.exemplares = new ArrayList<Exemplar>();
    }

    public Usuario(int id, int matricula, String nome) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.exemplares = new ArrayList<Exemplar>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", matricula=" + matricula + ", nome=" + nome + '}';
    }

}
