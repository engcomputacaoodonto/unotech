package Telas.FramesProducaoDiaria;

import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_ProducaoDiaria extends JFrame_Base
{
    private JLabel jLabel_Nome;
    private JLabel jLabel_Numero;
    private JLabel jLabel_Data;
    private JLabel jLabel_QtdLitros;
    private JLabel jLabel_Aviso;
    private JLabel jLabel_ErroNome;
    private JLabel jLabel_ErroNumero;
    private JLabel jLabel_ErroData;
    private JLabel jLabel_ErroQtdLitros;
    private JTextField jTextField_Nome;
    private JFormattedTextField jFormattedTextField_Numero;
    private JFormattedTextField jFormattedTextField_Data;
    private JFormattedTextField jFormattedTextField_QtdLitros;
    private JCheckBox jCheckBox_Nome;
    private JCheckBox jCheckBox_Numero;
    private JCheckBox jCheckBox_DataAtual;
    
    public JFrame_ProducaoDiaria(String imagem)
    {
        super(imagem);
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar Componentes
        jLabel_Nome =  new JLabel();
        jLabel_Numero = new JLabel();
        jLabel_Data = new JLabel();
        jLabel_QtdLitros = new JLabel();
        jLabel_Aviso = new JLabel();
        jLabel_ErroNome = new JLabel();
        jLabel_ErroNumero = new JLabel();
        jLabel_ErroData = new JLabel();
        jLabel_ErroQtdLitros = new JLabel();
        jTextField_Nome = new JTextField(40);
        jFormattedTextField_Numero = new JFormattedTextField();
        jFormattedTextField_Data = new JFormattedTextField();
        jFormattedTextField_QtdLitros = new JFormattedTextField();
        jCheckBox_Nome = new JCheckBox();
        jCheckBox_Numero = new JCheckBox();
        jCheckBox_DataAtual = new JCheckBox();
        
        //Nome de Campos
        jLabel_Nome.setText("Nome*:");
        jLabel_Numero.setText("Número*:");
        jLabel_Data.setText("Data*:");
        jLabel_QtdLitros.setText("Litros Produzidos*:");
        
        //Cor Vermelha para Erros
        jLabel_ErroNome.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_ErroNumero.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_ErroData.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_ErroQtdLitros.setForeground(new java.awt.Color(255, 0, 0));
        
        //Nome de CheckBox
        jCheckBox_Nome.setText("Nome");
        jCheckBox_Numero.setText("Número");
        jCheckBox_DataAtual.setText("Utilizar data atual");
        
        //Máscara Data
        jFormattedTextField_Data = setFormatData(jFormattedTextField_Data);
        
        //Máscara Número
        jFormattedTextField_Numero = setFormatNumero(jFormattedTextField_Numero);
        
        //Máscara Decimal
        jFormattedTextField_QtdLitros = setFormatDecimal(jFormattedTextField_QtdLitros);
        
        //Line 0
        getCons().fill = GridBagConstraints.BOTH;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Nome, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 2;
        getjPanel_CENTER().add(jTextField_Nome, getCons());
        
        //Line 1
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroNome, getCons());
        
        
        //Line 2
        getCons().gridx = 0;
        getCons().gridy = 2;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Numero, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_Numero, getCons());
        
        //Line 3
        getCons().gridy = 3;
        getjPanel_CENTER().add(jLabel_ErroNumero, getCons());

        //Line 4
        getCons().gridy = 4;
        getjPanel_CENTER().add(jCheckBox_Nome, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_Numero, getCons());
        
        //Line 5
        getCons().gridx = 0;
        getCons().gridy = 5;
        getjPanel_CENTER().add(jLabel_Data, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_Data, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_DataAtual, getCons());
        
        //Line 6
        getCons().gridx = 1;
        getCons().gridy = 6;
        getjPanel_CENTER().add(jLabel_ErroData, getCons());
        
        //Line 7
        getCons().gridx = 0;
        getCons().gridy = 7;
        getjPanel_CENTER().add(jLabel_QtdLitros, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_QtdLitros, getCons());
        
        //Line 8
        getCons().gridy = 8;
        getjPanel_CENTER().add(jLabel_ErroQtdLitros, getCons());
        
        //Line 9
        getCons().gridy = 9;
        getCons().gridwidth = 2;
        getjPanel_CENTER().add(jLabel_Aviso, getCons());
        
        //Ações de componentes
        //CheckBox Nome
        jCheckBox_Nome.setSelected(true);
        jFormattedTextField_Numero.setEnabled(false);
        jCheckBox_Nome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Numero.isSelected())
                {
                    jCheckBox_Numero.setSelected(false);
                }
                jTextField_Nome.setEnabled(true);
                jFormattedTextField_Numero.setEnabled(false);
            }
        });
        
        //CheckBox Número
        jCheckBox_Numero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_Nome.isSelected())
                {
                    jCheckBox_Nome.setSelected(false);
                }
                jTextField_Nome.setEnabled(false);
                jFormattedTextField_Numero.setEnabled(true);
            }
        });
        
        //CheckBox Data
        jCheckBox_DataAtual.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(jCheckBox_DataAtual.isSelected())
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String format = sdf.format(getDate());
                    jFormattedTextField_Data.setText(format);
                }
            }
        });
    }
    
    protected boolean Verificacao(ProducaoDiaria pd)
    {
        boolean retorno = true;
        
        String nomeNumero[] = {jTextField_Nome.getText(), jFormattedTextField_Numero.getText()};
            
        
        if(jCheckBox_Nome.isSelected())
        {
            if(jTextField_Nome.getText().length() == 0)
            {
                jLabel_ErroNome.setText("O campo Nome deve ser preenchido!");
                retorno = false;
            }

            if(jTextField_Nome.getText().length() > 255)
            {
                jLabel_ErroNome.setText("O campo Nome deve ocupar no máximo 255 caracteres!");
                retorno = false;
            }
            
            if(JTable_Tabela.getId(nomeNumero) == -1)
            {
                jLabel_ErroNome.setText(jTextField_Nome.getText() + " não cadastrado!");
                return false;
            }
        }
        
        if(jCheckBox_Numero.isSelected())
        {
            if(jFormattedTextField_Numero.getText().equals("      "))
            {
                jLabel_ErroNumero.setText("O campo Número deve ser preenchido!");
                retorno = false;
            }
            
            if(JTable_Tabela.getId(nomeNumero) == -1)
            {
                jLabel_ErroNumero.setText(jFormattedTextField_Numero.getText() + " não cadastrado!");
                return false;
            }
        }
        
        if(jFormattedTextField_QtdLitros.getText().equals("00.00"))
        {
            jLabel_ErroQtdLitros.setText("O campo Litros Produzidos deve ser preenchido!");
            retorno = false;
        }
        
        return retorno;
    }
    
    protected void ClearJLabel()
    {
        jLabel_ErroNome.setText(null);
        jLabel_ErroNumero.setText(null);
        jLabel_ErroData.setText(null);
        jLabel_ErroQtdLitros.setText(null);
    }
    
    protected void ClearCampos()
    {
        jTextField_Nome.setText(null);
        jFormattedTextField_Numero.setText(null);
        jFormattedTextField_QtdLitros.setText(null);
    }
    
    private Date getDate()
    {
        java.util.Date dataUtil = new java.util.Date();
        Date data = new Date(dataUtil.getTime());
        return data;
    }

    public abstract void Confirmar();

    public JLabel getjLabel_ErroData()
    {
        return jLabel_ErroData;
    }
    
    public JLabel getjLabel_Aviso()
    {
        return jLabel_Aviso;
    }

    public JTextField getjTextField_Nome()
    {
        return jTextField_Nome;
    }

    public JFormattedTextField getjFormattedTextField_Numero()
    {
        return jFormattedTextField_Numero;
    }

    public JFormattedTextField getjFormattedTextField_Data()
    {
        return jFormattedTextField_Data;
    }

    public JFormattedTextField getjFormattedTextField_QtdLitros()
    {
        return jFormattedTextField_QtdLitros;
    }

    public JCheckBox getjCheckBox_Nome()
    {
        return jCheckBox_Nome;
    }

    public JCheckBox getjCheckBox_Numero()
    {
        return jCheckBox_Numero;
    }

    public JCheckBox getjCheckBox_DataAtual()
    {
        return jCheckBox_DataAtual;
    }
    
    
}
