package DAO;

import Model.ColetaLeite;
import Model.ProducaoDiaria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conecta;

/**
 *
 * @author Shelmo
 */
public class ColetaLeiteDAO
{
    public static void RegistrarColetaLeite(ColetaLeite coletaLeite)
    {
        Conecta c = new Conecta();
        String sql = "INSERT INTO ColetaLeite VALUES(NULL, ?, ?, ?, ?)";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setInt(1, coletaLeite.getIdEmpresa());
            c.getPreparedStatement().setDate(2, coletaLeite.getDataColeta());
            c.getPreparedStatement().setInt(3, coletaLeite.getQtdLitros());
            c.getPreparedStatement().setString(4, coletaLeite.getQualidade());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
        }
    }
    
    public static void RemoverColetaLeite(ColetaLeite coletaLeite)
    {
        Conecta c = new Conecta();
        String sql = "DELETE FROM ColetaLeite WHERE idColetaLeite = ?";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setInt(1, coletaLeite.getIdColetaLeite());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
        }
    }
    
    public static void AlterarColetaLeite(ColetaLeite coletaLeite)
    {
        Conecta c = new Conecta();
        String sql = "UPDATE ColetaLeite SET idEmpresa = ?, dataColeta = ?, qtdLitros = ?, qualidade = ? WHERE idColetaLeite = ?";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setInt(1, coletaLeite.getIdEmpresa());
            c.getPreparedStatement().setDate(2, coletaLeite.getDataColeta());
            c.getPreparedStatement().setInt(3, coletaLeite.getQtdLitros());
            c.getPreparedStatement().setString(4, coletaLeite.getQualidade());
            c.getPreparedStatement().setInt(5, coletaLeite.getIdColetaLeite());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
        }
    }
    
    public static ArrayList<ColetaLeite> getColetaLeite()
    {
        Conecta c = new Conecta();
        ArrayList<ColetaLeite> listaColetaLeite = new ArrayList<>();
        ColetaLeite coletaLeite;
        try
        {
            ResultSet rSet = c.getPreparedStatement().executeQuery("SELECT * FROM ColetaLeite");
            for(;rSet.next();)
            {
                coletaLeite = new ColetaLeite();
                coletaLeite.setIdColetaLeite(rSet.getInt("idColetaLeite"));
                coletaLeite.setIdEmpresa(rSet.getInt("idEmpresa"));
                coletaLeite.setDataColeta(rSet.getDate("dataColeta"));
                coletaLeite.setQtdLitros(rSet.getInt("qtdLitros"));
                coletaLeite.setQualidade(rSet.getString("qualidade"));
                listaColetaLeite.add(coletaLeite);
            }
            rSet.close();
            c.Desconectar();
            return listaColetaLeite;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
            return listaColetaLeite;
        }
    }
}
