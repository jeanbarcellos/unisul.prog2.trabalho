package view;

import control.ProfessorControl;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import model.Professor;

/**
 * CadastroProfessorInserirView
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class CadastroProfessorInserirView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 2992990321051869810L;

    private ProfessorControl alunoControl;

    /**
     * Creates new form CadastroProfessorInserir
     */
    public CadastroProfessorInserirView() {
        initComponents();

        this.alunoControl = new ProfessorControl();
    }

    /**
     * Posiciona o painel no mei da tela
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
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

        panelProfessor = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelMatricula = new javax.swing.JLabel();
        textMatricula = new javax.swing.JTextField();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Inserir Professor");

        panelProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder("Professor"));

        labelId.setText("ID:");

        textId.setEditable(false);

        labelNome.setText("Nome:");

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        labelMatricula.setText("Matrícula:");

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

        javax.swing.GroupLayout panelProfessorLayout = new javax.swing.GroupLayout(panelProfessor);
        panelProfessor.setLayout(panelProfessorLayout);
        panelProfessorLayout.setHorizontalGroup(
            panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelId)
                    .addComponent(labelMatricula)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome)
                    .addGroup(panelProfessorLayout.createSequentialGroup()
                        .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProfessorLayout.createSequentialGroup()
                                .addComponent(buttonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonCancelar))
                            .addComponent(textMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 166, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProfessorLayout.setVerticalGroup(
            panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatricula)
                    .addComponent(textMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(panelProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        boolean validacao = this.validarFormulario();

        if (validacao) {
            String nome = textNome.getText();
            int matricula = Integer.parseInt(textMatricula.getText());

            // Cria o objeto de transição
            Professor aluno = new Professor();
            aluno.setNome(nome);
            aluno.setMatricula(matricula);

            // Envia o objeto criado para o controlador
            boolean retorno = this.alunoControl.inserir(aluno);

            if (retorno) {
                CadastroProfessorView.carregarTabela();
                JOptionPane.showMessageDialog(null, "Professor cadastrado com Sucesso.");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Tentar cadastrar Professor.");
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel panelProfessor;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textMatricula;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
