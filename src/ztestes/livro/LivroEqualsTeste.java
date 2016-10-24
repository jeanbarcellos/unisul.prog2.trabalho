/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes.livro;

import model.Livro;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class LivroEqualsTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Livro livro = new Livro();
        livro.setTitulo("Teste 1");
        System.out.println(livro.hashCode());

        Livro livro2 = new Livro();
        livro2.setTitulo("Teste 1");
        System.out.println(livro2.hashCode());

        if (livro2.equals(livro)) {
            System.out.println("É igual");
        } else {
            System.out.println("É diferente");            
        }

    }

}
