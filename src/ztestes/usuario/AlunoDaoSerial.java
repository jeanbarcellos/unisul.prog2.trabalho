package ztestes.usuario;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Curso;
import zold.PersistenciaArquivoTeste;

public class AlunoDaoSerial {

    public static void main(String[] args) {

        String filename = "conteudo/alunos.bin";
        String sequencia = "conteudo/aluno_seq";

        // SERIALIZAR ----------------------------------------------------------
        
//        Aluno usuario1 = new Aluno();
//        usuario1.setId(1);
//        usuario1.setMatricula(1001);
//        usuario1.setNome("Jean Barcellos");
//        usuario1.setCurso(null);
//
//        Aluno usuario2 = new Aluno();
//        usuario2.setId(2);
//        usuario2.setMatricula(1002);
//        usuario2.setNome("Pafúncio Constâncio");
//        usuario2.setCurso(null);
//
//        Aluno usuario3 = new Aluno();
//        usuario3.setId(3);
//        usuario3.setMatricula(1003);
//        usuario3.setNome("Marcos Almeida");
//        usuario3.setCurso(null);
//
        List<Aluno> lista = new ArrayList<Aluno>();
//        lista.add(usuario1);
//        lista.add(usuario2);
//        lista.add(usuario3);
//
//        for (Aluno profEx : lista) {
//            System.out.println(profEx);
//        }
//        
//        PersistenciaArquivoTeste.serializar(filename, lista);


        // DESERIALIZAR --------------------------------------------------------
          
//        List<Aluno> listaDes = PersistenciaArquivoTeste.deserializar(filename);
//
//        for (Aluno profEx : listaDes) {
//            System.out.println(profEx);
//        }
        
        // ÚLTIMO ID -----------------------------------------------------------
        
//        int ultimoId = PersistenciaArquivoTeste.getLastId(sequencia);
        
        
        // SEQUENCIAR ----------------------------------------------------------
//        
        PersistenciaArquivoTeste.sequenciar(sequencia);

    }

}
