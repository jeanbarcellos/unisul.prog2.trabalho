package util;

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
import java.util.List;

/**
 * Classe PersistenciaArquivo
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 18/11/2016
 *
 * @package utils
 *
 */
final public class PersistenciaArquivo {

    private final String pathLista;
    private final String pathSequencia;
    private int ultimoId;

    /**
     * Construtor
     *
     * @param pathLista Caminho Relativo (ou absoluto) do arquivo .bin
     * @param pathSequencia Caminho Relativo (ou absoluto) do arquivo txt com a
     * sequência
     *
     */
    public PersistenciaArquivo(String pathLista, String pathSequencia) {
        String arquivo = Config.getInstance().getValue("dirDados");
        
        this.pathLista = arquivo + pathLista;
        this.pathSequencia = arquivo + pathSequencia;
        this.ultimoId = this.getLastId();
    }

    /**
     * Serializa uma lista
     *
     * @param lista Lista a ser serealizada
     * @return resultado da serialização
     */
    public boolean serializar(List lista) {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;

        try {
            escritorByte = new FileOutputStream(this.pathLista);
            escritorObjeto = new ObjectOutputStream(escritorByte);

            escritorObjeto.writeObject(lista);
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
     * @return Lista Deserealizada
     */
    public List deserializar() {
        List lista = null;

        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(this.pathLista);
            leitorObjeto = new ObjectInputStream(leitorByte);
            lista = (List) leitorObjeto.readObject();

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
     * Recupera o valor atual da sequencia (Último ID registrado)
     *
     * @return último ID cadastrado
     */
    public int getLastId() {
        InputStream leitorByte = null;
        InputStreamReader leitorCaracter = null;
        BufferedReader leitorPalavras = null;

        try {
            leitorByte = new FileInputStream(this.pathSequencia);
            leitorCaracter = new InputStreamReader(leitorByte);
            leitorPalavras = new BufferedReader(leitorCaracter);

            String linha = leitorPalavras.readLine();
            ultimoId = Integer.parseInt(linha);

        } catch (FileNotFoundException e) {
            Log.write(e.getMessage());
        } catch (IOException e) {
            Log.write(e.getMessage());
        } finally {
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
        return ultimoId;
    }

    /**
     * Gerencia a sequência dos IDs. <br>
     *
     * Realiza a gravação, em um arquivo *.txt, do ID do último objeto
     * persistido.
     *
     * @return boolean
     */
    public boolean sequenciar() {
        this.getLastId();

        OutputStream escritorByte = null;
        OutputStreamWriter escritorCaracter = null;
        BufferedWriter escritorPalavras = null;

        int novoID = this.ultimoId + 1;

        try {
            escritorByte = new FileOutputStream(this.pathSequencia, false);
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

    /**
     * Reinicia o sequenciador
     *
     * @return boolean
     */
    public boolean reiniciarSequencia() {
        OutputStream escritorByte = null;
        OutputStreamWriter escritorCaracter = null;
        BufferedWriter escritorPalavras = null;

        try {
            escritorByte = new FileOutputStream(this.pathSequencia, false);
            escritorCaracter = new OutputStreamWriter(escritorByte);
            escritorPalavras = new BufferedWriter(escritorCaracter);

            String linha = "" + 0;

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
