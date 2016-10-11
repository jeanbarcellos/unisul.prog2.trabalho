package model;

import java.io.Serializable;

/**
 * Modelo Aluno
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

    public Aluno() {

    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
