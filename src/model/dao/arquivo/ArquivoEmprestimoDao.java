package model.dao.arquivo;

import model.Emprestimo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.dao.EmprestimoDao;

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
final public class ArquivoEmprestimoDao implements EmprestimoDao {

    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoEmprestimoDao() {
        this.persistArquivo = new PersistenciaArquivo("emprestimos.bin", "emprestimo_seq.txt");

        this.carregarLista();
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
    public boolean emprestar(Emprestimo emprestimo) {
        return this.insert(emprestimo);
    }

    @Override
    public boolean devolver(int emprestimoId, Date dataDevolucao) {
        this.carregarLista();       

        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getId() == emprestimoId) {
                //
            }
        }

        return true;
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

    private void carregarLista() {
        this.emprestimos = this.all();
    }

    @Override
    public List<Emprestimo> getEmprestimosPorUsuario(int usuarioId) {
        this.carregarLista();

        List<Emprestimo> lista = new ArrayList<Emprestimo>();

        for (Emprestimo emprestimo : this.emprestimos) {
            if ((emprestimo.getUsuario().getId() == usuarioId)
                    && (emprestimo.getDataDevolucao() == null)) {
                lista.add(emprestimo);
            }
        }

        return lista;
    }

}
