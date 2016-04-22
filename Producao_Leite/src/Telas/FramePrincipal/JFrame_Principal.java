package Telas.FramePrincipal;

import DAO.AnimalDAO;
import DAO.ProducaoDiariaDAO;
import Model.Animal;
import Model.ProducaoDiaria;
import Telas.FramesAnimais.JFrame_AlterarAnimais;
import Telas.FramesAnimais.JFrame_CadastrarAnimais;
import Telas.FramesAnimais.JFrame_PesquisarAnimais;
import Telas.FramesAnimais.JFrame_RemoverAnimais;
import Telas.FramesProducaoDiaria.JFrame_AlterarProducaoAnimalOrdenha;
import Telas.FramesProducaoDiaria.JFrame_CadastrarProducaoDiaria;
import Telas.FramesProducaoDiaria.JFrame_RemoverProducaoAnimalOrdenha;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private ArrayList<ProducaoDiaria> producaoAnimalOrdenhaList;
    
    private JButton jButton_Plantel;
    private JButton jButton_ProducaoOrdenha;
    private JButton jButton_CadastrarAnimal;
    private JButton jButton_AlterarAnimal;
    private JButton jButton_RemoverAnimal;
    private JButton jButton_LocalizarAnimal;
    private JButton jButton_CadastrarProducaoOrdenha;
    private JButton jButton_AlterarProducaoOrdenha;
    private JButton jButton_RemoverProducaoOrdenha;
    private JButton jButton_LocalizarProducaoOrdenha;
    
    
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
        jButton_CadastrarProducaoOrdenha = new JButton();
        jButton_AlterarProducaoOrdenha = new JButton();
        jButton_RemoverProducaoOrdenha = new JButton();
        jButton_LocalizarProducaoOrdenha = new JButton();
        
        //Texto e Icones em Componentes
        Icon add = new ImageIcon("src\\Telas\\FramePrincipal\\add.png");
        jButton_CadastrarAnimal.setIcon(add);
        jButton_CadastrarProducaoOrdenha.setIcon(add);
        Icon update = new ImageIcon("src\\Telas\\FramePrincipal\\update.png");
        jButton_AlterarAnimal.setIcon(update);
        jButton_AlterarProducaoOrdenha.setIcon(update);
        Icon remove = new ImageIcon("src\\Telas\\FramePrincipal\\remove.png");
        jButton_RemoverAnimal.setIcon(remove);
        jButton_RemoverProducaoOrdenha.setIcon(remove);
        Icon search = new ImageIcon("src\\Telas\\FramePrincipal\\search.png");
        jButton_LocalizarAnimal.setIcon(search);
        jButton_LocalizarProducaoOrdenha.setIcon(search);
        jButton_Plantel.setText("Plantel");
        jButton_ProducaoOrdenha.setText("Produção/Animal/Ordenha");
        getjButton_Voltar().setText("Fechar");
        
        //Visibilidade Componentes
        BotoesAnimaisVisibilidade(false);
        BotoesProducaoOrdenhaVisibilidade(false);
        getjButton_Confirmar().setVisible(false);
        
        //Adicionar Botões
        getjPanel_NORTH().add(jButton_Plantel);
        getjPanel_NORTH().add(jButton_ProducaoOrdenha);
        
        //Carregar dados
        animalList = AnimalDAO.getListaAnimais();
        producaoAnimalOrdenhaList = ProducaoDiariaDAO.getListaProducaoDiaria();
        tabela = new JTable_Tabela(animalList, producaoAnimalOrdenhaList);

        
        //Ação Botões
        //Botão Plantel
        jButton_Plantel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                getjPanel_CENTER().removeAll();
                BotoesProducaoOrdenhaVisibilidade(false);
                //jPanel_CENTER adicionando Botões
                getCons().fill = GridBagConstraints.NONE;
                getCons().anchor = GridBagConstraints.NORTHWEST;
                getCons().insets = new Insets(10, 10, 10, 10);

                //Linha 0
                getCons().gridwidth = 1;
                getCons().gridheight = 1;
                getCons().weightx = 0;
                getCons().weighty = 0;
                getCons().gridx = 0;
                getCons().gridy = 0;
                getjPanel_CENTER().add(jButton_CadastrarAnimal, getCons());
                getCons().gridx = 1;
                getjPanel_CENTER().add(jButton_RemoverAnimal, getCons());
                getCons().gridx = 2;
                getjPanel_CENTER().add(jButton_AlterarAnimal, getCons());
                getCons().gridx = 3;
                getjPanel_CENTER().add(jButton_LocalizarAnimal, getCons());
                getCons().gridy = 1;
                getCons().gridx = 0;
                
                BotoesAnimaisVisibilidade(true);
                addAnimais();
            }
        });
        
        //Botão Produção/Animal/Ordenha
        jButton_ProducaoOrdenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                getjPanel_CENTER().removeAll();
                BotoesAnimaisVisibilidade(false);
                //jPanel_CENTER adicionando Botões
                getCons().fill = GridBagConstraints.NONE;
                getCons().anchor = GridBagConstraints.NORTHWEST;
                getCons().insets = new Insets(10, 10, 10, 10);

                //Linha 0
                getCons().gridwidth = 1;
                getCons().gridheight = 1;
                getCons().weightx = 0;
                getCons().weighty = 0;
                getCons().gridx = 0;
                getCons().gridy = 0;
                getjPanel_CENTER().add(jButton_CadastrarProducaoOrdenha, getCons());
                getCons().gridx = 1;
                getjPanel_CENTER().add(jButton_RemoverProducaoOrdenha, getCons());
                getCons().gridx = 2;
                getjPanel_CENTER().add(jButton_AlterarProducaoOrdenha, getCons());
                getCons().gridx = 3;
                getjPanel_CENTER().add(jButton_LocalizarProducaoOrdenha, getCons());
                getCons().gridy = 1;
                getCons().gridx = 0;
                
                BotoesProducaoOrdenhaVisibilidade(true);
                addProducaoAnimalOrdenha();
            }
        });
        
        //Botão Cadastrar
        jButton_CadastrarAnimal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                new JFrame_CadastrarAnimais();
            }
        });
        
        jButton_CadastrarProducaoOrdenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                new JFrame_CadastrarProducaoDiaria();
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
        
        jButton_RemoverProducaoOrdenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                int select = tabela.getjTable_Tabela().getSelectedRow();
                if(select == -1)
                {
                    JOptionPane.showMessageDialog(null,"Nunhum campo selecionado!", "Erro!", 2);
                    return;
                }
                ProducaoDiaria pao = new ProducaoDiaria();
                pao.setId(producaoAnimalOrdenhaList.get(select).getId());
                pao.setIdAnimal(producaoAnimalOrdenhaList.get(select).getIdAnimal());
                pao.setData(producaoAnimalOrdenhaList.get(select).getData());
                pao.setQntLitros(producaoAnimalOrdenhaList.get(select).getQntLitros());
                new JFrame_RemoverProducaoAnimalOrdenha(pao, select);
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
        
        jButton_AlterarProducaoOrdenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                int select = tabela.getjTable_Tabela().getSelectedRow();
                if(select == -1)
                {
                    JOptionPane.showMessageDialog(null,"Nunhum campo selecionado!", "Erro!", 2);
                    return;
                }
                ProducaoDiaria pao = new ProducaoDiaria();
                pao.setId(producaoAnimalOrdenhaList.get(select).getId());
                pao.setIdAnimal(producaoAnimalOrdenhaList.get(select).getIdAnimal());
                pao.setData(producaoAnimalOrdenhaList.get(select).getData());
                pao.setQntLitros(producaoAnimalOrdenhaList.get(select).getQntLitros());
                new JFrame_AlterarProducaoAnimalOrdenha(pao, select);
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

    
    private void addAnimais()
    {
        tabela.setTabelaAnimais();
        JScrollPane jScrollPane_BaseTabela = new JScrollPane(tabela.getjTable_Tabela());
          
        getCons().fill = GridBagConstraints.BOTH;  
        getCons().weightx = 1;  
        getCons().gridwidth = GridBagConstraints.REMAINDER;
        getCons().weighty = 1;  
        getCons().gridheight = GridBagConstraints.REMAINDER;  
        getjPanel_CENTER().add(jScrollPane_BaseTabela, getCons());
    }
    
    private void addProducaoAnimalOrdenha()
    {
        tabela.setTabelaProducaoAnimalOrdenha();
        JScrollPane jScrollPane_BaseTabela = new JScrollPane(tabela.getjTable_Tabela());
          
        getCons().fill = GridBagConstraints.BOTH;  
        getCons().weightx = 1;  
        getCons().gridwidth = GridBagConstraints.REMAINDER;
        getCons().weighty = 1;  
        getCons().gridheight = GridBagConstraints.REMAINDER;
        getjPanel_CENTER().add(jScrollPane_BaseTabela, getCons());
    }
    
    private void BotoesAnimaisVisibilidade(boolean visibilidade)
    {
        jButton_CadastrarAnimal.setVisible(visibilidade);
        jButton_AlterarAnimal.setVisible(visibilidade);
        jButton_RemoverAnimal.setVisible(visibilidade);
        jButton_LocalizarAnimal.setVisible(visibilidade);
    }
    
    private void BotoesProducaoOrdenhaVisibilidade(boolean visibilidade)
    {
        jButton_CadastrarProducaoOrdenha.setVisible(visibilidade);
        jButton_AlterarProducaoOrdenha.setVisible(visibilidade);
        jButton_RemoverProducaoOrdenha.setVisible(visibilidade);
        jButton_LocalizarProducaoOrdenha.setVisible(visibilidade);
    }
    
    public void Confirmar(){/*Método não necessário para essa classe*/}
    
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
