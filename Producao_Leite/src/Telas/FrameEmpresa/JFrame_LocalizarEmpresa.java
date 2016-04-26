package Telas.FrameEmpresa;

import Model.Empresa;
import Telas.FramePrincipal.JTable_Tabela;
import Telas.JFrame_BaseLocalizar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarEmpresa extends JFrame_BaseLocalizar
{
    private ArrayList<Empresa> empresaList;
    
    public JFrame_LocalizarEmpresa()
    {
        super("");
        this.empresaList = JTable_Tabela.getEmpresa();
        
        getjCheckBox1().setText("Localizar por Nome");
        getjCheckBox2().setText("Localizar por Razão Social");
        getjCheckBox3().setText("Localizar por CNPJ");
    }
    
    public void AcaoJCheckBox1()
    {
        setjFormattedTextField_Localizar(setFormatNull(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_Localizar(setFormatNull(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox3()
    {
        setjFormattedTextField_Localizar(setFormatCNPJ(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    private boolean Verificações()
    {
        if(getjFormattedTextField_Localizar().getText().length() == 0 ||
                getjFormattedTextField_Localizar().getText().equals("__.___.___/____-__"))
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
    
    public void Confirmar()
    {
        int linha = -1;
        if(Verificações() && getjCheckBox1().isSelected())
        {
            for(int i = 0;empresaList.size() > i;i++)
            {
                if(empresaList.get(i).getNomeFantasia().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
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
            for(int i = 0;empresaList.size() > i;i++)
            {
                if(empresaList.get(i).getRazaoSocial().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
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
        
        if(Verificações() && getjCheckBox3().isSelected())
        {
            for(int i = 0;empresaList.size() > i;i++)
            {
                if(empresaList.get(i).getCnpj().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
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
    }
}
