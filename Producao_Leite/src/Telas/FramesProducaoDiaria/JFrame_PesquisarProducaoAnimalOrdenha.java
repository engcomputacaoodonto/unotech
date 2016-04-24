package Telas.FramesProducaoDiaria;

import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_PesquisarProducaoAnimalOrdenha extends JFrame_Base
{
    private JLabel jLabel_Pesquisa;
    private JLabel jLabel_ErroPesquisa;
    private JFormattedTextField jFormattedTextField_Pesquisa;
    private JCheckBox jCheckBox_Nome;
    private JCheckBox jCheckBox_Numero;
    private final ArrayList<ProducaoDiaria> producaoAnimalOrdenha;
    
    public JFrame_PesquisarProducaoAnimalOrdenha(ArrayList<ProducaoDiaria> producaoAnimalOrdenha)
    {
        super("");
        this.producaoAnimalOrdenha = producaoAnimalOrdenha;
        Componentes();
    }
    
    private void Componentes()
    {
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        
        
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
                jCheckBox_Nome.setSelected(true);
                if(jCheckBox_Numero.isSelected())
                {
                    jCheckBox_Numero.setSelected(false);
                    jFormattedTextField_Pesquisa = setFormatNull(jFormattedTextField_Pesquisa);
                    jFormattedTextField_Pesquisa.setText(null);
                }
            }
        });
        
        //CheckBox Pesquisar por Número
        jCheckBox_Numero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox_Numero.setSelected(true);
                if(jCheckBox_Nome.isSelected())
                {
                    jCheckBox_Nome.setSelected(false);
                    jFormattedTextField_Pesquisa = setFormatNumero(jFormattedTextField_Pesquisa);
                    jFormattedTextField_Pesquisa.setText(null);
                }
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
            for(int i = 0;producaoAnimalOrdenha.size() > i;i++)
            {
                String nomeNumero[] = {jFormattedTextField_Pesquisa.getText(), ""};
                if(JTable_Tabela.getId(nomeNumero) == producaoAnimalOrdenha.get(i).getId())
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
            for(int i = 0;producaoAnimalOrdenha.size() > i;i++)
            {
                String nomeNumero[] = {"", jFormattedTextField_Pesquisa.getText()};
                if(JTable_Tabela.getId(nomeNumero) == producaoAnimalOrdenha.get(i).getId())
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

