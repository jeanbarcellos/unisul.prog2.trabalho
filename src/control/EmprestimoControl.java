package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Aluno;
import model.Emprestimo;
import model.Professor;
import model.dao.DaoFactory;
import model.dao.EmprestimoDao;
import util.Config;
import util.Data;

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
        this.carregarLista();
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
     * Inserir um emprestimo
     *
     * @param emprestimo
     * @return Booleano
     */
    public boolean inserir(Emprestimo emprestimo) {

        Config config = Config.getInstance();
        int diasEmprestimo = Integer.parseInt(config.getValue("diasEmprestimo"));

        Date dataAgora = Data.dataAtual();
        Date dataPrevisao = Data.somaDias(dataAgora, diasEmprestimo);

        emprestimo.setId(this.autoId());
        emprestimo.setDataEmprestimo(dataAgora);
        emprestimo.setDataDevolucaoPrevista(dataPrevisao);

        // Inserir em memória
        this.emprestimos.add(emprestimo);

        // Persistir
        boolean db = this.emprestimoDao.insert(emprestimo);

        // Verifica o exito da persistência e mantêm sincronização local
        if (db) {
            return true;
        } else {
            this.emprestimos.remove(emprestimo);
            return false;
        }

    }

    /**
     * Realiza devolução
     *
     * @param emprestimoId
     * @return
     */
    public boolean devolver(int emprestimoId) {
        Date dataAgora = Data.dataAtual();
        boolean retorno;

        retorno = this.emprestimoDao.devolver(emprestimoId, dataAgora);

        if (retorno) {
            this.carregarLista();
            retorno = true;
        } else {
            retorno = false;
        }

        return retorno;
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

            boolean retorno = this.emprestimoDao.delete(id);

            return retorno;
        } else {
            return false;
        }
    }

    /**
     * Carega a lista no controlador
     *
     * @return Lista com todos os Emprestimos
     */
    private void carregarLista() {
        this.setEmprestimos(this.emprestimoDao.all());
    }

    /**
     * Pega o último ID
     *
     * @return Último ID cadastrado
     */
    private int ultimoId() {
        return this.emprestimoDao.lastId();
    }

    /**
     * Gera o póximo ID a ser inserido
     *
     * @return
     */
    private int autoId() {
        return this.ultimoId() + 1;
    }

    /**
     * Lista com todos os exemplares pegos por um usuário
     *
     * @param usuarioId ID do usuário
     * @return Emprestimo filtrado
     */
    public List<Emprestimo> getExemplaresPegos(int usuarioId) {
        return this.emprestimoDao.getEmprestimosPorUsuario(usuarioId);
    }

    /**
     * Verifica o timpo de usuário (Professor ou Aluno)
     *
     * @param emprestimo
     * @return
     */
    public static String tipoUsuario(Emprestimo emprestimo) {
        String tipo;

        if (emprestimo.getUsuario() instanceof Aluno) {
            tipo = "Aluno";
        } else if (emprestimo.getUsuario() instanceof Professor) {
            tipo = "Professor";
        } else {
            tipo = "Usuário";
        }

        return tipo;
    }

    /**
     * Verifica se o exemplar está disponível para empréstimo
     *
     * @param idExemplar ID do Exemplar
     * @return
     */
    public int getDisponibilidade(int idExemplar) {
        int situacao = 1;

        for (Emprestimo emprestimoExt : this.getEmprestimos()) {
            if (emprestimoExt.getExemplar().getId() == idExemplar
                    && emprestimoExt.getDataDevolucao() == null) {
                situacao = 0;
            }
        }
        return situacao;
    }
}
