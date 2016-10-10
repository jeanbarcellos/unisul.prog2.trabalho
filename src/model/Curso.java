package model;

import java.io.Serializable;

/**
 * Modelo Curso
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public class Curso implements Serializable {

    private static final long serialVersionUID = 6161029930731563853L;

    private int id;
    private String nome;

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
