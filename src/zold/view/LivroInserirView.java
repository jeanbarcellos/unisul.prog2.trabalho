package zold.view;

import control.LivroControl;
import javax.swing.JOptionPane;
import model.Livro;

/**
 * Classe LivroInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package view
 *
 */
public class LivroInserirView {

    private LivroControl livroControl;

    public LivroInserirView() {
        this.livroControl = new LivroControl();
    }

    public void show() {

        String titulo;
        String autor;

        // Colher informação do usuário
        titulo = JOptionPane.showInputDialog("Informe o NOME do Livro:");
        autor = JOptionPane.showInputDialog("Informe o AUTOR do Livro:");

        // Cria o objeto
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);

        // Envia o objeto criado para o controlador               
        boolean retorno = this.livroControl.inserir(livro);

        if (retorno) {
            JOptionPane.showMessageDialog(null, "Livro Cadastrado com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Livro.");
        }

    }

}
