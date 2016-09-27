package control;

import model.Curso;
import arq.CursoArq;

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
    private final CursoArq arquivo = new CursoArq();

    public List<Curso> getCursos() {
        return this.cursos;
    }

    public boolean inserir(int id, String nome) {

        // Cria o objeto Curso
        Curso objeto = new Curso();
        objeto.setId(id);
        objeto.setNome(nome);

        // Inserir na lista
        this.cursos.add(objeto);

        // Persistencia
        this.arquivo.insert(objeto);

        return true;
    }

    public boolean alterar(int id, String nome) {

        // Procura na lista
        Curso objeto = new Curso();
        objeto.setNome(nome);
        

        // Apaga na lista
        
        // Persistencia
        this.arquivo.update(objeto);

        return true;
    }

    public boolean excluir(int id) {

        // Procura na lista
        Curso objeto = new Curso();

        // Apaga na lista
        // Persistencia
        this.arquivo.delete(objeto);

        return true;
    }

    public List<Curso> listar(){
        return this.cursos;
    }
}
