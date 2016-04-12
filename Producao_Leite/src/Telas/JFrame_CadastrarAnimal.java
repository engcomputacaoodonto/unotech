/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Model.Animal;

/**
 *
 * @author Shelmo
 */
public class JFrame_CadastrarAnimal extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_CadastrarAnimal
     */
    public JFrame_CadastrarAnimal() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_Nome = new javax.swing.JTextField();
        jTextField_Brinco = new javax.swing.JTextField();
        jTextField_Raca = new javax.swing.JTextField();
        jTextField_Data_Nasc = new javax.swing.JTextField();
        jCheckBox_Macho = new javax.swing.JCheckBox();
        jCheckBox_Femea = new javax.swing.JCheckBox();
        jLabel_Nome = new javax.swing.JLabel();
        jLabel_Brinco = new javax.swing.JLabel();
        jLabel_Raca = new javax.swing.JLabel();
        jLabel_DataNasc = new javax.swing.JLabel();
        jLabel_Sexo = new javax.swing.JLabel();
        jLabel_Titulo_CA = new javax.swing.JLabel();
        jButton_Voltar = new javax.swing.JButton();
        jButton_Gravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox_Macho.setText("Macho");
        jCheckBox_Macho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_MachoActionPerformed(evt);
            }
        });

        jCheckBox_Femea.setText("Fêmea");
        jCheckBox_Femea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_FemeaActionPerformed(evt);
            }
        });

        jLabel_Nome.setText("Nome:");

        jLabel_Brinco.setText("Brinco:");

        jLabel_Raca.setText("Raça:");

        jLabel_DataNasc.setText("Data de Nascimento");

        jLabel_Sexo.setText("Sexo");

        jLabel_Titulo_CA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo_CA.setText("Cadastrar Animal");

        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        jButton_Gravar.setText("Gravar");
        jButton_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Nome)
                    .addComponent(jLabel_Brinco)
                    .addComponent(jLabel_Raca)
                    .addComponent(jLabel_DataNasc)
                    .addComponent(jLabel_Sexo))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox_Macho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Femea))
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jTextField_Brinco)
                    .addComponent(jTextField_Raca)
                    .addComponent(jTextField_Data_Nasc))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_Gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Voltar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel_Titulo_CA)
                        .addGap(127, 127, 127))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel_Titulo_CA)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Brinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Brinco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Raca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Raca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Data_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_DataNasc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_Macho)
                    .addComponent(jCheckBox_Femea)
                    .addComponent(jLabel_Sexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Voltar)
                    .addComponent(jButton_Gravar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_VoltarActionPerformed

    private void jCheckBox_MachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_MachoActionPerformed
        if(jCheckBox_Femea.isSelected())
            jCheckBox_Femea.setSelected(false);
    }//GEN-LAST:event_jCheckBox_MachoActionPerformed

    private void jCheckBox_FemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_FemeaActionPerformed
        if(jCheckBox_Macho.isSelected())
            jCheckBox_Macho.setSelected(false);
    }//GEN-LAST:event_jCheckBox_FemeaActionPerformed

    private void jButton_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GravarActionPerformed
        Animal animal = new Animal();
        animal.setNome(jTextField_Nome.getText());
        animal.setNumero(jTextField_Brinco.getText());
        animal.setRaca(jTextField_Data_Nasc.getText());
        if(jCheckBox_Macho.isSelected())
            animal.setSexo("M");
        if(jCheckBox_Femea.isSelected())
            animal.setSexo("F");
    }//GEN-LAST:event_jButton_GravarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Gravar;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JCheckBox jCheckBox_Femea;
    private javax.swing.JCheckBox jCheckBox_Macho;
    private javax.swing.JLabel jLabel_Brinco;
    private javax.swing.JLabel jLabel_DataNasc;
    private javax.swing.JLabel jLabel_Nome;
    private javax.swing.JLabel jLabel_Raca;
    private javax.swing.JLabel jLabel_Sexo;
    private javax.swing.JLabel jLabel_Titulo_CA;
    private javax.swing.JTextField jTextField_Brinco;
    private javax.swing.JTextField jTextField_Data_Nasc;
    private javax.swing.JTextField jTextField_Nome;
    private javax.swing.JTextField jTextField_Raca;
    // End of variables declaration//GEN-END:variables
}
