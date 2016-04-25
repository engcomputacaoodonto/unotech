package Telas.FramesProducaoDiaria;

import DAO.ProducaoDiariaDAO;
import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverProducaoAnimalOrdenha extends JFrame_ProducaoDiaria
{
    private final ProducaoDiaria producaoAnimalOrdenha;
    private final int select;
    
    public JFrame_RemoverProducaoAnimalOrdenha(ProducaoDiaria producaoAnimalOrdenha, int select)
    {
        super("src\\Telas\\FramesProducaoDiaria\\Remove_BackGround.jpg");
        this.producaoAnimalOrdenha = producaoAnimalOrdenha;
        this.select = select;
        
        getjLabel_Titulo().setText("Remover Produção/Animal/Ordenha");
        getjButton_Confirmar().setText("Remover");
        getjLabel_Aviso().setText("Deseja realmente remover a produção de leite desse Animal?");
        
        getjComboBox_Animal().setSelectedIndex(JTable_Tabela.getIndex(producaoAnimalOrdenha.getIdAnimal()));
        String format = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        format = sdf.format(producaoAnimalOrdenha.getData());
        
        
        getjFormattedTextField_Data().setText(format);
        getjFormattedTextField_QtdLitros().setText(String.valueOf(producaoAnimalOrdenha.getQntLitros()));
        
        getjComboBox_Animal().setEnabled(false);
        getjFormattedTextField_Data().setEditable(false);
        getjFormattedTextField_Data().setEditable(false);
        getjFormattedTextField_QtdLitros().setEditable(false);
        getjCheckBox_DataAtual().setVisible(false);
    }
    
    public void Confirmar()
    {
        ProducaoDiariaDAO.removerProducao(producaoAnimalOrdenha);
        JTable_Tabela.removeProducaoAnimalOrdenha(select);
        dispose();
    }
}
