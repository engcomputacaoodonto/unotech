package Telas.FramesAnimais;

import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Shelmo
 */
public class JFrame_PesquisarAnimais extends JFrame_Base
{
    private JLabel jLabel_Pesquisa;
    private JLabel jLabel_ErroPesquisa;
    private JTextField jTextField_Pesquisa;
    private JCheckBox jCheckBox_Nome;
    private JCheckBox jCheckBox_Numero;
    
    public JFrame_PesquisarAnimais()
    {
        super();
        Componentes();
        getjLabel_Titulo().setText("Pesquisar");
        getjButton_Confirmar().setText("Pesquisar");
    }
    
    private void Componentes()
    {
        jLabel_Pesquisa = new JLabel();
        jLabel_ErroPesquisa = new JLabel();
        jTextField_Pesquisa = new JTextField(40);
        jCheckBox_Nome = new JCheckBox();
        jCheckBox_Numero = new JCheckBox();
        
        //Nome de Campos
        jLabel_ErroPesquisa.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Pesquisa.setText("Pesquisa: ");
        
        //Nome de CheckBox
        jCheckBox_Nome.setText("Pesquisar por Nome");
        jCheckBox_Numero.setText("Pesquisar por Número");
        
        //Line 0
        getCons().fill = GridBagConstraints.BOTH;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Pesquisa, getCons());
        getCons().gridx = 2;
        getCons().gridwidth = 2;
        getjPanel_CENTER().add(jTextField_Pesquisa, getCons());
        
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
            }
        });
    }
    
    public void Confirmar()
    {
        
    }
}
