package Telas.FrameColetaLeite;

import DAO.ColetaLeiteDAO;
import Model.ColetaLeite;
import Telas.FramePrincipal.JTable_Tabela;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverColetaLeite extends JFrame_ColetaLeite
{
    private final ColetaLeite coletaLeite;
    private final int select;
    
    public JFrame_RemoverColetaLeite(ColetaLeite coletaLeite, int select)
    {
        super("src\\Telas\\FrameColetaLeite\\removeColetaLeite.jpg");
        this.coletaLeite = coletaLeite;
        this.select = select;
        
        getjLabel_Titulo().setText("Remover Coleta de Leite");
        getjButton_Confirmar().setText("Remover");
        getjLabel_Aviso().setText("Deseja realmente remover essa Coleta de Leite?");
        
        String format = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        format = sdf.format(this.coletaLeite.getDataColeta());
        getjFormattedTextField_Data().setText(format);
        
        getjFormattedTextField_QtdLitros().setText(String.valueOf(this.coletaLeite.getQtdLitros()));
        getjComboBox_Empresa().setSelectedIndex(JTable_Tabela.getIndexEmpresa(this.coletaLeite.getIdEmpresa()));
        if(this.coletaLeite.getQualidade().equals("B"))
            getjCheckBox_LeiteBom().setSelected(true);
        if(this.coletaLeite.getQualidade().equals("A"))
            getjCheckBox_LeiteAcido().setSelected(true);
        
        getjComboBox_Empresa().setEnabled(false);
        getjFormattedTextField_Data().setEditable(false);
        getjFormattedTextField_QtdLitros().setEditable(false);
        getjCheckBox_LeiteBom().setEnabled(false);
        getjCheckBox_LeiteAcido().setEnabled(false);
        getjCheckBox_DataAtual().setVisible(false);
        getjButton_NovaEmpresa().setVisible(false);
    }
    
    public void Confirmar()
    {
        ColetaLeiteDAO.RemoverColetaLeite(coletaLeite);
        JTable_Tabela.removeColetaLeite(select);
        dispose();
    }
}
