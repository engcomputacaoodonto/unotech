package Telas.FrameColetaLeite;

import Model.Empresa;
import Telas.FrameEmpresa.JFrame_CadastrarEmpresa;
import Telas.FramePrincipal.JTable_Tabela;
import java.sql.Date;
import Telas.JFrame_Base;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_ColetaLeite extends JFrame_Base
{
    private JLabel jLabel_Empresa;
    private JLabel jLabel_Data;
    private JLabel jLabel_QtdLitros;
    private JLabel jLabel_Qualidade;
    private JLabel jLabel_Aviso;
    private JLabel jLabel_ErroEmpresa;
    private JLabel jLabel_ErroData;
    private JLabel jLabel_ErroQtdLitros;
    
    private JComboBox jComboBox_Empresa;
    
    private JFormattedTextField jFormattedTextField_Data;
    private JFormattedTextField jFormattedTextField_QtdLitros;
    
    private JCheckBox jCheckBox_LeiteBom;
    private JCheckBox jCheckBox_LeiteAcido;
    private JCheckBox jCheckBox_DataAtual;
    
    private JButton jButton_NovaEmpresa;
    
    public JFrame_ColetaLeite(String image)
    {
        super(image);
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar componentes
        jLabel_Aviso = new JLabel();
        jLabel_Data = new JLabel();
        jLabel_Empresa = new JLabel();
        jLabel_QtdLitros = new JLabel();
        jLabel_Qualidade = new JLabel();
        jLabel_ErroData = new JLabel();
        jLabel_ErroEmpresa = new JLabel();
        jLabel_ErroQtdLitros = new JLabel();
        jComboBox_Empresa = new JComboBox();
        jCheckBox_LeiteBom = new JCheckBox();
        jCheckBox_LeiteAcido = new JCheckBox();
        jCheckBox_DataAtual = new JCheckBox();
        jButton_NovaEmpresa = new JButton();
        jFormattedTextField_Data = new JFormattedTextField();
        jFormattedTextField_QtdLitros = new JFormattedTextField();
        
        //Carregar dados ComboBox
        jComboBox_Empresa.setEditable(true);
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) jComboBox_Empresa.getModel();
        comboModel.removeAllElements();
        comboModel.addElement("--Selecione--");
        for(Empresa e : JTable_Tabela.getEmpresa())
            comboModel.addElement(e);
        
        //Textos
        jLabel_Empresa.setText("Empresa*:");
        jLabel_Data.setText("Data*:");
        jLabel_QtdLitros.setText("Litros de Leite Coletados*:");
        jLabel_Qualidade.setText("Qualidade*:");
        jCheckBox_DataAtual.setText("Data Atual");
        jCheckBox_LeiteAcido.setText("Ácido");
        jCheckBox_LeiteBom.setText("Bom");
        
        //Foreground Erros
        jLabel_ErroData.setForeground(Color.red);
        jLabel_ErroEmpresa.setForeground(Color.red);
        jLabel_ErroQtdLitros.setForeground(Color.red);
        
        //Botão Nova Empresa
        Icon add = new ImageIcon("src\\Telas\\FrameColetaLeite\\add.png");
        jButton_NovaEmpresa.setIcon(add);
        
        //Máscaras
        jFormattedTextField_Data = setFormatData(jFormattedTextField_Data);
        jFormattedTextField_QtdLitros = setFormatNumero(jFormattedTextField_QtdLitros);
        
        //Iniciar JCheckBox Padrão
        jCheckBox_LeiteBom.setSelected(true);
        
        
        getCons().fill = GridBagConstraints.BOTH;
        //Linha 0
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Empresa, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 2;
        getjPanel_CENTER().add(jComboBox_Empresa, getCons());
        getCons().gridx = 3;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jButton_NovaEmpresa, getCons());
        
        //Linha 1
        getCons().gridx = 1;
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroEmpresa, getCons());
        
        //Linha 2
        getCons().gridx = 0;
        getCons().gridy = 2;
        getjPanel_CENTER().add(jLabel_Data, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_Data, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_DataAtual, getCons());
        
        //Linha 3
        getCons().gridx = 1;
        getCons().gridy = 3;
        getjPanel_CENTER().add(jLabel_ErroData, getCons());
        
        //Linha 4
        getCons().gridx = 0;
        getCons().gridy = 4;
        getjPanel_CENTER().add(jLabel_QtdLitros, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_QtdLitros, getCons());
        
        //Linha 5
        getCons().gridy = 5;
        getCons().gridwidth = 4;
        getjPanel_CENTER().add(jLabel_ErroQtdLitros, getCons());
        
        //Linha 6
        getCons().gridx = 0;
        getCons().gridy = 6;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Qualidade, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jCheckBox_LeiteBom, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_LeiteAcido, getCons());
        
        //Linha 7
        getCons().gridx = 0;
        getCons().gridy = 7;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jLabel_Aviso, getCons());
        
        //Ações de componentes
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
                if(!jCheckBox_DataAtual.isSelected())
                {
                    jFormattedTextField_Data.setText(null);
                }
            }
        });
        
        //CheckBox LeiteBom
        jCheckBox_LeiteBom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox_LeiteBom.setSelected(true);
                if(jCheckBox_LeiteBom.isSelected())
                {
                    jCheckBox_LeiteAcido.setSelected(false);
                }
            }
        });
        
        //CheckBox LeiteAcido
        jCheckBox_LeiteAcido.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox_LeiteAcido.setSelected(true);
                if(jCheckBox_LeiteAcido.isSelected())
                {
                    jCheckBox_LeiteBom.setSelected(false);
                }
            }
        });
        
        //Button Nova Empresa
        jButton_NovaEmpresa.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                new JFrame_CadastrarEmpresa();
            }
        });
    }
    
    public boolean Verificacoes()
    {
        boolean retorno = true;
        
        if(jComboBox_Empresa.getSelectedIndex() == 0)
        {
            jLabel_ErroEmpresa.setText("Selecione o laticínio que coletou o leite!");
            retorno = false;
        }
        
        if(jFormattedTextField_QtdLitros.getText().equals("000000"))
        {
            jLabel_ErroQtdLitros.setText("O campo Quantidade de Litros Coletados é obrigatório!");
            retorno = false;
        }
        
        return retorno;
    }
    
    public void LimparErros()
    {
        jLabel_ErroData.setText(null);
        jLabel_ErroEmpresa.setText(null);
        jLabel_ErroQtdLitros.setText(null);
    }
    
    public void LimparCampos()
    {
        getjComboBox_Empresa().setSelectedIndex(0);
        getjFormattedTextField_Data().setText(null);
        getjFormattedTextField_QtdLitros().setText(null);
        getjCheckBox_LeiteBom().setSelected(true);
        getjCheckBox_LeiteAcido().setSelected(false);
    }
    
    private Date getDate()
    {
        java.util.Date dataUtil = new java.util.Date();
        Date data = new Date(dataUtil.getTime());
        return data;
    }

    public JLabel getjLabel_Aviso()
    {
        return jLabel_Aviso;
    }

    public JComboBox getjComboBox_Empresa()
    {
        return jComboBox_Empresa;
    }

    public JFormattedTextField getjFormattedTextField_Data()
    {
        return jFormattedTextField_Data;
    }

    public JFormattedTextField getjFormattedTextField_QtdLitros()
    {
        return jFormattedTextField_QtdLitros;
    }

    public JCheckBox getjCheckBox_LeiteBom()
    {
        return jCheckBox_LeiteBom;
    }

    public JCheckBox getjCheckBox_LeiteAcido()
    {
        return jCheckBox_LeiteAcido;
    }

    public JLabel getjLabel_ErroData()
    {
        return jLabel_ErroData;
    }

    public JCheckBox getjCheckBox_DataAtual()
    {
        return jCheckBox_DataAtual;
    }

    public JButton getjButton_NovaEmpresa()
    {
        return jButton_NovaEmpresa;
    }
}
