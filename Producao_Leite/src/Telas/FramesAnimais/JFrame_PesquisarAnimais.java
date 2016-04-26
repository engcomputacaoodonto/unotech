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
import Telas.JFrame_BaseLocalizar;
import java.awt.Color;


/**
 *
 * @author Shelmo
 */
public class JFrame_PesquisarAnimais extends JFrame_BaseLocalizar
{
    private ArrayList<Animal> animalList;
    
    public JFrame_PesquisarAnimais()
    {
        super("src\\Telas\\FramesAnimais\\Search_BackGround.jpg");
        this.animalList = JTable_Tabela.getAnimalList();
        
        getjCheckBox3().setVisible(false);
        getjCheckBox1().setText("Localizar por Nome");
        getjCheckBox2().setText("Localizar por Número");
    }
    
    
    private boolean Verificações()
    {
        if(getjFormattedTextField_Localizar().getText().length() == 0 ||
                getjFormattedTextField_Localizar().getText().equals("      "))
        {
            getjLabel_ErroLocalizar().setText("O campo Localizar deve ser preenchido!");
            return false;
        }
        if(getjFormattedTextField_Localizar().getText().length() > 255)
        {
            getjLabel_ErroLocalizar().setText("O campo Localizar deve conter no máximo 255 caracteres!");
            return false;
        }
        return true;
    }
    
    public void AcaoJCheckBox1()
    {
        setjFormattedTextField_Localizar(setFormatNull(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_Localizar(setFormatNumero(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox3(){}
    
    public void Confirmar()
    {
        int linha = -1;
        if(Verificações() && getjCheckBox1().isSelected())
        {
            for(int i = 0;animalList.size() > i;i++)
            {
                if(animalList.get(i).getNome().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
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
        if(Verificações() && getjCheckBox2().isSelected())
        {
            for(int i = 0;animalList.size() > i;i++)
            {
                if(animalList.get(i).getNumero().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
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
