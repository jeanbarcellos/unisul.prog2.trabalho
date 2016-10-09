package test;

import control.CursoControl;
import javax.swing.JOptionPane;
import model.Curso;

public class CursoTeste03 {

    public static void main(String[] args) {

        CursoControl cursoControl = new CursoControl();

        cursoControl.inserir(new Curso("Ciência da Computação"));
        cursoControl.inserir(new Curso("Arquitetura"));
        cursoControl.inserir(new Curso("Sistemas de Informação"));
        cursoControl.inserir(new Curso("Letras"));

        String texto = "Crusos Cadastrados:\n";
        for (int i = 0; i < cursoControl.listar().size(); i++) {
            Curso cursoExt = cursoControl.listar().get(i);
            texto += "ID: " + cursoExt.getId() + " - ";
            texto += "Nome: " + cursoExt.getNome() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);

//        List<Curso> cursos = new ArrayList<>();
//        cursos.add(new Curso(1, "Ciência da Computação"));
//        cursos.add(new Curso(2, "Arquitetura"));
//        cursos.add(new Curso(3, "Sistemas de Informação"));                
//        int ultioId = cursos.get(cursos.size() - 1).getId();        
//        int proximoId = ultioId + 1;                
//        System.out.println(proximoId);
    }

}
