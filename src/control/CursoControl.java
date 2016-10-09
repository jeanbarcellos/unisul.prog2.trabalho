package control;

import model.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe CursoControl
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 10/09/2016
 *
 * @package control
 *
 */
public class CursoControl extends Control {

    private final List<Curso> cursos = new ArrayList<>();

    public List<Curso> getCursos() {
        return this.cursos;
    }

    /**
     * Inserir curso
     * 
     * @param curso Objeto a ser cadastrado
     * @return void
     */
    public boolean inserir(Curso curso) {

        // Gerar automaticamente o ID
        curso.setId(autoId());

        // Inserir em memória
        this.cursos.add(curso);

        // Persistir
        
        
        return true;
    }

    public boolean alterar(int id, Curso curso) {

        return true;
    }

    public boolean excluir(int id) {

        return true;
    }

    public List<Curso> listar() {
        return this.cursos;
    }

    /**
     * Pega o último ID
     *
     * @return
     */
    private int ultimoId() {
        int size = cursos.size();
        int resultado = 0;

        if (size > 0) {
            resultado = cursos.get(size - 1).getId();
        }

        return resultado;
    }

    /**
     * Gera o póximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }
}
