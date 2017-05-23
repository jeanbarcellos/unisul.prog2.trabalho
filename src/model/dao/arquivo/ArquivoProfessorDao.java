package model.dao.arquivo;

import model.Professor;

import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.dao.ProfessorDao;

import util.PersistenciaArquivo;

/**
 * Classe ArquivoProfessorDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 18/11/2016
 *
 * @package model.dao
 *
 */
final public class ArquivoProfessorDao implements ProfessorDao {

    private List<Professor> professores = new ArrayList<Professor>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoProfessorDao() {
        this.persistArquivo = new PersistenciaArquivo("professores.bin", "usuario_seq.txt");
        
        this.carregarLista();
    }

    @Override
    public boolean insert(Professor professor) {

        // Adicionar a lista temporária local
        this.professores.add(professor);

        // Serializar arquivo
        this.persistArquivo.serializar(this.professores);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Professor professor) {

        Professor professorRef = this.load(professor.getId());

        if (professorRef != null) {

            // Altera somente o nome
            professorRef.setNome(professor.getNome());

            // Persistir
            this.persistArquivo.serializar(this.professores);

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Professor professorRef = this.load(id);

        if (professorRef != null) {

            // Remover a lista
            this.professores.remove(professorRef);

            // Persistir
            this.persistArquivo.serializar(this.professores);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Professor load(int id) {
        Professor retorno = null;
        for (Professor professorExt : professores) {
            if (professorExt.getId() == id) {
                retorno = professorExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Professor> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {
        return this.persistArquivo.getLastId();
    }

    private void carregarLista() {
        this.professores = this.all();
    }

    
    @Override
    public List<Curso> getCursos(int idProfessor) {
        this.carregarLista();
        Professor professor = this.load(idProfessor);
        return professor.getCursos();
    }

    @Override
    public boolean addCurso(int idProfessor, Curso curso) {
        Professor professor = this.load(idProfessor);

        professor.addCurso(curso);
        System.out.println(professor);

        this.persistArquivo.serializar(this.professores);

        this.carregarLista();

        return true;
    }

    @Override
    public boolean delCurso(int idProfessor, int cursoId) {
        Professor professor = this.load(idProfessor);
        professor.delCurso(cursoId);

        this.persistArquivo.serializar(this.professores);

        this.carregarLista();

        return true;
    }

    @Override
    public List<Professor> buscarPeloNome(String nome) {
        List<Professor> lista = new ArrayList<Professor>();

        for (Professor professor : this.professores) {
            System.out.println(professor);
            if (professor.getNome().equals(nome)) {
                lista.add(professor);
            }
        }
        return lista;
    }

    @Override
    public List<Professor> buscarPelaMatricula(int matricula) {
        List<Professor> lista = new ArrayList<Professor>();

        for (Professor professor : this.professores) {
            if (professor.getMatricula() == matricula) {
                lista.add(professor);
            }
        }
        return lista;
    }

}
