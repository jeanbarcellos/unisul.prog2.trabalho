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

    private final Livro livro;
    private final LivroControl livroControl = new LivroControl();
    private final ExemplarControl exemplarControl = new ExemplarControl();

    public ExemplarEditarView(int livroId) {
        this.livro = livroControl.getLivro(livroId);
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
