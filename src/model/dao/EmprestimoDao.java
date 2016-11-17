/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.Emprestimo;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface EmprestimoDao {
    
    /**
     * Inserir exemplar na base de dados
     *
     * @param emprestimo Objeto a ser inserido
     * @return Resultado da inserção
     */
    public boolean insert(Emprestimo emprestimo);
    
}
