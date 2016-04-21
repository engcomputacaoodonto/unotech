package Telas.FramesAnimais;

import Model.Animal;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Animal extends JFrame_Base
{
    private JLabel jLabel_Nome;
    private JLabel jLabel_Erro_Nome;
    private JLabel jLabel_Numero;
    private JLabel jLabel_Erro_Numero;
    private JLabel jLabel_Raca;
    private JLabel jLabel_Erro_Raca;
    private JLabel jLabel_Data_Nasc;
    private JLabel jLabel_Erro_Data_Nasc;
    private JLabel jLabel_Sexo;
    private JLabel jLabel_Erro_Sexo;
    private JLabel jLabel_Situacao;
    private JLabel jLabel_Erro_Situacao;
    private JLabel jLabel_Aviso;
    private JTextField jTextField_Nome;
    private JTextField jTextField_Raca;
    private JFormattedTextField jFormattedTextField_Numero;
    private JFormattedTextField jFormattedTextField_Data_Nasc;
    private JCheckBox jCheckBox_Macho;
    private JCheckBox jCheckBox_Femea;
    private JCheckBox jCheckBox_Ativo;
    private JCheckBox jCheckBox_Morte;
    private JCheckBox jCheckBox_Venda;
    
    public JFrame_Animal()
    {
        super();
        componentes();
    }
    
    public void componentes()
    {
        //Criar Componentes
        jLabel_Nome = new JLabel();
        jLabel_Erro_Nome = new JLabel();
        jLabel_Numero = new JLabel();
        jLabel_Erro_Numero = new JLabel();
        jLabel_Raca = new JLabel();
        jLabel_Erro_Raca = new JLabel();
        jLabel_Data_Nasc = new JLabel();
        jLabel_Erro_Data_Nasc = new JLabel();
        jLabel_Sexo = new JLabel();
        jLabel_Erro_Sexo = new JLabel();
        jLabel_Situacao = new JLabel();
        jLabel_Erro_Situacao = new JLabel();
        jLabel_Aviso = new JLabel();
        jTextField_Nome = new JTextField(40);
        jFormattedTextField_Numero = new JFormattedTextField();
        jTextField_Raca = new JTextField(40);
        jFormattedTextField_Data_Nasc = new JFormattedTextField();
        jCheckBox_Macho = new JCheckBox();
        jCheckBox_Femea = new JCheckBox();
        jCheckBox_Ativo = new JCheckBox();
        jCheckBox_Morte = new JCheckBox();
        jCheckBox_Venda = new JCheckBox();
        
        //Máscaras        
        jFormattedTextField_Data_Nasc = setFormatData(jFormattedTextField_Data_Nasc);
        jFormattedTextField_Numero = setFormatNumero(jFormattedTextField_Numero);
        
        //Nomes de Campos
        jLabel_Nome.setText("Nome*:");
        jLabel_Numero.setText("Número*:");
        jLabel_Raca.setText("Raça:");
        jLabel_Data_Nasc.setText("Data de Nascimento:");
        jLabel_Sexo.setText("Sexo*:");
        jLabel_Situacao.setText("Situação*:");
        
        //Cor vermelha para erros
        jLabel_Erro_Nome.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_Numero.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_Raca.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_Data_Nasc.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_Sexo.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Erro_Situacao.setForeground(new java.awt.Color(255, 0, 0));
        
        //Nomes de CheckBox
        jCheckBox_Macho.setText("Macho");
        jCheckBox_Femea.setText("Fêmea");
        jCheckBox_Ativo.setText("Ativo");
        jCheckBox_Morte.setText("Morte");
        jCheckBox_Venda.setText("Venda");
        
        //Line 0
        getCons().fill = GridBagConstraints.BOTH;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Nome, getCons());
        getCons().gridx = 2;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Nome, getCons());
        
        //Line 1
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_Erro_Nome, getCons());
        
        //Line 2
        getCons().gridx = 0;
        getCons().gridy = 2;
        getjPanel_CENTER().add(jLabel_Numero, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jFormattedTextField_Numero, getCons());
        
        //Line 3
        getCons().gridy = 3;
        getjPanel_CENTER().add(jLabel_Erro_Numero, getCons());
        
        //Line 4
        getCons().gridx = 0;
        getCons().gridy = 4;
        getjPanel_CENTER().add(jLabel_Raca, getCons());
        getCons().gridx = 2;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Raca, getCons());
        
        //Line 5
        getCons().gridy = 5;
        getjPanel_CENTER().add(jLabel_Erro_Raca, getCons());
        
        //Line 6
        getCons().gridx = 0;
        getCons().gridy = 6;
        getjPanel_CENTER().add(jLabel_Data_Nasc, getCons());
        getCons().gridx = 3;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jFormattedTextField_Data_Nasc, getCons());
        
        //Line 7
        getCons().gridy = 7;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jLabel_Erro_Data_Nasc, getCons());
        
        //Line 8
        getCons().gridx = 0;
        getCons().gridy = 8;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Sexo, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_Macho, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jCheckBox_Femea, getCons());
        
        //Line 9
        getCons().gridwidth = 3;
        getCons().gridx = 2;
        getCons().gridy = 9;
        getjPanel_CENTER().add(jLabel_Erro_Sexo, getCons());
        
        //Line 10
        getCons().gridx = 0;
        getCons().gridy = 10;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Situacao, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_Ativo, getCons());
        getCons().gridwidth = 1;
        getCons().gridx = 3;
        getjPanel_CENTER().add(jCheckBox_Morte, getCons());
        getCons().gridwidth = 1;
        getCons().gridx = 4;
        getjPanel_CENTER().add(jCheckBox_Venda, getCons());
        
        //Line 11
        getCons().gridwidth = 3;
        getCons().gridx = 2;
        getCons().gridy = 11;
        getjPanel_CENTER().add(jLabel_Erro_Situacao, getCons());
        
        //Line 13
        getCons().gridx = 3;
        getCons().gridy = 13;
        getjPanel_CENTER().add(jLabel_Aviso, getCons());
        
        //Ações de componentes
        //CheckBox Femea
        jCheckBox_Femea.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Macho.isSelected())
                {
                    jCheckBox_Macho.setSelected(false);
                }
            }
        });
        
        //CheckBox Macho
        jCheckBox_Macho.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Femea.isSelected())
                {
                    jCheckBox_Femea.setSelected(false);
                }
            }
        });
        
        //CheckBox Ativa
        jCheckBox_Ativo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Morte.isSelected())
                    jCheckBox_Morte.setSelected(false);
                if(jCheckBox_Venda.isSelected())
                    jCheckBox_Venda.setSelected(false);
            }
        });
        jCheckBox_Morte.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Venda.isSelected())
                    jCheckBox_Venda.setSelected(false);
                if(jCheckBox_Ativo.isSelected())
                    jCheckBox_Ativo.setSelected(false);
            }
        });
        jCheckBox_Venda.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Morte.isSelected())
                    jCheckBox_Morte.setSelected(false);
                if(jCheckBox_Ativo.isSelected())
                    jCheckBox_Ativo.setSelected(false);
            }
        });
    }
    
    protected boolean verificacoes(Animal animal)
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
        
        if(jFormattedTextField_Numero.getText().equals("      "))
        {
            jLabel_Erro_Numero.setText("O campo Número deve ser preenchido!");
            retorno = false;
        }
        
        if(animal.getRaca().length() > 255)
        {
            jLabel_Erro_Raca.setText("O campo Raça deve ocupar no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(!jCheckBox_Femea.isSelected() && !jCheckBox_Macho.isSelected())
        {
            jLabel_Erro_Sexo.setText("Uma das opções deve ser marcada!");
            retorno = false;
        }
        
        if(!jCheckBox_Ativo.isSelected() && !jCheckBox_Morte.isSelected() && !jCheckBox_Venda.isSelected())
        {
            jLabel_Erro_Situacao.setText("Uma das opções deve ser marcada!");
            retorno = false;
        }

        return retorno;
    }
    
    protected void clearJTextField()
    {
        jTextField_Nome.setText(null);
        jFormattedTextField_Numero.setText(null);
        jFormattedTextField_Data_Nasc.setText(null);
    }
    
    protected void clearJLabel()
    {
        jLabel_Erro_Nome.setText(null);
        jLabel_Erro_Numero.setText(null);
        jLabel_Erro_Raca.setText(null);
        jLabel_Erro_Data_Nasc.setText(null);
        jLabel_Erro_Sexo.setText(null);
        jLabel_Erro_Situacao.setText(null);
    }
    
    public abstract void Confirmar();

    public JLabel getjLabel_Erro_Data_Nasc() {
        return jLabel_Erro_Data_Nasc;
    }

    public JLabel getjLabel_Aviso() {
        return jLabel_Aviso;
    }

    public JTextField getjTextField_Nome() {
        return jTextField_Nome;
    }

    public JTextField getjTextField_Raca() {
        return jTextField_Raca;
    }

    public JFormattedTextField getjFormattedTextField_Numero() {
        return jFormattedTextField_Numero;
    }

    public JFormattedTextField getjFormattedTextField_Data_Nasc() {
        return jFormattedTextField_Data_Nasc;
    }

    public JCheckBox getjCheckBox_Macho() {
        return jCheckBox_Macho;
    }

    public JCheckBox getjCheckBox_Femea() {
        return jCheckBox_Femea;
    }

    public JCheckBox getjCheckBox_Ativo() {
        return jCheckBox_Ativo;
    }

    public JCheckBox getjCheckBox_Morte() {
        return jCheckBox_Morte;
    }

    public JCheckBox getjCheckBox_Venda() {
        return jCheckBox_Venda;
    }

    
}
