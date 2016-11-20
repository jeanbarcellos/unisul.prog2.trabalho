package model.dao;

import model.Professor;

import java.util.ArrayList;
import java.util.List;

import util.PersistenciaArquivo;

/**
 * Classe ArquivoProfessorDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 18/11/2016
 *
 * @package model.dao
 *
 */
class ArquivoProfessorDao implements ProfessorDao {

    private List<Professor> professores = new ArrayList<Professor>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoProfessorDao() {
        this.persistArquivo = new PersistenciaArquivo("professores.bin", "professor_seq.txt");
        this.professores = this.all();
    }

    @Override
    public boolean insert(Professor professor) {

        // Adicionar a lista temporária local
        this.professores.add(professor);

        // Serializar arquivo
        this.persistArquivo.serializar(this.professores);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Professor professor) {

        Professor professorRef = this.load(professor.getId());

        if (professorRef != null) {

            // Altera somente o nome
            professorRef.setNome(professor.getNome());

            // Persistir
            this.persistArquivo.serializar(this.professores);

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Professor professorRef = this.load(id);

        if (professorRef != null) {

            // Remover a lista
            this.professores.remove(professorRef);

            // Persistir
            this.persistArquivo.serializar(this.professores);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Professor load(int id) {
        Professor retorno = null;
        for (Professor professorExt : professores) {
            if (professorExt.getId() == id) {
                retorno = professorExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Professor> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {
        return this.persistArquivo.getLastId();
    }

//
//    /**
//     * Serializa a lista de professores
//     *
//     * @return resultado da serialização
//     */
//    private boolean serializar() {
//        return PersistenciaArquivoTeste.serializar(this.filename, this.professores);
//    }
//
//    /**
//     * Deserializa o arquivo contendo a lista de Professores
//     *
//     * @return
//     */
//    private List<Professor> deserializar() {
//        List<Professor> lista = PersistenciaArquivoTeste.deserializar(filename);
//        return lista;
//    }
//
//    /**
//     * Gerencia a sequência dos IDs
//     *
//     * Ao chamar este método, é gravado o último id no arquivo que contém a
//     * sequência.
//     *
//     * @return boolean
//     */
//    private boolean sequenciar() {
//    return PersistenciaArquivoTeste.sequenciar (

//this.sequencia);
//    }
    
    
}
