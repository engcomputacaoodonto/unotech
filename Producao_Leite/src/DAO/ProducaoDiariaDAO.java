/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.ProducaoDiaria;
import Model.Animal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conecta;
/**
 *
 * @author 285146
 */
public class ProducaoDiariaDAO
{
    public static void registrarProducao(ProducaoDiaria pd)
    {
        Conecta c = new Conecta();
        String sql = "INSERT INTO Producao VALUES(null, ?,?,?)";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setDate(1,pd.getData());
            c.getPreparedStatement().setDouble(2,pd.getQntLitros());
            c.getPreparedStatement().setInt(3,pd.getIdAnimal());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
        }
    }
    
    public static void removerProducao(ProducaoDiaria pd)
    {
        Conecta c = new Conecta();
        String sql = "DELETE FROM Producao WHERE idProducao = ?";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setInt(1, pd.getId());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    public static void atualizarProducao(ProducaoDiaria pd)
    {
        Conecta c = new Conecta();
        String sql = "UPDATE Producao SET dataP = ?, qtdLitros = ?, idAnimal = ? WHERE idProducao = ?";
        c.pStmt(sql);
        try
        {
            c.getPreparedStatement().setDate(1,pd.getData());
            c.getPreparedStatement().setDouble(2,pd.getQntLitros());
            c.getPreparedStatement().setInt(3,pd.getIdAnimal());
            c.getPreparedStatement().setInt(3, pd.getId());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
        }
    }
    
    public static ArrayList<ProducaoDiaria> getListaProducaoDiaria()
    {
        Conecta c = new Conecta();
        ArrayList<ProducaoDiaria> listaProducaoDiaria = new ArrayList<>();
        
        ProducaoDiaria pd;
        
        try
        {
            ResultSet rSet = c.getPreparedStatement().executeQuery("SELECT * FROM Producao");
            for(;rSet.next();)
            {
                pd = new ProducaoDiaria();
                pd.setId(rSet.getInt("idProducao"));
                pd.setIdAnimal(rSet.getInt("idAnimal"));
                pd.setData(rSet.getDate("dataP"));
                pd.setQntLitros(rSet.getDouble("qtdlitros"));
                listaProducaoDiaria.add(pd);
            }
            rSet.close();
            c.Desconectar();
            return listaProducaoDiaria;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
            return listaProducaoDiaria;
        }
    }
}
