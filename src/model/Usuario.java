package model;

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
public class Usuario {

    private int matricula;
    private String nome;
    private Curso curso;
    private List<Exemplar> exemplares;

    public Usuario() {
        this.exemplares = new ArrayList<Exemplar>();
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

}
