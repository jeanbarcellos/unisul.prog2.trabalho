package model.dao;

import model.Curso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe ArquivoCursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
final class ArquivoCursoDao implements CursoDao {

    private final String filename = "conteudo/cursos.bin";
    List<Curso> cursos = new ArrayList<Curso>();

    public ArquivoCursoDao() {
        this.cursos = this.all();
    }

    @Override
    public boolean insert(Curso curso) {

        // Adicionar a lista temporária local
        this.cursos.add(curso);

        // Serializar arquivo
        serializar();

        return true;
    }

    @Override
    public boolean update(int id, Curso curso) {

        Curso cursoRef = this.load(id);

        if (cursoRef != null) {
            
            // Altera somente o nome
            cursoRef.setNome(curso.getNome());

            // Persistir
            serializar();

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Curso cursoRef = this.load(id);

        if (cursoRef != null) {
            
            // Remover a lista
            this.cursos.remove(cursoRef);

            // Persistir
            serializar();

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Curso load(int id) {
        Curso retorno = null;
        for (Curso cursoExt : cursos) {
            if (cursoExt.getId() == id) {
                retorno = cursoExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Curso> all() {
        return deserializar();
    }

    private boolean serializar() {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;

        try {
            escritorByte = new FileOutputStream(filename);
            escritorObjeto = new ObjectOutputStream(escritorByte);

            escritorObjeto.writeObject(this.cursos);
            escritorObjeto.flush();

            return true;
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return false;
        } catch (IOException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (escritorObjeto != null) {
                    escritorObjeto.close();
                }
                if (escritorByte != null) {
                    escritorByte.close();
                }
            } catch (Exception e) {
            }
        }

    }

    private List<Curso> deserializar() {
        List<Curso> lista = null;

        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(filename);
            leitorObjeto = new ObjectInputStream(leitorByte);

            lista = (List<Curso>) leitorObjeto.readObject();

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            try {
                if (leitorObjeto != null) {
                    leitorObjeto.close();
                }
                if (leitorByte != null) {
                    leitorByte.close();
                }
            } catch (Exception e) {
            }
        }
        return lista;

    }
}
