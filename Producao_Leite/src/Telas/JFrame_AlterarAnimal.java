/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.AnimalDAO;
import Model.Animal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarAnimal extends javax.swing.JFrame {

    Animal animal;
    int select;
    public JFrame_AlterarAnimal(Animal animal, int select)
    {
        this.animal = animal;
        this.select = select;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
        setResizable(false);
        setJLabelErros();
        try
        {
            MaskFormatter Data = new MaskFormatter("##/##/####");
            jFormattedTextField_DataNasc.setFormatterFactory(new DefaultFormatterFactory(Data));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String format = sdf.format(this.animal.getDataNasc());
            jFormattedTextField_DataNasc.setText(format);
        }
        catch (ParseException exc)
        {}
        jTextField_Nome.setText(this.animal.getNome());
        jTextField_Brico.setText(this.animal.getNumero());
        jTextField_Raca.setText(this.animal.getRaca());
        
        if(this.animal.getSexo().equals("M"))
            jCheckBox_Macho.setSelected(true);
        if(this.animal.getSexo().equals("F"))
            jCheckBox_Femea.setSelected(true);
        
        if(this.animal.getSituacao().equals("A"))
            jCheckBox_Ativo.setSelected(true);
        if(this.animal.getSituacao().equals("M"))
            jCheckBox_Morto.setSelected(true);
        if(this.animal.getSituacao().equals("V"))
            jCheckBox_Vendido.setSelected(true);
        
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
        jTextField_Brico = new javax.swing.JTextField();
        jLabel_Erro_Nome = new javax.swing.JLabel();
        jLabel_Erro_Brinco = new javax.swing.JLabel();
        jTextField_Raca = new javax.swing.JTextField();
        jLabel_Erro_Raca = new javax.swing.JLabel();
        jFormattedTextField_DataNasc = new javax.swing.JFormattedTextField();
        jLabel_Erro_DataNasc = new javax.swing.JLabel();
        jCheckBox_Macho = new javax.swing.JCheckBox();
        jCheckBox_Femea = new javax.swing.JCheckBox();
        jCheckBox_Ativo = new javax.swing.JCheckBox();
        jCheckBox_Morto = new javax.swing.JCheckBox();
        jCheckBox_Vendido = new javax.swing.JCheckBox();
        jLabel_Nome = new javax.swing.JLabel();
        jLabel_Numero = new javax.swing.JLabel();
        jLabel_Raca = new javax.swing.JLabel();
        jLabel_Data_Nasx = new javax.swing.JLabel();
        jLabel_sexo = new javax.swing.JLabel();
        jLabel_Situacao = new javax.swing.JLabel();
        jLabel_Titulo = new javax.swing.JLabel();
        jButton_Voltar = new javax.swing.JButton();
        jButton_Gravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField_Brico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BricoActionPerformed(evt);
            }
        });

        jLabel_Erro_Nome.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Erro_Nome.setText("jLabel1");

        jLabel_Erro_Brinco.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_Erro_Brinco.setText("jLabel2");

        jLabel_Erro_Raca.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Erro_Raca.setText("jLabel3");

        jLabel_Erro_DataNasc.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_DataNasc.setText("jLabel4");

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

        jCheckBox_Ativo.setText("Ativo");
        jCheckBox_Ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_AtivoActionPerformed(evt);
            }
        });

        jCheckBox_Morto.setText("Morto");
        jCheckBox_Morto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_MortoActionPerformed(evt);
            }
        });

        jCheckBox_Vendido.setText("Vendido");
        jCheckBox_Vendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_VendidoActionPerformed(evt);
            }
        });

        jLabel_Nome.setText("Nome:*");

        jLabel_Numero.setText("Brinco:*");

        jLabel_Raca.setText("Raça:");

        jLabel_Data_Nasx.setText("Data de  Nascimento:");

        jLabel_sexo.setText("Sexo:*");

        jLabel_Situacao.setText("Situação:*");

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setText("Alterar Registro de Animais");

        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        jButton_Gravar.setText("Gravar Alterações");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel_Titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Nome)
                            .addComponent(jLabel_Numero)
                            .addComponent(jLabel_Raca)
                            .addComponent(jLabel_Data_Nasx)
                            .addComponent(jLabel_sexo)
                            .addComponent(jLabel_Situacao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox_Ativo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox_Morto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox_Vendido))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox_Macho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox_Femea))
                            .addComponent(jLabel_Erro_DataNasc)
                            .addComponent(jLabel_Erro_Raca)
                            .addComponent(jLabel_Erro_Brinco)
                            .addComponent(jLabel_Erro_Nome)
                            .addComponent(jTextField_Nome)
                            .addComponent(jTextField_Brico)
                            .addComponent(jTextField_Raca, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField_DataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_Gravar)
                .addGap(18, 18, 18)
                .addComponent(jButton_Voltar)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel_Titulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Erro_Nome)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Brico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Numero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Erro_Brinco)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Raca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Raca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Erro_Raca)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_DataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Data_Nasx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Erro_DataNasc)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_Macho)
                    .addComponent(jCheckBox_Femea)
                    .addComponent(jLabel_sexo))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_Ativo)
                    .addComponent(jCheckBox_Morto)
                    .addComponent(jCheckBox_Vendido)
                    .addComponent(jLabel_Situacao))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Voltar)
                    .addComponent(jButton_Gravar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_BricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_BricoActionPerformed

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

    private void jCheckBox_AtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_AtivoActionPerformed
        if(jCheckBox_Morto.isSelected())
            jCheckBox_Morto.setSelected(false);
        if(jCheckBox_Vendido.isSelected())
            jCheckBox_Vendido.setSelected(false);
    }//GEN-LAST:event_jCheckBox_AtivoActionPerformed

    private void jCheckBox_MortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_MortoActionPerformed
        if(jCheckBox_Ativo.isSelected())
            jCheckBox_Ativo.setSelected(false);
        if(jCheckBox_Vendido.isSelected())
            jCheckBox_Vendido.setSelected(false);
    }//GEN-LAST:event_jCheckBox_MortoActionPerformed

    private void jCheckBox_VendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_VendidoActionPerformed
        if(jCheckBox_Ativo.isSelected())
            jCheckBox_Ativo.setSelected(false);
        if(jCheckBox_Morto.isSelected())
            jCheckBox_Morto.setSelected(false);
    }//GEN-LAST:event_jCheckBox_VendidoActionPerformed

    private void jButton_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GravarActionPerformed
        boolean teste;
        setJLabelErros();
        
        animal.setNome(jTextField_Nome.getText());
        animal.setNumero(jTextField_Brico.getText());
        animal.setRaca(jTextField_Raca.getText());
        
        teste = verificacoes(animal);
        
        if(!jFormattedTextField_DataNasc.getText().equals("__/__/____"))
            {
            try
            { 
                java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_DataNasc.getText());
                Date data = new Date(dataUtil.getTime());
                animal.setDataNasc(data);
            }
            catch (ParseException ex)
            {
                jLabel_Erro_DataNasc.setText("Data inválida!");
                return;
            }
        }

        if(jCheckBox_Macho.isSelected())
            animal.setSexo("M");
        if(jCheckBox_Femea.isSelected())
            animal.setSexo("F");
        
        if(jCheckBox_Ativo.isSelected())
            animal.setSituacao("A");
        if(jCheckBox_Morto.isSelected())
            animal.setSituacao("M");
        if(jCheckBox_Vendido.isSelected())
            animal.setSituacao("V");
        
        if(teste)
        {
            AnimalDAO.alterarAnimal(animal);
            JFrame_Principal.alterAnimalList(animal, select);
            dispose();
        }
        
    }//GEN-LAST:event_jButton_GravarActionPerformed

    private void setJLabelErros()
    {
        jLabel_Erro_Nome.setText(" ");
        jLabel_Erro_Brinco.setText(" ");
        jLabel_Erro_Raca.setText(" ");
        jLabel_Erro_DataNasc.setText(" ");
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Gravar;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JCheckBox jCheckBox_Ativo;
    private javax.swing.JCheckBox jCheckBox_Femea;
    private javax.swing.JCheckBox jCheckBox_Macho;
    private javax.swing.JCheckBox jCheckBox_Morto;
    private javax.swing.JCheckBox jCheckBox_Vendido;
    private javax.swing.JFormattedTextField jFormattedTextField_DataNasc;
    private javax.swing.JLabel jLabel_Data_Nasx;
    private javax.swing.JLabel jLabel_Erro_Brinco;
    private javax.swing.JLabel jLabel_Erro_DataNasc;
    private javax.swing.JLabel jLabel_Erro_Nome;
    private javax.swing.JLabel jLabel_Erro_Raca;
    private javax.swing.JLabel jLabel_Nome;
    private javax.swing.JLabel jLabel_Numero;
    private javax.swing.JLabel jLabel_Raca;
    private javax.swing.JLabel jLabel_Situacao;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_sexo;
    private javax.swing.JTextField jTextField_Brico;
    private javax.swing.JTextField jTextField_Nome;
    private javax.swing.JTextField jTextField_Raca;
    // End of variables declaration//GEN-END:variables
}
