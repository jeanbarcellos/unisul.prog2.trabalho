package model.dao;

import util.Config;

/**
 * Classe DaoFactory
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
public abstract class DaoFactory {

    /**
     * Retorna uma instância DaoFactory
     *
     * @return
     */
    public static DaoFactory getDaoFactory() {

        Config config = Config.getInstance();

        int tipo = Integer.parseInt(config.getValue("tipo"));

        if (tipo == 1) {
            return new PostgresDaoFactory();
        } else {
            return new ArquivoDaoFactory();
        }

    }

    /**
     * DAO Factory de Curso
     *
     * @return Instância de CursoDao
     */
    public abstract CursoDao getCursoDao();

    /**
     * DAO Factory de Livro
     *
     * @return Instância de LivroDao
     */
    public abstract LivroDao getLivroDao();

    /**
     * DAO Factory de Usuario
     *
     * @return Instância de UsuarioDao
     */
    public abstract UsuarioDao getUsuarioDao();

    /**
     * DAO Factory de Exemplar
     *
     * @return Instância de ExemplarDao
     */
    public abstract ExemplarDao getExemplarDao();

    /**
     * DAO Factory de Professor
     *
     * @return Instância de ProfessorDao
     */
    public abstract ProfessorDao getProfessorDao();

    /**
     * DAO Factory de Aluno
     *
     * @return Instância de AlunoDao
     */
    public abstract AlunoDao getAlunoDao();

    /**
     * DAO Factory de Emprestimo
     *
     * @return Instância de getEmprestimoDao
     */
    public abstract EmprestimoDao getEmprestimoDao();

}
