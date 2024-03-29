package view;

import control.AlunoControl;
import control.CursoControl;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Curso;

/**
 * CadastroAlunoInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class CadastroAlunoInserirView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 4575540545230503611L;

    private AlunoControl alunoControl;
    private CursoControl cursoControl;
    private List<Curso> cursos;

    /**
     * Creates new form AlunoViewInserir
     */
    public CadastroAlunoInserirView() {
        initComponents();

        this.alunoControl = new AlunoControl();
        this.cursoControl = new CursoControl();

        this.cursos = this.cursoControl.getCursos();

        this.carregarCombo();
    }

    /**
     * Posiciona o painel no mei da tela
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * Popula o ComboBox de Cursos
     */
    public void carregarCombo() {
        this.comboCurso.removeAllItems();

        this.comboCurso.addItem("Selecione");
        for (int i = 0; i < this.cursos.size(); i++) {
            this.comboCurso.addItem(this.cursos.get(i).getNome());
        }
    }

    /**
     * Valida o formulário;
     *
     * @return
     */
    private boolean validarFormulario() {
        // Campo Nome
        if (textNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Você deve preencher o nome.");
            textNome.requestFocus();
            return false;
        }
        // Campo Nome
        if (textMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Você deve preencher a matrícula.");
            textMatricula.requestFocus();
            return false;
        }
        //
        if (comboCurso.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(null, "Você deve selecionar o curso.");
            comboCurso.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelMatricula = new javax.swing.JLabel();
        textMatricula = new javax.swing.JTextField();
        curso = new javax.swing.JLabel();
        comboCurso = new javax.swing.JComboBox<>();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Inserir Aluno");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno"));

        labelId.setText("ID:");

        textId.setEditable(false);

        labelNome.setText("Nome:");

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        labelMatricula.setText("Matrícula:");

        curso.setText("Curso:");

        comboCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelId)
                    .addComponent(curso)
                    .addComponent(labelMatricula)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonCancelar))
                            .addComponent(textMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatricula)
                    .addComponent(textMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curso)
                    .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        boolean validacao = this.validarFormulario();

        if (validacao) {
            String nome = textNome.getText();
            int matricula = Integer.parseInt(textMatricula.getText());
            int cursoSel = comboCurso.getSelectedIndex() - 1;
            int cursoId = 0;

            for (int i = 0; i < this.cursos.size(); i++) {
                if (i == cursoSel) {
                    cursoId = this.cursos.get(i).getId();
                    i = cursos.size();
                }
            }

            // Cria o objeto de transição
            Aluno aluno = new Aluno();
            aluno.setCurso(this.cursoControl.getCurso(cursoId));
            aluno.setNome(nome);
            aluno.setMatricula(matricula);

            // Envia o objeto criado para o controlador               
            boolean retorno = this.alunoControl.inserir(aluno);

            if (retorno) {
                CadastroAlunoView.carregarTabela();
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com Sucesso.");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Aluno.");
                this.setVisible(false);
            }
        }

    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JComboBox<String> comboCurso;
    private javax.swing.JLabel curso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textMatricula;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
