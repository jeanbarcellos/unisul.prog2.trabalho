package model.dao;

import model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

import util.PersistenciaArquivo;

/**
 * Classe ArquivoEmprestimoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 19/11/2016
 *
 * @package model.dao
 *
 */
class ArquivoEmprestimoDao implements EmprestimoDao {

    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoEmprestimoDao() {
        this.persistArquivo = new PersistenciaArquivo("emprestimos.bin", "emprestimo_seq.txt");
        this.emprestimos = this.all();
    }

    @Override
    public boolean insert(Emprestimo emprestimo) {

        // Adicionar a lista temporária local
        this.emprestimos.add(emprestimo);

        // Serializar arquivo
        this.persistArquivo.serializar(this.emprestimos);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Emprestimo emprestimo) {

        Emprestimo emprestimoRef = this.load(emprestimo.getId());

        if (emprestimoRef != null) {

            // Altera somente o nome
//            emprestimoRef.setNome(emprestimo.getNome());

            // Persistir
            this.persistArquivo.serializar(this.emprestimos);

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Emprestimo emprestimoRef = this.load(id);

        if (emprestimoRef != null) {

            // Remover a lista
            this.emprestimos.remove(emprestimoRef);

            // Persistir
            this.persistArquivo.serializar(this.emprestimos);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Emprestimo load(int id) {
        Emprestimo retorno = null;
        for (Emprestimo emprestimoExt : emprestimos) {
            if (emprestimoExt.getId() == id) {
                retorno = emprestimoExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Emprestimo> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {
        return this.persistArquivo.getLastId();
    }

    @Override
    public List<Emprestimo> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
