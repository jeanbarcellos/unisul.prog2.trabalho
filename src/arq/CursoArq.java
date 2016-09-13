package arq;

import model.Curso;

/**
 * Classe CursoArq
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/09/2016
 *
 * @package arq
 *
 */
public class CursoArq {

    private final String src = "conteudo/Curso.bin";

    public void insert(Curso obj) {
        System.out.println("Insert | arquivo " + src);
    }

    public void update(Curso obj) {
        System.out.println("Update | arquivo " + src);
    }

    public void delete(Curso obj) {
        System.out.println("Delete | arquivo " + src);
    }

}
