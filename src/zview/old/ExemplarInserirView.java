package zview.old;

import model.Exemplar;

import control.ExemplarControl;

import javax.swing.JOptionPane;
import model.Livro;

/**
 * Classe ExemplarInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 02/11/2016
 *
 * @package view
 *
 */
public class ExemplarInserirView {

    private Livro livro;
    private ExemplarControl exemplarControl = new ExemplarControl();

    public ExemplarInserirView(Livro livro) {
        this.livro = livro;
    }    

    public void show() {
        
        String livroTxt = "";
        livroTxt += "LIVRO \n";
        livroTxt += "Titulo: " + this.livro.getTitulo() + " \n";
        livroTxt += "Autorr: " + this.livro.getAutor() + " \n\n";

        String edicao = JOptionPane.showInputDialog(livroTxt + "Informe a EDICÃO do Exemplar:");
        String localizacao = JOptionPane.showInputDialog(livroTxt + "Informe a LOCALIZAÇÃO do Exemplar:");

        Exemplar exemplar = new Exemplar();
        exemplar.setLivro(this.livro);
        exemplar.setEdicao(edicao);
        exemplar.setLocalizacao(localizacao);

        boolean retorno = exemplarControl.inserir(exemplar);

        if (retorno) {
            JOptionPane.showMessageDialog(null, "Exemplar Cadastrado com Sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Exemplar.");
        }

    }

}
