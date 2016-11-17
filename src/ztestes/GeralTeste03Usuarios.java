package ztestes;

import model.*;

public class GeralTeste03Usuarios {

    static int total = 0;

    public static int incrTotal() {
        total = total + 1;
        return total;
    }

    public static void usuarioInserir(Usuario usuario) {
        int id = incrTotal();
        String sql1 = "";
        String sql2 = "";

        sql1 += "INSERT INTO usuario (id, nome) VALUES (" + id + ");";

        if (usuario instanceof Professor) {
            sql2 = "INSERT INTO professor ";
            sql2 += "(usuario_id, matricula) ";
            sql2 += "VALLUES ";
            sql2 += "(" + id + "," + usuario.getMatricula() + ", '" + usuario.getNome() + "');";

        } else if (usuario instanceof Aluno) {
            sql2 = "INSERT INTO aluno ";
            sql2 += "(usuario_id, matricula) ";
            sql2 += "VALLUES ";
            sql2 += "(" + id + "," + usuario.getMatricula() + ", '" + usuario.getNome() + "');";

        }

        System.out.println(sql1);
        System.out.println(sql2 + "\n");

    }

    public static void main(String[] args) {

        Aluno usuario1 = new Aluno();
        usuario1.setMatricula(10001);
        usuario1.setNome("Jean Barcellos Aluno");
        usuario1.setCurso(new Curso("Sistemas de Informação"));

        Professor usuario2 = new Professor();
        usuario2.setMatricula(10001);
        usuario2.setNome("Jean Barcellos Profe");

        Aluno usuario3 = new Aluno();
        usuario3.setMatricula(10002);
        usuario3.setNome("Mario José da Silva");
        usuario3.setCurso(new Curso("Ciência da Computação"));

        usuarioInserir(usuario1);
        usuarioInserir(usuario2);
        usuarioInserir(usuario3);

    }

}
