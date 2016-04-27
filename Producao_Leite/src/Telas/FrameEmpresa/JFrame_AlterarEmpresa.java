package Telas.FrameEmpresa;

import DAO.EmpresaDAO;
import Model.Empresa;
import Telas.FramePrincipal.JTable_Tabela;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarEmpresa extends JFrame_Empresa
{
    private final Empresa empresa;
    private final int select;
    
    public JFrame_AlterarEmpresa(Empresa empresa, int select)
    {
        super("src\\Telas\\FrameEmpresa\\updateBackGround.jpg");
        this.empresa = empresa;
        this.select = select;
        
        getjLabel_Titulo().setText("Alterar Laticínio");
        getjButton_Confirmar().setText("Salvar Alterarções");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        
        getjTextField_Nome().setText(this.empresa.getNomeFantasia());
        getjTextField_RazaoSocial().setText(this.empresa.getRazaoSocial());
        getjFormattedTextField_Cnpj().setText(this.empresa.getCnpj());
        getjTextField_Email().setText(this.empresa.getEmail());
        getjFormattedTextField_Teleone().setText(this.empresa.getTelefone());
        getjTextField_HomePage().setText(this.empresa.getHomePage());
        getjTextField_Cidade().setText(this.empresa.getCidade());
        getjTextField_Logradouro().setText(this.empresa.getLogradouro());
        getjTextField_Bairro().setText(this.empresa.getBairro());
        getjComboBox_Estado().setSelectedItem(this.empresa.getEstado());
    }
    
    public void Confirmar()
    {
        LimparErros();
        empresa.setNomeFantasia(getjTextField_Nome().getText());
        empresa.setRazaoSocial(getjTextField_RazaoSocial().getText());
        empresa.setCnpj(getjFormattedTextField_Cnpj().getText());
        empresa.setEmail(getjTextField_Email().getText());
        empresa.setTelefone(getjFormattedTextField_Teleone().getText());
        empresa.setHomePage(getjTextField_HomePage().getText());
        empresa.setCidade(getjTextField_Cidade().getText());
        empresa.setLogradouro(getjTextField_Logradouro().getText());
        empresa.setBairro(getjTextField_Bairro().getText());
        if(getjComboBox_Estado().getSelectedIndex() == 0)
            empresa.setEstado("");
        else
            empresa.setEstado((String) getjComboBox_Estado().getItemAt(getjComboBox_Estado().getSelectedIndex()));
        
        if(Verificações())
        {
            EmpresaDAO.AlterarEmpresa(empresa);
            JTable_Tabela.setEmpresa(empresa, select);
        }
        else
            return;
        
        dispose();
    }
}
