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

    /**
     * Construtor
     */
    public Curso() {
    }

    /**
     * Construtor com do Nome por parametro
     * @param nome Nome do Curso
     */
    public Curso(String nome) {
        this.nome = nome;
    }

    /**
     * Construtor com passagem de ID e Nome por parâmetro
     * @param id ID do Curso
     * @param nome Nome do Curso
     */
    public Curso(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Retorna o ID do Curso
     * @return ID do Curso
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do Curso
     * @param id ID do Curso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do Curso
     * @return Nome do Curso
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do Curso
     * @param nome Nome do Curso
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + '}';
    }

        
}
