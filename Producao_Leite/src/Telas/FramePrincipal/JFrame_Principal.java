package Telas.FramePrincipal;

import DAO.AnimalDAO;
import Model.Animal;
import Telas.FramesAnimais.JFrame_CadastrarAnimais;
import Telas.JFrame_Base;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public class JFrame_Principal extends JFrame_Base
{
    private ArrayList<Animal> animalList;
    
    private JButton jButton_Plantel;
    private JButton jButton_CadastrarAnimal;
    private JButton jButton_AlterarAnimal;
    private JButton jButton_RemoverAnimal;
    private JButton jButton_LocalizarAnimal;
    
    private JScrollPane jScrollPane_BaseTabela;
    
    private JTable jTable_Tabela;
    private JTable_Tabela tabela;
    
    public JFrame_Principal()
    {
        super();
        setSize(1920, 1080);
        Componentes();
    }
    
    public void Componentes()
    {
        //Iniciar Componentes
        jButton_Plantel = new JButton();
        jButton_CadastrarAnimal = new JButton();
        jButton_AlterarAnimal = new JButton();
        jButton_RemoverAnimal = new JButton();
        jButton_LocalizarAnimal = new JButton();
        
        //Texto Componentes
        jButton_CadastrarAnimal.setText("+");
        jButton_AlterarAnimal.setText("A");
        jButton_RemoverAnimal.setText("-");
        jButton_LocalizarAnimal.setText("L");
        jButton_Plantel.setText("Plantel");
        
        //Visibilidade Componentes
        jButton_CadastrarAnimal.setVisible(false);
        jButton_AlterarAnimal.setVisible(false);
        jButton_RemoverAnimal.setVisible(false);
        jButton_LocalizarAnimal.setVisible(false);
        getjButton_Confirmar().setVisible(false);
        
        getjPanel_NORTH().add(jButton_Plantel);
        
        //jPanel_CENTER adicionando Botões
        getCons().fill = GridBagConstraints.NONE;  
        getCons().anchor = GridBagConstraints.NORTHWEST;  
        getCons().insets = new Insets(10,10,10,10);
        
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
        
        //Ação Botões
        //Botão Plantel
        jButton_Plantel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                animalList = AnimalDAO.getListaAnimais();
                jButton_CadastrarAnimal.setVisible(true);
                jButton_AlterarAnimal.setVisible(true);
                jButton_LocalizarAnimal.setVisible(true);
                jButton_RemoverAnimal.setVisible(true);
                add();
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
        
        //Botão 
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
