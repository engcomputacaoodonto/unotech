package Telas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_BaseLocalizar extends JFrame_Base
{
    private JLabel jLabel_Localizar;
    private JLabel jLabel_ErroLocalizar;
    private JFormattedTextField jFormattedTextField_Localizar;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    
    public JFrame_BaseLocalizar(String image)
    {
        super(image);
        Componentes();
    }
    
    public void Componentes()
    {
        //Criar componentes
        jLabel_Localizar = new JLabel();
        jLabel_ErroLocalizar = new JLabel();
        jFormattedTextField_Localizar = new JFormattedTextField();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        
        //Textos
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        jLabel_Localizar.setText("Localizar");
        
        //Campo de Erro
        jLabel_ErroLocalizar.setForeground(Color.red);
        
        //Line 0
        getCons().fill = GridBagConstraints.BOTH;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Localizar, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jFormattedTextField_Localizar, getCons());
        
        //Line 1
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroLocalizar, getCons());
        
        //Line 2
        getCons().gridwidth = 1;
        getCons().gridx = 1;
        getCons().gridy = 2;
        getjPanel_CENTER().add(jCheckBox1, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jCheckBox2, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jCheckBox3, getCons());
        
        
        //Marcar CheckBox Padrao
        jCheckBox1.setSelected(true);
        
        //Ações Componentes
        //CheckBox1
        jCheckBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox1.setSelected(true);
                if(jCheckBox1.isSelected())
                {
                    jCheckBox2.setSelected(false);
                    jCheckBox3.setSelected(false);
                    AcaoJCheckBox1();
                }
            }
        });
        
        //CheckBox2
        jCheckBox2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox2.setSelected(true);
                if(jCheckBox2.isSelected())
                {
                    jCheckBox1.setSelected(false);
                    jCheckBox3.setSelected(false);
                    AcaoJCheckBox2();
                }
            }
        });
        
        //CheckBox3
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3.setSelected(true);
                if(jCheckBox3.isSelected())
                {
                    jCheckBox1.setSelected(false);
                    jCheckBox2.setSelected(false);
                    AcaoJCheckBox3();
                }
            }
        });
    }

    public JLabel getjLabel_ErroLocalizar()
    {
        return jLabel_ErroLocalizar;
    }

    public JFormattedTextField getjFormattedTextField_Localizar()
    {
        return jFormattedTextField_Localizar;
    }

    public JCheckBox getjCheckBox1()
    {
        return jCheckBox1;
    }

    public JCheckBox getjCheckBox2()
    {
        return jCheckBox2;
    }

    public JCheckBox getjCheckBox3()
    {
        return jCheckBox3;
    }

    public void setjFormattedTextField_Localizar(JFormattedTextField jFormattedTextField_Localizar)
    {
        this.jFormattedTextField_Localizar = jFormattedTextField_Localizar;
    }
    
    public abstract void AcaoJCheckBox1();
    
    public abstract void AcaoJCheckBox2();
    
    public abstract void AcaoJCheckBox3();
    
    public abstract void Confirmar();
}
