package model.dao;

import model.Curso;

import java.util.List;
import java.util.ArrayList;
import utils.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

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

    private List<Curso> cursos = new ArrayList<Curso>();
    private final String filename = "conteudo/cursos.bin";
    private final String sequencia = "conteudo/curso_seq";

    public ArquivoCursoDao() {
        this.cursos = this.all();
    }

    @Override
    public boolean insert(Curso curso) {

        // Adicionar a lista temporária local
        this.cursos.add(curso);

        // Serializar arquivo
        this.serializar();

        // Sequenciar arquivo
        this.sequenciar();

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
            this.serializar();

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

    @Override
    public int lastId() {
        InputStream leitorByte = null;
        InputStreamReader leitorCaracter = null;
        BufferedReader leitorPalavras = null;
        int ultimo_id = 0;

        try {
            leitorByte = new FileInputStream(this.sequencia);
            leitorCaracter = new InputStreamReader(leitorByte);
            leitorPalavras = new BufferedReader(leitorCaracter);

            String linha = leitorPalavras.readLine();
            ultimo_id = Integer.parseInt(linha);

        } catch (FileNotFoundException e) {
            Log.write(e.getMessage());
        } catch (IOException e) {
            Log.write(e.getMessage());
        } finally {
            // Todo recruso aberto deve ser fechado
            try {
                if (leitorByte != null) {
                    leitorByte.close();
                }
                if (leitorCaracter != null) {
                    leitorCaracter.close();
                }
                if (leitorPalavras != null) {
                    leitorPalavras.close();
                }
            } catch (Exception e) {
            }
        }
        return ultimo_id;
    }

    /**
     * Serializa a lista de cursos
     *
     * @return resultado da serialização
     */
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
            Log.write(e.getMessage());
            return false;
        } catch (IOException e) {
            Log.write(e.getMessage());
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

    /**
     * Deserializa o arquivo contendo a lista de Cursos
     *
     * @return
     */
    private List<Curso> deserializar() {
        List<Curso> lista = null;

        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(filename);
            leitorObjeto = new ObjectInputStream(leitorByte);
            lista = (List<Curso>) leitorObjeto.readObject();

        } catch (FileNotFoundException e) {
            Log.write(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            Log.write(e.getMessage());
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

    /**
     * Gerencia a sequência dos IDs
     *
     * Ao chamar este método, é gravado o último id no arquivo que contém a
     * sequência.
     *
     * @return boolean
     */
    private boolean sequenciar() {
        OutputStream escritorByte = null;
        OutputStreamWriter escritorCaracter = null;
        BufferedWriter escritorPalavras = null;

        int novoID = this.lastId() + 1;

        try {
            escritorByte = new FileOutputStream(this.sequencia, false);
            escritorCaracter = new OutputStreamWriter(escritorByte);
            escritorPalavras = new BufferedWriter(escritorCaracter);

            String linha = "" + novoID;

            escritorPalavras.write(linha);
            escritorPalavras.flush();

            return true;

        } catch (FileNotFoundException e) {
            Log.write(e.getMessage());
            return false;
        } catch (IOException e) {
            Log.write(e.getMessage());
            return false;
        } finally {
            try {
                if (escritorPalavras != null) {
                    escritorPalavras.close();
                }
                if (escritorCaracter != null) {
                    escritorCaracter.close();
                }
                if (escritorByte != null) {
                    escritorByte.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
