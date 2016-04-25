package Telas.FramesProducaoDiaria;

import Model.Animal;
import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_ProducaoDiaria extends JFrame_Base
{
    private JLabel jLabel_Animal;
    private JLabel jLabel_Data;
    private JLabel jLabel_QtdLitros;
    private JLabel jLabel_Aviso;
    private JLabel jLabel_ErroAnimal;
    private JLabel jLabel_ErroData;
    private JLabel jLabel_ErroQtdLitros;
    private JComboBox jComboBox_Animal;
    private JFormattedTextField jFormattedTextField_Data;
    private JFormattedTextField jFormattedTextField_QtdLitros;
    private JCheckBox jCheckBox_DataAtual;
    
    public JFrame_ProducaoDiaria(String imagem)
    {
        super(imagem);
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar Componentes
        jLabel_Animal =  new JLabel();
        jLabel_Data = new JLabel();
        jLabel_QtdLitros = new JLabel();
        jLabel_Aviso = new JLabel();
        jLabel_ErroAnimal = new JLabel();
        jLabel_ErroData = new JLabel();
        jLabel_ErroQtdLitros = new JLabel();
        jComboBox_Animal = new JComboBox();
        jFormattedTextField_Data = new JFormattedTextField();
        jFormattedTextField_QtdLitros = new JFormattedTextField();
        jCheckBox_DataAtual = new JCheckBox();
        
        //Carregar dados ComboBox
        jComboBox_Animal.setEditable(true);
        for(Animal a:JTable_Tabela.getAnimalList())
            jComboBox_Animal.addItem(a.getNome()+" - "+a.getNumero());
        
        //Nome de Campos
        jLabel_Animal.setText("Vaca*:");
        jLabel_Data.setText("Data*:");
        jLabel_QtdLitros.setText("Litros Produzidos*:");
        
        //Cor Vermelha para Erros
        jLabel_ErroAnimal.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_ErroData.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_ErroQtdLitros.setForeground(new java.awt.Color(255, 0, 0));
        
        //Nome de CheckBox
        jCheckBox_DataAtual.setText("Utilizar data atual");
        
        //Máscara Data
        jFormattedTextField_Data = setFormatData(jFormattedTextField_Data);
        
        //Máscara Decimal
        jFormattedTextField_QtdLitros = setFormatDecimal(jFormattedTextField_QtdLitros);
        
        //Line 0
        getCons().fill = GridBagConstraints.BOTH;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Animal, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jComboBox_Animal, getCons());
        
        //Line 1
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroAnimal, getCons());
        
        //Line 2
        getCons().gridx = 0;
        getCons().gridy = 2;
        getjPanel_CENTER().add(jLabel_Data, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_Data, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_DataAtual, getCons());
        
        //Line 3
        getCons().gridx = 1;
        getCons().gridy = 3;
        getjPanel_CENTER().add(jLabel_ErroData, getCons());
        
        //Line 4
        getCons().gridx = 0;
        getCons().gridy = 4;
        getjPanel_CENTER().add(jLabel_QtdLitros, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_QtdLitros, getCons());
        
        //Line 5
        getCons().gridy = 5;
        getjPanel_CENTER().add(jLabel_ErroQtdLitros, getCons());
        
        //Line 6
        getCons().gridy = 6;
        getCons().gridwidth = 2;
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
    }
    
    protected boolean Verificacao(ProducaoDiaria pd)
    {
        boolean retorno = true;
        
        if(jFormattedTextField_QtdLitros.getText().equals("00.00"))
        {
            jLabel_ErroQtdLitros.setText("O campo Litros Produzidos deve ser preenchido!");
            retorno = false;
        }
        
        return retorno;
    }
    
    protected void ClearJLabel()
    {
        jLabel_ErroData.setText(null);
        jLabel_ErroQtdLitros.setText(null);
    }
    
    protected void ClearCampos()
    {
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

    public JFormattedTextField getjFormattedTextField_Data()
    {
        return jFormattedTextField_Data;
    }

    public JFormattedTextField getjFormattedTextField_QtdLitros()
    {
        return jFormattedTextField_QtdLitros;
    }

    public JCheckBox getjCheckBox_DataAtual()
    {
        return jCheckBox_DataAtual;
    }

    public JComboBox getjComboBox_Animal()
    {
        return jComboBox_Animal;
    }
}
