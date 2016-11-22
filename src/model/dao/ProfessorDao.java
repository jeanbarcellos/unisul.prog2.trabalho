package model.dao;

import model.Professor;

import java.util.List;
import model.Curso;

/**
 * Interface ProfessorDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface ProfessorDao {

    /**
     * Inserir professor na base de dados
     *
     * @param professor
     * @return Resultado da inserção
     */
    public boolean insert(Professor professor);

    /**
     * Alterar professor na base de dados
     *
     * @param professor Objeto a ser alterado
     * @return
     */
    public boolean update(Professor professor);

    /**
     * Apagar professor da base de dados
     *
     * @param id ID do Objeto
     * @return
     */
    public boolean delete(int id);

    /**
     * Recupera um objeto da base de dados através de seu ID informado e
     * instancia-o na memória
     *
     * @param id ID do objeto
     * @return Objeto Professor
     */
    public Professor load(int id);

    /**
     * Recupera todos os registros da base de dados
     *
     * @return Lista de todos os Professors
     */
    public List<Professor> all();

    /**
     * Recupera o último ID cadastrado
     *
     * @return último ID cadastrado
     */
    public int lastId();

    /**
     * Lista os cursos que o professor participa
     *
     * @param idProfessor do Professor
     * @return
     */
    public List<Curso> getCursos(int idProfessor);

    /**
     * Relaciona um professor a um curso
     *
     * @param idProfessor ID do Professor
     * @param curso ID do Curso
     * @return Boolean
     */
    public boolean addCurso(int idProfessor, Curso curso);

    /**
     * Relaciona um professo a um curso
     *
     * @param idProfessor ID do Professor
     * @param cursoId ID do Curso
     * @return Boolean
     */
    public boolean delCurso(int idProfessor, int cursoId);

    /**
     * Realiza buscar de professores pelo nome
     *
     * @param nome Nome a ser pesquisado
     * @return Lista de Professores
     */
    public List<Professor> buscarPeloNome(String nome);

    /**
     * Realiza buscar de professores pelo nome
     *
     * @param matricula Matrícula a ser pesquisada
     * @return Lista de Professores
     */
    public List<Professor> buscarPelaMatricula(int matricula);
}
