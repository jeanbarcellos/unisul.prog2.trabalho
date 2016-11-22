package control;

import model.Professor;

import model.dao.DaoFactory;
import model.dao.ProfessorDao;

import java.util.List;
import java.util.ArrayList;

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
        for (Professor alunoExt : this.getProfessores()) {
            if (alunoExt.getId() == id) {
                retorno = alunoExt;
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

    public List<Professor> buscarPeloNome(String nome) {
        return professorDao.buscarPeloNome(nome);
    }

    public List<Professor> buscarPelaMatricula(int matricula) {
        return professorDao.buscarPelaMatricula(matricula);
    }

}
