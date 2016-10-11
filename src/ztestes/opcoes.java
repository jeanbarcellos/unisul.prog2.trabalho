/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import javax.swing.JOptionPane;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class opcoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int escolha = 0;

        while (escolha >= 0 && escolha <= 3) {

            String titulo = "Gerencimaneto de Cursos";
            String mensagem = "Selecione uma opção.";
            String[] opcoes = {" Inserir ", " Editar ", " Excluir ", " Listar ", " Voltar ao menu"};

            escolha = JOptionPane.showOptionDialog(null, mensagem, titulo,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, opcoes, opcoes[0]);          

            switch (escolha) {

                case 0:
                    // Chama a view de Inserção
                    break;
                case 1:
                    // Chama a view de Consultas
                    break;
                case 2:
                    // Chama a view de Relatórios
                    break;
                case 3:
                    // Chama a view de Procedimentos
                    break;
            }

        }

    }

}
