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
    
    public JFrame_AlterarProducaoAnimalOrdenha(ProducaoDiaria producaoAnimalOrdenha, int select)
    {
        super("src\\Telas\\FramesProducaoDiaria\\Update_BackGround.jpg");
        this.producaoAnimalOrdenha = producaoAnimalOrdenha;
        this.select = select;
        
        getjComboBox_Animal().setSelectedIndex(JTable_Tabela.getIndex(producaoAnimalOrdenha.getIdAnimal()));
        
        String format = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        format = sdf.format(producaoAnimalOrdenha.getData());
        
        getjLabel_Titulo().setText("Alterar produção diária por animal");
        getjButton_Confirmar().setText("Salvar Alterações");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        
        
        getjFormattedTextField_Data().setText(format);
        getjFormattedTextField_QtdLitros().setText(String.valueOf(producaoAnimalOrdenha.getQntLitros()));
    }
    public void Confirmar()
    {
        ClearJLabel();
        
        producaoAnimalOrdenha.setIdAnimal(JTable_Tabela.getId(getjComboBox_Animal().getSelectedIndex()));
        
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
