package view;

import control.EmprestimoControl;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import model.Emprestimo;
import util.Data;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class EmprestimoDevolucaoView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 267626876742832959L;
    private EmprestimoControl emprestimoControl;
    private Emprestimo emprestimo;

    /**
     * Creates new form EmprestimoDevolucaoView
     */
    public EmprestimoDevolucaoView(int exemplarId) {
        initComponents();

        this.emprestimoControl = new EmprestimoControl();

        this.emprestimo = this.emprestimoControl.getEmprestimo(exemplarId);

        this.popularFormulario();
    }

    private void popularFormulario() {
        // Dados do Usuário
        textMatricula.setText("" + this.emprestimo.getUsuario().getMatricula());
        textNome.setText(this.emprestimo.getUsuario().getNome());
        textTipo.setText(EmprestimoControl.tipoUsuario(this.emprestimo));

        // Dados do Livro
        textLivroId.setText("" + this.emprestimo.getExemplar().getId());
        textLivroTitulo.setText("" + this.emprestimo.getExemplar().getLivro().getTitulo());
        textLivroAutor.setText("" + this.emprestimo.getExemplar().getLivro().getAutor());

        // Dados do Empréstimo
        String dataEmprestimo = Data.formatar(this.emprestimo.getDataEmprestimo(), "BR_DATA");
        String dataDevPrev = Data.formatar(this.emprestimo.getDataDevolucaoPrevista(), "BR_DATA");
        String dataDev = Data.formatar(Data.dataAtual(), "BR_DATA");

        textDtEmprestimo.setText(dataEmprestimo);
        textDtDevolucaoPrev.setText(dataDevPrev);
        textDtDevolucao.setText(dataDev);
    }

    /**
     * Posiciona o painel no mei da tela
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuario = new javax.swing.JPanel();
        labelMatricula = new javax.swing.JLabel();
        textMatricula = new javax.swing.JTextField();
        labelTipo = new javax.swing.JLabel();
        textTipo = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        panelLivro = new javax.swing.JPanel();
        labelLivroId = new javax.swing.JLabel();
        textLivroId = new javax.swing.JTextField();
        labelLivroTitulo = new javax.swing.JLabel();
        textLivroTitulo = new javax.swing.JTextField();
        labelLivroAutor = new javax.swing.JLabel();
        textLivroAutor = new javax.swing.JTextField();
        panelEmprestimo = new javax.swing.JPanel();
        labelDtEmprestimo = new javax.swing.JLabel();
        textDtEmprestimo = new javax.swing.JTextField();
        labelDtDevolucaoPrev = new javax.swing.JLabel();
        textDtDevolucaoPrev = new javax.swing.JTextField();
        labelDtDevolucao = new javax.swing.JLabel();
        textDtDevolucao = new javax.swing.JTextField();
        devolver = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Realizar Devolução");
        setToolTipText("");

        panelUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));

        labelMatricula.setText("Matrícula:");

        textMatricula.setEditable(false);
        textMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMatriculaActionPerformed(evt);
            }
        });

        labelTipo.setText("Tipo:");

        textTipo.setEditable(false);

        labelNome.setText("Nome:");

        textNome.setEditable(false);

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNome)
                    .addComponent(labelMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuarioLayout.createSequentialGroup()
                        .addComponent(textMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(labelTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textTipo))
                    .addGroup(panelUsuarioLayout.createSequentialGroup()
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMatricula)
                    .addComponent(labelTipo)
                    .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLivro.setBorder(javax.swing.BorderFactory.createTitledBorder("Livro"));

        labelLivroId.setText("ID:");

        textLivroId.setEditable(false);

        labelLivroTitulo.setText("Título:");

        textLivroTitulo.setEditable(false);

        labelLivroAutor.setText("Edição:");

        textLivroAutor.setEditable(false);

        javax.swing.GroupLayout panelLivroLayout = new javax.swing.GroupLayout(panelLivro);
        panelLivro.setLayout(panelLivroLayout);
        panelLivroLayout.setHorizontalGroup(
            panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelLivroAutor)
                    .addComponent(labelLivroTitulo)
                    .addComponent(labelLivroId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLivroLayout.createSequentialGroup()
                        .addComponent(textLivroId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textLivroAutor)
                    .addComponent(textLivroTitulo))
                .addContainerGap())
        );
        panelLivroLayout.setVerticalGroup(
            panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivroLayout.createSequentialGroup()
                .addGroup(panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLivroId)
                    .addComponent(textLivroId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLivroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLivroTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLivroAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLivroAutor))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        panelEmprestimo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datas do Empréstimo"));

        labelDtEmprestimo.setText("Data Emprestimo:");

        textDtEmprestimo.setEditable(false);

        labelDtDevolucaoPrev.setText("Data Previsão Devolução:");

        textDtDevolucaoPrev.setEditable(false);

        labelDtDevolucao.setText("Data Devolução:");

        textDtDevolucao.setEditable(false);

        javax.swing.GroupLayout panelEmprestimoLayout = new javax.swing.GroupLayout(panelEmprestimo);
        panelEmprestimo.setLayout(panelEmprestimoLayout);
        panelEmprestimoLayout.setHorizontalGroup(
            panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmprestimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmprestimoLayout.createSequentialGroup()
                        .addComponent(labelDtEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textDtEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmprestimoLayout.createSequentialGroup()
                        .addGroup(panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDtDevolucao)
                            .addComponent(labelDtDevolucaoPrev))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDtDevolucaoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEmprestimoLayout.setVerticalGroup(
            panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmprestimoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDtEmprestimo)
                    .addComponent(textDtEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDtDevolucaoPrev)
                    .addComponent(textDtDevolucaoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDtDevolucao)))
        );

        devolver.setText("Realizar Devolução");
        devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLivro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(devolver)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devolver)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMatriculaActionPerformed

    private void devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverActionPerformed
        Object[] options = {"Sim", "Não"};
        int retornoDevolver = JOptionPane.showOptionDialog(null, "Tem certeza que deseja realizar a devolção?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (retornoDevolver == JOptionPane.YES_OPTION) {

            boolean retorno = this.emprestimoControl.devolver(this.emprestimo.getId());

            if (retorno) {
                EmprestimoLivroView.carregarTabela();
                JOptionPane.showMessageDialog(null, "Exemplar devolvido com sucesso.");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao devolver exemplar.");
            }

        }

    }//GEN-LAST:event_devolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton devolver;
    private javax.swing.JLabel labelDtDevolucao;
    private javax.swing.JLabel labelDtDevolucaoPrev;
    private javax.swing.JLabel labelDtEmprestimo;
    private javax.swing.JLabel labelLivroAutor;
    private javax.swing.JLabel labelLivroId;
    private javax.swing.JLabel labelLivroTitulo;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel panelEmprestimo;
    private javax.swing.JPanel panelLivro;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTextField textDtDevolucao;
    private javax.swing.JTextField textDtDevolucaoPrev;
    private javax.swing.JTextField textDtEmprestimo;
    private javax.swing.JTextField textLivroAutor;
    private javax.swing.JTextField textLivroId;
    private javax.swing.JTextField textLivroTitulo;
    private javax.swing.JTextField textMatricula;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textTipo;
    // End of variables declaration//GEN-END:variables
}
