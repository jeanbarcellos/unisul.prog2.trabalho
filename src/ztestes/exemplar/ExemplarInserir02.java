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
public class ExemplarInserir02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LivroControl livroControl = new LivroControl();
        ExemplarControl exemplarControl = new ExemplarControl();

        int livroId;
        String localizacao;
        String edicao;
        
        String texto = "";
        texto += "Informe o ID do Livro:\n";        
        livroId = Integer.parseInt(JOptionPane.showInputDialog(texto));

        // Carrega o objeto a --------------------------------------------------
        Livro livro = livroControl.getLivro(livroId);

        if (livro == null) {
            JOptionPane.showMessageDialog(null, "O livro informado não existe.");
        } else {
            int opcao = 1;

            int totalExemplares = exemplarControl.total(livro.getId());

            while (opcao >= 1 && opcao <= 3) {

                String exemplaresTxt = "ID | Edição | Localização:\n";
                for (Exemplar exemp : exemplarControl.listar(livroId)) {
                    exemplaresTxt += "" + exemp.getId() + " | " + exemp.getEdicao() + " | " + exemp.getLocalizacao() + " \n";
                }

                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "LIVRO: \n"
                        + "Titulo: " + livro.getTitulo() + " | "
                        + "Autor: " + livro.getAutor() + " | "
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
//                        exemplar.setLivro(livro);
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
