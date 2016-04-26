package Telas.FrameColetaLeite;

import Model.Animal;
import Model.ColetaLeite;
import Model.Empresa;
import Telas.FramePrincipal.JTable_Tabela;
import Telas.JFrame_BaseLocalizar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarColetaLeite extends JFrame_BaseLocalizar
{
    private final ArrayList<ColetaLeite> coletaLeiteList;
    
    public JFrame_LocalizarColetaLeite()
    {
        super("");
        
        this.coletaLeiteList = JTable_Tabela.getColetaLeite();
        
        getjCheckBox3().setVisible(false);
        getjCheckBox1().setText("Localizar por Empresa");
        getjCheckBox2().setText("Localizar por Data");
    }
    
    public void AcaoJCheckBox1()
    {
        setjFormattedTextField_Localizar(setFormatNull(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_Localizar(setFormatData(getjFormattedTextField_Localizar()));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox3(){}
    
    private boolean Verificacoes()
    {
        return true;
    }
    
    public void Confirmar()
    {
        int linha = -1;
        if(Verificacoes() && getjCheckBox1().isSelected())
        {
            for(Empresa e : JTable_Tabela.getEmpresa())
            {
                if(e.getNomeFantasia().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
                {
                    linha = JTable_Tabela.getIndexPAO(e.getIdEmpresa());
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
        
        if(Verificacoes() && getjCheckBox2().isSelected())
        {
            for(ColetaLeite cl : JTable_Tabela.getColetaLeite())
            {
                String format = null;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                format = sdf.format(cl.getDataColeta());
                if(getjFormattedTextField_Localizar().getText().equalsIgnoreCase(format))
                {
                    
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
