package Telas.FramePrincipal;

import Model.Animal;
import Model.ProducaoDiaria;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private static ArrayList<ProducaoDiaria> producaoAnimalOrdenhaList;
    
    public JTable_Tabela(ArrayList<Animal> animalList, ArrayList<ProducaoDiaria> producaoAnimalOrdenhaList)
    {
        JTable_Tabela.producaoAnimalOrdenhaList = producaoAnimalOrdenhaList;
        JTable_Tabela.animalList = animalList;
        jTable_Tabela = new JTable();
    }
    
    private static void TabelaAnimais()
    {
        try
        {
            if (!animalList.isEmpty())
            {
                jTable_Tabela.getTableHeader().setReorderingAllowed(false);
                jTable_Tabela.setModel(new javax.swing.table.DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return false;
                    }

                });
                String[] nomeColunas = {"Nome", " Numero", "Raça", "Data de Nascimento", "Sexo", "Situação"};
                DefaultTableModel model = (DefaultTableModel) jTable_Tabela.getModel();
                model.setColumnIdentifiers(nomeColunas);
                model.setNumRows(0);
                for (Animal c : animalList)
                {
                    String sexo = null;
                    String situacao = null;
                    String format = null;
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
                    
                    if(c.getDataNasc() != null)
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        format = sdf.format(c.getDataNasc());
                    }
                    model.addRow(new Object[]{c.getNome(), c.getNumero(), c.getRaca(), format, sexo, situacao});
                }
                
            }
        } catch (Exception e) {
            
        }
    }
    
    private static void TabelaProducaoAnimalOrdenha()
    {
        try
        {
            if (!animalList.isEmpty())
            {
                jTable_Tabela.getTableHeader().setReorderingAllowed(false);
                jTable_Tabela.setModel(new javax.swing.table.DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return false;
                    }

                });
                String[] nomeColunas = {"Nome", " Numero", "Data", "Litros Produzidos"};
                DefaultTableModel model = (DefaultTableModel) jTable_Tabela.getModel();
                model.setColumnIdentifiers(nomeColunas);
                model.setNumRows(0);
                for (ProducaoDiaria c : producaoAnimalOrdenhaList)
                {
                    String format = null;
                    String nome = null;
                    String numero = null;
                    
                    for(int i = 0;i < animalList.size();i++)
                    {
                        if(c.getIdAnimal() == animalList.get(i).getId())
                        {
                            nome = animalList.get(i).getNome();
                            numero = animalList.get(i).getNumero();
                            break;
                        }
                    }
                    
                    if(c.getData() != null)
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        format = sdf.format(c.getData());
                    }
                    model.addRow(new Object[]{nome, numero, format, c.getQntLitros()});
                }
                
            }
        } catch (Exception e) {
            
        }
    }
    
    public static void setTabelaAnimais()
    {
        TabelaAnimais();
    }
    
    public static void setTabelaProducaoAnimalOrdenha()
    {
        TabelaProducaoAnimalOrdenha();
    }

    public static ArrayList<Animal> getAnimalList()
    {
        return animalList;
    }
    
    public static int getId(int select)
    {
        return animalList.get(select).getId();
    }
    
    public static int getIndexPAO(int id)
    {
        int i = 0;
        for(ProducaoDiaria pao : producaoAnimalOrdenhaList)
        {
            if(pao.getIdAnimal() == id)
                return i;
            i++;
        }
        return -1;
    }
    
    public static int getIndex(int id)
    {
        int i = 0;
        for(Animal a : animalList)
        {
            if(a.getId() == id)
                return i;
            i++;
        }
        return i;
    }
    
    public static void addAnimal(Animal animal)
    {
        animalList.add(animal);
        TabelaAnimais();
    }
    
    public static void removeAnimal(int select)
    {
        animalList.remove(select);
        TabelaAnimais();
    }
    
    public static void setAnimal(Animal animal, int select)
    {
        animalList.set(select, animal);
        TabelaAnimais();
    }
    
    public static void addProducaoAnimalOrdenha(ProducaoDiaria producaoAnimalOrdenha)
    {
        producaoAnimalOrdenhaList.add(producaoAnimalOrdenha);
        TabelaProducaoAnimalOrdenha();
    }
    
    public static void removeProducaoAnimalOrdenha(int select)
    {
        producaoAnimalOrdenhaList.remove(select);
        TabelaProducaoAnimalOrdenha();
    }
    
    public static void setProducaoAnimalOrdenha(ProducaoDiaria producaoAnimalOrdenha, int select)
    {
        producaoAnimalOrdenhaList.set(select, producaoAnimalOrdenha);
        TabelaProducaoAnimalOrdenha();
    }

    public static JTable getjTable_Tabela()
    {
        return jTable_Tabela;
    }
}
