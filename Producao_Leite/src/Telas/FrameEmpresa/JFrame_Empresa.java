package Telas.FrameEmpresa;

import Telas.JFrame_Base;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Empresa extends JFrame_Base
{
    private JLabel jLabel_Nome;
    private JLabel jLabel_RazaoSocial;
    private JLabel jLabel_Cnpj;
    private JLabel jLabel_Telefone;
    private JLabel jLabel_Email;
    private JLabel jLabel_HomePage;
    private JLabel jLabel_Cidade;
    private JLabel jLabel_Bairro;
    private JLabel jLabel_Logradouro;
    private JLabel jLabel_Estado;
    private JLabel jLabel_Aviso;
    private JLabel jLabel_ErroNome;
    private JLabel jLabel_ErroRazaoSocial;
    private JLabel jLabel_ErroEmail;
    private JLabel jLabel_ErroHomePage;
    private JLabel jLabel_ErroCidade;
    private JLabel jLabel_ErroBairro;
    private JLabel jLabel_ErroLogradouro;
    private JLabel jLabel_ErroEstado;
    
    private JTextField jTextField_Nome;
    private JTextField jTextField_RazaoSocial;
    private JTextField jTextField_Email;
    private JTextField jTextField_HomePage;
    private JTextField jTextField_Cidade;
    private JTextField jTextField_Bairro;
    private JTextField jTextField_Logradouro;
    
    private JFormattedTextField jFormattedTextField_Cnpj;
    private JFormattedTextField jFormattedTextField_Teleone;
    
    private JComboBox jComboBox_Estado;
    
    public JFrame_Empresa(String Image)
    {
        super(Image);
        
        getjLabel_Titulo().setText("Teste");
        getjButton_Confirmar().setText("Salvar");
        Componentes();
    }
    
    public void Componentes()
    {
        //Criar Componentes
        jLabel_Aviso = new JLabel();
        jLabel_Bairro = new JLabel();
        jLabel_Cidade = new JLabel();
        jLabel_Cnpj = new JLabel();
        jLabel_Email = new JLabel();
        jLabel_Estado = new JLabel();
        jLabel_HomePage = new JLabel();
        jLabel_Logradouro = new JLabel();
        jLabel_Nome = new JLabel();
        jLabel_RazaoSocial = new JLabel();
        jLabel_Telefone = new JLabel();
        
        jLabel_ErroBairro = new JLabel();
        jLabel_ErroCidade = new JLabel();
        jLabel_ErroEmail = new JLabel();
        jLabel_ErroEstado = new JLabel();
        jLabel_ErroHomePage = new JLabel();
        jLabel_ErroLogradouro = new JLabel();
        jLabel_ErroNome = new JLabel();
        jLabel_ErroRazaoSocial = new JLabel();
        
        jTextField_Bairro = new JTextField(15);
        jTextField_Cidade = new JTextField(10);
        jTextField_Email = new JTextField(30);
        jTextField_HomePage = new JTextField(30);
        jTextField_Logradouro = new JTextField(10);
        jTextField_Nome = new JTextField(30);
        jTextField_RazaoSocial = new JTextField(30);
        
        jFormattedTextField_Cnpj = new JFormattedTextField();
        jFormattedTextField_Teleone = new JFormattedTextField();
        
        jComboBox_Estado = new JComboBox();
        
        //Nome de Campos
        jLabel_Nome.setText("Nome*:");
        jLabel_RazaoSocial.setText("Razão Social:");
        jLabel_Cnpj.setText("CNPJ:");
        jLabel_Telefone.setText("Telefone:");
        jLabel_Email.setText("E-mail:");
        jLabel_HomePage.setText("HomePage:");
        jLabel_Cidade.setText("Cidade:");
        jLabel_Bairro.setText("Bairro");
        jLabel_Logradouro.setText("Logradouro:");
        jLabel_Estado.setText("UF:");
        
        //Foreground Erros
        jLabel_ErroNome.setForeground(Color.red);
        jLabel_ErroRazaoSocial.setForeground(Color.red);
        jLabel_ErroEmail.setForeground(Color.red);
        jLabel_ErroHomePage.setForeground(Color.red);
        jLabel_ErroCidade.setForeground(Color.red);
        jLabel_ErroBairro.setForeground(Color.red);
        jLabel_ErroLogradouro.setForeground(Color.red);
        jLabel_ErroEstado.setForeground(Color.red);
        
        //Máscaras
        jFormattedTextField_Cnpj = setFormatCNPJ(jFormattedTextField_Cnpj);
        jFormattedTextField_Teleone = setFormatTelefone(jFormattedTextField_Teleone);
        
        //Linha 0
        getCons().gridx = 0;
        getCons().gridy = 0;
        getjPanel_CENTER().add(jLabel_Nome, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Nome, getCons());
        
        //Linha 1
        getCons().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroNome, getCons());
        
        //Linha 2
        getCons().gridx = 0;
        getCons().gridy = 2;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_RazaoSocial, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_RazaoSocial, getCons());
        
        //Linha 3
        getCons().gridy = 3;
        getjPanel_CENTER().add(jLabel_ErroRazaoSocial, getCons());
        
        //Linha 4
        getCons().gridx = 0;
        getCons().gridy = 4;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Cnpj, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_Cnpj, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jLabel_Telefone, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jFormattedTextField_Teleone, getCons());
        
        //Linha 6
        getCons().gridx = 0;
        getCons().gridy = 6;
        getjPanel_CENTER().add(jLabel_Email, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Email, getCons());
        
        //Linha 7
        getCons().gridy = 7;
        getjPanel_CENTER().add(jLabel_ErroEmail, getCons());
        
        //Linha 8
        getCons().gridx = 0;
        getCons().gridy = 8;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_HomePage, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_HomePage, getCons());
        
        //Linha 9
        getCons().gridy = 9;
        getjPanel_CENTER().add(jLabel_ErroHomePage, getCons());
        
        //Linha 10
        getCons().gridx = 0;
        getCons().gridy = 10;
        getCons().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Cidade, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jTextField_Cidade, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jLabel_Bairro, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jTextField_Bairro, getCons());
        
        //Linha 11
        getCons().gridx = 1;
        getCons().gridy = 11;
        getjPanel_CENTER().add(jLabel_ErroCidade, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jLabel_ErroBairro, getCons());
        
        //Linha 12
        getCons().gridx = 0;
        getCons().gridy = 12;
        getjPanel_CENTER().add(jLabel_Logradouro, getCons());
        getCons().gridx = 1;
        getjPanel_CENTER().add(jTextField_Logradouro, getCons());
        getCons().gridx = 2;
        getjPanel_CENTER().add(jLabel_Estado, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jComboBox_Estado, getCons());
        
        //Linha 13
        getCons().gridx = 1;
        getCons().gridy = 13;
        getjPanel_CENTER().add(jLabel_ErroLogradouro, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jLabel_ErroEstado, getCons());
        
        
        //Linha 14
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jLabel_Aviso, getCons());
        
        

        //Dados JComboBox
        jComboBox_Estado.addItem("--SELECIONE--");
        jComboBox_Estado.addItem("Acre");
        jComboBox_Estado.addItem("Alagoas");
        jComboBox_Estado.addItem("Amapá");
        jComboBox_Estado.addItem("Amazonas");
        jComboBox_Estado.addItem("Bahia");
        jComboBox_Estado.addItem("Ceará");
        jComboBox_Estado.addItem("Distrito Federal");
        jComboBox_Estado.addItem("Espirito Santo");
        jComboBox_Estado.addItem("Goiás");
        jComboBox_Estado.addItem("Maranhão");
        jComboBox_Estado.addItem("Mato Grosso");
        jComboBox_Estado.addItem("Mato Grosso do Sul");
        jComboBox_Estado.addItem("Minas Gerais");
        jComboBox_Estado.addItem("Pará");
        jComboBox_Estado.addItem("Paraíba");
        jComboBox_Estado.addItem("Paraná");
        jComboBox_Estado.addItem("Pernambuco");
        jComboBox_Estado.addItem("Piauí");
        jComboBox_Estado.addItem("Rio de Janeiro");
        jComboBox_Estado.addItem("Rio Grande do Norte");
        jComboBox_Estado.addItem("Rio Grande do Sul");
        jComboBox_Estado.addItem("Rondônia");
        jComboBox_Estado.addItem("Roraima");
        jComboBox_Estado.addItem("Santa Catarina");
        jComboBox_Estado.addItem("São Paulo");
        jComboBox_Estado.addItem("Sergipe");
        jComboBox_Estado.addItem("Tocantins");
    }
    
    public boolean Verificações()
    {
        boolean retorno = true;
        
        if(jTextField_Nome.getText().isEmpty())
        {
            jLabel_ErroNome.setText("O campo Nome é obrigatório!");
            retorno = false;
        }
        
        if(jTextField_Nome.getText().length() > 255)
        {
            jLabel_ErroNome.setText("O campo Nome deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(jTextField_RazaoSocial.getText().length() > 255)
        {
            jLabel_ErroRazaoSocial.setText("O campo Razão Social deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(jTextField_Bairro.getText().length() > 255)
        {
            jLabel_ErroBairro.setText("O campo Bairro deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(jTextField_Cidade.getText().length() > 255)
        {
            jLabel_ErroCidade.setText("O campo Cidade deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(jTextField_Email.getText().length() > 255)
        {
            jLabel_ErroEmail.setText("O campo E-mail deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(jTextField_HomePage.getText().length() > 255)
        {
            jLabel_ErroHomePage.setText("O campo HomePage deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        if(jTextField_Logradouro.getText().length() > 255)
        {
            jLabel_ErroLogradouro.setText("O campo Logradouro deve conter no máximo 255 caracteres!");
            retorno = false;
        }
        
        return retorno;
    }

    public void LimparErros()
    {
        jLabel_ErroBairro.setText(null);
        jLabel_ErroCidade.setText(null);
        jLabel_ErroEmail.setText(null);
        jLabel_ErroEstado.setText(null);
        jLabel_ErroHomePage.setText(null);
        jLabel_ErroLogradouro.setText(null);
        jLabel_ErroNome.setText(null);
        jLabel_ErroRazaoSocial.setText(null);
        jLabel_Estado.setText(null);
    }
    
    public void LimparCampos()
    {
        jTextField_Bairro.setText(null);
        jTextField_Cidade.setText(null);
        jTextField_Email.setText(null);
        jTextField_HomePage.setText(null);
        jTextField_Logradouro.setText(null);
        jTextField_Nome.setText(null);
        jTextField_RazaoSocial.setText(null);
        jFormattedTextField_Cnpj.setText(null);
        jFormattedTextField_Teleone.setText(null);
        jComboBox_Estado.setSelectedIndex(0);
    }
    
    public JLabel getjLabel_Aviso()
    {
        return jLabel_Aviso;
    }

    public JTextField getjTextField_Nome()
    {
        return jTextField_Nome;
    }

    public JTextField getjTextField_RazaoSocial()
    {
        return jTextField_RazaoSocial;
    }

    public JTextField getjTextField_Email()
    {
        return jTextField_Email;
    }

    public JTextField getjTextField_HomePage()
    {
        return jTextField_HomePage;
    }

    public JTextField getjTextField_Cidade()
    {
        return jTextField_Cidade;
    }

    public JTextField getjTextField_Bairro()
    {
        return jTextField_Bairro;
    }

    public JTextField getjTextField_Logradouro()
    {
        return jTextField_Logradouro;
    }

    public JFormattedTextField getjFormattedTextField_Cnpj()
    {
        return jFormattedTextField_Cnpj;
    }

    public JFormattedTextField getjFormattedTextField_Teleone()
    {
        return jFormattedTextField_Teleone;
    }

    public JComboBox getjComboBox_Estado()
    {
        return jComboBox_Estado;
    }
    
    public abstract void Confirmar();
}
