package Telas.FramePrincipal;

import DAO.AnimalDAO;
import Model.Animal;
import Telas.FramesAnimais.JFrame_AlterarAnimais;
import Telas.FramesAnimais.JFrame_CadastrarAnimais;
import Telas.FramesAnimais.JFrame_PesquisarAnimais;
import Telas.FramesAnimais.JFrame_RemoverAnimais;
import Telas.FramesProducaoDiaria.JFrame_CadastrarProducaoDiaria;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_Principal extends JFrame_Base
{
    private ArrayList<Animal> animalList;
    
    private JButton jButton_Plantel;
    private JButton jButton_ProducaoOrdenha;
    private JButton jButton_CadastrarAnimal;
    private JButton jButton_AlterarAnimal;
    private JButton jButton_RemoverAnimal;
    private JButton jButton_LocalizarAnimal;
    
    private JScrollPane jScrollPane_BaseTabela;
    
    private JTable_Tabela tabela;
    
    public JFrame_Principal()
    {
        super("src\\Telas\\FramePrincipal\\dairy.jpg");
        setSize(1920, 1080);
        Componentes();
    }
    
    public void Componentes()
    {
        //Iniciar Componentes
        jButton_Plantel = new JButton();
        jButton_ProducaoOrdenha = new JButton();
        jButton_CadastrarAnimal = new JButton();
        jButton_AlterarAnimal = new JButton();
        jButton_RemoverAnimal = new JButton();
        jButton_LocalizarAnimal = new JButton();
        
        //Texto Componentes
        Icon add = new ImageIcon("src\\Telas\\FramePrincipal\\add.png");
        jButton_CadastrarAnimal.setIcon(add);
        Icon update = new ImageIcon("src\\Telas\\FramePrincipal\\update.png");
        jButton_AlterarAnimal.setIcon(update);
        Icon remove = new ImageIcon("src\\Telas\\FramePrincipal\\remove.png");
        jButton_RemoverAnimal.setIcon(remove);
        Icon search = new ImageIcon("src\\Telas\\FramePrincipal\\search.png");
        jButton_LocalizarAnimal.setIcon(search);
        jButton_Plantel.setText("Plantel");
        jButton_ProducaoOrdenha.setText("Produção/Animal/Ordenha");
        getjButton_Voltar().setText("Fechar");
        
        //Visibilidade Componentes
        jButton_CadastrarAnimal.setVisible(false);
        jButton_AlterarAnimal.setVisible(false);
        jButton_RemoverAnimal.setVisible(false);
        jButton_LocalizarAnimal.setVisible(false);
        getjButton_Confirmar().setVisible(false);
        
        getjPanel_NORTH().add(jButton_Plantel);
        getjPanel_NORTH().add(jButton_ProducaoOrdenha);

        
        //Ação Botões
        //Botão Plantel
        jButton_Plantel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                getjPanel_CENTER().removeAll();
                //jPanel_CENTER adicionando Botões
                getCons().fill = GridBagConstraints.NONE;
                getCons().anchor = GridBagConstraints.NORTHWEST;
                getCons().insets = new Insets(10, 10, 10, 10);

                //Linha 0
                getCons().gridx = 0;
                getCons().gridy = 0;
                getjPanel_CENTER().add(jButton_CadastrarAnimal, getCons());
                getCons().gridx = 1;
                getjPanel_CENTER().add(jButton_RemoverAnimal, getCons());
                getCons().gridx = 2;
                getjPanel_CENTER().add(jButton_AlterarAnimal, getCons());
                getCons().gridx = 3;
                getjPanel_CENTER().add(jButton_LocalizarAnimal, getCons());
                
                animalList = AnimalDAO.getListaAnimais();
                jButton_CadastrarAnimal.setVisible(true);
                jButton_AlterarAnimal.setVisible(true);
                jButton_LocalizarAnimal.setVisible(true);
                jButton_RemoverAnimal.setVisible(true);
                add();
            }
        });
        
        //Botão Produção/Animal/Ordenha
        jButton_ProducaoOrdenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                getjPanel_CENTER().removeAll();
                new JFrame_CadastrarProducaoDiaria();
            }
        });
        
        //Botão CadastrarAnimal
        jButton_CadastrarAnimal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                new JFrame_CadastrarAnimais();
            }
        });
        
        //Botão Remover
        jButton_RemoverAnimal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                int select = tabela.getjTable_Tabela().getSelectedRow();
                if(select == -1)
                {
                    JOptionPane.showMessageDialog(null,"Nunhum campo selecionado!", "Erro!", 2);
                    return;
                }
                Animal animal = new Animal();
                animal.setId(animalList.get(select).getId());
                animal.setNome(animalList.get(select).getNome());
                animal.setNumero(animalList.get(select).getNumero());
                animal.setRaca(animalList.get(select).getRaca());
                animal.setDataNasc(animalList.get(select).getDataNasc());
                animal.setSexo(animalList.get(select).getSexo());
                animal.setSituacao(animalList.get(select).getSituacao());
                new JFrame_RemoverAnimais(animal, select);
            }
        });
        
        //Botão Alterar
        jButton_AlterarAnimal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                int select = tabela.getjTable_Tabela().getSelectedRow();
                if(select == -1)
                {
                    JOptionPane.showMessageDialog(null,"Nunhum campo selecionado!", "Erro!", 2);
                    return;
                }
                Animal animal = new Animal();
                animal.setId(animalList.get(select).getId());
                animal.setNome(animalList.get(select).getNome());
                animal.setNumero(animalList.get(select).getNumero());
                animal.setRaca(animalList.get(select).getRaca());
                animal.setDataNasc(animalList.get(select).getDataNasc());
                animal.setSexo(animalList.get(select).getSexo());
                animal.setSituacao(animalList.get(select).getSituacao());
                new JFrame_AlterarAnimais(animal, select);
            }
        });
        
        //Botão Localizar
        jButton_LocalizarAnimal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                new JFrame_PesquisarAnimais(animalList);
            }
        });
    }

    
    public void add()
    {
        tabela = new JTable_Tabela(animalList);
        
        jScrollPane_BaseTabela = new JScrollPane(tabela.getjTable_Tabela());
          
        getCons().weighty = 1;  
        getCons().gridheight = GridBagConstraints.REMAINDER;  
          
        getCons().fill = GridBagConstraints.BOTH;  
        getCons().weightx = 1;  
        getCons().gridwidth = GridBagConstraints.REMAINDER;
        getCons().gridy = 1;
        getCons().gridx = 0;
        getjPanel_CENTER().add(jScrollPane_BaseTabela, getCons());
    }
    
    public void Confirmar(){}
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFrame_Principal();
            }
        });
    }
}
