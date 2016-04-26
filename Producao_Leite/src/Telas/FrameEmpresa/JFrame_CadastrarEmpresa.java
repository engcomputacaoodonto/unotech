/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.FrameEmpresa;

import DAO.EmpresaDAO;
import Model.Empresa;

/**
 *
 * @author Shelmo
 */
public class JFrame_CadastrarEmpresa extends JFrame_Empresa
{
    public JFrame_CadastrarEmpresa()
    {
        super("");
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser marcados");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Titulo().setText("Nova Empresa");
    }
    
    public void Confirmar()
    {
        Empresa empresa = new Empresa();
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
        EmpresaDAO.RegistrarEmpresa(empresa);
    }
}
