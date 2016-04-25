package Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.ParseException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Base extends javax.swing.JFrame
{
    private JPanel jPanel_SOUTH;
    private JPanel jPanel_NORTH;
    private JPanel jPanel_CENTER;
    private JLabel jLabel_Titulo;
    private JLabel jLabel_Background;
    private JButton jButton_Voltar;
    private JButton jButton_Confirmar;
    private GridBagConstraints cons;
    
    
    public JFrame_Base(String image)
    {
        JLabel_Background(new ImageIcon(image));
        componentes();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    private void componentes()
    {
        cons = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();  

        jLabel_Titulo = new JLabel();
        jButton_Voltar = new JButton();
        jButton_Confirmar = new JButton();
        
        jPanel_SOUTH = new JPanel();
        jPanel_NORTH = new JPanel();
        jPanel_CENTER = new JPanel();
        jPanel_CENTER.setOpaque(false);
        jPanel_SOUTH.setOpaque(false);
        jPanel_NORTH.setOpaque(false);

        
        
        jPanel_SOUTH.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanel_NORTH.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel_CENTER.setLayout(layout);

        
        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dispose();
            }
        });
        
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Confirmar();
            }
        });
        
        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        
        
        jPanel_SOUTH.add(jButton_Confirmar);
        jPanel_SOUTH.add(jButton_Voltar);
        jPanel_NORTH.add(jLabel_Titulo);
        jLabel_Background.setLayout(new BorderLayout());
        jLabel_Background.add(BorderLayout.SOUTH, jPanel_SOUTH);
        jLabel_Background.add(BorderLayout.NORTH, jPanel_NORTH);
        jLabel_Background.add(BorderLayout.CENTER, jPanel_CENTER);
        setSize(600, 400);
        setVisible(true);
    }
    
    private void JLabel_Background(ImageIcon img_bg)
    {
        Icon img_background = img_bg;
        jLabel_Background = new JLabel(img_background);
        setContentPane(jLabel_Background);
    }
    
    public JFormattedTextField setFormatNumero(JFormattedTextField jFormattedTextField_Numero)
    {
        try
        {
            MaskFormatter mask = new MaskFormatter("######");
            jFormattedTextField_Numero.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc)
        {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro!", 3);
        }
        
        return jFormattedTextField_Numero;
    }
    
    public JFormattedTextField setFormatNull(JFormattedTextField jFormattedTextField_Null)
    {
        jFormattedTextField_Null.setFormatterFactory(null);
        
        return jFormattedTextField_Null;
    }
    
    public JFormattedTextField setFormatData(JFormattedTextField jFormattedTextField_Data)
    {
        try
        {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
            jFormattedTextField_Data.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc)
        {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro!", 3);
        }
        
        return jFormattedTextField_Data;
    }

    public JFormattedTextField setFormatDecimal(JFormattedTextField jFormattedTextField_Decimal)
    {
        try
        {
            MaskFormatter mask = new MaskFormatter("##.##");
            mask.setPlaceholderCharacter('0');
            jFormattedTextField_Decimal.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc)
        {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro!", 3);
        }
        return jFormattedTextField_Decimal;
    }
    
    public JFormattedTextField setFormatTelefone(JFormattedTextField jFormattedTextField_Telefone)
    {
        try
        {
            MaskFormatter mask = new MaskFormatter("(##)####-####");
            mask.setPlaceholderCharacter('_');
            jFormattedTextField_Telefone.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc)
        {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro!", 3);
        }
        return jFormattedTextField_Telefone;
    }
    
    public JFormattedTextField setFormatCNPJ(JFormattedTextField jFormattedTextField_CNPJ)
    {
        try
        {
            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
            mask.setPlaceholderCharacter('_');
            jFormattedTextField_CNPJ.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc)
        {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro!", 3);
        }
        return jFormattedTextField_CNPJ;
    }
    
    public JPanel getjPanel_CENTER()
    {
        return jPanel_CENTER;
    }

    public JPanel getjPanel_NORTH()
    {
        return jPanel_NORTH;
    }

    public JLabel getjLabel_Titulo()
    {
        return jLabel_Titulo;
    }

    public GridBagConstraints getCons()
    {
        return cons;
    }

    public JButton getjButton_Confirmar()
    {
        return jButton_Confirmar;
    }

    public JButton getjButton_Voltar()
    {
        return jButton_Voltar;
    }

    public void setCons(GridBagConstraints cons)
    {
        this.cons = cons;
    }

    public abstract void Confirmar();
}
