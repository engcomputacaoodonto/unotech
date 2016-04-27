package Telas.FrameEmpresa;

import DAO.EmpresaDAO;
import Model.Empresa;
import Telas.FramePrincipal.JTable_Tabela;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverEmpresa extends JFrame_Empresa
{
    private Empresa empresa;
    private final int select;
    
    public JFrame_RemoverEmpresa(Empresa empresa, int select)
    {
        super("src\\Telas\\FrameEmpresa\\removeBackGround.jpg");
        
        this.empresa = empresa;
        this.select = select;
        
        getjLabel_Titulo().setText("Remover Laticínio");
        getjButton_Confirmar().setText("Remover");
        getjLabel_Aviso().setText("Deseja realmente remover esse Laticínio?");
        
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
        
        getjTextField_Bairro().setEditable(false);
        getjTextField_Cidade().setEditable(false);
        getjTextField_Email().setEditable(false);
        getjTextField_HomePage().setEditable(false);
        getjTextField_Logradouro().setEditable(false);
        getjTextField_Nome().setEditable(false);
        getjTextField_RazaoSocial().setEditable(false);
        getjFormattedTextField_Cnpj().setEditable(false);
        getjFormattedTextField_Teleone().setEditable(false);
        getjComboBox_Estado().setEnabled(false);
    }
    
    public void Confirmar()
    {
        EmpresaDAO.RemoverEmpresa(empresa);
        JTable_Tabela.removeEmpresa(select);
        dispose();
    }
}
