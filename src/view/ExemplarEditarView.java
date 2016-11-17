package view;

import control.ExemplarControl;
import control.LivroControl;

import javax.swing.JOptionPane;
import model.Exemplar;
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
class ExemplarEditarView {

    private Livro livro;
    private ExemplarControl exemplarControl = new ExemplarControl();

    public ExemplarEditarView(Livro livro) {
        this.livro = livro;
    }

    public void show() {

        String livroTxt = "";
        livroTxt += "LIVRO \n";
        livroTxt += "Titulo: " + this.livro.getTitulo() + " \n";
        livroTxt += "Autorr: " + this.livro.getAutor() + " \n\n";
        
        int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do EXEMPPLAR a ser alterado:"));

        Exemplar exemplarSelecionado = exemplarControl.getExemplar(idAlterar);

        if (exemplarSelecionado != null) {

            String edicao = JOptionPane.showInputDialog(livroTxt + "Informe a EDICÃO do Exemplar:");
            String localizacao = JOptionPane.showInputDialog(livroTxt + "Informe a LOCALIZAÇÃO do Exemplar:");
            
            exemplarSelecionado.setEdicao(edicao);
            exemplarSelecionado.setLocalizacao(localizacao);

            boolean retorno = exemplarControl.alterar(exemplarSelecionado);

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Exemplar alterado com Sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Tentar alterar Exemplar.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O código informado não existe");
        }

    }

}
