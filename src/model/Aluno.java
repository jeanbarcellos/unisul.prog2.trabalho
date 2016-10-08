package model;

/**
 * Modelo Aluno
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public class Aluno extends Usuario {

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
