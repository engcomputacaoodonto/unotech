package Telas.FramePrincipal;

import Model.Animal;
import Model.ColetaLeite;
import Model.Empresa;
import Model.ProducaoDiaria;
import Telas.FrameColetaLeite.JFrame_AlterarColetaLeite;
import Telas.FrameColetaLeite.JFrame_CadastrarColetaLeite;
import Telas.FrameColetaLeite.JFrame_LocalizarColetaLeite;
import Telas.FrameColetaLeite.JFrame_RemoverColetaLeite;
import Telas.FrameEmpresa.JFrame_AlterarEmpresa;
import Telas.FrameEmpresa.JFrame_CadastrarEmpresa;
import Telas.FrameEmpresa.JFrame_LocalizarEmpresa;
import Telas.FrameEmpresa.JFrame_RemoverEmpresa;
import Telas.FramesAnimais.JFrame_AlterarAnimais;
import Telas.FramesAnimais.JFrame_CadastrarAnimais;
import Telas.FramesAnimais.JFrame_PesquisarAnimais;
import Telas.FramesAnimais.JFrame_RemoverAnimais;
import Telas.FramesProducaoDiaria.JFrame_AlterarProducaoAnimalOrdenha;
import Telas.FramesProducaoDiaria.JFrame_CadastrarProducaoDiaria;
import Telas.FramesProducaoDiaria.JFrame_PesquisarProducaoAnimalOrdenha;
import Telas.FramesProducaoDiaria.JFrame_RemoverProducaoAnimalOrdenha;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_Principal extends JFrame_Base
{
    private boolean PlantelSelecionado;
    private boolean ProducaoAnimalOrdenhaSelecionado;
    private boolean EmpresaSelecionado;
    private boolean ColetaLeiteSelecionado;
    
    private final int PLANTEL = 0;
    private final int PRODUCAOANIMALORDENHA = 1;
    private final int EMPRESA = 2;
    private final int COLETALEITE = 3;
    
    private JButton jButton_Plantel;
    private JButton jButton_ProducaoOrdenha;
    private JButton jButton_Empresa;
    private JButton jButton_ColetaLeite;
    private JButton jButton_Add;
    private JButton jButton_Update;
    private JButton jButton_Remove;
    private JButton jButton_Search;
    private JButton jButton_Close;
    
    private JScrollPane jScrollPane_BaseTabela;
    
    private JTable_Tabela tabela;
    
    public JFrame_Principal()
    {
        super("src\\Telas\\FramePrincipal\\dairy.jpg");
        Componentes();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void Componentes()
    {
        //Iniciar Componentes
        jButton_Plantel = new JButton();
        jButton_ProducaoOrdenha = new JButton();
        jButton_Empresa = new JButton();
        jButton_ColetaLeite = new JButton();
        jButton_Add = new JButton();
        jButton_Update = new JButton();
        jButton_Remove = new JButton();
        jButton_Search = new JButton();
        jButton_Close = new JButton();
        
        //Texto e Icones em Componentes
        Icon add = new ImageIcon("src\\Telas\\FramePrincipal\\add.png");
        jButton_Add.setIcon(add);
        Icon update = new ImageIcon("src\\Telas\\FramePrincipal\\update.png");
        jButton_Update.setIcon(update);
        Icon remove = new ImageIcon("src\\Telas\\FramePrincipal\\remove.png");
        jButton_Remove.setIcon(remove);
        Icon search = new ImageIcon("src\\Telas\\FramePrincipal\\search.png");
        jButton_Search.setIcon(search);
        Icon close = new ImageIcon("src\\Telas\\FramePrincipal\\close.png");
        jButton_Close.setIcon(close);
        jButton_Plantel.setText("Plantel");
        jButton_Plantel.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButton_ProducaoOrdenha.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButton_Empresa.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButton_ColetaLeite.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButton_ProducaoOrdenha.setText("Produção/Animal/Ordenha");
        jButton_Empresa.setText("Laticínio");
        jButton_ColetaLeite.setText("Coleta de Leite");
        getjButton_Voltar().setText("Fechar");
        getjButton_Voltar().setFont(new java.awt.Font("Tahoma", 1, 18));
        
        
        //Visibilidade Componentes
        VisibilidadeBotoes(false);
        getjButton_Confirmar().setVisible(false);
        
        //Adicionar Botões
        getjPanel_NORTH().add(jButton_Plantel);
        getjPanel_NORTH().add(jButton_ProducaoOrdenha);
        getjPanel_NORTH().add(jButton_Empresa);
        getjPanel_NORTH().add(jButton_ColetaLeite);
        
        //Carregar dados
        tabela = new JTable_Tabela();
        
        
        //jPanel_CENTER adicionando Botões
        getCons().fill = GridBagConstraints.NONE;
        getCons().anchor = GridBagConstraints.NORTHEAST;
        getCons().insets = new Insets(10, 10, 10, 10);

        //Linha 0
        getCons().gridwidth = 1;
        getCons().gridheight = 1;
        getCons().weightx = 0;
        getCons().weighty = 0;
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jButton_Add, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jButton_Remove, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jButton_Update, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jButton_Search, getCons());
        getCons().gridx = 4;
        getjPanel_CENTER().add(jButton_Close, getCons());

        
        //Ação Botões
        //Botão Plantel
        jButton_Plantel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MostrarTabela(PLANTEL);
            }
        });
        
        //Botão Produção/Animal/Ordenha
        jButton_ProducaoOrdenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MostrarTabela(PRODUCAOANIMALORDENHA);
            }
        });
        
        //Botão Empresa
        jButton_Empresa.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MostrarTabela(EMPRESA);
            }
        });
        
        //Botão ColetaLeite
        jButton_ColetaLeite.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MostrarTabela(COLETALEITE);
            }
        });
        
        //Botão Add
        jButton_Add.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(PlantelSelecionado)
                    new JFrame_CadastrarAnimais();
                
                if(ProducaoAnimalOrdenhaSelecionado)
                    new JFrame_CadastrarProducaoDiaria();
                
                if(EmpresaSelecionado)
                    new JFrame_CadastrarEmpresa();
                
                if(ColetaLeiteSelecionado)
                    new JFrame_CadastrarColetaLeite();
            }
        });
        
        //Botão Remover
        jButton_Remove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(PlantelSelecionado)
                    Remover(PLANTEL);
                
                if(ProducaoAnimalOrdenhaSelecionado)
                    Remover(PRODUCAOANIMALORDENHA);
                
                if(EmpresaSelecionado)
                    Remover(EMPRESA);
                
                if(ColetaLeiteSelecionado)
                    Remover(COLETALEITE);
            }
        });
        
        
        //Botão Alterar
        jButton_Update.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(PlantelSelecionado)
                    Alterar(PLANTEL);
                
                if(ProducaoAnimalOrdenhaSelecionado)
                    Alterar(PRODUCAOANIMALORDENHA);
                
                if(EmpresaSelecionado)
                    Alterar(EMPRESA);
                
                if(ColetaLeiteSelecionado)
                    Alterar(COLETALEITE);
            }
        });
        
        //Botão Localizar
        jButton_Search.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(PlantelSelecionado)
                    new JFrame_PesquisarAnimais();
                
                if(ProducaoAnimalOrdenhaSelecionado)
                    new JFrame_PesquisarProducaoAnimalOrdenha();
                
                if(EmpresaSelecionado)
                    new JFrame_LocalizarEmpresa();
                
                if(ColetaLeiteSelecionado)
                    new JFrame_LocalizarColetaLeite();
            }
        });
        
        //Botão Close
        jButton_Close.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LimparTela();
            }
        });
        
        //Click duplo na Tabela
        JTable_Tabela.getjTable_Tabela().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                if(evt.getClickCount() == 2)
                {
                    if(PlantelSelecionado)
                        Alterar(PLANTEL);
                    if(ProducaoAnimalOrdenhaSelecionado)
                        Alterar(PRODUCAOANIMALORDENHA);
                    if(EmpresaSelecionado)
                        Alterar(EMPRESA);
                    if(ColetaLeiteSelecionado)
                        Alterar(COLETALEITE);
                }
            }
        });
    }
    
    private int SelecionarTabela()
    {
        int select = tabela.getjTable_Tabela().getSelectedRow();
        if (select == -1)
            JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
        
        return select;
        
    }
    
    private void Alterar(int constante)
    {
        int select = SelecionarTabela();
        
        if(select == -1)
            return;
        
        if(constante == 0)
        {
            Animal animal = JTable_Tabela.getAnimalList().get(select);
            new JFrame_AlterarAnimais(animal, select);
        }
        
        if(constante == 1)
        {
            ProducaoDiaria pao = JTable_Tabela.getProducaoAnimalOrdenha().get(select);
            new JFrame_AlterarProducaoAnimalOrdenha(pao, select);
        }
        
        if(constante == 2)
        {
            Empresa empresa = JTable_Tabela.getEmpresa().get(select);
            new JFrame_AlterarEmpresa(empresa, select);
        }
        
        if(constante == 3)
        {
            ColetaLeite coletaLeite = JTable_Tabela.getColetaLeite().get(select);
            new JFrame_AlterarColetaLeite(coletaLeite, select);
        }
    }
    
    private void Remover(int constante)
    {
        int select = SelecionarTabela();
        
        if(select == -1)
            return;
        
        if(constante == 0)
        {
            Animal animal = JTable_Tabela.getAnimalList().get(select);
            new JFrame_RemoverAnimais(animal, select);
        }
        
        if(constante == 1)
        {
            ProducaoDiaria pao = JTable_Tabela.getProducaoAnimalOrdenha().get(select);
            new JFrame_RemoverProducaoAnimalOrdenha(pao, select);
        }
        
        if(constante == 2)
        {
            Empresa empresa = JTable_Tabela.getEmpresa().get(select);
            new JFrame_RemoverEmpresa(empresa, select);
        }
        
        if(constante == 3)
        {
            ColetaLeite coletaLeite = JTable_Tabela.getColetaLeite().get(select);
            new JFrame_RemoverColetaLeite(coletaLeite, select);
        }
    }
    
    private void MontarJPanelCentral(int constante)
    {
        if(jScrollPane_BaseTabela != null)
            LimparTela();
        VisibilidadeBotoes(true);
        TelaSelecionada(constante);
        getCons().gridy = 1;
        getCons().gridx = 0;
        jScrollPane_BaseTabela = new JScrollPane(JTable_Tabela.getjTable_Tabela());
        
        getCons().fill = GridBagConstraints.BOTH;  
        getCons().weightx = 1;  
        getCons().gridwidth = GridBagConstraints.REMAINDER;
        getCons().weighty = 1;  
        getCons().gridheight = GridBagConstraints.REMAINDER;  
        getjPanel_CENTER().add(jScrollPane_BaseTabela, getCons());
    }
    
    private void MostrarTabela(int constante)
    {
        JTable_Tabela.SelecionarTabela(constante);
        MontarJPanelCentral(constante);
    }
    
    private void VisibilidadeBotoes(boolean visi)
    {
        jButton_Add.setVisible(visi);
        jButton_Close.setVisible(visi);
        jButton_Remove.setVisible(visi);
        jButton_Search.setVisible(visi);
        jButton_Update.setVisible(visi);
    }
    
    private void TelaSelecionada(int constante)
    {
        PlantelSelecionado = false;
        ProducaoAnimalOrdenhaSelecionado = false;
        EmpresaSelecionado = false;
        ColetaLeiteSelecionado = false;
        
        if(constante == 0)
            PlantelSelecionado = true;
        if(constante == 1)
            ProducaoAnimalOrdenhaSelecionado = true;
        if(constante == 2)
            EmpresaSelecionado = true;
        if(constante == 3)
            ColetaLeiteSelecionado = true;
    }
    
    private void LimparTela()
    {
        TelaSelecionada(-1);
        VisibilidadeBotoes(false);
        jScrollPane_BaseTabela.setVisible(false);
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
