package Telas.FrameColetaLeite;

import DAO.ColetaLeiteDAO;
import Model.ColetaLeite;
import Model.Empresa;
import Telas.FramePrincipal.JTable_Tabela;
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
    private final int select;
    
    public JFrame_AlterarColetaLeite(ColetaLeite coletaLeite, int select)
    {
        super("src\\Telas\\FrameColetaLeite\\updateColetaLeite.jpg");
        this.coletaLeite = coletaLeite;
        this.select = select;
        
        getjLabel_Titulo().setText("Alterar Coleta de Leite");
        getjButton_Confirmar().setText("Salvar Alterarções");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        
        String format = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        format = sdf.format(this.coletaLeite.getDataColeta());
        getjFormattedTextField_Data().setText(format);
        
        getjComboBox_Empresa().setSelectedIndex(JTable_Tabela.getIndexEmpresa(this.coletaLeite.getIdEmpresa()));
        
        getjFormattedTextField_QtdLitros().setText(String.valueOf(this.coletaLeite.getQtdLitros()));
        if(this.coletaLeite.getQualidade().equals("B"))
            getjCheckBox_LeiteBom().setSelected(true);
        if(this.coletaLeite.getQualidade().equals("A"))
            getjCheckBox_LeiteAcido().setSelected(true);
    }
    
    public void Confirmar()
    {
        LimparErros();
        
        coletaLeite.setQtdLitros(Integer.parseInt(getjFormattedTextField_QtdLitros().getText()));
        
        boolean verificacao = Verificacoes();
        
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
        
        if(verificacao)
        {
            Empresa empresa = (Empresa) getjComboBox_Empresa().getSelectedItem();
            coletaLeite.setIdEmpresa(empresa.getIdEmpresa());
            ColetaLeiteDAO.AlterarColetaLeite(coletaLeite);
            JTable_Tabela.setColetaLeite(coletaLeite, select);
        }
        else
            return;
        
        dispose();
    }
}
