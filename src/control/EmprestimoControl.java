package control;

import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.dao.DaoFactory;
import model.dao.EmprestimoDao;

/**
 * Classe EmprestimoControl
 *
 * @author Jean Barcellos
 * @date 19/11/2016
 *
 * @package view
 *
 */
public class EmprestimoControl {

    /**
     * Lista com todos os emprestimos sincronizados com a base de dados
     */
    private List<Emprestimo> emprestimos;

    /**
     * Instância do DaoFactory de Emprestimos
     */
    private final EmprestimoDao emprestimoDao = DaoFactory.getDaoFactory().getEmprestimoDao();

    /**
     * Construtor
     *
     * Carrega a lista de emprestimos armazanados na base de dados
     */
    public EmprestimoControl() {
        this.emprestimos = new ArrayList<Emprestimo>();

        // Carrega os emprestimos vindos da base de dados
        this.setEmprestimos(this.carregarLista());
    }

    /**
     * Retona a lista de Emprestimos do controlador
     *
     * @return Lista de Emprestimos
     */
    public List<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    /**
     * Seta a Lista de emprestimos do controlador Declaramos seEmprestimos()
     * como privado pois ninguem além do próprio controlador pode gerenciar a
     * lista.
     *
     * @param emprestimos Emprestimos a serem setados na lista.
     */
    private void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    /**
     * Inserir um emprestimo
     *
     * @param emprestimo
     * @return Booleano
     */
    public boolean inserir(Emprestimo emprestimo) {

        emprestimo.setId(this.autoId());

        // Inserir em memória
        this.emprestimos.add(emprestimo);

        // Persistir
        boolean db = emprestimoDao.insert(emprestimo);

        // Verifica o exito da persistência e mantêm sincronização local
        if (db) {
            return true;
        } else {
            this.emprestimos.remove(emprestimo);
            return false;
        }

    }

    /**
     * Alterar um emprestimo
     *
     * @param id ID do Objeto a ser alterado
     * @param emprestimo Objeto Emprestimo já modificado
     * @return Booleando
     */
    public boolean alterar(int id, Emprestimo emprestimo) {

//        // Referencia o Objeto a ser alterado na memória
//        Emprestimo emprestimoRef = this.getEmprestimo(id);
//
//        // Verifica se o objeto existe
//        if (emprestimoRef != null) {
//
//            // Altera somente o nome
//            emprestimoRef.setNome(emprestimo.getNome());
//
//            boolean retorno = emprestimoDao.update(emprestimo);
//
//            return retorno;
//        } else {
//            return false;
//        }
        return true;

    }

    /**
     * Excluir um objeto da base de dados
     *
     * @param id ID do Objeto a ser excluido
     * @return true ou false
     */
    public boolean excluir(int id) {

        // Carrega o Objeto
        Emprestimo emprestimoRef = this.getEmprestimo(id);

        if (emprestimoRef != null) {

            // Remove da listas
            this.emprestimos.remove(emprestimoRef);

            boolean retorno = emprestimoDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Retorna a referência de um objeto da lista através de seu ID. Caso não o
     * encontre retorna NULL.
     *
     * @param id ID do Emprestimo a ser buscado na lista
     * @return Objeto Emprestimo
     */
    public Emprestimo getEmprestimo(int id) {
        Emprestimo retorno = null;
        for (Emprestimo emprestimoExt : this.getEmprestimos()) {
            if (emprestimoExt.getId() == id) {
                retorno = emprestimoExt;
            }
        }
        return retorno;
    }

    /**
     * Carega a lista no controlador
     *
     * @return Lista com todos os Emprestimos
     */
    private List<Emprestimo> carregarLista() {
        return emprestimoDao.all();
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return emprestimoDao.lastId();
    }

    /**
     * Gera o póximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }

}
