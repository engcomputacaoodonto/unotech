/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.ProducaoDiaria;
import Model.Animal;
import java.sql.SQLException;
import util.Conecta;
/**
 *
 * @author 285146
 */
public class ProducaoDiariaDAO {
    public static void registrarProducao(ProducaoDiaria pd){
        Conecta c = new Conecta();
        String sql = "INSERT INTO producao VALUES(null, ?,?,?)";
        c.pStmt(sql);
        try {
            c.getPreparedStatement().setDate(1,pd.getData());
            c.getPreparedStatement().setDouble(2,pd.getQntLitros());
            c.getPreparedStatement().setInt(3,pd.getIdAnimal());
            c.getPreparedStatement().execute();
            c.Desconectar();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
        }
    }
    
    
    
}
