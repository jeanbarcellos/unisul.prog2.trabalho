package model;

import java.io.Serializable;

/**
 * Modelo Aluno. Especialização de Usuario
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public class Aluno extends Usuario implements Serializable {

    private static final long serialVersionUID = 9159168048922608852L;

    private Curso curso;

    /**
     * Construtor
     */
    public Aluno() {

    }

    /**
     * Retorna o curso que o Aluno frequenta
     * @return
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Define o curso que o Aluno frequena
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
