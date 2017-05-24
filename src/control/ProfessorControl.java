package control;

import model.Professor;

import model.dao.DaoFactory;
import model.dao.ProfessorDao;

import java.util.List;
import java.util.ArrayList;
import model.Curso;

/**
 * Classe ProfessorControl
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 01/11/2016
 *
 * @package control
 *
 */
public class ProfessorControl {

    /**
     * Lista com todos os professores sincronizados com a base de dados
     */
    private List<Professor> professores;

    /**
     * Instância do DaoFactory de Cursos
     */
    private ProfessorDao professorDao = DaoFactory.getDaoFactory().getProfessorDao();

    /**
     * Contrutor
     */
    public ProfessorControl() {
        this.professores = new ArrayList<Professor>();
        this.setProfessores(this.carregarLista());
    }

    /**
     * Retorna a lista de Professores do controlador
     *
     * @return Lista de Professores
     */
    public List<Professor> getProfessores() {
        return professores;
    }

    /**
     * Seta a Lista de professores do controlador. Declaramos setProfessor()
     * como privado pois ninguem, além do próprio controlador, pode gerenciar a
     * lista.
     *
     * @param professores Professores a serem setados na lista.
     */
    private void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    /**
     * Inserir um aluno
     *
     * @param aluno
     * @return Booleano
     */
    public boolean inserir(Professor aluno) {

        aluno.setId(this.autoId());

        this.professores.add(aluno);

        boolean db = professorDao.insert(aluno);

        if (db) {
            return true;
        } else {
            this.professores.remove(aluno);
            return false;
        }

    }

    /**
     * Alterar um aluno
     *
     * @param aluno Objeto Professor já modificado
     * @return Booleando
     */
    public boolean alterar(Professor aluno) {

        Professor alunoRef = this.getProfessor(aluno.getId());

        if (alunoRef != null) {
            aluno.setNome(aluno.getNome());
            aluno.setMatricula(aluno.getMatricula());

            boolean retorno = professorDao.update(aluno);

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

        Professor alunoRef = this.getProfessor(id);

        if (alunoRef != null) {
            this.professores.remove(alunoRef);

            boolean retorno = professorDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Retorna a referência de um objeto da lista através de seu ID. Caso não o
     * encontre retorna NULL.
     *
     * @param id ID do Professor a ser buscado na lista
     * @return Objeto Professor
     */
    public Professor getProfessor(int id) {
        Professor retorno = null;
        for (Professor profExt : this.getProfessores()) {
            if (profExt.getId() == id) {
                retorno = profExt;
            }
        }
        return retorno;
    }

    /**
     * Pegar professor por matricula
     *
     * @param matricula Matrícula a ser pesquisada
     * @return
     */
    public Professor getProfessorMatricula(int matricula) {
        Professor retorno = null;
        for (Professor profExt : this.getProfessores()) {
            if (profExt.getMatricula() == matricula) {
                retorno = profExt;
            }
        }
        return retorno;
    }

    /**
     * Carrega a lista no controlador
     *
     * @return Lista com todos os Professores
     */
    private List<Professor> carregarLista() {
        return professorDao.all();
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return professorDao.lastId();
    }

    /**
     * Gera o próximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }

    /**
     * Recupera a lista de cursos que o professor participa
     *
     * @param idProfessor ID do Professor
     * @return
     */
    public List<Curso> getCursosParticipa(int idProfessor) {
        return this.professorDao.getCursos(idProfessor);
    }

    /**
     * Adiciona um professor a um curso, no qual participa
     *
     * @param idProfessor ID do Professor
     * @param curso Curso no qual irá participar
     * @return
     */
    public boolean adicionarCurso(int idProfessor, Curso curso) {
        return this.professorDao.addCurso(idProfessor, curso);
    }

    /**
     * Desassocia um professor a um curso que ele até então participava
     *
     * @param idProfessor ID do Professor
     * @param idCurso ID do Curso
     * @return
     */
    public boolean excluirCurso(int idProfessor, int idCurso) {
        return this.professorDao.delCurso(idProfessor, idCurso);
    }

    /**
     * Buscar Professor através de seu nome
     *
     * @param nome Nome
     * @return
     */
    public List<Professor> buscarPeloNome(String nome) {
        return professorDao.buscarPeloNome(nome);
    }

    /**
     * Buscar professor através da sua matrícula
     *
     * @param matricula Matricula
     * @return
     */
    public List<Professor> buscarPelaMatricula(int matricula) {
        return professorDao.buscarPelaMatricula(matricula);
    }

}
