package zold;

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
import util.Log;

/**
 * Classe PersistenciaArquivoTeste
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 18/11/2016
 *
 * @package utils
 *
 */
public class PersistenciaArquivoTeste {
    
    String pathLista;
    String pathSequencia;

    public PersistenciaArquivoTeste(String pathLista, String pathSequencia) {
        this.pathLista = pathLista;
        this.pathSequencia = pathSequencia;
    }    
    

    /**
     * Serializa uma lista
     *
     * @param path Caminho Relativo (ou absoluto) do arquivo .bin
     * @param lista Lista a ser serealizada
     * @return resultado da serialização
     */
    public static boolean serializar(String path, List lista) {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;

        try {
            escritorByte = new FileOutputStream(path);
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
     * @param path Caminho Relativo (ou absoluto) do arquivo .bin
     * @return Lista Deserealizada
     */
    public static List deserializar(String path) {
        List lista = null;

        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(path);
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
     * @param path Caminho Relativo (ou absoluto) do arquivo txt com a sequência
     * @return último ID cadastrado
     */
    public static int getLastId(String path) {
        InputStream leitorByte = null;
        InputStreamReader leitorCaracter = null;
        BufferedReader leitorPalavras = null;
        int ultimoId = 0;

        try {
            leitorByte = new FileInputStream(path);
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
     * @param path Caminho Relativo (ou absoluto) do arquivo txt com a sequência
     * @param ultimoId ID do último objeto registrado
     * @return boolean
     */
    public static boolean sequenciar(String path) {
        int ultimoId = PersistenciaArquivoTeste.getLastId(path);

        OutputStream escritorByte = null;
        OutputStreamWriter escritorCaracter = null;
        BufferedWriter escritorPalavras = null;

        int novoID = ultimoId + 1;

        try {
            escritorByte = new FileOutputStream(path, false);
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
     * @param path Caminho Relativo (ou absoluto) do arquivo txt com a sequência
     * @return boolean
     */
    public static boolean reiniciarSequencia(String path) {
        OutputStream escritorByte = null;
        OutputStreamWriter escritorCaracter = null;
        BufferedWriter escritorPalavras = null;

        try {
            escritorByte = new FileOutputStream(path, false);
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
