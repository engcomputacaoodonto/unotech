package Telas.FramesProducaoDiaria;

import DAO.AnimalDAO;
import DAO.ProducaoDiariaDAO;
import Model.Animal;
import Model.ProducaoDiaria;
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
    public JFrame_CadastrarProducaoDiaria()
    {
        super();
        getjLabel_Titulo().setText("Cadastrar produção diária por animal");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser preenchidos ou marcados!");
    }
    
    public void Confirmar()
    {
        ClearJLabel();
        ProducaoDiaria pd = new ProducaoDiaria();
        
        ArrayList<Animal> ListaAnimal = AnimalDAO.getListaAnimais(); 
        
        if(getjCheckBox_Nome().isSelected())
        {
            for(Animal a:ListaAnimal)
            { 
                if(a.getNome().equals(getjTextField_Nome().getText()))
                { 
                    pd.setIdAnimal(a.getId());
                    break;
                } 
            }
        }
        
        if(getjCheckBox_Numero().isSelected())
        {
            for(Animal a:ListaAnimal)
            { 
                if(a.getNumero().equals(getjFormattedTextField_Numero().getText()))
                { 
                    pd.setIdAnimal(a.getId());
                    break;
                } 
            }
        }
         
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
        }
        else
            return;
        
        ClearCampos();
    }
}
