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
public class JFrame_AlterarProducaoAnimalOrdenha extends JFrame_ProducaoDiaria
{
    private final ProducaoDiaria producaoAnimalOrdenha;
    private final int select;
    private final String nomeNumero[];
    
    public JFrame_AlterarProducaoAnimalOrdenha(ProducaoDiaria producaoAnimalOrdenha, int select)
    {
        super("");
        this.producaoAnimalOrdenha = producaoAnimalOrdenha;
        this.select = select;
        
        nomeNumero = JTable_Tabela.getNomeNumeroAnimal(this.producaoAnimalOrdenha.getIdAnimal());
        String format = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        format = sdf.format(producaoAnimalOrdenha.getData());
        
        getjLabel_Titulo().setText("Alterar produção diária por animal");
        getjButton_Confirmar().setText("Salvar Alterações");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        
        getjTextField_Nome().setText(nomeNumero[0]);
        getjFormattedTextField_Numero().setText(nomeNumero[1]);
        
        
        getjFormattedTextField_Data().setText(format);
        getjFormattedTextField_QtdLitros().setText(String.valueOf(producaoAnimalOrdenha.getQntLitros()));
    }
    public void Confirmar()
    {
        ClearJLabel();
        
        nomeNumero[0] = getjTextField_Nome().getText();
        nomeNumero[1] = getjFormattedTextField_Numero().getText();
        
        
        producaoAnimalOrdenha.setIdAnimal(JTable_Tabela.getId(nomeNumero));
        
        try
        {
            java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(getjFormattedTextField_Data().getText());
            Date data = new Date(dataUtil.getTime());
            producaoAnimalOrdenha.setData(data);
        }
        catch (ParseException ex)
        {
            getjLabel_ErroData().setText("Data inválida!");
            return;
        }
        
        producaoAnimalOrdenha.setQntLitros(parseDouble(getjFormattedTextField_QtdLitros().getText()));
        
        if(Verificacao(producaoAnimalOrdenha))
        {
            ProducaoDiariaDAO.atualizarProducao(producaoAnimalOrdenha);
            JTable_Tabela.setProducaoAnimalOrdenha(producaoAnimalOrdenha, select);
        }
        else
            return;
        
        dispose();
    }
}
