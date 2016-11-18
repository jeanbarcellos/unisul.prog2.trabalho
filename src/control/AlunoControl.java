package control;

import model.Aluno;

import model.dao.DaoFactory;
import model.dao.AlunoDao;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe AlunoControl
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 01/11/2016
 *
 * @package control
 *
 */
public class AlunoControl {

    /**
     * Lista com todos os alunos sincronizados com a base de dados
     */
    private List<Aluno> alunos;

    /**
     * Instância do DaoFactory de Cursos
     */
    private AlunoDao alunoDao = DaoFactory.getDaoFactory().getAlunoDao();

    /**
     * Contrutor
     */
    public AlunoControl() {
        this.alunos = new ArrayList<Aluno>();
        this.setAlunos(this.carregarLista());
    }

    /**
     * Retorna a lista de Alunos do controlador
     *
     * @return Lista de Alunos
     */
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * Seta a Lista de alunos do controlador. Declaramos setAluno() como privado
     * pois ninguem, além do próprio controlador, pode gerenciar a lista.
     *
     * @param alunos Alunos a serem setados na lista.
     */
    private void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    /**
     * Inserir um aluno
     *
     * @param aluno
     * @return Booleano
     */
    public boolean inserir(Aluno aluno) {

        aluno.setId(this.autoId());

        this.alunos.add(aluno);

        boolean db = alunoDao.insert(aluno);

        if (db) {
            return true;
        } else {
            this.alunos.remove(aluno);
            return false;
        }

    }

    /**
     * Alterar um aluno
     *
     * @param aluno Objeto Aluno já modificado
     * @return Booleando
     */
    public boolean alterar(Aluno aluno) {

        Aluno alunoRef = this.getAluno(aluno.getId());

        if (alunoRef != null) {
            aluno.setNome(aluno.getNome());
            aluno.setMatricula(aluno.getMatricula());
            aluno.setCurso(aluno.getCurso());

            boolean retorno = alunoDao.update(aluno);

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

        Aluno alunoRef = this.getAluno(id);

        if (alunoRef != null) {
            this.alunos.remove(alunoRef);

            boolean retorno = alunoDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Retorna a referência de um objeto da lista através de seu ID. Caso não o
     * encontre retorna NULL.
     *
     * @param id ID do Aluno a ser buscado na lista
     * @return Objeto Aluno
     */
    public Aluno getAluno(int id) {
        Aluno retorno = null;
        for (Aluno alunoExt : this.getAlunos()) {
            if (alunoExt.getId() == id) {
                retorno = alunoExt;
            }
        }
        return retorno;
    }

    /**
     * Carrega a lista no controlador
     *
     * @return Lista com todos os Alunos
     */
    private List<Aluno> carregarLista() {
        return alunoDao.all();
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return alunoDao.lastId();
    }

    /**
     * Gera o próximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }

}
