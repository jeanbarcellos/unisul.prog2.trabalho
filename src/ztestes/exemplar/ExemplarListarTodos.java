package ztestes.exemplar;

import control.ExemplarControl;
import model.Exemplar;

public class ExemplarListarTodos {

    public static void main(String[] args) {

        ExemplarControl livroExemplar = new ExemplarControl();

        String resultTxt;

        for (Exemplar exe : livroExemplar.getExemplares()) {
//            System.out.println(exe);

            resultTxt = "";
            resultTxt += "ID: " + exe.getId() + " | ";
            resultTxt += "Livro {ID " + exe.getLivro().getId() + ", ";
            resultTxt += "Titulo: " + exe.getLivro().getTitulo() + "} | ";
            resultTxt += "Edição" + exe.getEdicao();
            System.out.println(resultTxt);
        }

    }

}
