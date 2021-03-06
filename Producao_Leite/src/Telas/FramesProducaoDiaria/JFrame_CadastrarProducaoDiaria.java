package Telas.FramesProducaoDiaria;

import DAO.ProducaoDiariaDAO;
import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import static java.lang.Double.parseDouble;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shelmo
 */
public class JFrame_CadastrarProducaoDiaria extends JFrame_ProducaoDiaria
{
    
    public JFrame_CadastrarProducaoDiaria()
    {
        super("src\\Telas\\FramesProducaoDiaria\\add_BackGround.jpg");
        getjLabel_Titulo().setText("Cadastrar produção por animal por ordenha");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser preenchidos ou marcados!");
    }
    
    public void Confirmar()
    {
        ClearJLabel();
        ProducaoDiaria pd = new ProducaoDiaria();
        
        pd.setIdAnimal(JTable_Tabela.getId(getjComboBox_Animal().getSelectedIndex()));
        try
        {
            java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(getjFormattedTextField_Data().getText());
            Date data = new Date(dataUtil.getTime());
            pd.setData(data);
        }
        catch (ParseException ex)
        {
            getjLabel_ErroData().setText("Data inválida!");
            return;
        }

        pd.setQntLitros(parseDouble(getjFormattedTextField_QtdLitros().getText()));
        
        if(Verificacao(pd))
        {
            ProducaoDiariaDAO.registrarProducao(pd);
            JTable_Tabela.addProducaoAnimalOrdenha(pd);
        }
        else
            return;
        
        ClearCampos();
    }
}
