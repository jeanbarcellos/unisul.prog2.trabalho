package view.tm;

import model.Emprestimo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.Data;

/**
 * Classe EmprestimoTM
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 20/11/2016
 *
 * @package tela
 *
 */
public class ExemplaresPegosTM extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Emprestimo> linhas;
    private String[] colunas = new String[]{"Titulo", "Autor", "Edição", "Dt Emprestimo", "Dt Entrega"};

    public ExemplaresPegosTM() {
        linhas = new ArrayList<Emprestimo>();
    }

    public ExemplaresPegosTM(List<Emprestimo> lista) {
        linhas = new ArrayList<Emprestimo>(lista);
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        /*
        switch(columnIndex){
            case 0:
                return Integer.class;
            default:
                return String.class;
        }
         */
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprestimo f = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getExemplar().getLivro().getTitulo();
            case 1:
                return f.getExemplar().getLivro().getAutor();
            case 2:
                return f.getExemplar().getEdicao();
            case 3:                                
                return Data.formatar(f.getDataEmprestimo(), "BR_DATA");
            case 4:
                return Data.formatar(f.getDataDevolucaoPrevista(), "BR_DATA");
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    // modifica na linha e coluna especificada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        // Carrega o item da linha que deve ser modificado
//        Emprestimo f = linhas.get(rowIndex);
//
//        // Seta o valor do campo respectivo
//        switch (columnIndex) {
//            case 0:
//                f.setExemplar(exemplar);
//                f.setExemplar().setLivro().setTitulo(aValue.toString());
//                break;
//            case 1:
//                f.setNome(aValue.toString());
//                break;
//            case 3:
//                f.setMatricula(Integer.parseInt(aValue.toString()));
//                break;
//            case 4:
////                f.setCurso(aValue.toString());
////                break;
//            default:
//            // Isto não deveria acontecer...             
//        }
//        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada
    public void setValueAt(Emprestimo aValue, int rowIndex) {
//        Emprestimo f = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
//
//        f.setId(Integer.parseInt(aValue.toString()));
//        f.setNome(aValue.getNome());
//
//        fireTableCellUpdated(rowIndex, 0);
//        fireTableCellUpdated(rowIndex, 1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Emprestimo getEmprestimo(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addEmprestimo(Emprestimo f) {
        // Adiciona o registro.
        linhas.add(f);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addLista(List<Emprestimo> f) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(f);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
