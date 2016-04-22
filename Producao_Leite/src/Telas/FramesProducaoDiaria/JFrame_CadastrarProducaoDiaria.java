package Telas.FramesProducaoDiaria;

import DAO.AnimalDAO;
import DAO.ProducaoDiariaDAO;
import Model.Animal;
import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import static java.lang.Double.parseDouble;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Shelmo
 */
public class JFrame_CadastrarProducaoDiaria extends JFrame_ProducaoDiaria
{
    private String nomeNumero[];
    
    public JFrame_CadastrarProducaoDiaria()
    {
        super();
        this.nomeNumero = new String[2];
        getjLabel_Titulo().setText("Cadastrar produção diária por animal");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser preenchidos ou marcados!");
    }
    
    public void Confirmar()
    {
        ClearJLabel();
        ProducaoDiaria pd = new ProducaoDiaria();
         
        nomeNumero[0] = getjTextField_Nome().getText();
        nomeNumero[1] = getjFormattedTextField_Numero().getText();
        
        
        pd.setIdAnimal(JTable_Tabela.getId(nomeNumero));
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
