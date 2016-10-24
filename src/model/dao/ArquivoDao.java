package model.dao;

import java.util.List;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface ArquivoDao {
 
    /**
     * Serializa a lista de cursos
     *
     * @return resultado da serialização
     */
    boolean serializar();

    /**
     * Deserializa o arquivo contendo a lista
     *
     * @return
     */
    List<Object> deserializar();

    /**
     * Gerencia a sequência dos IDs
     *
     * Ao chamar este método, é gravado o último id no arquivo que contém a
     * sequência.
     *
     * @return boolean
     */
     boolean sequenciar();
}
