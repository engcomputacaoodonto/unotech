package Telas.FrameEmpresa;

import DAO.EmpresaDAO;
import Model.Empresa;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarEmpresa extends JFrame_Empresa
{
    private final Empresa empresa;
    
    public JFrame_AlterarEmpresa(Empresa empresa)
    {
        super("");
        this.empresa = empresa;
        
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
        empresa.setNomeFantasia(getjTextField_Nome().getText());
        empresa.setRazaoSocial(getjTextField_RazaoSocial().getText());
        empresa.setCnpj(getjFormattedTextField_Cnpj().getText());
        empresa.setEmail(getjTextField_Email().getText());
        empresa.setTelefone(getjFormattedTextField_Teleone().getText());
        empresa.setHomePage(getjTextField_HomePage().getText());
        empresa.setCidade(getjTextField_Cidade().getText());
        empresa.setLogradouro(getjTextField_Logradouro().getText());
        empresa.setBairro(getjTextField_Bairro().getText());
        empresa.setEstado((String) getjComboBox_Estado().getItemAt(getjComboBox_Estado().getSelectedIndex()));
        EmpresaDAO.AlterarEmpresa(empresa);
    }
}
