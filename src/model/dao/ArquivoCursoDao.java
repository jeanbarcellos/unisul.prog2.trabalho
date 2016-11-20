package model.dao;

import model.Curso;

import java.util.List;
import java.util.ArrayList;

import util.PersistenciaArquivo;

/**
 * Classe ArquivoCursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
final class ArquivoCursoDao implements CursoDao {

    private List<Curso> cursos = new ArrayList<Curso>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoCursoDao() {
        this.persistArquivo = new PersistenciaArquivo("cursos.bin", "curso_seq.txt");
        this.cursos = this.all();
    }

    @Override
    public boolean insert(Curso curso) {

        // Adicionar a lista temporária local
        this.cursos.add(curso);

        // Serializar arquivo
        this.persistArquivo.serializar(this.cursos);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Curso curso) {

        Curso cursoRef = this.load(curso.getId());

        if (cursoRef != null) {

            // Altera somente o nome
            cursoRef.setNome(curso.getNome());

            // Persistir
            this.persistArquivo.serializar(this.cursos);

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Curso cursoRef = this.load(id);

        if (cursoRef != null) {

            // Remover a lista
            this.cursos.remove(cursoRef);

            // Persistir
            this.persistArquivo.serializar(this.cursos);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Curso load(int id) {
        Curso retorno = null;
        for (Curso cursoExt : cursos) {
            if (cursoExt.getId() == id) {
                retorno = cursoExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Curso> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {        
        return this.persistArquivo.getLastId();
    }
    
}
