package Telas.FramesProducaoDiaria;

import Model.Animal;
import Mascaras.Mascaras;
import Model.ProducaoDiaria;
import Telas.FramePrincipal.JTable_Tabela;
import Telas.JFrame_BaseLocalizar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_PesquisarProducaoAnimalOrdenha extends JFrame_BaseLocalizar
{
    private final ArrayList<ProducaoDiaria> producaoAnimalOrdenha;
    
    public JFrame_PesquisarProducaoAnimalOrdenha()
    {
        super("src\\Telas\\FramesProducaoDiaria\\Search_BackGround.jpg");
        this.producaoAnimalOrdenha = JTable_Tabela.getProducaoAnimalOrdenha();
        getjCheckBox3().setVisible(false);
        getjCheckBox1().setText("Localizar por Nome");
        getjCheckBox2().setText("Localizar por Número");
    }
    
    private boolean Verificacoes()
    {
        if(getjFormattedTextField_Localizar().getText().length() == 0 ||
                getjFormattedTextField_Localizar().getText().equals("      "))
        {
            getjLabel_ErroLocalizar().setText("O campo Localizar deve ser preenchido!");
            return false;
        }
        if(getjFormattedTextField_Localizar().getText().length() > 255)
        {
            getjLabel_ErroLocalizar().setText("O campo Localizar deve conter no máximo 255 caracteres!");
            return false;
        }
        return true;
    }
    
    public void AcaoJCheckBox1()
    {
        setjFormattedTextField_Localizar(Mascaras.setFormat(getjFormattedTextField_Localizar(), null, Mascaras.NULO));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_Localizar(Mascaras.setFormat(getjFormattedTextField_Localizar(), "######", Mascaras.NULO));
        getjFormattedTextField_Localizar().setText(null);
    }
    
    public void AcaoJCheckBox3(){}
    
    public void Confirmar()
    {
        int linha = -1;
        if(Verificacoes() && getjCheckBox1().isSelected())
        {
            for(Animal a : JTable_Tabela.getAnimalList())
            {
                if(a.getNome().equalsIgnoreCase(getjFormattedTextField_Localizar().getText()))
                {
                    linha = JTable_Tabela.getIndexPAO(a.getId());
                    break;
                }
            }
            if(linha != -1)
            {
                JTable_Tabela.getjTable_Tabela().setRowSelectionInterval(linha, linha);
                JTable_Tabela.getjTable_Tabela().setColumnSelectionInterval(0, 0);
                dispose();
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Animal não encontrado!", "Erro!", 2);
            }
        }
        if(Verificacoes() && getjCheckBox2().isSelected())
        {
            for(Animal a : JTable_Tabela.getAnimalList())
            {
                if(a.getNumero().equals(getjFormattedTextField_Localizar().getText()))
                {
                    linha = JTable_Tabela.getIndexPAO(a.getId());
                    break;
                }
            }
            if(linha != -1)
            {
                JTable_Tabela.getjTable_Tabela().setRowSelectionInterval(linha, linha);
                JTable_Tabela.getjTable_Tabela().setColumnSelectionInterval(1, 1);
                dispose();
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Animal não encontrado!", "Erro!", 2);
            }
        }
    }
}

