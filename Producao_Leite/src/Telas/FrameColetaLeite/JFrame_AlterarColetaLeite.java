package Telas.FrameColetaLeite;

import DAO.ColetaLeiteDAO;
import Model.ColetaLeite;
import Model.Empresa;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarColetaLeite extends JFrame_ColetaLeite
{
    private final ColetaLeite coletaLeite;
    
    public JFrame_AlterarColetaLeite(ColetaLeite coletaLeite)
    {
        super("");
        this.coletaLeite = coletaLeite;
        
        getjLabel_Titulo().setText("Remover Coleta de Leite");
        getjButton_Confirmar().setText("Remover");
        getjLabel_Aviso().setText("Deseja realmente remover essa Coleta de Leite?");
        
        String format = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        format = sdf.format(this.coletaLeite.getDataColeta());
        getjFormattedTextField_Data().setText(format);
        
        getjFormattedTextField_QtdLitros().setText(String.valueOf(this.coletaLeite.getQtdLitros()));
        if(this.coletaLeite.getQualidade().equals("B"))
            getjCheckBox_LeiteBom().setSelected(true);
        if(this.coletaLeite.getQualidade().equals("A"))
            getjCheckBox_LeiteAcido().setSelected(true);
    }
    
    public void Confirmar()
    {
        ColetaLeite coletaLeite = new ColetaLeite();
        
        Empresa empresa = (Empresa) getjComboBox_Empresa().getSelectedItem();
        coletaLeite.setIdEmpresa(empresa.getIdEmpresa());
        coletaLeite.setQtdLitros(Integer.parseInt(getjFormattedTextField_QtdLitros().getText()));
        
        try
        {
            java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(getjFormattedTextField_Data().getText());
            Date data = new Date(dataUtil.getTime());
            coletaLeite.setDataColeta(data);
        }
        catch (ParseException ex)
        {
            getjLabel_ErroData().setText("Data inválida!");
            return;
        }
        
        if(getjCheckBox_LeiteBom().isSelected())
            coletaLeite.setQualidade("B");
        
        if(getjCheckBox_LeiteAcido().isSelected())
            coletaLeite.setQualidade("A");
        
        ColetaLeiteDAO.RegistrarColetaLeite(coletaLeite);
    }
}
