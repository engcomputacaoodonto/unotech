package Telas.FrameEmpresa;

import DAO.EmpresaDAO;
import Model.Empresa;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverEmpresa extends JFrame_Empresa
{
    private Empresa empresa;
    public JFrame_RemoverEmpresa(Empresa empresa)
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
        EmpresaDAO.RemoverEmpresa(empresa);
        dispose();
    }
}
