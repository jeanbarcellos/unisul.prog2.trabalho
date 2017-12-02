package control;

import model.Curso;

import model.dao.DaoFactory;
import model.dao.CursoDao;

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

    /**
     * Instância do DaoFactory de Cursos
     */
    private final CursoDao cursoDao = DaoFactory.getDaoFactory().getCursoDao();

    /**
     * Construtor
     *
     * Carrega a lista de cursos armazanados na base de dados
     */
    public CursoControl() {
//        this.cursos = new ArrayList<Curso>();

        // Carrega os cursos vindos da base de dados
//        this.setCursos(this.carregarLista());
    }

    /**
     * Retona a lista de Cursos do controlador
     *
     * @return Lista de Cursos
     */
    public List<Curso> getCursos() {
        return this.cursoDao.all();
    }

    /**
     * Inserir um curso
     *
     * @param curso
     * @return Booleano
     */
    public boolean inserir(Curso curso) {

        // Gerar automaticamente o ID e definir no novo Objeto
        curso.setId(autoId());

        return this.cursoDao.insert(curso);
//        // Inserir em memória
//        this.cursos.add(curso);
//
//        // Persistir
//        boolean db = cursoDao.insert(curso);
//
//        // Verifica o exito da persistência e mantêm sincronização local
//        if (db) {
//            return true;
//        } else {
//            this.cursos.remove(curso);
//            return false;
//        }
    }

    /**
     * Alterar um curso
     *
     * @param curso Objeto Curso já modificado
     * @return Booleando
     */
    public boolean alterar(Curso curso) {
        System.out.println(curso);
        return this.cursoDao.update(curso);
//
//        // Referencia o Objeto a ser alterado na memória
//        Curso cursoRef = this.getCurso(curso.getId());
//
//        // Verifica se o objeto existe
//        if (cursoRef != null) {
//
//            // Altera somente o nome
//            cursoRef.setNome(curso.getNome());
//
//            boolean retorno = cursoDao.update(curso);
//
//            return retorno;
//        } else {
//            return false;
//        }

    }

    /**
     * Excluir um objeto da base de dados
     *
     * @param id ID do Objeto a ser excluido
     * @return true ou false
     */
    public boolean excluir(int id) {
        return this.cursoDao.delete(id);
//        // Carrega o Objeto
//        Curso cursoRef = this.getCurso(id);
//
//        if (cursoRef != null) {
//
//            // Remove da listas
//            this.cursos.remove(cursoRef);
//
//            boolean retorno = cursoDao.delete(id);
//
//            return retorno;
//        } else {
//            return false;
//        }
    }

    /**
     * Retorna a referência de um objeto da lista através de seu ID. Caso não o
     * encontre retorna NULL.
     *
     * @param id ID do Curso a ser buscado na lista
     * @return Objeto Curso
     */
    public Curso getCurso(int id) {
        return this.cursoDao.load(id);
//        Curso retorno = null;
//        for (Curso cursoExt : this.getCursos()) {
//            if (cursoExt.getId() == id) {
//                retorno = cursoExt;
//            }
//        }
//        return retorno;
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return cursoDao.lastId();
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
