package Telas.FrameColetaLeite;

import Mascaras.Mascaras;
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
        super("src\\Telas\\FrameColetaLeite\\searchColetaLeite.jpg");
        
        this.coletaLeiteList = JTable_Tabela.getColetaLeite();
        
        getjCheckBox3().setVisible(false);
        getjCheckBox1().setText("Localizar por Empresa");
        getjCheckBox2().setText("Localizar por Data");
    }
    
    public void AcaoJCheckBox1()
    {
        setjFormattedTextField_Localizar(Mascaras.setFormat(getjFormattedTextField_Localizar(), null, Mascaras.NULO));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_Localizar(Mascaras.setFormat(getjFormattedTextField_Localizar(), "##/##/####", '_'));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox3(){}
    
    private boolean Verificacoes()
    {
        if(getjFormattedTextField_Localizar().getText().isEmpty() ||
                getjFormattedTextField_Localizar().getText().equals("__/__/____"))
        {
            getjLabel_ErroLocalizar().setText("O campo Localizar é obrigatório!");
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
        getjLabel_ErroLocalizar().setText(null);
        if(Verificacoes() && getjCheckBox1().isSelected())
        {
            for(Empresa e : JTable_Tabela.getEmpresa())
            {
                if(e.getNomeFantasia().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
                {
                    linha = JTable_Tabela.getLinhaEmpresa(e.getIdEmpresa());
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
                 JOptionPane.showMessageDialog(this, "Empresa não encontrada!", "Erro!", 2);
            }
        }
        
        if(Verificacoes() && getjCheckBox2().isSelected())
        {
            int i = 0;
            for(ColetaLeite cl : JTable_Tabela.getColetaLeite())
            {
                String format = null;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                format = sdf.format(cl.getDataColeta());
                if(getjFormattedTextField_Localizar().getText().equals(format))
                {
                    linha = i;
                }
                i++;
            }
            if(linha != -1)
            {
                JTable_Tabela.getjTable_Tabela().setRowSelectionInterval(linha, linha);
                JTable_Tabela.getjTable_Tabela().setColumnSelectionInterval(0, 0);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Data não encontrada!", "Erro!", 2);
            }
        }
    }
}
