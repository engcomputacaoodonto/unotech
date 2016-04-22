package Telas.FramesAnimais;

import Model.Animal;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Telas.FramePrincipal.JTable_Tabela;


/**
 *
 * @author Shelmo
 */
public class JFrame_PesquisarAnimais extends JFrame_Base
{
    private JLabel jLabel_Pesquisa;
    private JLabel jLabel_ErroPesquisa;
    private JFormattedTextField jFormattedTextField_Pesquisa;
    private JCheckBox jCheckBox_Nome;
    private JCheckBox jCheckBox_Numero;
    private ArrayList<Animal> animalList;
    
    public JFrame_PesquisarAnimais(ArrayList<Animal> animalList)
    {
        super("");
        Componentes();
        this.animalList = animalList;
    }
    
    private void Componentes()
    {
        getjLabel_Titulo().setText("Pesquisar");
        getjButton_Confirmar().setText("Pesquisar");
        
        
        jLabel_Pesquisa = new JLabel();
        jLabel_ErroPesquisa = new JLabel();
        jFormattedTextField_Pesquisa = new JFormattedTextField();
        jCheckBox_Nome = new JCheckBox();
        jCheckBox_Numero = new JCheckBox();
        
        //Nome de Campos
        jLabel_ErroPesquisa.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Pesquisa.setText("Localizar: ");
        
        //Nome de CheckBox
        jCheckBox_Nome.setText("Localizar por Nome");
        jCheckBox_Numero.setText("Localizar por Número");
        
        //Line 0
        getCons().fill = GridBagConstraints.BOTH;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Pesquisa, getCons());
        getCons().gridx = 2;
        getCons().gridwidth = 2;
        getjPanel_CENTER().add(jFormattedTextField_Pesquisa, getCons());
        
        //Line 1
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroPesquisa, getCons());
        
        //Line 2
        getCons().gridwidth = 1;
        getCons().gridx = 2;
        getCons().gridy = 2;
        getjPanel_CENTER().add(jCheckBox_Nome, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jCheckBox_Numero, getCons());
        
        //Marcar Pesquisar por Nome como Padrao
        jCheckBox_Nome.setSelected(true);
        
        
        //Ações Componentes
        //CheckBox Pesquisar por Nome
        jCheckBox_Nome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Numero.isSelected())
                {
                    jCheckBox_Numero.setSelected(false);
                }
                
                jFormattedTextField_Pesquisa = setFormatNull(jFormattedTextField_Pesquisa);
            }
        });
        
        //CheckBox Pesquisar por Número
        jCheckBox_Numero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Nome.isSelected())
                {
                    jCheckBox_Nome.setSelected(false);
                }
                
                jFormattedTextField_Pesquisa = setFormatNumero(jFormattedTextField_Pesquisa);
            }
        });
    }
    
    private boolean Verificações()
    {
        if(jFormattedTextField_Pesquisa.getText().length() == 0 ||
                jFormattedTextField_Pesquisa.getText().equals("      "))
        {
            jLabel_ErroPesquisa.setText("O campo Localizar deve ser preenchido!");
            return false;
        }
        if(jFormattedTextField_Pesquisa.getText().length() > 255 && jCheckBox_Nome.isSelected())
        {
            jLabel_ErroPesquisa.setText("O campo Localizar deve conter no máximo 255 caracteres!");
            return false;
        }
        return true;
    }
    
    public void Confirmar()
    {
        int linha = -1;
        if(Verificações() && jCheckBox_Nome.isSelected())
        {
            for(int i = 0;animalList.size() > i;i++)
            {
                if(animalList.get(i).getNome().equalsIgnoreCase(jFormattedTextField_Pesquisa.getText()))
                {
                    linha = i;
                    break;
                }
            }
            if(linha != -1)
            {
                JTable_Tabela.getjTable_Tabela().setRowSelectionInterval(linha, linha);
                JTable_Tabela.getjTable_Tabela().setColumnSelectionInterval(0, 0);
                dispose();
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Animal não encontrado!", "Erro!", 2);
            }
        }
        if(Verificações() && jCheckBox_Numero.isSelected())
        {
            for(int i = 0;animalList.size() > i;i++)
            {
                if(animalList.get(i).getNumero().equalsIgnoreCase(jFormattedTextField_Pesquisa.getText()))
                {
                    linha = i;
                    break;
                }
            }
            if(linha != -1)
            {
                JTable_Tabela.getjTable_Tabela().setRowSelectionInterval(linha, linha);
                JTable_Tabela.getjTable_Tabela().setColumnSelectionInterval(1, 1);
                dispose();
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Animal não encontrado!", "Erro!", 2);
            }
        }
    }
}
