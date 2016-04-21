package Telas.FramePrincipal;

import Model.Animal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shelmo
 */
public class JTable_Tabela
{
    private static JTable jTable_Tabela;
    private static ArrayList<Animal> animalList;
    
    public JTable_Tabela(ArrayList<Animal> animalList)
    {
        this.animalList = animalList;
        jTable_Tabela = new JTable();
        TabelaAnimais();
    }
    
    private static void TabelaAnimais()
    {
        try
        {
            if (!animalList.isEmpty())
            {
                String[] nomeColunas = {"Nome", " Numero", "Raça", "Data de Nascimento", "Sexo", "Situação"};
                DefaultTableModel model = (DefaultTableModel) jTable_Tabela.getModel();
                model.setColumnIdentifiers(nomeColunas);
                model.setNumRows(0);
                for (Animal c : animalList)
                {
                    String sexo = null;
                    String situacao = null;
                    if(c.getSexo().equals("F"))
                        sexo = "Fêmea";
                    if(c.getSexo().equals("M"))
                        sexo = "Macho";
                    
                    if(c.getSituacao().equals("A"))
                        situacao = "Ativo";
                    if(c.getSituacao().equals("M"))
                        situacao = "Morte";
                    if(c.getSituacao().equals("V"))
                        situacao = "Venda";
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String format = sdf.format(c.getDataNasc());
                    model.addRow(new Object[]{c.getNome(), c.getNumero(), c.getRaca(), format, sexo, situacao});
                }
                
            }
        } catch (Exception e) {
            
        }
    }
    
    public static void addAnimal(Animal animal)
    {
        animalList.add(animal);
        TabelaAnimais();
    }

    public JTable getjTable_Tabela()
    {
        return jTable_Tabela;
    }
}
