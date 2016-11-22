package view.tm;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Curso;

/**
 * Classe CursoTM
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 20/11/2016
 *
 * @package tela
 *
 */
public class ProfessorCursoTM extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Curso> linhas;
    private String[] colunas = new String[]{"Cd.", "Nome"};

    public ProfessorCursoTM() {
        linhas = new ArrayList<Curso>();
    }

    public ProfessorCursoTM(List<Curso> lista) {
        linhas = new ArrayList<Curso>(lista);
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
        Curso f = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getNome();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    // modifica na linha e coluna especificada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Carrega o item da linha que deve ser modificado
        Curso f = linhas.get(rowIndex);

        // Seta o valor do campo respectivo
        switch (columnIndex) {
            case 0:
                f.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                f.setNome(aValue.toString());
                break;
            default:
            // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada
    public void setValueAt(Curso aValue, int rowIndex) {
        Curso f = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        f.setId(Integer.parseInt(aValue.toString()));
        f.setNome(aValue.getNome());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Curso getCurso(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addCurso(Curso f) {
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
    public void addLista(List<Curso> f) {
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
