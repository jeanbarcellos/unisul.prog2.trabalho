package control;

import model.Curso;

import model.dao.CursoDao;
import model.dao.DaoFactory;

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
public final class CursoControl {

    private List<Curso> cursos;

    /**
     * Construtor
     */
    public CursoControl() {
        this.cursos = new ArrayList<Curso>();
        
        // Carrega os cursos vindos da base de dados
        this.setCursos(this.carregarLista());
    }

    public List<Curso> getCursos() {
        return this.cursos;
    }

    private void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    /**
     * Inserir objeto
     *
     * @param curso
     * @return Booleano
     */
    public boolean inserir(Curso curso) {

        // Gerar automaticamente o ID
        curso.setId(autoId());

        // Inserir em memória
        this.cursos.add(curso);

        // Persistir
        DaoFactory dao = DaoFactory.getDaoFactory();
        CursoDao cursoDao = dao.getCursoDao();

        return cursoDao.insert(curso);
    }

    /**
     * Alterar objeto
     *
     * @param id ID do Objeto a ser alterado
     * @param curso Objeto Curso já modificado
     * @return Booleando
     */
    public boolean alterar(int id, Curso curso) {

        // Referencia o Objeto a ser alterado na memória
        Curso cursoLista = this.getCurso(id);

        // Verifica se o objeto existe
        if (cursoLista != null) {

            // Altera somente o nome
            cursoLista.setNome(curso.getNome());

            // Persiste a ateração
            DaoFactory dao = DaoFactory.getDaoFactory();
            CursoDao cursoDao = dao.getCursoDao();
            boolean retorno = cursoDao.update(id, curso);

            return retorno;
        } else {
            return false;
        }

    }

    /**
     * Excluir um objeto da base de dados
     *
     * @param id ID do Objeto a ser excluido
     * @return true ou false
     */
    public boolean excluir(int id) {

        // Carrega o Objeto
        Curso cursoLista = this.getCurso(id);

        if (cursoLista != null) {

            // Remove da listas
            this.cursos.remove(cursoLista);

            // Persiste a exclusão
            DaoFactory dao = DaoFactory.getDaoFactory();
            CursoDao cursoDao = dao.getCursoDao();

            boolean retorno = cursoDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Recupera (retorna) um objeto da lista através de seu ID
     *
     * @param id ID do Curso
     * @return Objeto Curso
     */
    public Curso getCurso(int id) {
        Curso retorno = null;
        for (Curso cursoExt : this.getCursos()) {
            if (cursoExt.getId() == id) {
                retorno = cursoExt;
            }
        }
        return retorno;
    }

    /**
     * Carega a lista do controlador
     *
     * @return Lista com todos os Cursos
     */
    private List<Curso> carregarLista() {
        DaoFactory dao = DaoFactory.getDaoFactory();
        CursoDao cursoDao = dao.getCursoDao();
        return cursoDao.all();
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
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
