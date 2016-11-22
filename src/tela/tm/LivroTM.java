package tela.tm;

import model.Livro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe LivroTM
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 20/11/2016
 *
 * @package tela
 *
 */
public class LivroTM extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Livro> linhas;
    private String[] colunas = new String[]{"Código", "Título", "Autor"};

    public LivroTM() {
        linhas = new ArrayList<Livro>();
    }

    public LivroTM(List<Livro> lista) {
        linhas = new ArrayList<Livro>(lista);
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
        Livro f = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getTitulo();
            case 2:
                return f.getAutor();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    // modifica na linha e coluna especificada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Carrega o item da linha que deve ser modificado
        Livro f = linhas.get(rowIndex);

        // Seta o valor do campo respectivo
        switch (columnIndex) {
            case 0:
                f.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                f.setTitulo(aValue.toString());
                break;
            case 2:
                f.setAutor(aValue.toString());
                break;
            default:
            // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // modifica na linha especificada
    public void setValueAt(Livro aValue, int rowIndex) {
        Livro f = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        f.setId(Integer.parseInt(aValue.toString()));
        f.setTitulo(aValue.getTitulo());
        f.setAutor(aValue.getAutor());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Livro getLivro(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addLivro(Livro f) {
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
    public void addLista(List<Livro> f) {
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
