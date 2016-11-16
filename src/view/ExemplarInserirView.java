package view;

import model.Exemplar;

import control.ExemplarControl;
import control.LivroControl;

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
class ExemplarInserirView {

    private final Livro livro;
    private final LivroControl livroControl = new LivroControl();
    private final ExemplarControl exemplarControl = new ExemplarControl();

    public ExemplarInserirView(int livroId) {
        this.livro = livroControl.getLivro(livroId);
    }

    public void show() {
        
        String livroTxt = "";
        livroTxt += "LIVRO \n";
        livroTxt += "Titulo: " + this.livro.getTitulo() + " \n";
        livroTxt += "Autorr: " + this.livro.getAutor() + " \n\n";

        String edicao = JOptionPane.showInputDialog(livroTxt + "Informe a EDICÃO do Exemplar:");
        String localizacao = JOptionPane.showInputDialog(livroTxt + "Informe a LOCALIZAÇÃO do Exemplar:");

        Exemplar exemplar = new Exemplar();
        exemplar.setLivroId(this.livro.getId());
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
