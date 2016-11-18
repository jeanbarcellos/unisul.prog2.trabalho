package ztestes.usuario;

import java.util.ArrayList;
import java.util.List;
import model.Professor;
import zold.PersistenciaArquivoTeste;

public class ProfessorDaoSerial {

    public static void main(String[] args) {

        String filename = "conteudo/professores.bin";
        String sequencia = "conteudo/professor_seq";

        // SERIALIZAR ----------------------------------------------------------
        
//        Professor usuario1 = new Professor();
//        usuario1.setId(1);
//        usuario1.setMatricula(1001);
//        usuario1.setNome("Flávio Ceci");
//
//        Professor usuario2 = new Professor();
//        usuario2.setId(2);
//        usuario2.setMatricula(1002);
//        usuario2.setNome("Ricardo Ribeiro");
//
//        Professor usuario3 = new Professor();
//        usuario3.setId(3);
//        usuario3.setMatricula(1003);
//        usuario3.setNome("Alessandra");
//
//        List<Professor> lista = new ArrayList<>();
//        lista.add(usuario1);
//        lista.add(usuario2);
//        lista.add(usuario3);
//
//        for (Professor profEx : lista) {
//            System.out.println(profEx);
//        }
//        
//        PersistenciaArquivoTeste.serializar(filename, lista);


        // DESERIALIZAR --------------------------------------------------------
          
        List<Professor> listaDes = PersistenciaArquivoTeste.deserializar(filename);

        for (Professor profEx : listaDes) {
            System.out.println(profEx);
        }
        
        // ÚLTIMO ID -----------------------------------------------------------
        
        int ultimoId = PersistenciaArquivoTeste.getLastId(sequencia);
        
        
        // SEQUENCIAR ----------------------------------------------------------
        
        PersistenciaArquivoTeste.sequenciar(sequencia);

    }

}
