package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo Professor
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public class Professor extends Usuario {

    private List<Curso> cursos;    

    public Professor() {
        this.cursos = new ArrayList<Curso>();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    
    
}
