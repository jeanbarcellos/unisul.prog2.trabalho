package view;

import view.tm.ProfessorTM;
import model.Professor;
import control.ProfessorControl;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class CadastroProfessorView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 738582654898301711L;

    private ProfessorControl professorControl;

    /**
     * Creates new form CadastroProfessorView
     */
    public CadastroProfessorView() {
        initComponents();

        this.professorControl = new ProfessorControl();

        this.carregarTabela();
    }

    /**
     * Posiciona o painel no mei da tela
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * Popula a tabela com a lista de professores
     */
    public static void carregarTabela() {
        List<Professor> lista = new ProfessorControl().getProfessores();

        ProfessorTM professorTM = new ProfessorTM(lista);
        tableProfessorLista.setModel(professorTM);
        tableProfessorLista.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableProfessorLista.getColumnModel().getColumn(1).setPreferredWidth(400);
        tableProfessorLista.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private boolean validarBuscar() {
        String licalizar = textlocalizar.getText();
        int indice = comboBoxPor.getSelectedIndex();

        if (licalizar.equals("")) {
            JOptionPane.showMessageDialog(null, "Você deve informar alguma palavra-chave.");
            textlocalizar.requestFocus();
            return false;
        }
        if (indice == 0) {
            JOptionPane.showMessageDialog(null, "Você deve informar o tipo de dado.");
            comboBoxPor.requestFocus();
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

        panelProfessoresCadastrados = new javax.swing.JPanel();
        scrollPaneProfessorLista = new javax.swing.JScrollPane();
        tableProfessorLista = new javax.swing.JTable();
        labelPor = new javax.swing.JLabel();
        comboBoxPor = new javax.swing.JComboBox<>();
        labelLocalizar = new javax.swing.JLabel();
        textlocalizar = new javax.swing.JTextField();
        buttonRecarregar = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        buttonDetalhar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonCursos = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Professores");

        panelProfessoresCadastrados.setBorder(javax.swing.BorderFactory.createTitledBorder("Professores Cadastrados"));

        tableProfessorLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Matrícula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneProfessorLista.setViewportView(tableProfessorLista);
        if (tableProfessorLista.getColumnModel().getColumnCount() > 0) {
            tableProfessorLista.getColumnModel().getColumn(0).setResizable(false);
            tableProfessorLista.getColumnModel().getColumn(2).setResizable(false);
        }

        labelPor.setText("Por:");

        comboBoxPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Nome", "Matrícula" }));
        comboBoxPor.setActionCommand("");

        labelLocalizar.setText("Localizar:");

        buttonRecarregar.setText("Recarregar Lista");
        buttonRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecarregarActionPerformed(evt);
            }
        });

        buttonBuscar.setText("Pesquisar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        buttonDetalhar.setText("Detalhar");
        buttonDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetalharActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonCursos.setText("Gerenciar cursos que participa");
        buttonCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProfessoresCadastradosLayout = new javax.swing.GroupLayout(panelProfessoresCadastrados);
        panelProfessoresCadastrados.setLayout(panelProfessoresCadastradosLayout);
        panelProfessoresCadastradosLayout.setHorizontalGroup(
            panelProfessoresCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfessoresCadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProfessoresCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelProfessoresCadastradosLayout.createSequentialGroup()
                        .addComponent(labelLocalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textlocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxPor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRecarregar))
                    .addComponent(scrollPaneProfessorLista, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProfessoresCadastradosLayout.createSequentialGroup()
                        .addComponent(buttonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDetalhar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCursos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExcluir)))
                .addContainerGap())
        );
        panelProfessoresCadastradosLayout.setVerticalGroup(
            panelProfessoresCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfessoresCadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProfessoresCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPor)
                    .addComponent(comboBoxPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLocalizar)
                    .addComponent(textlocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar)
                    .addComponent(buttonRecarregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneProfessorLista, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProfessoresCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNovo)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonDetalhar)
                    .addComponent(buttonCursos))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProfessoresCadastrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProfessoresCadastrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecarregarActionPerformed
        this.carregarTabela();
    }//GEN-LAST:event_buttonRecarregarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed

        String chave = textlocalizar.getText();
        int indice = comboBoxPor.getSelectedIndex();

        boolean retorno = this.validarBuscar();

        if (retorno) {
            List<Professor> lista = null;

            if (indice == 1) {
                lista = professorControl.buscarPeloNome(chave);
            } else if (indice == 2) {
                lista = professorControl.buscarPelaMatricula(Integer.parseInt(chave));
            }

            if (lista != null) {
                ProfessorTM professorTM = new ProfessorTM(lista);
                tableProfessorLista.setModel(professorTM);
                tableProfessorLista.getColumnModel().getColumn(0).setPreferredWidth(30);
                tableProfessorLista.getColumnModel().getColumn(1).setPreferredWidth(400);
                tableProfessorLista.getColumnModel().getColumn(2).setPreferredWidth(50);
            } else {
                JOptionPane.showMessageDialog(null, "Não há professores cadastrados com os dados informados.");
            }
        }
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed

        CadastroProfessorInserirView inserirView = new CadastroProfessorInserirView();
        Principal.desktop.add(inserirView);
        inserirView.getFont();
        inserirView.setPosicao();
        inserirView.setVisible(true);
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetalharActionPerformed
        int linha = tableProfessorLista.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma professor para detalhar.");
        } else {
            int idEditar = (int) tableProfessorLista.getValueAt(linha, 0);

            CadastroProfessorDetalheView detalheView = new CadastroProfessorDetalheView(idEditar);
            Principal.desktop.add(detalheView);
            detalheView.getFont();
            detalheView.setPosicao();
            detalheView.setVisible(true);
        }
    }//GEN-LAST:event_buttonDetalharActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        int linha = tableProfessorLista.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir");
        } else {
            Object[] options = {"Sim", "Cancelar"};
            int retornoExcluir = JOptionPane.showOptionDialog(null, "Tens certeza que deseja excluir o professor selecionado?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

            if (retornoExcluir == JOptionPane.YES_OPTION) {

                int idExcluir = (int) tableProfessorLista.getValueAt(linha, 0);

                boolean retorno = professorControl.excluir(idExcluir);

                if (retorno) {
                    JOptionPane.showMessageDialog(null, "Professor excluído com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao excluír o professor.");
                }

            }
            carregarTabela();

        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCursosActionPerformed
        int linha = tableProfessorLista.getSelectedRow();
        
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma professor para gerenciar os cursos que participa.");
        } else {
            int idEditar = (int) tableProfessorLista.getValueAt(linha, 0);

            CadastroProfessorCursoView curoView = new CadastroProfessorCursoView(idEditar);
            Principal.desktop.add(curoView);
            curoView.getFont();
            curoView.setPosicao();
            curoView.setVisible(true);
        }
    }//GEN-LAST:event_buttonCursosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonCursos;
    private javax.swing.JButton buttonDetalhar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonRecarregar;
    private javax.swing.JComboBox<String> comboBoxPor;
    private javax.swing.JLabel labelLocalizar;
    private javax.swing.JLabel labelPor;
    private javax.swing.JPanel panelProfessoresCadastrados;
    private javax.swing.JScrollPane scrollPaneProfessorLista;
    public static javax.swing.JTable tableProfessorLista;
    private javax.swing.JTextField textlocalizar;
    // End of variables declaration//GEN-END:variables
}