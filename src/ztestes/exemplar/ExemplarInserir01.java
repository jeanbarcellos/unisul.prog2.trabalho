/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes.exemplar;

import control.ExemplarControl;
import control.LivroControl;
import java.util.List;
import javax.swing.JOptionPane;
import model.Exemplar;
import model.Livro;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class ExemplarInserir01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LivroControl livroControl = new LivroControl();
        ExemplarControl exemplarControl = new ExemplarControl();

        int livroId;
        String localizacao;
        String edicao;

//        List<Livro> lista = livroControl.getLivros();

        // Listagem de livros --------------------------------------------------
        String texto = "Livros Cadastrados:\n";
//        for (int i = 0; i < lista.size(); i++) {
//            Livro livroExt = lista.get(i);
//            texto += "ID: " + livroExt.getId() + " - ";
//            texto += "Título: " + livroExt.getTitulo() + " - ";
//            texto += "Autor: " + livroExt.getAutor() + "  \n";
//        }
        texto += "\nInforme o ID do Livro:\n";
        
        livroId = Integer.parseInt(JOptionPane.showInputDialog(texto));

        // Carrega o objeto a --------------------------------------------------
        Livro livroSelecionado = livroControl.getLivro(livroId);

        if (livroSelecionado == null) {
            JOptionPane.showMessageDialog(null, "O livro informado não existe.");
        } else {
            int opcao = 1;

            int totalExemplares = exemplarControl.total(livroSelecionado.getId());

            while (opcao >= 1 && opcao <= 3) {

                String exemplaresTxt = "ID | Edição | Localização:\n";
                for (Exemplar exemp : exemplarControl.listar(livroId)) {
                    exemplaresTxt += "" + exemp.getId() + " | " + exemp.getEdicao() + " | " + exemp.getLocalizacao() + " \n";
                }

                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "LIVRO: \n"
                        + "Titulo: " + livroSelecionado.getTitulo() + " | "
                        + "Autor: " + livroSelecionado.getAutor() + " | "
                        + "Total Exemplares: " + totalExemplares + "\n"
                        + "\n"
                        + "EXEMPLARES: \n"
                        + exemplaresTxt
                        + "\n"
                        + "O que desejas fazer? \n"
                        + "1 - Cadastrar\n"
                        + "2 - Alterar \n"
                        + "3 - Apagar \n"
                        + "0 - Voltar ao menu de cadastros \n\n",
                        "GERENCIAR EXEMPLARES", JOptionPane.QUESTION_MESSAGE
                ));

                switch (opcao) {
                    case 1:

                        edicao = JOptionPane.showInputDialog("Informe a EDICÃO do Exemplar:");
                        localizacao = JOptionPane.showInputDialog("Informe a LOCALIZAÇÃO do Exemplar:");

                        Exemplar exemplar = new Exemplar();
//                        exemplar.setLivro(livroSelecionado);
                        exemplar.setEdicao(edicao);
                        exemplar.setLocalizacao(localizacao);

                        boolean retorno = exemplarControl.inserir(exemplar);

                        if (retorno) {
                            JOptionPane.showMessageDialog(null, "Exemplar Cadastrado com Sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Exemplar.");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }

            }

        }

    }

}
