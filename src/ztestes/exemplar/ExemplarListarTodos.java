package ztestes.exemplar;

import control.ExemplarControl;
import control.LivroControl;
import model.Exemplar;
import model.Livro;

public class ExemplarListarTodos {

    public static void main(String[] args) {

        LivroControl livroControl = new LivroControl();
        ExemplarControl livroExemplar = new ExemplarControl();
        
        String resultTxt;        
        Livro livro;
        
        for(Exemplar exe : livroExemplar.getExemplares()){
            livro =  livroControl.getLivro(exe.getLivroId());
            
            resultTxt = "";
            resultTxt += "ID: " + exe.getId() + " | ";
            resultTxt += "Livro {ID " + livro.getId() + ", ";
            resultTxt += "Titulo: " + livro.getTitulo()+ "} | ";
            resultTxt += "Edição" + exe.getEdicao();
            
            System.out.println(resultTxt);
        }
        
    }

}
