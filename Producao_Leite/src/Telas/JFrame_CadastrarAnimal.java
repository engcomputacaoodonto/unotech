/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.AnimalDAO;
import Model.Animal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

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
        try
        {
            MaskFormatter Data = new MaskFormatter("##/##/####");
            Data.setPlaceholderCharacter('_');
            jFormattedTextField_Data_Nasc.setFormatterFactory(new DefaultFormatterFactory(Data));
        }
        catch (ParseException exc)
        {}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField_Nome = new javax.swing.JTextField();
        jTextField_Brinco = new javax.swing.JTextField();
        jTextField_Raca = new javax.swing.JTextField();
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
        jFormattedTextField_Data_Nasc = new javax.swing.JFormattedTextField();
        jLabel_Erro_Nome = new javax.swing.JLabel();
        jLabel_Erro_Brinco = new javax.swing.JLabel();
        jLabel_Erro_Raca = new javax.swing.JLabel();
        jLabel_Erro_Data_Nasc = new javax.swing.JLabel();
        jLabel_Erro_Sexo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 373;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 25, 0, 0);
        getContentPane().add(jTextField_Nome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 373;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 25, 0, 0);
        getContentPane().add(jTextField_Brinco, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 373;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 25, 0, 0);
        getContentPane().add(jTextField_Raca, gridBagConstraints);

        jCheckBox_Macho.setText("Macho");
        jCheckBox_Macho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_MachoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 25, 0, 0);
        getContentPane().add(jCheckBox_Macho, gridBagConstraints);

        jCheckBox_Femea.setText("Fêmea");
        jCheckBox_Femea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_FemeaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        getContentPane().add(jCheckBox_Femea, gridBagConstraints);

        jLabel_Nome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 39, 0, 0);
        getContentPane().add(jLabel_Nome, gridBagConstraints);

        jLabel_Brinco.setText("Brinco:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 39, 0, 0);
        getContentPane().add(jLabel_Brinco, gridBagConstraints);

        jLabel_Raca.setText("Raça:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 39, 0, 0);
        getContentPane().add(jLabel_Raca, gridBagConstraints);

        jLabel_DataNasc.setText("Data de Nascimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 39, 0, 0);
        getContentPane().add(jLabel_DataNasc, gridBagConstraints);

        jLabel_Sexo.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 39, 0, 0);
        getContentPane().add(jLabel_Sexo, gridBagConstraints);

        jLabel_Titulo_CA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo_CA.setText("Cadastrar Animal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 23, 0, 0);
        getContentPane().add(jLabel_Titulo_CA, gridBagConstraints);

        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 13, 12);
        getContentPane().add(jButton_Voltar, gridBagConstraints);

        jButton_Gravar.setText("Gravar");
        jButton_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GravarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 41, 13, 0);
        getContentPane().add(jButton_Gravar, gridBagConstraints);

        jFormattedTextField_Data_Nasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_Data_NascActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 25, 0, 0);
        getContentPane().add(jFormattedTextField_Data_Nasc, gridBagConstraints);

        jLabel_Erro_Nome.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_Nome.setText("    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 25, 0, 0);
        getContentPane().add(jLabel_Erro_Nome, gridBagConstraints);

        jLabel_Erro_Brinco.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Erro_Brinco.setText("    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 25, 0, 0);
        getContentPane().add(jLabel_Erro_Brinco, gridBagConstraints);

        jLabel_Erro_Raca.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Erro_Raca.setText("    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 25, 0, 0);
        getContentPane().add(jLabel_Erro_Raca, gridBagConstraints);

        jLabel_Erro_Data_Nasc.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Erro_Data_Nasc.setText("    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 25, 0, 0);
        getContentPane().add(jLabel_Erro_Data_Nasc, gridBagConstraints);

        jLabel_Erro_Sexo.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Erro_Sexo.setText("     ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 25, 0, 0);
        getContentPane().add(jLabel_Erro_Sexo, gridBagConstraints);

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
        boolean testes;
        
        setText();
        
        Animal animal = new Animal();
        animal.setNome(jTextField_Nome.getText());
        animal.setNumero(jTextField_Brinco.getText());
        animal.setRaca(jTextField_Raca.getText());
        
        testes = verificacoes(animal);
        
        if(!jFormattedTextField_Data_Nasc.getText().equals("__/__/____"))
            {
            try
            { 
                java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_Data_Nasc.getText());
                Date data = new Date(dataUtil.getTime());
                animal.setDataNasc(data);
            }
            catch (ParseException ex)
            {
                jLabel_Erro_Data_Nasc.setText("Data inválida!");
                return;
            }
        }

        if(jCheckBox_Macho.isSelected())
            animal.setSexo("M");
        if(jCheckBox_Femea.isSelected())
            animal.setSexo("F");
        if(!jCheckBox_Femea.isSelected() && !jCheckBox_Macho.isSelected())
        {
            jLabel_Erro_Sexo.setText("Selecione o sexo do animal!");
            return;
        }
        
        animal.setSituacao("A");
        
        if(testes)
            AnimalDAO.registrarAnimal(animal);
        else
            return;
        
        jTextField_Nome.setText(null);
        jTextField_Brinco.setText(null);
        jTextField_Raca.setText(null);
        jFormattedTextField_Data_Nasc.setText(null);
        jCheckBox_Femea.setSelected(false);
        jCheckBox_Macho.setSelected(false);
    }//GEN-LAST:event_jButton_GravarActionPerformed

    private void jFormattedTextField_Data_NascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_Data_NascActionPerformed
    }//GEN-LAST:event_jFormattedTextField_Data_NascActionPerformed

    
    private boolean verificacoes(Animal animal)
    {
        boolean retorno = true;
        
        if(animal.getNome().length() == 0)
        {
            jLabel_Erro_Nome.setText("O campo Nome deve ser preenchido!");
            retorno = false;
        }
        
        if(animal.getNome().length() > 255)
        {
            jLabel_Erro_Nome.setText("O campo Nome deve ocupar no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(animal.getNumero().length() == 0)
        {
            jLabel_Erro_Brinco.setText("O campo Brinco deve ser preenchido!");
            retorno = false;
        }
        
        if(animal.getNumero().length() != 6 && animal.getNumero().length() != 15 && animal.getNumero().length() != 0)
        {
            jLabel_Erro_Brinco.setText("Utilize o número de registro na CIDASC! (6 ou 15 dígitos)");
            retorno = false;
        }
        
        if(animal.getRaca().length() > 255)
        {
            jLabel_Erro_Raca.setText("O campo Raça deve ocupar no máximo 255 caracteres!");
            retorno = false;
        }

        return retorno;
    }
    
    private void setText()
    {
        jLabel_Erro_Nome.setText(" ");
        jLabel_Erro_Brinco.setText(" ");
        jLabel_Erro_Raca.setText(" ");
        jLabel_Erro_Data_Nasc.setText(" ");
        jLabel_Erro_Sexo.setText(" ");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Gravar;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JCheckBox jCheckBox_Femea;
    private javax.swing.JCheckBox jCheckBox_Macho;
    private javax.swing.JFormattedTextField jFormattedTextField_Data_Nasc;
    private javax.swing.JLabel jLabel_Brinco;
    private javax.swing.JLabel jLabel_DataNasc;
    private javax.swing.JLabel jLabel_Erro_Brinco;
    private javax.swing.JLabel jLabel_Erro_Data_Nasc;
    private javax.swing.JLabel jLabel_Erro_Nome;
    private javax.swing.JLabel jLabel_Erro_Raca;
    private javax.swing.JLabel jLabel_Erro_Sexo;
    private javax.swing.JLabel jLabel_Nome;
    private javax.swing.JLabel jLabel_Raca;
    private javax.swing.JLabel jLabel_Sexo;
    private javax.swing.JLabel jLabel_Titulo_CA;
    private javax.swing.JTextField jTextField_Brinco;
    private javax.swing.JTextField jTextField_Nome;
    private javax.swing.JTextField jTextField_Raca;
    // End of variables declaration//GEN-END:variables

}
