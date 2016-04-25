package DAO;

import Model.Empresa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conecta;

/**
 *
 * @author Shelmo
 */
public class EmpresaDAO
{
    public static void RegistrarEmpresa(Empresa empresa)
    {
        Conecta c = new Conecta();
        String sql = "INSERT INTO Empresa VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setString(1, empresa.getNomeFantasia());
            c.getPreparedStatement().setString(2, empresa.getRazaoSocial());
            c.getPreparedStatement().setString(3, empresa.getCnpj());
            c.getPreparedStatement().setString(4, empresa.getEmail());
            c.getPreparedStatement().setString(5, empresa.getTelefone());
            c.getPreparedStatement().setString(6, empresa.getHomePage());
            c.getPreparedStatement().setString(7, empresa.getCidade());
            c.getPreparedStatement().setString(8, empresa.getLogradouro());
            c.getPreparedStatement().setString(9, empresa.getBairro());
            c.getPreparedStatement().setString(10, empresa.getEstado());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void RemoverEmpresa(Empresa empresa)
    {
        Conecta c = new Conecta();
        String sql = "DELETE FROM Empresa WHERE idEmpresa = ?";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setInt(1, empresa.getIdEmpresa());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void AlterarEmpresa(Empresa empresa)
    {
        Conecta c = new Conecta();
        String sql = "UPDATE Empresa SET nomeFantasia = ?, razaoSocial = ?, cnpj = ?, email = ?,"
                + "telefone = ?, homePage = ?, cidade = ?, logradouro = ?, bairro = ?, estado = ?"
                + "WHERE idEmpresa = ?";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setString(1, empresa.getNomeFantasia());
            c.getPreparedStatement().setString(2, empresa.getRazaoSocial());
            c.getPreparedStatement().setString(3, empresa.getCnpj());
            c.getPreparedStatement().setString(4, empresa.getEmail());
            c.getPreparedStatement().setString(5, empresa.getTelefone());
            c.getPreparedStatement().setString(6, empresa.getHomePage());
            c.getPreparedStatement().setString(7, empresa.getCidade());
            c.getPreparedStatement().setString(8, empresa.getLogradouro());
            c.getPreparedStatement().setString(9, empresa.getBairro());
            c.getPreparedStatement().setString(10, empresa.getEstado());
            c.getPreparedStatement().setInt(11, empresa.getIdEmpresa());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static ArrayList<Empresa> getListaEmpresa()
    {
        Conecta c = new Conecta();
        
        ArrayList<Empresa> listaEmpresa = new ArrayList<>();
        Empresa empresa;
        
        try
        {
            ResultSet rSet = c.getPreparedStatement().executeQuery("SELECT * FROM Empresa");
            for(;rSet.next();)
            {
                empresa = new Empresa();
                empresa.setIdEmpresa(rSet.getInt("idEmpresa"));
                empresa.setNomeFantasia(rSet.getString("nomeFantasia"));
                empresa.setRazaoSocial(rSet.getString("razaoSocial"));
                empresa.setCnpj(rSet.getString("cnpj"));
                empresa.setEmail(rSet.getString("email"));
                empresa.setTelefone(rSet.getString("telefone"));
                empresa.setHomePage(rSet.getString("homePage"));
                empresa.setCidade(rSet.getString("cidade"));
                empresa.setLogradouro(rSet.getString("logradouro"));
                empresa.setBairro(rSet.getString("bairro"));
                empresa.setEstado(rSet.getString("estado"));
                listaEmpresa.add(empresa);
            }
            rSet.close();
            c.Desconectar();
            return listaEmpresa;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
            return listaEmpresa;
        }
    }
}
