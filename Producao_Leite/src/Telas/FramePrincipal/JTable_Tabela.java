package Telas.FramePrincipal;

import DAO.AnimalDAO;
import DAO.ColetaLeiteDAO;
import DAO.EmpresaDAO;
import DAO.ProducaoDiariaDAO;
import Model.Animal;
import Model.ColetaLeite;
import Model.Empresa;
import Model.ProducaoDiaria;
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
    private static ArrayList<Empresa> empresaList;
    private static ArrayList<ColetaLeite> coletaLeiteList;
    
    public JTable_Tabela()
    {
        JTable_Tabela.producaoAnimalOrdenhaList = ProducaoDiariaDAO.getListaProducaoDiaria();
        JTable_Tabela.animalList = AnimalDAO.getListaAnimais();
        JTable_Tabela.empresaList = EmpresaDAO.getListaEmpresa();
        JTable_Tabela.coletaLeiteList = ColetaLeiteDAO.getColetaLeite();
        jTable_Tabela = new JTable();
        jTable_Tabela.setFont(new java.awt.Font("Tahoma", 0, 15));
    }
    
    private static void TabelaAnimais()
    {
        try
        {
            jTable_Tabela.removeAll();
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
        }
        catch(Exception ex){}
    }
    
    private static void TabelaProducaoAnimalOrdenha()
    {
        try
        {
            jTable_Tabela.removeAll();
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
        }
        catch(Exception ex){}
    }
    
    private static void TabelaEmpresa()
    {
        try
        {
            jTable_Tabela.removeAll();
            if(!empresaList.isEmpty())
            {
                jTable_Tabela.getTableHeader().setReorderingAllowed(false);
                jTable_Tabela.setModel(new javax.swing.table.DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return false;
                    }

                });
                String[] nomeColunas = {"Nome", "Razão Social", "CNPJ", "E-mail", "Telefone", "HomePage", "Cidade", "Bairro", "Logradouro", "Estado"};
                DefaultTableModel model = (DefaultTableModel) jTable_Tabela.getModel();
                model.setColumnIdentifiers(nomeColunas);
                model.setNumRows(0);
                
                for (Empresa e : empresaList)
                {
                    model.addRow(new Object[]{e.getNomeFantasia(), e.getRazaoSocial(), e.getCnpj(), e.getEmail(),
                    e.getTelefone(), e.getHomePage(), e.getCidade(), e.getBairro(), e.getLogradouro(), e.getEstado()});
                }
            }
        }
        catch(Exception ex){}
    }
    
    private static void TabelaColetaLeite()
    {
        try
        {
            jTable_Tabela.removeAll();
            if (!coletaLeiteList.isEmpty())
            {
                jTable_Tabela.getTableHeader().setReorderingAllowed(false);
                jTable_Tabela.setModel(new javax.swing.table.DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return false;
                    }

                });
                String[] nomeColunas = {"Laticínio", " Data", "Litros Entregues", "Qualidade"};
                DefaultTableModel model = (DefaultTableModel) jTable_Tabela.getModel();
                model.setColumnIdentifiers(nomeColunas);
                model.setNumRows(0);
                for (ColetaLeite cl : coletaLeiteList)
                {
                    String format = null;
                    String nome = null;
                    String qualidade = null;
                    
                    for(int i = 0;i < empresaList.size();i++)
                    {
                        if(cl.getIdEmpresa() == empresaList.get(i).getIdEmpresa())
                        {
                            nome = empresaList.get(i).getNomeFantasia();
                            break;
                        }
                    }
                    
                    if(cl.getDataColeta()!= null)
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        format = sdf.format(cl.getDataColeta());
                    }
                    
                    if(cl.getQualidade().equals("B"))
                        qualidade = "Bom";
                    
                    if(cl.getQualidade().equals("A"))
                        qualidade = "Ácido";
                    
                    model.addRow(new Object[]{nome, format, cl.getQtdLitros(), qualidade});
                }
            }
        }
        catch(Exception ex){}
    }
    
    public static void SelecionarTabela(int constante)
    {
        if(constante == 0)
            TabelaAnimais();
        if(constante == 1)
            TabelaProducaoAnimalOrdenha();
        if(constante == 2)
            TabelaEmpresa();
        if(constante == 3)
            TabelaColetaLeite();
    }

    public static ArrayList<Animal> getAnimalList()
    {
        return animalList;
    }
    
    public static ArrayList<ProducaoDiaria> getProducaoAnimalOrdenha()
    {
        return producaoAnimalOrdenhaList;
    }
    
    public static ArrayList<Empresa> getEmpresa()
    {
        return empresaList;
    }
    
    public static ArrayList<ColetaLeite> getColetaLeite()
    {
        return coletaLeiteList;
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
    
    public static int getLinhaEmpresa(int id)
    {
        int i = 0;
        for(Empresa e : empresaList)
        {
            if(e.getIdEmpresa() == id)
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
    
     public static int getIndexEmpresa(int id)
    {
        int i = 0;
        for(Empresa e : empresaList)
        {
            if(e.getIdEmpresa() == id)
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
    
    public static void addColetaLeite(ColetaLeite coletaLeite)
    {
        coletaLeiteList.add(coletaLeite);
        TabelaColetaLeite();
    }
    
    public static void removeColetaLeite(int select)
    {
        coletaLeiteList.remove(select);
        TabelaColetaLeite();
    }
    
    public static void setColetaLeite(ColetaLeite coletaLeite, int select)
    {
        coletaLeiteList.set(select, coletaLeite);
        TabelaColetaLeite();
    }
    
    public static void addEmpresa(Empresa empresa)
    {
        empresaList.add(empresa);
        TabelaEmpresa();
    }
    
    public static void removeEmpresa(int select)
    {
        empresaList.remove(select);
        TabelaEmpresa();
    }
    
    public static void setEmpresa(Empresa empresa, int select)
    {
        empresaList.set(select, empresa);
        TabelaEmpresa();
    }

    public static JTable getjTable_Tabela()
    {
        return jTable_Tabela;
    }
}
