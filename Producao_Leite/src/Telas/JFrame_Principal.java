/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.AnimalDAO;
import Model.Animal;
import Telas.FramesAnimais.JFrame_AlterarAnimais;
import Telas.FramesAnimais.JFrame_Animal;
import Telas.FramesAnimais.JFrame_CadastrarAnimais;
import Telas.FramesAnimais.JFrame_PesquisarAnimais;
import Telas.FramesAnimais.JFrame_RemoverAnimais;
import Telas.FramesProducaoDiaria.JFrame_CadastrarProducaoDiaria;
import Telas.FramesProducaoDiaria.JFrame_ProducaoDiaria;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public class JFrame_Principal extends javax.swing.JFrame {

    private static ArrayList<Animal> animalList;

    /**
     * Creates new form JFrame_Principal
     */
    public JFrame_Principal()
    {
        initComponents();
        setResizable(false);
        jLayeredPane_Plantel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Fechar = new javax.swing.JButton();
        jLabel_Titulo = new javax.swing.JLabel();
        jLayeredPane_Plantel = new javax.swing.JLayeredPane();
        jButton_Cadastro_Animais = new javax.swing.JButton();
        jButton_Remover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Animais = new javax.swing.JTable();
        JButton_AlterarAnimal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton_Plantel = new javax.swing.JButton();
        FixaCanto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Fechar.setText("Fechar");
        jButton_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(958, 606, -1, -1));

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Titulo.setText("UNOTECH");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 13, -1, -1));

        jButton_Cadastro_Animais.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Cadastro_Animais.setText("Cadastrar Animal");
        jButton_Cadastro_Animais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cadastro_AnimaisActionPerformed(evt);
            }
        });

        jButton_Remover.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Remover.setText("Remover Animal");
        jButton_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoverActionPerformed(evt);
            }
        });

        jTable_Animais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Numero", "Raça", "Data Nascimento", "Sexo", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Animais.setColumnSelectionAllowed(true);
        jTable_Animais.getTableHeader().setReorderingAllowed(false);
        jTable_Animais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_AnimaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Animais);
        jTable_Animais.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        JButton_AlterarAnimal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JButton_AlterarAnimal.setText("Alterar Animal");
        JButton_AlterarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_AlterarAnimalActionPerformed(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLayeredPane_Plantel.setLayer(jButton_Cadastro_Animais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_Plantel.setLayer(jButton_Remover, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_Plantel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_Plantel.setLayer(JButton_AlterarAnimal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_Plantel.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane_PlantelLayout = new javax.swing.GroupLayout(jLayeredPane_Plantel);
        jLayeredPane_Plantel.setLayout(jLayeredPane_PlantelLayout);
        jLayeredPane_PlantelLayout.setHorizontalGroup(
            jLayeredPane_PlantelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_PlantelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane_PlantelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane_PlantelLayout.createSequentialGroup()
                        .addComponent(jButton_Cadastro_Animais, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Remover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButton_AlterarAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane_PlantelLayout.setVerticalGroup(
            jLayeredPane_PlantelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_PlantelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jLayeredPane_PlantelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cadastro_Animais)
                    .addComponent(jButton_Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButton_AlterarAnimal)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jLayeredPane_Plantel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 113, -1, -1));

        jButton_Plantel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton_Plantel.setText("Plantel");
        jButton_Plantel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PlantelActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Plantel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 58, -1, -1));
        getContentPane().add(FixaCanto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 630, 10, 20));

        jButton2.setText("Produção Diaria");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Cadastro_AnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cadastro_AnimaisActionPerformed
        //new JFrame_CadastrarAnimal();
        //new JFrame_Animal();
        new JFrame_CadastrarAnimais();
    }//GEN-LAST:event_jButton_Cadastro_AnimaisActionPerformed

    private void jButton_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_FecharActionPerformed

    private void jButton_PlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PlantelActionPerformed
        animalList = AnimalDAO.getListaAnimais();
        atualizarTabela();
        jLayeredPane_Plantel.setVisible(true);
    }//GEN-LAST:event_jButton_PlantelActionPerformed

    private void jButton_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoverActionPerformed
        int select = jTable_Animais.getSelectedRow();
        if(select == -1)
        {
            JOptionPane.showMessageDialog(this, "Nenhum animal selecionado!", "Ops...", 2);
            return;
        }
        Animal animal = new Animal();
        animal.setId(animalList.get(select).getId());
        animal.setNome(animalList.get(select).getNome());
        animal.setNumero(animalList.get(select).getNumero());
        animal.setRaca(animalList.get(select).getRaca());
        animal.setDataNasc(animalList.get(select).getDataNasc());
        animal.setSexo(animalList.get(select).getSexo());
        animal.setSituacao(animalList.get(select).getSituacao());
        new JFrame_RemoverAnimais(animal, select);
    }//GEN-LAST:event_jButton_RemoverActionPerformed

    private void JButton_AlterarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_AlterarAnimalActionPerformed
        int select = jTable_Animais.getSelectedRow();
        if(select == -1)
        {
            JOptionPane.showMessageDialog(this, "Nenhum animal selecionado!", "Ops...", 2);
            return;
        }
        Animal animal = new Animal();
        animal.setId(animalList.get(select).getId());
        animal.setNome(animalList.get(select).getNome());
        animal.setNumero(animalList.get(select).getNumero());
        animal.setRaca(animalList.get(select).getRaca());
        animal.setDataNasc(animalList.get(select).getDataNasc());
        animal.setSexo(animalList.get(select).getSexo());
        animal.setSituacao(animalList.get(select).getSituacao());
        new JFrame_AlterarAnimais(animal, select);
    }//GEN-LAST:event_JButton_AlterarAnimalActionPerformed

    private void jTable_AnimaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_AnimaisMouseClicked
            int click = evt.getClickCount();
            if(click == 2)
            {
                int select = jTable_Animais.getSelectedRow();
                Animal animal = new Animal();
                animal.setId(animalList.get(select).getId());
                animal.setNome(animalList.get(select).getNome());
                animal.setNumero(animalList.get(select).getNumero());
                animal.setRaca(animalList.get(select).getRaca());
                animal.setDataNasc(animalList.get(select).getDataNasc());
                animal.setSexo(animalList.get(select).getSexo());
                animal.setSituacao(animalList.get(select).getSituacao());
                new JFrame_AlterarAnimais(animal, select);
            }
    }//GEN-LAST:event_jTable_AnimaisMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new JFrame_PesquisarAnimais(animalList);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new JFrame_CadastrarProducaoDiaria();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void atualizarTabela()
    {
        try
        {
            if (!animalList.isEmpty())
            {
                String[] nomeColunas = {"Nome", " Numero", "Raça", "Data de Nascimento", "Sexo", "Situação"};
                DefaultTableModel model = (DefaultTableModel) jTable_Animais.getModel();
                model.setColumnIdentifiers(nomeColunas);
                model.setNumRows(0);
                for (Animal c : animalList)
                {
                    String sexo = null;
                    String situacao = null;
                    String dataN = null;
                    if(c.getSexo().equals("F"))
                        sexo = "Fêmea";
                    if(c.getSexo().equals("M"))
                        sexo = "Macho";
                    
                    if(c.getSituacao().equals("A"))
                        situacao = "Ativo";
                    if(c.getSituacao().equals("M"))
                        situacao = "Morte";
                    if(c.getSituacao().equals("V"))
                        situacao = "Venda";
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    dataN = sdf.format(c.getDataNasc());
                    model.addRow(new Object[]{c.getNome(), c.getNumero(), c.getRaca(), dataN, sexo, situacao});      
                        
                }
                
            }
        } catch (Exception e) {
            
        }
    }
    
    public static void addAnimalList(Animal animal)
    {
        animalList.add(animal);
        atualizarTabela();
    }
    
    public static void alterAnimalList(Animal animal, int select)
    {
        animalList.set(select, animal);
        atualizarTabela();
    }
    
    public static void removerAnimalList(int select)
    {
        animalList.remove(select);
        atualizarTabela();
    }
    
    public static JTable getJTable()
    {
        return jTable_Animais;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFrame_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FixaCanto;
    private javax.swing.JButton JButton_AlterarAnimal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Cadastro_Animais;
    private javax.swing.JButton jButton_Fechar;
    private javax.swing.JButton jButton_Plantel;
    private javax.swing.JButton jButton_Remover;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLayeredPane jLayeredPane_Plantel;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable_Animais;
    // End of variables declaration//GEN-END:variables
}
