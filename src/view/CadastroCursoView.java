package view;

import view.tm.CursoTM;
import control.CursoControl;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;

/**
 * CadastroCursoView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class CadastroCursoView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;
    
    private CursoControl cursoControl;
    private CursoTM cursoTM;

    /**
     * Creates new form CadastroClientesView
     */
    public CadastroCursoView() {
        initComponents();

        this.cursoControl = new CursoControl();

        this.carregarTabela();

        this.gerenciarBotoes(true, false, false, false, false);
    }

    /**
     * Posiciona o painel no mei da tela
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * Popula a tabela com a lista de cursos
     */
    private void carregarTabela() {
        List<Curso> lista = this.cursoControl.getCursos();

        this.cursoTM = new CursoTM(lista);
        tableCursoLista.setModel(cursoTM);
        tableCursoLista.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableCursoLista.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    /**
     * Gerencia botões do Fomurlário
     *
     * @param novo Botão Novo
     * @param editar Botão Editar
     * @param excluir Botão Excluir
     * @param salvar Botão Salvar
     * @param cancelar Botão Cancelar
     */
    private void gerenciarBotoes(boolean novo, boolean editar, boolean excluir, boolean salvar, boolean cancelar) {
        this.buttonNovo.setEnabled(novo);
        this.buttonEditar.setEnabled(editar);
        this.buttonExcluir.setEnabled(excluir);
        this.buttonSalvar.setEnabled(salvar);
        this.buttonCancelar.setEnabled(cancelar);
    }

    /**
     * Valida o formulário;
     *
     * @return
     */
    private boolean validarFormulario() {
        // Campo Nome
        if (textNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Você deve preencher o nome do curso.");
            textNome.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * Limpa os campos do formulário
     */
    private void limparFormulario() {
        textId.setText("");
        textNome.setText("");
    }

    /**
     * Libera o formulário para edição
     */
    private void liberarFormulario() {
        textNome.setEnabled(true);
    }

    /**
     * Bloqueia o formulário contra edições
     */
    private void bloquearFormulario() {
        textNome.setEnabled(false);
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo deste método é
     * sempre regenerado pelo Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCurso = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        scrollPaneCursoLista = new javax.swing.JScrollPane();
        tableCursoLista = new javax.swing.JTable();
        buttonNovo = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Cursos");
        setVisible(true);

        panelCurso.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso"));

        labelId.setText("ID:");

        textId.setEditable(false);
        textId.setEnabled(false);

        labelNome.setText("Nome:");

        textNome.setEnabled(false);

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

        javax.swing.GroupLayout panelCursoLayout = new javax.swing.GroupLayout(panelCurso);
        panelCurso.setLayout(panelCursoLayout);
        panelCursoLayout.setHorizontalGroup(
            panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNome)
                    .addComponent(labelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome)
                    .addGroup(panelCursoLayout.createSequentialGroup()
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCursoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCancelar)
                .addGap(69, 69, 69))
        );
        panelCursoLayout.setVerticalGroup(
            panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableCursoLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCursoLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCursoLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCursoListaMouseClicked(evt);
            }
        });
        scrollPaneCursoLista.setViewportView(tableCursoLista);

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollPaneCursoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonExcluir)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneCursoLista, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNovo)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento Click do Botão Salvar
     *
     * @param evt
     */
    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        boolean validacao = this.validarFormulario();

        if (validacao) {
            String nome = textNome.getText();
            Curso curso = new Curso();
            boolean retorno;

            if (textId.getText().equals("")) { // Cadstrar

                curso.setNome(nome);

                retorno = this.cursoControl.inserir(curso);

                if (retorno) {
                    this.carregarTabela();

                    JOptionPane.showMessageDialog(null, "Curso Cadastrado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Curso.");
                }

            } else { // Editar

                curso.setId(Integer.parseInt(textId.getText()));
                curso.setNome(nome);

                retorno = this.cursoControl.alterar(curso);

                if (retorno) {
                    JOptionPane.showMessageDialog(null, "Curso alterado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Tentar alterar informações do curso.");
                }
            }
        }

        this.limparFormulario();

        this.bloquearFormulario();

        this.gerenciarBotoes(true, false, false, false, false);

    }//GEN-LAST:event_buttonSalvarActionPerformed

    /**
     * Evento Click do Botão Cancelar
     *
     * @param evt
     */
    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.limparFormulario();

        this.bloquearFormulario();

        gerenciarBotoes(true, false, false, false, false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    /**
     * Evento Click do Botão Novo
     *
     * @param evt
     */
    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        this.limparFormulario();

        this.liberarFormulario();

        textNome.requestFocus();

        gerenciarBotoes(false, false, false, true, true);
    }//GEN-LAST:event_buttonNovoActionPerformed

    /**
     * Evento Click do Botão Editar
     *
     * @param evt
     */
    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        this.liberarFormulario();

        this.gerenciarBotoes(false, false, false, true, true);
    }//GEN-LAST:event_buttonEditarActionPerformed

    /**
     * Evento Click do Botão Excluir
     *
     * @param evt
     */
    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        Object[] options = {"Sim", "Cancelar"};
        int retornoExcluir = JOptionPane.showOptionDialog(null, "Tens certeza que deseja excluir ...?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (retornoExcluir == JOptionPane.YES_OPTION) {

            int idExcluir = Integer.parseInt(textId.getText());

            boolean retorno = this.cursoControl.excluir(idExcluir);

            if (retorno) {
                this.carregarTabela();
                JOptionPane.showMessageDialog(null, "Curso excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluír o curso.");
            }

            this.limparFormulario();

            this.bloquearFormulario();
        } else {

        }

        this.gerenciarBotoes(true, false, false, false, false);
    }//GEN-LAST:event_buttonExcluirActionPerformed

    /**
     * Evento Click na Linha Tabela Lista de Cursos
     *
     * @param evt
     */
    private void tableCursoListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCursoListaMouseClicked
        this.bloquearFormulario();

        int indice = tableCursoLista.getSelectedRow();
        if (indice >= 0 && indice < this.cursoTM.getRowCount()) {
            Curso temp = cursoTM.getCurso(indice);
            textId.setText("" + temp.getId());
            textNome.setText(temp.getNome());
        }

        this.gerenciarBotoes(true, true, true, false, false);
    }//GEN-LAST:event_tableCursoListaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel panelCurso;
    private javax.swing.JScrollPane scrollPaneCursoLista;
    private javax.swing.JTable tableCursoLista;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
