package view;

import javax.swing.JOptionPane;

/**
 * Classe CursoListarView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 08/10/2016
 *
 * @package view
 *
 */
public class CursoListarView {

    public void show() {

        JOptionPane.showMessageDialog(null, "Exibindo listagem");

    }

}

//        String texto = "Crusos Cadastrados:\n";
//        for (int i = 0; i < cursoControl.listar().size(); i++) {
//            Curso cursoExt = cursoControl.listar().get(i);
//            texto += "ID: " + cursoExt.getId() + " - ";
//            texto += "Nome: " + cursoExt.getNome() + "\n";
//        }
////                    for(Curso cursoExt : cursoControl.listar()){
////                        texto += cursoExt.getNome() + "\n";
////                    }                                        
//        JOptionPane.showMessageDialog(null, texto);
