package model.dao;

import model.Exemplar;

import java.util.ArrayList;
import java.util.List;
import utils.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

/**
 * Classe ArquivoExemplarDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 15/11/2016
 *
 * @package model.dao
 *
 */
final class ArquivoExemplarDao implements ExemplarDao {

    private List<Exemplar> exemplares = new ArrayList<Exemplar>();
    private final String filename = "conteudo/exemplares.bin";
    private final String sequencia = "conteudo/exemplar_seq";

    public ArquivoExemplarDao() {
        this.exemplares = this.all();
    }

    @Override
    public boolean insert(Exemplar exemplar) {

        // Adicionar a lista temporária local
        this.exemplares.add(exemplar);

        // Serializar arquivo
        this.serializar();

        // Sequenciar arquivo
        this.sequenciar();

        return true;
    }

    @Override
    public boolean update(Exemplar exemplar) {

        Exemplar exemplarRef = this.load(exemplar.getId());

        if (exemplarRef != null) {

            // Altera somente o nome
            exemplarRef.setEdicao(exemplar.getEdicao());
            exemplarRef.setLocalizacao(exemplar.getEdicao());

            // Persistir
            serializar();

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Exemplar exemplarRef = this.load(id);

        if (exemplarRef != null) {

            // Remover a lista
            this.exemplares.remove(exemplarRef);

            // Persistir
            this.serializar();

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Exemplar load(int id) {
        Exemplar retorno = null;
        for (Exemplar exemplarExt : this.exemplares) {
            if (exemplarExt.getId() == id) {
                retorno = exemplarExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Exemplar> all() {
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
     * Serializa a lista de exemplares
     *
     * @return resultado da serialização
     */
    private boolean serializar() {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;

        try {
            escritorByte = new FileOutputStream(filename);
            escritorObjeto = new ObjectOutputStream(escritorByte);

            escritorObjeto.writeObject(this.exemplares);
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
     * Deserializa o arquivo contendo a lista de Exemplares
     *
     * @return
     */
    private List<Exemplar> deserializar() {
        List<Exemplar> lista = null;

        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(filename);
            leitorObjeto = new ObjectInputStream(leitorByte);
            lista = (List<Exemplar>) leitorObjeto.readObject();

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

    @Override
    public int total(int livroId) {
        int total = 0;
        for (Exemplar exemplarExt : exemplares) {
            if (exemplarExt.getLivro().getId() == livroId) {
                total++;
            }
        }
        return total;
    }

    @Override
    public List<Exemplar> listar(int livroId) {

        List<Exemplar> lista = new ArrayList<Exemplar>();

        for (Exemplar exemplarExt : this.exemplares) {
            if (exemplarExt.getLivro().getId() == livroId) {
                lista.add(exemplarExt);
            }
        }
        System.out.println(lista);
        return lista;
    }

}
