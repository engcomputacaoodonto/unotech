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
public class JFrame_CadastrarColetaLeite extends JFrame_ColetaLeite
{
    public JFrame_CadastrarColetaLeite()
    {
        super("src\\Telas\\FrameColetaLeite\\addColetaLeite.jpg");
        getjLabel_Titulo().setText("Registrar Coleta de Leite");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser preenchidos ou marcados!");
    }
    
    public void Confirmar()
    {
        LimparErros();
        ColetaLeite coletaLeite = new ColetaLeite();
        
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
            ColetaLeiteDAO.RegistrarColetaLeite(coletaLeite);
            JTable_Tabela.addColetaLeite(coletaLeite);
        }
        else
            return;
        
        LimparCampos();
    }
}
