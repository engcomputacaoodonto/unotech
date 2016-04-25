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
public class JFrame_Empresa extends JFrame_Base
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
    private JLabel jLabel_ErroCnpj;
    private JLabel jLabel_ErroTelefone;
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
    
    public JFrame_Empresa()
    {
        super("");
        
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
        jLabel_ErroCnpj = new JLabel();
        jLabel_ErroEmail = new JLabel();
        jLabel_ErroEstado = new JLabel();
        jLabel_ErroHomePage = new JLabel();
        jLabel_ErroLogradouro = new JLabel();
        jLabel_ErroNome = new JLabel();
        jLabel_ErroRazaoSocial = new JLabel();
        jLabel_ErroTelefone = new JLabel();
        
        jTextField_Bairro = new JTextField(40);
        jTextField_Cidade = new JTextField(40);
        jTextField_Email = new JTextField(40);
        jTextField_HomePage = new JTextField(40);
        jTextField_Logradouro = new JTextField(40);
        jTextField_Nome = new JTextField(40);
        jTextField_RazaoSocial = new JTextField(40);
        
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
        jLabel_ErroCnpj.setForeground(Color.red);
        jLabel_ErroTelefone.setForeground(Color.red);
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
        
        //Linha 5
        getCons().gridx = 1;
        getCons().gridy = 5;
        getjPanel_CENTER().add(jLabel_ErroCnpj, getCons());
        getCons().gridx = 3;
        getjPanel_CENTER().add(jLabel_ErroTelefone, getCons());
        
        //Linha 6
        getCons().gridx = 0;
        getCons().gridy = 6;
        getjPanel_CENTER().add(jLabel_Email, getCons());
        getCons().gridx = 1;
        getCons().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Email, getCons());
    }
    
    
    
    public void Confirmar(){}
}
