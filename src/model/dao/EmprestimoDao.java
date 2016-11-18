package model.dao;

import model.Emprestimo;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface EmprestimoDao {

    /**
     * Inserir Emprestimo na base de dados
     *
     * @param emprestimo Objeto a ser inserido
     * @return Resultado da inserção
     */
    public boolean insert(Emprestimo emprestimo);

}
