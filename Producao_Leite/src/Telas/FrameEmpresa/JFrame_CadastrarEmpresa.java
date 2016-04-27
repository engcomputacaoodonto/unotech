/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.FrameEmpresa;

import DAO.EmpresaDAO;
import Model.Empresa;
import Telas.FramePrincipal.JTable_Tabela;

/**
 *
 * @author Shelmo
 */
public class JFrame_CadastrarEmpresa extends JFrame_Empresa
{
    public JFrame_CadastrarEmpresa()
    {
        super("src\\Telas\\FrameEmpresa\\addBackGround.jpg");
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser marcados");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Titulo().setText("Novo Laticínio");
    }
    
    public void Confirmar()
    {
        LimparErros();
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
        if(getjComboBox_Estado().getSelectedIndex() == 0)
            empresa.setEstado("");
        else
            empresa.setEstado((String) getjComboBox_Estado().getItemAt(getjComboBox_Estado().getSelectedIndex()));
        
        if(Verificações())
        {
            EmpresaDAO.RegistrarEmpresa(empresa);
            JTable_Tabela.addEmpresa(empresa);
        }
        else
            return;
        
        LimparCampos();
    }
}
