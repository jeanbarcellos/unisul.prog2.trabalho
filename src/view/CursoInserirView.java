package view;

import model.Curso;
import control.CursoControl;
import javax.swing.JOptionPane;

/**
 * Classe CursoInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class CursoInserirView {

    public void show() {

        String nome;

        // Colher informação do usuário
        nome = JOptionPane.showInputDialog("Informe o nome do curso a ser inserido:");

        // Objeto de Transição
        Curso curso = new Curso();
        curso.setNome(nome);

        // Envia o objeto criado para o controlador               
//        boolean retorno = this.cursoControl.inserir(curso);
//        
//        if (retorno) {
//            JOptionPane.showMessageDialog(null, "Curso Cadastrado com Sucesso");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Curso");
//        }

        // Persistir

    }

}
