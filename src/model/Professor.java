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

    private static final long serialVersionUID = -4753435542710781157L;

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

    public boolean addCurso(Curso curso) {
        this.cursos.add(curso);
        return true;
    }

    public boolean delCurso(int cursoId) {       
        for (Curso cursoEx : this.cursos) {
            if (cursoEx.getId() == cursoId) {
                this.cursos.remove(cursoEx);
                return true;
            }
        }
        return true;
    }

    public Curso getCurso(int id) {
        Curso retorno = null;
        for (Curso cursoEx : this.cursos) {
            if (cursoEx.getId() == id) {
                retorno = cursoEx;
            }
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + super.getId() + ", matricula=" + super.getMatricula() + ", nome=" + super.getNome() + ", cursos=" + cursos + "}";
    }
    
    

}
